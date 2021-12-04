package com.packt.datastructuresandalg.lesson4.activity.project.bonus;

import java.util.Arrays;

public class InventoryAndManufacturingPlanSolution {
	
	private int numberOfPeriods; // planning period
	private double inventoryHoldingCostPerProduct[];
	private double manufacturingCostPerProduct[];
	private double setUpCostPerPeriodOfManufacture[];
	
	private int productionCapacity[]; // limit of production per period  
	private int inventoryCapacity[]; // limit of production per period capacity
	 
	private int startingInventory; //inventory level at the beginning of planning period
	private int endingInventory; //desired inventory level at the end of planning period
	
	private int[] productionPlan;
	private int[] inventoryPlan;
	
	private int[] demands;
	
	/*
	 * row are starting inventory amounts columns are periods 
	 * and values are costs
	 */
	private double[][] memoriseCostOfStates; 
	
	/*
	 * row are starting inventory amounts columns are periods and values are production amounts
	 */
	private int[][] memoriseProductionOfStates; 
	
	
	/**
	 * @param inventoryHoldingCostPerProduct inventory holding cost per product
	 * @param manufacturingCostPerProduct manufacturing cost per product
	 * @param setUpCostPerPeriodOfManufacture setup cost per period of manufacture 
	 * (Occurs if any amount of product is manufactured)
	 * @param productionCapacity production capacity
	 * @param inventoryCapacity inventory capacity
	 * @param demands market demand per period and index 0 must be undefined (-1),
	 * values should start from index 1
	 * @param startingInventory
	 * @param endingInventory
	 */
	public InventoryAndManufacturingPlanSolution(double inventoryHoldingCostPerProduct,
			double manufacturingCostPerProduct, double setUpCostPerPeriodOfManufacture, int productionCapacity,
			int inventoryCapacity, int[] demands, int startingInventory, int endingInventory) {
		
		super();
		
		
		this.numberOfPeriods = demands.length-1;
		
		this.inventoryHoldingCostPerProduct = new double[this.numberOfPeriods+1];
		this.manufacturingCostPerProduct = new double[this.numberOfPeriods+1];
		this.setUpCostPerPeriodOfManufacture = new double[this.numberOfPeriods+1];
		this.productionCapacity = new int[this.numberOfPeriods+1];		
		this.inventoryCapacity = new int[this.numberOfPeriods+1];
		
		
		Arrays.fill(this.inventoryHoldingCostPerProduct, inventoryHoldingCostPerProduct);
		Arrays.fill(this.manufacturingCostPerProduct, manufacturingCostPerProduct);
		Arrays.fill(this.setUpCostPerPeriodOfManufacture, setUpCostPerPeriodOfManufacture);
		Arrays.fill(this.productionCapacity, productionCapacity);		
		Arrays.fill(this.inventoryCapacity, inventoryCapacity);
		
		this.startingInventory = startingInventory;
		this.endingInventory = endingInventory;
		
		this.demands = demands;
		
		productionPlan = new int [numberOfPeriods+1];
		inventoryPlan = new int[numberOfPeriods+2];
		
		memoriseCostOfStates = new double[inventoryCapacity+1][demands.length+1]; 
		
		for (int i = 0; i < memoriseCostOfStates.length; i++) {
			for (int j = 0; j < memoriseCostOfStates[i].length; j++) {
				
				memoriseCostOfStates[i][j] = Double.POSITIVE_INFINITY;
			}
		}
		
		memoriseProductionOfStates = new int[inventoryCapacity+1][4+1];
		
		for (int i = 0; i < memoriseProductionOfStates.length; i++) {
			for (int j = 0; j < memoriseProductionOfStates[i].length; j++) {
				
				memoriseProductionOfStates[i][j] = Integer.MAX_VALUE;
			}
		}		
	}
	
	
	
	/**
	 * @param numberOfPeriods Total number of periods to plan
	 * @param inventoryHoldingCostPerProduct inventory holding cost per product per period and 
	 * index 0 must be undefined, values should start from index 1
	 * @param manufacturingCostPerProduct manufacturing cost per product per period and 
	 * index 0 must be undefined, values should start from index 1
	 * @param setUpCostPerPeriodOfManufacture setup cost per period of manufacture per period 
	 * and index 0 must be undefined, values should start from index 1
	 * @param productionCapacity  production capacity per period and index 0 must be undefined,
	 * values should start from index 1
	 * @param inventoryCapacity  inventory capacity per period and index 0 must be undefined,
	 * values should start from index 1
	 * 
	 * @param startingInventory  starting inventory level at the beginning of planing period
	 * @param endingInventory desired inventory level at the beginning of planing period
	 * 
	 * @param demands market demand per period and index 0 must be undefined,
	 * values should start from index 1
	 */
	public InventoryAndManufacturingPlanSolution(double[] inventoryHoldingCostPerProduct,
			double[] manufacturingCostPerProduct, double[] setUpCostPerPeriodOfManufacture, int[] productionCapacity,
			int[] inventoryCapacity, int startingInventory, int endingInventory, int[] demands) {
		super();

		this.inventoryHoldingCostPerProduct = inventoryHoldingCostPerProduct;
		this.manufacturingCostPerProduct = manufacturingCostPerProduct;
		this.setUpCostPerPeriodOfManufacture = setUpCostPerPeriodOfManufacture;
		this.productionCapacity = productionCapacity;
		this.inventoryCapacity = inventoryCapacity;
		this.startingInventory = startingInventory;
		this.endingInventory = endingInventory;
		this.demands = demands;
		this.numberOfPeriods = demands.length-1;
		
		productionPlan = new int [demands.length];
		inventoryPlan = new int[demands.length];
		
		inventoryPlan[0] = this.startingInventory;
		inventoryPlan[numberOfPeriods] = this.endingInventory;
		
		//find max inventory capacity
		int maxInventoryCapcity = Arrays.stream(inventoryCapacity).max().getAsInt();
				
		memoriseCostOfStates = new double[maxInventoryCapcity+1][demands.length+1]; 
		
		for (int i = 0; i < memoriseCostOfStates.length; i++) {
			for (int j = 0; j < memoriseCostOfStates[i].length; j++) {
				
				memoriseCostOfStates[i][j] = Double.POSITIVE_INFINITY;
			}
		}
		
		memoriseProductionOfStates = new int[maxInventoryCapcity+1][numberOfPeriods+1];
		
		for (int i = 0; i < memoriseProductionOfStates.length; i++) {
			for (int j = 0; j < memoriseProductionOfStates[i].length; j++) {
				
				memoriseProductionOfStates[i][j] = Integer.MAX_VALUE;
			}
		}
	}



	public int[] getProductionPlan() {
		return productionPlan;
	}

	public void setProductionPlan(int[] productionPlan) {
		this.productionPlan = productionPlan;
	}

	public int[] getInventoryPlan() {
		return inventoryPlan;
	}

	public void setInventoryPlan(int[] inventoryPlan) {
		this.inventoryPlan = inventoryPlan;
	}	
	
	public double[][] getMemoriseCostOfStates() {
		return memoriseCostOfStates;
	}

	public int[][] getMemoriseProductionOfStates() {
		return memoriseProductionOfStates;
	}
		
	/**
	 * This method is the main method to plan production and inventory
	 */
	public void planProduction() {
		
		//Case 1: last period
		for (int i = 0; i <= inventoryCapacity[inventoryCapacity.length-1] ; i++) {
			
			int demand = demands[numberOfPeriods];
			
			memoriseProductionOfStates[i][numberOfPeriods] = 
					demand + endingInventory - i;
			
			memoriseCostOfStates[i][numberOfPeriods] = productionCost(demand + endingInventory - i);
					
		}
		
		//Case 2 intermediate periods; periods except first and last
		//for each period
		for (int j = numberOfPeriods-1; j > 0 ; j--) {
			
			//for each starting inventory level
			for (int i = 0; i <= inventoryCapacity[j]; i++) {
				
				//total cost will be production, production setup and inventory			
				memoriseCostOfStates[i][j] = totalCost(i, j);
			}
		}
		
		
		//Case 3 first period (index 1); starting inventory is 0 so different 
		int planningPeriod = 1;
			
		int demand = demands[planningPeriod];
		
		memoriseCostOfStates[0][planningPeriod] = totalCost(startingInventory, planningPeriod);

		
		/*
		 * find and write optimal
		 */
		
		//get optimal for first period and calculate inventory
		int periodProduction = memoriseProductionOfStates[0][1]; 
		
		productionPlan[1] = periodProduction;
		inventoryPlan[1] = productionPlan[1] - demands[1];
		
		//for the remaining periods 
		for (int i = 2; i < numberOfPeriods + 1; i++) {
			//get previous excess inventory
			int inventory = inventoryPlan[i-1]; 
			
			//(which is the starting inventory of this period)
			periodProduction = memoriseProductionOfStates[inventory][i]; 
			
			productionPlan[i] = periodProduction;
			
			inventoryPlan[i] =  productionPlan[i] - demands[i] + inventoryPlan[i-1];
		}		
	}
		

	/**This method calculates total cost for last period of planning season.
	 * This method is for Case 1 in which only production cost occurs.  
	 * 
	 * @param amountOfProduction amount of production
	 * 
	 * @return total cost due to production
	 */
	public double productionCost(int amountOfProduction) {
			
		if (amountOfProduction == 0) {
			return 0;
		}else {
			return setUpCostPerPeriodOfManufacture [numberOfPeriods]
				+ amountOfProduction*manufacturingCostPerProduct[numberOfPeriods];
		}
	}

	/**This method calculates total cost for periods of planning season except last period.
	 * This method is for Case 2 and 3.  
	 * 
	 * @param startingInventory starting inventory at the beginning of period.
	 * @param planningPeriod number of planning period.
	 * 
	 * @return returns the total cost of the given period.
	 */
	public double totalCost(int startingInventory, int planningPeriod) {
		
		//check if it is already calculated
		if (memoriseCostOfStates[startingInventory][planningPeriod] != Double.POSITIVE_INFINITY) {
			return memoriseCostOfStates[startingInventory][planningPeriod];
		}
		
		double minCost = Double.POSITIVE_INFINITY;
		
		int minCostProductionAmount = -1;
		
		int demand = demands[planningPeriod];
		
		int minProductionAmount =  demand - startingInventory;
		int maxProductionAmount = Math.min(productionCapacity[planningPeriod], 
				inventoryCapacity[planningPeriod] - startingInventory + demand);
		
		//find min cost between 0 production to max production
		for (int i = minProductionAmount; i < maxProductionAmount + 1 ; i++) {

			double totalCost = Double.POSITIVE_INFINITY;
			
			//are we manufacturing ?
			if (i == 0) {
				//calculate cost
				totalCost = inventoryHoldingCostPerProduct[planningPeriod]*(startingInventory -demand) 
						+ totalCost(startingInventory -demand, planningPeriod + 1);
			} else {
				//calculate cost
				totalCost = setUpCostPerPeriodOfManufacture[planningPeriod] 
						+ i*manufacturingCostPerProduct[planningPeriod] 
								+ inventoryHoldingCostPerProduct[planningPeriod]*(startingInventory + i -demand) 
						+ totalCost(startingInventory + i -demand, planningPeriod + 1);
			}
					
			//assign if min cost
			if (totalCost < minCost) {
				minCost = totalCost;
				minCostProductionAmount = i;
			}
		}

		memoriseProductionOfStates[startingInventory][planningPeriod] = minCostProductionAmount;

		return minCost;
	}


	
	
	
	


}
