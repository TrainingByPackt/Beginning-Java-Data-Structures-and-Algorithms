package com.packt.datastructuresandalg.lesson1.activity.project.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.packt.datastructuresandalg.lesson1.activity.project.SimilarCustomer;
import com.packt.datastructuresandalg.lesson1.activity.project.SimilarCustomerOld;

public class SimilarCustomerTest {
	
	private static SimilarCustomer similarCustomer = new SimilarCustomer();
	
	private static double[][] customerBehaviorMatrixBig;
	private static double[][] customerBehaviorMatrixSmall;
	private static double[][] customerBehaviorMatrixEmpty;
	private static double[][] expectedMinMaxMatrixSmall;
	private static double[][] expectedMinMaxMatrixEmpty;
	private static double[][] expectedNormalizedMatrixBig;
	private static double[][] expectedNormalizedMatrixSmall; 
	private static double[][] expectedNormalizedMatrixEmpty;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		customerBehaviorMatrixBig = new double [][]{
			 {1, 32, 2, 3, 0, 0, 0, 2, 0, 1, 2, 0, 3, 0, 0, 0, 0, 0, 2, 3, 0, 2},
			 {2, 21, 2, 5, 0, 0, 1, 2, 1, 2, 0, 3, 0, 2, 0, 0, 0, 2, 0, 0, 1, 1},
			 {3, 56, 3, 3, 0, 0, 0, 2, 3, 1, 2, 0, 3, 0, 0, 1, 0, 0, 0, 2, 0, 0},
			 {1, 18, 2, 3, 0, 0, 0, 2, 5, 1, 0, 1, 0, 0, 0 ,0, 0, 0, 1, 1, 0, 0},
			 {2, 45, 4, 4, 0, 0, 0, 2, 3, 5, 1, 2, 0, 3, 3, 0, 1, 2, 0, 0, 1, 0},
			 {1, 27, 2, 3, 0, 0, 1, 2, 7, 6, 0, 0, 3, 0, 0, 0, 2, 0, 0, 1, 1, 0}};
		 
		customerBehaviorMatrixSmall = new double [][]{
			 {1, 2, 3, 0 ,0 ,0},
			 {2, 2, 5, 0 ,0 ,1},
			 {3, 3, 3, 0 ,0 ,0}};
			 
		 customerBehaviorMatrixEmpty = new double [2][6];
		 
		expectedMinMaxMatrixSmall = new double[][] {
			 {1, 2, 3, 0 ,0 ,0},
			 {3, 3, 5, 0 ,0 ,1},
		};
		
		expectedMinMaxMatrixEmpty = new double[2][6];
			
		expectedNormalizedMatrixSmall = new double[][] {
			{0, 0, 0, 0 ,0 ,0},
			{0.5, 0, 1, 0 ,0 ,1},
			{1, 1, 0, 0 ,0 ,0}};
			
		expectedNormalizedMatrixEmpty = new double[2][6];
		
		expectedNormalizedMatrixBig = new double[][]{																							
			{0,		0.368421053, 	0,		0, 	0,	0,	0,	0,	0,			 0,		1,		0,			 1,	0,			 0,	0,	0,	 0,	1,	 		1,			 0,	1	},
			{0.5,	0.078947368,	0,		1,	0,	0,	1,	0,	0.142857143, 0.2,	0,		1,			 0,	0.666666667, 0,	0,	0,	 1,	0,	 		0,			 1,	0.5	},
			{1,		1, 				0.5,	0,	0,	0,	0,	0,	0.428571429, 0,		1,		0,			 1,	0,			 0,	1,	0,	 0,	0,	 		0.666666667, 0,	0	},
			{0,		0,				0,		0,	0,	0,	0,	0,	0.714285714, 0,		0,		0.333333333, 0,	0,			 0,	0,	0,	 0,	0.5, 		0.333333333, 0,	0	},
			{0.5,	0.710526316,	1,		0.5,0,	0,	0,	0,	0.428571429, 0.8,	0.5,	0.666666667, 0,	1,			 1,	0,	0.5, 1,	0,	 		0,			 1,	0	},
			{0,		0.236842105,	0,		0,	0,	0,	1,	0,	1,			 1,	 	0,		0,			 1,	0,			 0,	0,	1,	0,	 0,			0.333333333, 1,	0	}};																						

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		similarCustomer = null;
		customerBehaviorMatrixBig = null;
		customerBehaviorMatrixSmall = null;
		customerBehaviorMatrixEmpty = null;
		expectedMinMaxMatrixSmall = null;
		expectedMinMaxMatrixEmpty = null;
		expectedNormalizedMatrixBig = null;
		expectedNormalizedMatrixSmall = null;
		expectedNormalizedMatrixEmpty = null;
	}

	@Test
	public void findMinMaxValuesOfEachColumnTest() {

		double[][] calculatedMinMaxMatrixSmall = 
				similarCustomer.findMinMaxValuesOfEachColumn(customerBehaviorMatrixSmall);
		
		assertArrayEquals(expectedMinMaxMatrixSmall, calculatedMinMaxMatrixSmall);	

		double[][] calculatedMinMaxMatrixEmpty = 
				similarCustomer.findMinMaxValuesOfEachColumn(customerBehaviorMatrixEmpty);
		
		assertArrayEquals(expectedMinMaxMatrixEmpty, calculatedMinMaxMatrixEmpty);
	}
	
	@Test
	public void normalizedCustomerBehaviourMatrixTest() {
		double[][] calculatedNormalizedMatrixBig = 
				similarCustomer.calculateNormalizedCustomerBehaviorMatrix(customerBehaviorMatrixBig);
		
		for (int i = 0; i < calculatedNormalizedMatrixBig.length; i++) {
			assertArrayEquals(expectedNormalizedMatrixBig[i], calculatedNormalizedMatrixBig[i], 0.001);
		}
		
		
		
		double[][] calculatedNormalizedMatrixSmall = 
				similarCustomer.calculateNormalizedCustomerBehaviorMatrix(customerBehaviorMatrixSmall);
		
		assertArrayEquals(expectedNormalizedMatrixSmall, calculatedNormalizedMatrixSmall);
		

		double[][] calculatedNormalizedMatrixEmpty = 
				similarCustomer.calculateNormalizedCustomerBehaviorMatrix(customerBehaviorMatrixEmpty);
				
		assertArrayEquals(expectedNormalizedMatrixEmpty, calculatedNormalizedMatrixEmpty);
	}
	

	@Test
	public void calculateEuclideanDistanceTest() {
		
		assertEquals(0, similarCustomer.calculateEuclideanDistance(
				customerBehaviorMatrixEmpty[0], customerBehaviorMatrixEmpty[1]), 0.000_001);
		
		assertEquals(Math.sqrt(3.25), similarCustomer.calculateEuclideanDistance(
				expectedNormalizedMatrixSmall[1], expectedNormalizedMatrixSmall[2]), 0.000_001);		
		
		assertEquals(Math.sqrt(6), similarCustomer.calculateEuclideanDistance(
				customerBehaviorMatrixSmall[1], customerBehaviorMatrixSmall[0]), 0.000_001);		
	}

	@Test
	public void findMostSimilarCustomerIndexTest() {
		int index_0_SimilarCustomer = similarCustomer.findMostSimilarCustomerIndex(expectedNormalizedMatrixBig, 0);
		int index_1_SimilarCustomer = similarCustomer.findMostSimilarCustomerIndex(expectedNormalizedMatrixBig, 1);
		int index_2_SimilarCustomer = similarCustomer.findMostSimilarCustomerIndex(expectedNormalizedMatrixBig, 2);
		int index_3_SimilarCustomer = similarCustomer.findMostSimilarCustomerIndex(expectedNormalizedMatrixBig, 3);
		int index_4_SimilarCustomer = similarCustomer.findMostSimilarCustomerIndex(expectedNormalizedMatrixBig, 4);
		int index_5_SimilarCustomer = similarCustomer.findMostSimilarCustomerIndex(expectedNormalizedMatrixBig, 5);
		
		assertEquals(3, index_0_SimilarCustomer);
		assertEquals(4, index_1_SimilarCustomer);
		assertEquals(0, index_2_SimilarCustomer);
		assertEquals(0, index_3_SimilarCustomer);
		assertEquals(1, index_4_SimilarCustomer);
		assertEquals(3, index_5_SimilarCustomer);
	}
	
	@Test
	public void findMostSimilarCustomerTest() {
		
		int index_0_SimilarCustomer = similarCustomer.findMostSimilarCustomer(customerBehaviorMatrixBig, 0);
		int index_1_SimilarCustomer = similarCustomer.findMostSimilarCustomer(customerBehaviorMatrixBig, 1);
		int index_2_SimilarCustomer = similarCustomer.findMostSimilarCustomer(customerBehaviorMatrixBig, 2);
		int index_3_SimilarCustomer = similarCustomer.findMostSimilarCustomer(customerBehaviorMatrixBig, 3);
		int index_4_SimilarCustomer = similarCustomer.findMostSimilarCustomer(customerBehaviorMatrixBig, 4);
		int index_5_SimilarCustomer = similarCustomer.findMostSimilarCustomer(customerBehaviorMatrixBig, 5);
		
		assertEquals(3, index_0_SimilarCustomer);
		assertEquals(4, index_1_SimilarCustomer);
		assertEquals(0, index_2_SimilarCustomer);
		assertEquals(0, index_3_SimilarCustomer);
		assertEquals(1, index_4_SimilarCustomer);
		assertEquals(3, index_5_SimilarCustomer);
	}
	
	@Test
	public void findMostSimilarCustomerOldTest() {
		
		SimilarCustomerOld customerOld = new SimilarCustomerOld();
		
		int index_0_SimilarCustomer = customerOld.findMostSimilarCustomer(customerBehaviorMatrixBig, 0);
		int index_1_SimilarCustomer = customerOld.findMostSimilarCustomer(customerBehaviorMatrixBig, 1);
		int index_2_SimilarCustomer = customerOld.findMostSimilarCustomer(customerBehaviorMatrixBig, 2);
		int index_3_SimilarCustomer = customerOld.findMostSimilarCustomer(customerBehaviorMatrixBig, 3);
		int index_4_SimilarCustomer = customerOld.findMostSimilarCustomer(customerBehaviorMatrixBig, 4);
		int index_5_SimilarCustomer = customerOld.findMostSimilarCustomer(customerBehaviorMatrixBig, 5);
		
		assertEquals(3, index_0_SimilarCustomer);
		assertEquals(4, index_1_SimilarCustomer);
		assertEquals(0, index_2_SimilarCustomer);
		assertEquals(0, index_3_SimilarCustomer);
		assertEquals(1, index_4_SimilarCustomer);
		assertEquals(3, index_5_SimilarCustomer);
	}
	
	@Test
	public void outPerformOldAlgorithmTest() {
		SimilarCustomerOld customerOld = new SimilarCustomerOld();
		
		Instant startTimeOld = Instant.now();
		
		for (int i = 0; i < 1_000_000; i++) {
			
			int index = i%6;
			customerOld.findMostSimilarCustomer(customerBehaviorMatrixBig, index);
			
		}
		
		Instant finishTimeOld = Instant.now();
		
		Duration timeElapsedOld = Duration.between(startTimeOld, finishTimeOld);
		long oldAlgorithmRuntime = timeElapsedOld.toNanos();
		
		Instant startTimeNew = Instant.now();
		
		for (int i = 0; i < 1_000_000; i++) {
			
			int index = i%6;
			similarCustomer.findMostSimilarCustomer(customerBehaviorMatrixBig, index);
			
		}
				
		Instant finishTimeNew = Instant.now();
		
		Duration timeElapsedNew = Duration.between(startTimeNew, finishTimeNew);
		
		long newAlgorithmRuntime = timeElapsedNew.toNanos();
		
		boolean isOutPerformed = newAlgorithmRuntime < oldAlgorithmRuntime ;
		
		System.out.println("Runtime of old algorithm in Nanos: " + oldAlgorithmRuntime);
		System.out.println("Runtime of new algorithm in Nanos: " + newAlgorithmRuntime);
		
		//must outperform the old algorithm
		assertTrue(isOutPerformed,
				"New algorithm must have a better runtime performance than the old algorithm!");
	}
}
