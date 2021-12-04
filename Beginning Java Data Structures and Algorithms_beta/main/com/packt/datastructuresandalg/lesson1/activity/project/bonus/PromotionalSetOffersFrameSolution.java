package com.packt.datastructuresandalg.lesson1.activity.project.bonus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import com.packt.datastructuresandalg.lesson1.activity.project.Product;

public class PromotionalSetOffersFrameSolution {
	
	/**
	 * This method get the product index of the requested web page and previous data
	 * and finds together bought items, makes bundle of three (obviously first one is 
	 * the product of the requested web page), and returns them as a list to show customer
	 * 
	 * @param currentProductIndex product index of the requested web page (at least 11)
	 * @param customerBehaviorMatrix previous data of customers and products
	 * @param orderedProductList list of all products ordered wrt dataMatrixIndex of product
	 * @return list of 3 product to be suggested based on previous sales of online store; 
	 * containing the product of requested page, and if suggestions are less than 3, more
	 * products are added to the list  until list size is 3.
	 */
	public static ArrayList<Product> promotionalSetOffer(int currentProductIndex, 
			double[][] customerBehaviorMatrix, ArrayList<Product> orderedProductList) {
		//define return index; 3 products
		ArrayList<Product> returnList = new ArrayList<>(3);
		
		//must include product of current web page 
		returnList.add(orderedProductList.get(currentProductIndex-11));
		
		//find the most two other items sold together and add to the list
		returnList.addAll(findTogetherSoldItems(
				currentProductIndex, customerBehaviorMatrix, orderedProductList)); ;		
		
		return returnList;		
	}

	
	/**
	 * This method gets the the product index of the requested web page and previous data
	 * and finds together bought items, makes bundle of the most sold two
	 * If the product is new and never sold before, or not enough data available
 	 * using the most sold one or two products to make a bundle of three products.
	 * 
	 * @param currentProductIndex product index of the requested web page (at least 11)
	 * @param customerBehaviorMatrix previous data of customers and products
	 * @param orderedProductList list of all products ordered wrt dataMatrixIndex of product
	 * @return the most sold two items together with the product of the requested web page
	 */
	public static Collection<? extends Product> findTogetherSoldItems(int currentProductIndex,
			double[][] customerBehaviorMatrix, ArrayList<Product> orderedProductList) {
		
		//define the return list
		ArrayList<Product> returnList = new ArrayList<>(2);
		
		//define sold product counter list 
		ArrayList<SoldItemCounter> itemCounter = new ArrayList<>();
		
		//add all products to counter
		for (Iterator iterator = orderedProductList.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			itemCounter.add(new SoldItemCounter(product));
		}
		
		//find customers who bought this item
		for (int i = 0; i < customerBehaviorMatrix.length; i++) {
			
			/*
			 * currentProductIndex starts from 11 and 10 columns before it in customerBehaviorMatrix
			 * so -11 (reset the index to zero) and add the first 10 columns so it starts
			 * from index 10 in customerBehaviorMatrix
			 */
			int currentProductIndexInDataMatrix = currentProductIndex -11 +10;
		
			// check if customer has bought this item

			if (customerBehaviorMatrix[i][currentProductIndexInDataMatrix] > 0) {
				
				for (int j = 10; j < customerBehaviorMatrix[i].length; j++) {					
					//count all other purchases
					if (customerBehaviorMatrix[i][j] > 0 && j != currentProductIndexInDataMatrix) {
						//since product index in customerBehaviorMatrix began from 11th column; index 10
						itemCounter.get(j-10).addCounter((int) customerBehaviorMatrix[i][j]);
					}
				}
			}
		}		
		
		//sort the sold items wrt counters
		itemCounter.sort(Comparator.comparing(SoldItemCounter::getCounter).reversed());
		
		//add first two products to return list
		for (int i = 0; i < 2; i++) {
			//check if there is available product to make bundle
			if (itemCounter.get(i).getCounter()>0) {
				Product addItem = itemCounter.get(i).getProduct();
				returnList.add(addItem);
			} 
		}
		
		//if not enough product is available to bundle add the most sold ones
		if (returnList.size()<2) {
			
			//define the most sold product counter list 
			ArrayList<SoldItemCounter> theMostSoldItemCounter = new ArrayList<>();
			
			//add all products to counter
			for (Iterator iterator = orderedProductList.iterator(); iterator.hasNext();) {
				Product product = (Product) iterator.next();
				theMostSoldItemCounter.add(new SoldItemCounter(product));
			}
			
			//find customers who bought this item
			for (int i = 0; i < customerBehaviorMatrix.length; i++) {									
				for (int j = 10; j < customerBehaviorMatrix[i].length; j++) {	
									
					//since product index in customerBehaviorMatrix began from 11th column; index 10
					theMostSoldItemCounter.get(j-10).addCounter((int) customerBehaviorMatrix[i][j]);
					
				}				
			}
			
			//sort the sold items wrt counters
			theMostSoldItemCounter.sort(Comparator.comparing(SoldItemCounter::getCounter).reversed());
			
			int index = 0;
			
			do {
				returnList.add(theMostSoldItemCounter.get(index).getProduct());
				index++;
			} while (returnList.size()<2);
		}
		
		return returnList;
	}
}
