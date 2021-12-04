package com.packt.datastructuresandalg.lesson4.activity.project.bonus;

public class InventoryAndManufacturingPlan {
	
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
	public InventoryAndManufacturingPlan(double inventoryHoldingCostPerProduct,
			double manufacturingCostPerProduct, double setUpCostPerPeriodOfManufacture, int productionCapacity,
			int inventoryCapacity, int[] demands, int startingInventory, int endingInventory) {
		
		//TODO constructor
		
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
	public InventoryAndManufacturingPlan(double[] inventoryHoldingCostPerProduct,
			double[] manufacturingCostPerProduct, double[] setUpCostPerPeriodOfManufacture, int[] productionCapacity,
			int[] inventoryCapacity, int startingInventory, int endingInventory, int[] demands) {

		//TODO constructor
		
	}



	public int[] getProductionPlan() {
		
		//TODO getProductionPlan()
		
		return null;
	}

	public void setProductionPlan(int[] productionPlan) {
		
		//TODO setProductionPlan()

	}

	public int[] getInventoryPlan() {
		
		//TODO getInventoryPlan()
		
		return null;
	}

	public void setInventoryPlan(int[] inventoryPlan) {
		
		//TODO setInventoryPlan

	}	
	
	public double[][] getMemoriseCostOfStates() {
		
		//TODO getMemoriseCostOfStates
		
		return null;
	}

	public int[][] getMemoriseProductionOfStates() {
		
		//TODO getMemoriseProductionOfStates
		
		return null;
	}
		
	/**
	 * This method is the main method to plan production and inventory
	 */
	public void planProduction() {
		
		//TODO planProduction()
		
	}
		

	/**
	 * 
	 */
	public double productionCost(int amountOfProduction) {
		
		//TODO productionCost()
		
		return -1;
	}

	/**
	 * 
	 */
	public double totalCost(int startingInventory, int planningPeriod) {

		//TODO totalCost
		
		return -1;
	}


	
	
	
	


}
