package com.packt.datastructuresandalg.lesson1.activity.project;

public class SimilarCustomer {
	
	/**
	 * This methods finds the most similar customer to the given customer using
	 * Euclidean distance
	 * 
	 * @param customerBehaviorMatrix data from online store
	 * @param currentCustomerIndex current customer visiting the online store
	 * @return index of the most similar customer wrt given customer index
	 */
	public int findMostSimilarCustomer(double[][] customerBehaviorMatrix, int currentCustomerIndex) {
		
		//TODO findMostSimilarCustomer()
		
		//2. Normalize the dataset

		
		//3. Calculate similarity using Euclidean distance
				
		return -1;
	}
	
	/**
	 * This method normalizes given customer behavior matrix
	 * @param customerBehaviorMatrix customer Behavior data 
	 * @return normalized customer behavior matrix
	 */
	public double[][] calculateNormalizedCustomerBehaviorMatrix( 
			double[][] customerBehaviorMatrix) {

		//TODO calculateNormalizedCustomerBehaviorMatrix()

		
		//define a new return matrix

		
		// for each entry normalize value and store in return matrix
	
				
				//Assign the normalized value

								

				
		return null;		
	}


	/**
	 * This method finds min and max values of the customer behavior matrix 
	 * and stores them in a matrix
	 * 
	 * @param costumerBehaviourMatrix 	data from online store
	 * @return 2 row matrix with first row showing min of each column and 
	 * second row showing max of each 
	 */
	public double[][] findMinMaxValuesOfEachColumn(double[][] customerBehaviorMatrix) {
		
		//TODO findMinMaxValuesOfEachColumn()
		
		//define a new return matrix
		
		//assign min and max values to return matrix

		//for each column find min and max

								
				//check min

					//store min in the corresponding return matrix


				//check max
	
					//store max in the corresponding return matrix

					
		return null;
	}
	
	
	/**
	 * This method gets a customer index and normalized customer behavior data then
	 * returns the most similar customer to given one
	 * @param normalizedCustomerBehaviorMatrix normalized customer behavior data
	 * @param currentCustomerIndex index of the customer which will be the base of search 
	 * @return index of most similar other customer
	 */
	public int findMostSimilarCustomerIndex(double[][] normalizedCustomerBehaviorMatrix, 
			int currentCustomerIndex) {
		
		//TODO findMostSimilarCustomerIndex()

		

		return -1;		
	}
	
	/**
	 * This methods calculates Euclidean distance between two equally size vector
	 * 
	 * @param vectorOne First vector
	 * @param vectorTwo Second Vector
	 * @return distance (double) between given two vectors
	 */
	public double calculateEuclideanDistance(double[] vectorOne, double[] vectorTwo) {

		//TODO calculateEuclideanDistance()
		
		//check if vectors have same length

		
		return -1;
	}
}
