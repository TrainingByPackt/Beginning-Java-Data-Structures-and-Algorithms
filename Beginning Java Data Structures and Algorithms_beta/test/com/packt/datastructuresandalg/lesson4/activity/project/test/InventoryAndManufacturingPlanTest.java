package com.packt.datastructuresandalg.lesson4.activity.project.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.packt.datastructuresandalg.lesson4.activity.project.InventoryAndManufacturingPlanSolution;

class InventoryAndManufacturingPlanTest {

	public static double inventoryHoldingCostPerProduct;
	public static double manufacturingCostPerProduct;
	public static double setUpCostPerPeriodOfManufacture;
	
	public static int productionCapacity; 
	public static int inventoryCapacity;
	
	public static int[] demands;
	
	public static int[] expectedProductionPlan;
	public static int[] expectedInventoryPlan;

	
	public static double[][] expectedMemoriseCostOfStates; 

	public static int[][] expectedMemoriseProductionOfStates; 
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		inventoryHoldingCostPerProduct = 0.5;
		manufacturingCostPerProduct = 1;
		setUpCostPerPeriodOfManufacture = 3;
		
		productionCapacity = 5;
		inventoryCapacity = 4;
		
		demands = new int[]{1,3,2,4};
		
		expectedProductionPlan = new int[] {0, 1, 5, 0, 4};
		
		expectedInventoryPlan = new int[] {0, 0, 2, 0, 0};

		
		expectedMemoriseCostOfStates = new double[][] {
			{Double.POSITIVE_INFINITY, 20.0, 16.0, 12.0, 7.0}, 
			{Double.POSITIVE_INFINITY, 16.0, 15.0, 10.0, 6.0}, 
			{Double.POSITIVE_INFINITY, 15.5, 14.0, 7.0, 5.0}, 
			{Double.POSITIVE_INFINITY, 15.0, 12.0, 6.5, 4.0}, 
			{Double.POSITIVE_INFINITY, 13.5, 10.5, 6.0, 0.0}}; 

		expectedMemoriseProductionOfStates = new int[][] {
			{2147483647, 1, 5, 2, 4}, 
			{2147483647, 0, 4, 5, 3}, 
			{2147483647, 0, 3, 0, 2}, 
			{2147483647, 0, 0, 0, 1}, 
			{2147483647, 0, 0, 0, 0}}; 
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {		
		demands = null;
		expectedProductionPlan = null;		
		expectedInventoryPlan = null;		
		expectedMemoriseCostOfStates = null;
		expectedMemoriseProductionOfStates = null; 
	}

	@Test
	void testPlanProduction() {
		
		
		int[] demand= {1,3,2,4};
		
		InventoryAndManufacturingPlanSolution plan = 
				new InventoryAndManufacturingPlanSolution(0.5, 1, 3, 5, 4, demand);
		
		plan.planProduction();
		
		//check inventory plan
		assertArrayEquals(expectedInventoryPlan, plan.getInventoryPlan());
		
		//check production plan
		assertArrayEquals(expectedProductionPlan, plan.getProductionPlan());

	}

	@Test
	void testProductionCost() {
		
		int[] demand= {1,3,2,4};
		
		InventoryAndManufacturingPlanSolution plan = 
				new InventoryAndManufacturingPlanSolution(0.5, 1, 3, 5, 4, demand);
		
		//check costs for last period		
		assertEquals(expectedMemoriseCostOfStates[0][4],plan.productionCost(demand[3]-0));
		assertEquals(expectedMemoriseCostOfStates[1][4],plan.productionCost(demand[3]-1));
		assertEquals(expectedMemoriseCostOfStates[2][4],plan.productionCost(demand[3]-2));
	}

	@Test
	void testTotalCost() {
		
		int[] demands= {1,3,2,4};
		
		InventoryAndManufacturingPlanSolution plan = 
				new InventoryAndManufacturingPlanSolution(0.5, 1, 3, 5, 4, demands);
		
		double[][] costofStates = plan.getMemoriseCostOfStates();
		
		costofStates[0][4]= 7;
		costofStates[1][4]= 6;
		costofStates[2][4]= 5;
		costofStates[3][4]= 4;
		costofStates[4][4]= 0;
		
		assertEquals(expectedMemoriseCostOfStates[0][3], plan.totalCost(0, 3));
		
		
		//check intermediate periods & first period
		for (int j = 3; j > 0 ; j--) {
			
			//for each starting inventory level
			for (int i = 0; i <= 4; i++) {
				System.out.println(i);
				//total cost will be production, production setup and inventory			
				assertEquals(expectedMemoriseCostOfStates[i][j], plan.totalCost(i, j));
			}
		}		
	}
}
