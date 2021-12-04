package com.packt.datastructuresandalg.lesson1.activity.project;

import java.util.ArrayList;

public class SuggestionFrames {
	
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
		
		//TODO otherProductsOfTheSellerList()
		
		//define return index; 5 products
	
		
		/*
		 * find product from index; product list is ordered wrt column index 
		 * so list index will be 11 smaller
		 */

				
		//find the most similar other customer
	
		
		//get current customer vector

		
		//get similar customer vector

		
		//find suggestions 
		//start from 10 since the first 10 columns are not products

			//product list is ordered wrt column index so list index will be 10 smaller

		
		//remove excess if list is larger than 5 

		
		// and add if list is smaller than 5

		
		return null;
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
		
		//TODO interestedProductsSuggestionList()
		
		//define return index; 5 products

		
		/*
		 * find product from index; product list is ordered wrt column index 
		 * so list index will be 11 smaller
		 */

				
		//find the most similar other customer

		
		//get current customer vector

		
		//get similar customer vector

		
		//find suggestions 
		//start from 10 since the first 10 columns are not products

			//product list is ordered wrt column index so list index will be 10 smaller

		
		//remove excess if list is larger than 5 
		
		// and add if list is smaller than 5

		return null;
	}
}
