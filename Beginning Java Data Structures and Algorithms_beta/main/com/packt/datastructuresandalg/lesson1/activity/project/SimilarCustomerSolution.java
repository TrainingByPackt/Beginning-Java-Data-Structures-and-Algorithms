package com.packt.datastructuresandalg.lesson1.activity.project;

public class SimilarCustomerSolution {
	
	/**
	 * This methods finds the most similar customer to the given customer using
	 * Euclidean distance
	 * 
	 * @param customerBehaviorMatrix data from online store
	 * @param currentCustomerIndex current customer visiting the online store
	 * @return index of the most similar customer wrt given customer index
	 */
	public int findMostSimilarCustomer(double[][] customerBehaviorMatrix, int currentCustomerIndex) {
			
		//2. Normalize the dataset
		double[][] normalizedCustomerbehavior =
				calculateNormalizedCustomerBehaviorMatrix(customerBehaviorMatrix);
		
		//3. Calculate similarity using Euclidean distance
		int mostSimilarCustomerIndex = 
				findMostSimilarCustomerIndex(normalizedCustomerbehavior, currentCustomerIndex);
				
		return mostSimilarCustomerIndex;
	}
	
	/**
	 * This method normalizes given customer behavior matrix
	 * @param customerBehaviorMatrix customer Behavior data 
	 * @return normalized customer behavior matrix
	 */
	public double[][] calculateNormalizedCustomerBehaviorMatrix( 
			double[][] customerBehaviorMatrix) {

		double[][] minMaxValuesMatrix = findMinMaxValuesOfEachColumn(customerBehaviorMatrix);
		
		//define a new return matrix
		double[][] returnMatrix = 
				new double[customerBehaviorMatrix.length][customerBehaviorMatrix[0].length];
		
		// for each entry normalize value and store in return matrix
		for (int j = 0; j < returnMatrix[0].length; j++) {
			double min = minMaxValuesMatrix[0][j];
			double max = minMaxValuesMatrix[1][j];
			
			for (int i = 0; i < returnMatrix.length; i++) {
				double value = customerBehaviorMatrix[i][j];
				
				//Assign the normalized value
				if ((max-min)==0) {
					returnMatrix[i][j] = 0;
				} else {
					returnMatrix[i][j] = (value - min)/(max-min);
				}
								
			}
		}
				
		return returnMatrix;		
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
		
		//define a new return matrix
		double[][] returnMatrix = new double[2][customerBehaviorMatrix[0].length];
		
		//assign min and max values to return matrix
		for (int j = 0; j < returnMatrix[0].length; j++) {
			returnMatrix[0][j] = Double.POSITIVE_INFINITY;
			returnMatrix[1][j] = Double.NEGATIVE_INFINITY;
		}
		
		//for each column find min and max
		for (int i = 0; i < customerBehaviorMatrix.length; i++) {
			for (int j = 0; j < customerBehaviorMatrix[i].length; j++) {
								
				//check min
				if (customerBehaviorMatrix[i][j] < returnMatrix[0][j]) {
					//store min in the corresponding return matrix
					returnMatrix[0][j] = customerBehaviorMatrix[i][j];
				}
				
				//check max
				if (customerBehaviorMatrix[i][j] > returnMatrix[1][j]) {
					//store max in the corresponding return matrix
					returnMatrix[1][j] = customerBehaviorMatrix[i][j];
				}
			}
		}
					
		return returnMatrix;
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
		
		int returnIndex = -1;
		
		double[] currentCustomerVector = normalizedCustomerBehaviorMatrix[currentCustomerIndex];
		
		double minDistance = Double.POSITIVE_INFINITY;
		
		for (int i = 0; i < normalizedCustomerBehaviorMatrix.length; i++) {
			
			if (i!= currentCustomerIndex) {
				
				double[] secondCustomerVector = normalizedCustomerBehaviorMatrix[i]; 
				
				double distance = 
						calculateEuclideanDistance(currentCustomerVector, secondCustomerVector);
				
				if (distance < minDistance) {
					returnIndex = i;
					minDistance = distance;
				}
			}
			
		}
		
		return returnIndex;		
	}
	
	/**
	 * This methods calculates Euclidean distance between two equally size vector
	 * 
	 * @param vectorOne First vector
	 * @param vectorTwo Second Vector
	 * @return distance (double) between given two vectors
	 */
	public double calculateEuclideanDistance(double[] vectorOne, double[] vectorTwo) {
		double sum = 0;
		
		//check if vectors have same length
		if (vectorOne.length != vectorTwo.length) {
			return -1;
		}
		
		for (int i = 0; i < vectorOne.length; i++) {
			double squareOfDifferance = (vectorOne[i]-vectorTwo[i])*(vectorOne[i]-vectorTwo[i]);
			
			sum += squareOfDifferance;
		}
		
		return Math.sqrt(sum);
	}
}
