package com.packt.datastructuresandalg.lesson4.activity.project;

public class InventoryAndManufacturingPlanSolution {
	
	private int numberOfPeriods; // planning period
	private double inventoryHoldingCostPerProduct;
	private double manufacturingCostPerProduct;
	private double setUpCostPerPeriodOfManufacture;
	
	private int productionCapacity; // limit of production per period  
	private int inventoryCapacity; // limit of production per period capacity
	
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
	 */
	public InventoryAndManufacturingPlanSolution(double inventoryHoldingCostPerProduct,
			double manufacturingCostPerProduct, double setUpCostPerPeriodOfManufacture, int productionCapacity,
			int inventoryCapacity, int[] demands) {
		super();
		this.inventoryHoldingCostPerProduct = inventoryHoldingCostPerProduct;
		this.manufacturingCostPerProduct = manufacturingCostPerProduct;
		this.setUpCostPerPeriodOfManufacture = setUpCostPerPeriodOfManufacture;
		this.productionCapacity = productionCapacity;
		this.inventoryCapacity = inventoryCapacity;
		
		this.demands = new int[demands.length+1];
		this.demands[0] = -1;
		System.arraycopy(demands, 0, this.demands, 1, demands.length);
		
		productionPlan = new int [demands.length+1];
		inventoryPlan = new int[demands.length+1];
		
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
		
		this.numberOfPeriods = demands.length;
		
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
		for (int i = 0; i <= inventoryCapacity ; i++) {
			
			int demand = demands[numberOfPeriods];
			
			memoriseProductionOfStates[i][numberOfPeriods] = demand-i;
			
			memoriseCostOfStates[i][numberOfPeriods] = productionCost(demand-i);		
		}
		
		//Case 2 intermediate periods; periods except first and last
		//for each period
		for (int j = numberOfPeriods-1; j > 0 ; j--) {
			
			//for each starting inventory level
			for (int i = 0; i <= inventoryCapacity; i++) {
				
				//total cost will be production, production setup and inventory			
				memoriseCostOfStates[i][j] = totalCost(i, j);
			}
		}
		
		
		//Case 3 first period (index 1); starting inventory is 0 so different 
		int planningPeriod = 1;
			
		int demand = demands[planningPeriod];
		
		memoriseCostOfStates[0][planningPeriod] = totalCost(0, planningPeriod);
		
		/*
		 * find and write optimal
		 */
		
		//get optimal for first period and calculate inventory
		int periodProduction = memoriseProductionOfStates[0][1]; 
		
		productionPlan[1] = periodProduction;
		inventoryPlan[1] = productionPlan[1] - demands[1];
		
		//for the remaining periods 
		for (int i = 2; i < productionPlan.length; i++) {
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
			return setUpCostPerPeriodOfManufacture 
				+ amountOfProduction*manufacturingCostPerProduct;
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
		int maxProductionAmount = Math.min(productionCapacity, 
				inventoryCapacity - startingInventory + demand);
		
		//find min production amount to max production amount
		for (int i = minProductionAmount; i < maxProductionAmount + 1 ; i++) {

			double totalCost = Double.POSITIVE_INFINITY;
			
			//are we manufacturing ?
			if (i == 0) {
				//calculate cost
				totalCost = inventoryHoldingCostPerProduct*(startingInventory -demand) 
						+ totalCost(startingInventory -demand, planningPeriod + 1);
			} else {
				//calculate cost
				totalCost = setUpCostPerPeriodOfManufacture
						+ i*manufacturingCostPerProduct + inventoryHoldingCostPerProduct*(startingInventory + i -demand) 
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
