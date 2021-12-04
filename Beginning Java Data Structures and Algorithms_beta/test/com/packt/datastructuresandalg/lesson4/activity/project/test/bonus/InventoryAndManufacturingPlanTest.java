package com.packt.datastructuresandalg.lesson4.activity.project.test.bonus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.packt.datastructuresandalg.lesson4.activity.project.bonus.InventoryAndManufacturingPlanSolution;

class InventoryAndManufacturingPlanTest {

	public static double inventoryHoldingCostPerProduct;
	public static double manufacturingCostPerProduct;
	public static double setUpCostPerPeriodOfManufacture;
	
	public static int productionCapacity; 
	public static int inventoryCapacity;
	
	public static int[] demands;
	
	public static int[] expectedProductionPlan;
	public static int[] expectedInventoryPlan;

	public static int[] expectedProductionPlan2;
	public static int[] expectedInventoryPlan2;
	
	public static double[][] expectedMemoriseCostOfStates; 
	public static double[][] expectedMemoriseCostOfStates2; 

	public static int[][] expectedMemoriseProductionOfStates; 
	public static int[][] expectedMemoriseProductionOfStates2; 
	
	public static double[] inventoryHoldingCostPerProductArray;
	public static double[] manufacturingCostPerProductArray;
	public static double[] setUpCostPerPeriodOfManufactureArray;
	public static int[] productionCapacityArray; 
	public static  int[] inventoryCapacityArray; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		inventoryHoldingCostPerProduct = 0.5;
		manufacturingCostPerProduct = 1;
		setUpCostPerPeriodOfManufacture = 3;
		
		productionCapacity = 5;
		inventoryCapacity = 4;
		
		demands = new int[]{1,3,2,4};
		
		expectedProductionPlan = new int[] {0, 1, 5, 0, 4};
		
		expectedInventoryPlan = new int[] {0, 0, 2, 0, 0, 0};

		
		expectedMemoriseCostOfStates = new double[][] {
			{Double.POSITIVE_INFINITY, 20.0, 16.0, 12.0, 7.0}, 
			{Double.POSITIVE_INFINITY, 16.0, 15.0, 10.0, 6.0}, 
			{Double.POSITIVE_INFINITY, 15.5, 14.0, 7.0, 5.0}, 
			{Double.POSITIVE_INFINITY, 15.0, 12.0, 6.5, 4.0}, 
			{Double.POSITIVE_INFINITY, 13.5, 10.5, 6.0, 0.0}}; 
			
		expectedMemoriseCostOfStates2 = new double[][] {
			{Double.POSITIVE_INFINITY, 21.5, 22.0, 15.0, 9.0, Double.POSITIVE_INFINITY}, 
			{Double.POSITIVE_INFINITY, 22.0, 20.0, 13.5, 8.0, Double.POSITIVE_INFINITY}, 
			{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 17.0, 9.0, 7.0, Double.POSITIVE_INFINITY}, 
			{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 15.0, Double.POSITIVE_INFINITY, 6.0, Double.POSITIVE_INFINITY}, 
			{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 5.0, Double.POSITIVE_INFINITY}};

		expectedMemoriseProductionOfStates = new int[][] {
			{2147483647, 1, 5, 2, 4}, 
			{2147483647, 0, 4, 5, 3}, 
			{2147483647, 0, 3, 0, 2}, 
			{2147483647, 0, 0, 0, 1}, 
			{2147483647, 0, 0, 0, 0}}; 
		
		expectedMemoriseProductionOfStates2 = new int[][] {
			{2147483647, 1, 3, 2, 7}, 
			{2147483647, 0, 2, 1, 6}, 
			{2147483647, 2147483647, 3, 0, 5}, 
			{2147483647, -1, 0, 0, 4}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 3}}; 
		
		expectedProductionPlan2 = new int[] {0, 1, 3, 2, 7};
		
		expectedInventoryPlan2 = new int[] {3, 0, 0, 0, 3};

		inventoryHoldingCostPerProductArray = new double[] {0, 0.5, 0.5, 1, 1};
		manufacturingCostPerProductArray = new double[] {1, 1, 2, 1.5, 1};
		setUpCostPerPeriodOfManufactureArray = new double[] {3, 2, 1, 3, 2};
		productionCapacityArray = new int[] {0, 1, 3, 2, 4}; 
		inventoryCapacityArray = new int[] {0, 1, 3, 2, 4}; 
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {		
		demands = null;
		
		expectedProductionPlan = null;		
		expectedInventoryPlan = null;	
		expectedProductionPlan2 = null;		
		expectedInventoryPlan2 = null;	
		
		expectedMemoriseCostOfStates = null;
		expectedMemoriseProductionOfStates = null; 
		expectedMemoriseCostOfStates2 = null;
		expectedMemoriseProductionOfStates2 = null;
		
		inventoryHoldingCostPerProductArray = null;
		manufacturingCostPerProductArray = null;
		setUpCostPerPeriodOfManufactureArray = null;
		productionCapacityArray = null; 
		inventoryCapacityArray = null; 
	}

	@Test
	void testPlanProduction() {
		
		
		int[] demand= {0, 1,3,2,4};
		
		InventoryAndManufacturingPlanSolution plan = 
				new InventoryAndManufacturingPlanSolution(0.5, 1, 3, 5, 4, demand, 0, 0);
		
		plan.planProduction();
		
		//check inventory plan
		assertArrayEquals(expectedInventoryPlan, plan.getInventoryPlan());
		
		//check production plan
		assertArrayEquals(expectedProductionPlan, plan.getProductionPlan());
		


		InventoryAndManufacturingPlanSolution plan2 = new InventoryAndManufacturingPlanSolution(inventoryHoldingCostPerProductArray,
				manufacturingCostPerProductArray, setUpCostPerPeriodOfManufactureArray, productionCapacityArray,
				inventoryCapacityArray, 3, 3, demand);
		
		plan2.planProduction();
		
		//check inventory plan
		assertArrayEquals(expectedInventoryPlan2, plan2.getInventoryPlan());
		
		//check production plan
		assertArrayEquals(expectedProductionPlan2, plan2.getProductionPlan());
	}

	@Test
	void testProductionCost() {
		
		int[] demand= {0,1,3,2,4};
		
		InventoryAndManufacturingPlanSolution plan = 
				new InventoryAndManufacturingPlanSolution(0.5, 1, 3, 5, 4, demand, 0, 0);
		
		//check costs for last period		
		assertEquals(expectedMemoriseCostOfStates[0][4],plan.productionCost(demand[4]-0));
		assertEquals(expectedMemoriseCostOfStates[1][4],plan.productionCost(demand[4]-1));
		assertEquals(expectedMemoriseCostOfStates[2][4],plan.productionCost(demand[4]-2));
		
		InventoryAndManufacturingPlanSolution plan2 = new InventoryAndManufacturingPlanSolution(inventoryHoldingCostPerProductArray,
				manufacturingCostPerProductArray, setUpCostPerPeriodOfManufactureArray, productionCapacityArray,
				inventoryCapacityArray, 3, 3, demand);
		
		plan2.planProduction();
		
		//check costs for last period		
		assertEquals(expectedMemoriseCostOfStates2[0][4],plan2.productionCost(demand[4]-0 + 3));
		assertEquals(expectedMemoriseCostOfStates2[1][4],plan2.productionCost(demand[4]-1 + 3));
		assertEquals(expectedMemoriseCostOfStates2[2][4],plan2.productionCost(demand[4]-2 + 3));
		
	}

	@Test
	void testTotalCost() {
		
		int[] demands= {0, 1, 3, 2, 4};
		
		InventoryAndManufacturingPlanSolution plan = 
				new InventoryAndManufacturingPlanSolution(0.5, 1, 3, 5, 4, demands, 0, 0);
		
		double[][] costofStates = plan.getMemoriseCostOfStates();
		
		costofStates[0][4]= 7;
		costofStates[1][4]= 6;
		costofStates[2][4]= 5;
		costofStates[3][4]= 4;
		costofStates[4][4]= 0;
		
		assertEquals(expectedMemoriseCostOfStates[0][4], plan.totalCost(0, 4));
		
		
		//check intermediate periods & first period
		for (int j = 3; j > 0 ; j--) {
			
			//for each starting inventory level
			for (int i = 0; i <= 4; i++) {
				//total cost will be production, production setup and inventory			
				assertEquals(expectedMemoriseCostOfStates[i][j], plan.totalCost(i, j));
			}
		}
		
		InventoryAndManufacturingPlanSolution plan2 = new InventoryAndManufacturingPlanSolution(inventoryHoldingCostPerProductArray,
				manufacturingCostPerProductArray, setUpCostPerPeriodOfManufactureArray, productionCapacityArray,
				inventoryCapacityArray, 3, 3, demands);
		
		costofStates = plan2.getMemoriseCostOfStates();
		
		costofStates[0][4]= 9;
		costofStates[1][4]= 8;
		costofStates[2][4]= 7;
		costofStates[3][4]= 6;
		costofStates[4][4]= 5;
		
		assertEquals(expectedMemoriseCostOfStates2[0][4], plan2.totalCost(0, 4));
		
		//check intermediate periods
		for (int j = 3; j > 1 ; j--) {

			//for each starting inventory level
			for (int i = 0; i <= 4; i++) {
				//total cost will be production, production setup and inventory			

				//check if calculated during dynamic programming recursion
				if (expectedMemoriseCostOfStates2[i][j] != Double.POSITIVE_INFINITY) {
					assertEquals(expectedMemoriseCostOfStates2[i][j], plan2.totalCost(i, j));
				}
				
			}
		}		
	}
}
