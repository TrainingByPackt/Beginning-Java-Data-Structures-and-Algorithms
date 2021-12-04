package com.packt.datastructuresandalg.lesson1.activity.project;

public class SimilarCustomerOld {

	public int findMostSimilarCustomer(double[][] customerBehaviorMatrix, int currentCustomerIndex) {
		
		//1. find the min max values
		double[][] minMaxValuesMatrix = new double[2][customerBehaviorMatrix[0].length];
		
		//assign min and max values to return matrix
		for (int j = 0; j < minMaxValuesMatrix[0].length; j++) {
			minMaxValuesMatrix[0][j] = Double.MAX_VALUE;
			minMaxValuesMatrix[1][j] = Double.MIN_VALUE;
		}
		
		//for each column find min and max
		for (int i = 0; i < customerBehaviorMatrix.length; i++) {
			for (int j = 0; j < customerBehaviorMatrix[i].length; j++) {								
				//check min
				if (customerBehaviorMatrix[i][j] < minMaxValuesMatrix[0][j]) {
					//store min in the corresponding return matrix
					minMaxValuesMatrix[0][j] = customerBehaviorMatrix[i][j];
				}				
				//check max
				if (customerBehaviorMatrix[i][j] > minMaxValuesMatrix[1][j]) {
					//store max in the corresponding return matrix
					minMaxValuesMatrix[1][j] = customerBehaviorMatrix[i][j];
				}
			}
		}
		
		//2. Normalize the dataset				
		double[][] normalizedCustomerbehavior = 
				new double[customerBehaviorMatrix.length][customerBehaviorMatrix[0].length];
		
		// for each entry normalize value and store in return matrix
		for (int j = 0; j < normalizedCustomerbehavior[0].length; j++) {
			double min = minMaxValuesMatrix[0][j];
			double max = minMaxValuesMatrix[1][j];
			
			for (int i = 0; i < normalizedCustomerbehavior.length; i++) {
				double value = customerBehaviorMatrix[i][j];
				
				//Assign the normalized value
				if ((max-min)==0) {
					normalizedCustomerbehavior[i][j] = 0;
				} else {
					normalizedCustomerbehavior[i][j] = (value - min)/(max-min);
				}
								
			}
		}
		
		//3. Calculate similarity using Euclidean distance		
		double similarityMatrix[][] = 
				new double[normalizedCustomerbehavior.length][normalizedCustomerbehavior.length];

		// for each customer
		for (int i = 0; i < similarityMatrix.length; i++) {
			// for each customer
			for (int i2 = 0; i2 < similarityMatrix.length; i2++) {
				
				//define sum of squares
				double sum = 0;
				
				//for each behavior
				for (int j = 0; j < normalizedCustomerbehavior[i].length; j++) {
					
					//calculate difference
					double difference = (normalizedCustomerbehavior[i][j]-normalizedCustomerbehavior[i2][j]);
					//square the difference
					double squareOfDifference = difference*difference;
					//add to the sum
					sum += squareOfDifference;
					
				}				
				//add square root of sum as similarity 
				similarityMatrix[i][i2] = Math.sqrt(sum);
			}
		}
		
		//4. find similar (other) customer; min distance
		int returnIndex = -1;
		double distance = Double.MAX_VALUE;
		
			for (int j = 0; j < similarityMatrix[currentCustomerIndex].length; j++) {				
				if (currentCustomerIndex != j && similarityMatrix[currentCustomerIndex][j] < distance) {
					returnIndex = j;
					distance = similarityMatrix[currentCustomerIndex][j];
				}
			}		
		return returnIndex;
	}
}
