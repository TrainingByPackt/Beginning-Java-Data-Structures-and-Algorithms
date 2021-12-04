package com.packt.datastructuresandalg.lesson1.activity.project.bonus;

import java.util.ArrayList;
import java.util.Collection;

import com.packt.datastructuresandalg.lesson1.activity.project.Product;

public class PromotionalSetOffersFrame {
	
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
		
		//TODO promotionalSetOffer()
		
		//define return index; 3 products
		
		//must include product of current web page 
		
		//find the most two other items sold together and add to the list
;		
		
		return null;		
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
		
		//TODO findTogetherSoldItems()
		
		//define the return list
		
		//define sold product counter list 
		
		//add all products to counter
		
		//find customers who bought this item
			
			/*
			 * currentProductIndex starts from 11 and 10 columns before it in customerBehaviorMatrix
			 * so -11 (reset the index to zero) and add the first 10 columns so it starts
			 * from index 10 in customerBehaviorMatrix
			 */
		
			// check if customer has bought this item
				
					//count all other purchases

						//since product index in customerBehaviorMatrix began from 11th column; index 10

		//sort the sold items wrt counters

		
		//add first two products to return list

			//check if there is available product to make bundle
		
		//if not enough product is available to bundle add the most sold ones
			
			//define the most sold product counter list 
			
			//add all products to counter
			
			//find customers who bought this item
									
					//since product index in customerBehaviorMatrix began from 11th column; index 10
			
			//sort the sold items wrt counters
		
		return null;
	}
}
