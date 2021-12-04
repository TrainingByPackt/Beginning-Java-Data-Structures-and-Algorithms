package com.packt.datastructuresandalg.lesson4.activity.project;

public class InventoryAndManufacturingPlan {
	
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
	 * @param inventoryHoldingCostPerProduct 
	 * @param manufacturingCostPerProduct 
	 * @param setUpCostPerPeriodOfManufacture 
	 * @param productionCapacity 
	 * @param inventoryCapacity 
	 * @param demands market demand per period and index 0 must be undefined (-1),
	 * values should start from index 1
	 */
	public InventoryAndManufacturingPlan(double inventoryHoldingCostPerProduct,
			double manufacturingCostPerProduct, double setUpCostPerPeriodOfManufacture, int productionCapacity,
			int inventoryCapacity, int[] demands) {
		super();

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
		
		//TODO setInventoryPlan()
		
	}	
	
	public double[][] getMemoriseCostOfStates() {
		
		//TODO getMemoriseCostOfStates()
		
		return null;
	}

	public int[][] getMemoriseProductionOfStates() {
		
		//TODO getMemoriseProductionOfStates()
		
		return null;
	}
		
	/**
	 * 
	 */
	public void planProduction() {
		
		//TODO planProduction()
		
		//Case 1: last period
		
		
		//Case 2 intermediate periods; periods except first and last
		//for each period
		
			
			//for each starting inventory level

				
				//total cost will be production, production setup and inventory			

		
		//Case 3 first period (index 1); starting inventory is 0 so different 
		
		/*
		 * find and write optimal
		 */
		
		//get optimal for first period and calculate inventory

		
		//for the remaining periods 

			//get previous excess inventory

			
	}
		

	public double productionCost(int amountOfProduction) {

		//TODO productionCost()
		
		return -1;
	}


	public double totalCost(int startingInventory, int planningPeriod) {
		
		//TODO totalCost()
		
		//check if it is already calculated

		

		
		//find min production amount to max production amount

			//are we manufacturing ?

			
			//calculate cost

			//assign if min cost

		return -1;
	}
}
