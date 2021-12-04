package com.packt.datastructuresandalg.lesson1.activity.project;

import java.util.ArrayList;
import java.util.Iterator;

public class SuggestionFramesSolution {
	
	/**
	 * This method gets the visiting customer index and the product index of requested page 
	 * and using previous data collected it produces product suggestions from the same seller
	 * or brand
	 * 
	 * @param currentProductIndex the product index of requested web page (at least 11)
	 * @param currentCustomerIndex the visiting customer
	 * @param customerBehaviorMatrix the previous data collected
	 * @param orderedProductList list of all products ordered wrt dataMatrixIndex of product
	 * 
	 * @return list of 5 product to be suggested from same brand/seller/manufacturer; 
	 * not containing the product of requested page, and if suggestions are less than 5
	 * products from same brand/seller/manufacturer are added to the list  until list size is five.
	 */
	public ArrayList<Product> otherProductsOfTheSellerList(int currentProductIndex, 
			int currentCustomerIndex, double[][] customerBehaviorMatrix,
			ArrayList<Product> orderedProductList) {
		
		//define return index; 5 products
		ArrayList<Product> returnList = new ArrayList<>(5);
		
		/*
		 * find product from index; product list is ordered wrt column index 
		 * so list index will be 11 smaller
		 */
		Product currentProduct = orderedProductList.get(currentProductIndex-11);
				
		//find the most similar other customer
		SimilarCustomer similarCustomer = new SimilarCustomer();
		
		int similarCustomerIndex = similarCustomer.findMostSimilarCustomer(
				customerBehaviorMatrix, currentCustomerIndex);
		
		//get current customer vector
		double[] currentCustormerVector = customerBehaviorMatrix[currentCustomerIndex];
		
		//get similar customer vector
		double[] similarCustomerVector = customerBehaviorMatrix[similarCustomerIndex];
		
		//find suggestions 
		//start from 10 since the first 10 columns are not products
		for (int i = 10; i < similarCustomerVector.length; i++) {
			//product list is ordered wrt column index so list index will be 10 smaller
			Product suggestedProduct = orderedProductList.get(i-10);
			
			if (currentCustormerVector[i] == 0 && similarCustomerVector[i]!=0 
					&& suggestedProduct.getManufacturerCode() == currentProduct.getManufacturerCode()
					&& i != currentProduct.getDataMatrixIndex()) {
				
				returnList.add(suggestedProduct);
			}
		}
		
		//remove excess if list is larger than 5 
		if (returnList.size() > 5) {
			for (int i = 5; i < similarCustomerVector.length; i++) {
				returnList.remove(i);
			}
		}
		
		// and add if list is smaller than 5
		for (Iterator iterator = orderedProductList.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			if (product.getManufacturerCode() == currentProduct.getManufacturerCode()
					&& product.getDataMatrixIndex() != currentProduct.getDataMatrixIndex()) {
				returnList.add(product);
				if (returnList.size() >= 5) {
					break;
				}
			}
		}
		
		return returnList;
	}
	
	/**
	 * This method gets the visiting customer index and the product index of requested page 
	 * and using previous data collected it produces product suggestions based on previous 
	 * sales of similar customer
	 * 
	 * @param currentProductIndex the product index of requested web page (at least 11)
	 * @param currentCustomerIndex the visiting customer
	 * @param customerBehaviorMatrix the previous data collected
	 * @param orderedProductList list of all products ordered wrt dataMatrixIndex of product
	 * 
	 * @return list of 5 product to be suggested based on previous sales of similar customer; 
	 * not containing the product of requested page, and if suggestions are less than 5, 
	 * more products are added to the list until list size is five.
	 */
	public ArrayList<Product> interestedProductsSuggestionList(int currentProductIndex, 
			int currentCustomerIndex, double[][] customerBehaviorMatrix,
			ArrayList<Product> orderedProductList) {
		
		//define return index; 5 products
		ArrayList<Product> returnList = new ArrayList<>(5);
		
		/*
		 * find product from index; product list is ordered wrt column index 
		 * so list index will be 11 smaller
		 */
		Product currentProduct = orderedProductList.get(currentProductIndex-11);
				
		//find the most similar other customer
		SimilarCustomer similarCustomer = new SimilarCustomer();
		
		int similarCustomerIndex = similarCustomer.findMostSimilarCustomer(
				customerBehaviorMatrix, currentCustomerIndex);
		
		//get current customer vector
		double[] currentCustormerVector = customerBehaviorMatrix[currentCustomerIndex];
		
		//get similar customer vector
		double[] similarCustomerVector = customerBehaviorMatrix[similarCustomerIndex];
		
		//find suggestions 
		//start from 10 since the first 10 columns are not products
		for (int i = 10; i < similarCustomerVector.length; i++) {
			//product list is ordered wrt column index so list index will be 10 smaller
			Product suggestedProduct = orderedProductList.get(i-10);
			
			if (currentCustormerVector[i] == 0 && similarCustomerVector[i]!=0 
					&& i != currentProduct.getDataMatrixIndex()) {
				
				returnList.add(suggestedProduct);
			}
		}
		
		//remove excess if list is larger than 5 
		if (returnList.size() > 5) {
			for (int i = 5; i < similarCustomerVector.length; i++) {
				returnList.remove(i);
			}
		}
		
		// and add if list is smaller than 5
		for (Iterator iterator = orderedProductList.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			if (product.getDataMatrixIndex() != currentProduct.getDataMatrixIndex()) {
				returnList.add(product);
				if (returnList.size() >= 5) {
					break;
				}
			}
		}
		
		return returnList;
	}
}
