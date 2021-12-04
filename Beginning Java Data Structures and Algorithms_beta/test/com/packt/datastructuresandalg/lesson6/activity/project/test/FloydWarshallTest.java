package com.packt.datastructuresandalg.lesson6.activity.project.test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.packt.datastructuresandalg.lesson6.activity.project.*;

class FloydWarshallTest {
	
	public static FloydWarshall case1;
	public static FloydWarshall case2;
	public static FloydWarshall case3;
	public static FloydWarshall case4;
	public static FloydWarshall case5;
	
	public static int[][] adjacencyMatrixCase1;
	public static int[][] adjacencyMatrixCase2;
	public static int[][] adjacencyMatrixCase3;
	public static int[][] adjacencyMatrixCase4;
	public static int[][] adjacencyMatrixCase5;
	
	public static int[][] comeFromMatrixCase1;
	public static int[][] comeFromMatrixCase2;
	public static int[][] comeFromMatrixCase3;
	public static int[][] comeFromMatrixCase4;
	public static int[][] comeFromMatrixCase5;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		case1 = new FloydWarshall(5);
		case1.addEdge(0, 1, 10, "20th St");
		case1.addEdge(0, 3, 5, "Folsom St");
		case1.addEdge(1, 3, 2, "Nobles Alley");
		case1.addEdge(1, 2, 1, "Winter Pl");
		case1.addEdge(2, 4, 4, "Rancho Drive");
		case1.addEdge(3, 1, 3, "Lexington St");
		case1.addEdge(3, 2, 9, "Spruce Ave");
		case1.addEdge(3, 4, 2, "Morgan Rd");
		case1.addEdge(4, 2, 6, "Oakley Blvd");

		adjacencyMatrixCase1 = new int[][] {
			{0, 8, 9, 5, 7},
			{2147483647, 0, 1, 2, 4},
			{2147483647, 2147483647, 0, 2147483647, 4},
			{2147483647, 3, 4, 0, 2},
			{2147483647, 2147483647, 6, 2147483647, 0}};
		
		comeFromMatrixCase1 = new int[][] {
			{0, 3, 1, 0, 3},
			{-1, 1, 1, 1, 3},
			{-1, -1, 2, -1, 2},
			{-1, 3, 1, 3, 3},
			{-1, -1, 4, -1, 4}};
		
		
		case2 = new FloydWarshall(7);
		case2.addEdge(1, 2, 4, "20th St");
		case2.addEdge(1, 3, 3, "Winter Pl");
		case2.addEdge(2, 4, 3, "Lexington St");
		case2.addEdge(2, 5, 2, "Rancho Drive");
		case2.addEdge(3, 5, 3, "Spruce Ave");
		case2.addEdge(4, 6, 2, "Morgan Rd");
		case2.addEdge(5, 6, 2, "Oakley Blvd");
		
		adjacencyMatrixCase2 = new int[][] {
			{0, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}, 
			{2147483647, 0, 4, 3, 7, 6, 8}, {2147483647, 2147483647, 0, 2147483647, 3, 2, 4}, 
			{2147483647, 2147483647, 2147483647, 0, 2147483647, 3, 5}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 0, 2147483647, 2}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 0, 2}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 0}};
		
		comeFromMatrixCase2 = new int[][] {
			{0, -1, -1, -1, -1, -1, -1}, 
			{-1, 1, 1, 1, 2, 2, 5}, 
			{-1, -1, 2, -1, 2, 2, 5}, 
			{-1, -1, -1, 3, -1, 3, 5}, 
			{-1, -1, -1, -1, 4, -1, 4}, 
			{-1, -1, -1, -1, -1, 5, 5}, 
			{-1, -1, -1, -1, -1, -1, 6}};
			
		case3 = new FloydWarshall(6);
		case3.addEdge(1, 2, 2, "Oakley Blvd");
		case3.addEdge(1, 3, 8, "20th St");
		case3.addEdge(2, 3, 5, "Spruce Ave");
		case3.addEdge(2, 4, 4, "Rancho Drive");
		case3.addEdge(2, 5, 12, "Lexington St");
		case3.addEdge(3, 4, 6, "Morgan Rd");
		case3.addEdge(4, 5, 10, "Winter Pl");
		
		adjacencyMatrixCase3 = new int[][]{
			{0, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}, 
			{2147483647, 0, 2, 7, 6, 14}, 
			{2147483647, 2147483647, 0, 5, 4, 12}, 
			{2147483647, 2147483647, 2147483647, 0, 6, 16}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 0, 10}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 0}};
			
		comeFromMatrixCase3 = new int[][] {
			{0, -1, -1, -1, -1, -1}, 
			{-1, 1, 1, 2, 2, 2}, 
			{-1, -1, 2, 2, 2, 2}, 
			{-1, -1, -1, 3, 3, 4}, 
			{-1, -1, -1, -1, 4, 4}, 
			{-1, -1, -1, -1, -1, 5}};
			
		case4 = new FloydWarshall(11);
		case4.addEdge(1, 2, 2, "Folsom St");
		case4.addEdge(1, 3, 4, "Mission St");
		case4.addEdge(1, 4, 3, "18th St");
		case4.addEdge(2, 5, 7, "Oakley Blvd");
		case4.addEdge(2, 6, 4, "19th St");
		case4.addEdge(2, 7, 6, "20th St");
		case4.addEdge(3, 5, 3, "21th St");
		case4.addEdge(3, 6, 2, "Main St");
		case4.addEdge(3, 7, 4, "Keyes St");
		case4.addEdge(4, 5, 4, "Service Rd");
		case4.addEdge(4, 6, 1, "Industrial Way");
		case4.addEdge(4, 7, 5, "Rancho Drive");
		case4.addEdge(5, 8, 1, "Grant Ave");
		case4.addEdge(5, 9, 3, "Spruce Ave");
		case4.addEdge(6, 8, 6, "Valencia St");
		case4.addEdge(6, 9, 3, "Morgan Rd");
		case4.addEdge(7, 8, 3, "San Carlos St");
		case4.addEdge(7, 9, 3, "Nobles Alley");
		case4.addEdge(8, 10, 3, "Winter Pl");
		case4.addEdge(9, 10, 4, "Lexington St");
		
		adjacencyMatrixCase4 = new int[][] {
			{0, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}, 
			{2147483647, 0, 2, 4, 3, 7, 4, 8, 8, 7, 11}, 
			{2147483647, 2147483647, 0, 2147483647, 2147483647, 7, 4, 6, 8, 7, 11}, 
			{2147483647, 2147483647, 2147483647, 0, 2147483647, 3, 2, 4, 4, 5, 7}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 0, 4, 1, 5, 5, 4, 8}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 0, 2147483647, 2147483647, 1, 3, 4}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 0, 2147483647, 6, 3, 7}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 0, 3, 3, 6}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 0, 2147483647, 3}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 0, 4}, 
			{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 0}};
			
		comeFromMatrixCase4 = new int[][] {
			{0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, 
			{-1, 1, 1, 1, 1, 3, 4, 2, 5, 6, 8}, 
			{-1, -1, 2, -1, -1, 2, 2, 2, 5, 6, 8}, 
			{-1, -1, -1, 3, -1, 3, 3, 3, 5, 6, 8}, 
			{-1, -1, -1, -1, 4, 4, 4, 4, 5, 6, 8}, 
			{-1, -1, -1, -1, -1, 5, -1, -1, 5, 5, 8}, 
			{-1, -1, -1, -1, -1, -1, 6, -1, 6, 6, 9}, 
			{-1, -1, -1, -1, -1, -1, -1, 7, 7, 7, 8}, 
			{-1, -1, -1, -1, -1, -1, -1, -1, 8, -1, 8}, 
			{-1, -1, -1, -1, -1, -1, -1, -1, -1, 9, 9}, 
			{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10}};
			
			case5 = new FloydWarshall(11);
			case5.addEdge(1, 2, 2, "Mission St");
			case5.addEdge(1, 3, 4, "San Carlos St");
			case5.addEdge(1, 4, 3, "Lexington St");
			case5.addEdge(2, 5, 7, "Valencia St");
			case5.addEdge(2, 6, 4, "18th St");
			case5.addEdge(2, 7, 6, "19th St");
			case5.addEdge(3, 5, 3, "20th St");
			case5.addEdge(3, 6, 2, "21th St");
			case5.addEdge(3, 7, 4, "Folsom St");
			case5.addEdge(4, 5, 4, "Grant Ave");
			case5.addEdge(4, 6, 1, "Industrial Way");
			case5.addEdge(4, 7, 5, "Spruce Ave");
			case5.addEdge(5, 8, 1, "Service Rd");
			case5.addEdge(5, 9, 3, "Morgan Rd");
			case5.addEdge(6, 8, 6, "Main St");
			case5.addEdge(6, 9, 3, "Keyes St");
			case5.addEdge(7, 8, 3, "Rancho Drive");
			case5.addEdge(7, 9, 3, "Oakley Blvd");
			case5.addEdge(8, 10, 3, "Winter Pl");
			case5.addEdge(9, 10, 4, "Nobles Alley");
			
			case5.addEdge(2, 1, 2, "Mission St");
			case5.addEdge(3, 1, 4, "San Carlos St");
			case5.addEdge(4, 1, 3, "Lexington St");
			case5.addEdge(5, 2, 7, "Valencia St");
			case5.addEdge(6, 2, 4, "18th St");
			case5.addEdge(7, 2, 6, "19th St");
			case5.addEdge(5, 3, 3, "20th St");
			case5.addEdge(6, 3, 2, "21th St");
			case5.addEdge(7, 3, 4, "Folsom St");
			case5.addEdge(5, 4, 4, "Grant Ave");
			case5.addEdge(6, 4, 1, "Industrial Way");
			case5.addEdge(7, 4, 5, "Spruce Ave");
			case5.addEdge(8, 6, 6, "Main St");
			case5.addEdge(9, 6, 3, "Keyes St");
			case5.addEdge(8, 7, 3, "Rancho Drive");
			case5.addEdge(9, 7, 3, "Oakley Blvd");
			case5.addEdge(10, 8, 3, "Winter Pl");
			case5.addEdge(10, 9, 4, "Nobles Alley");
			
			adjacencyMatrixCase5 = new int[][] {
				{0, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}, 
				{2147483647, 0, 2, 4, 3, 7, 4, 8, 8, 7, 11}, 
				{2147483647, 2, 0, 6, 5, 7, 4, 6, 8, 7, 11}, 
				{2147483647, 4, 6, 0, 3, 3, 2, 4, 4, 5, 7}, 
				{2147483647, 3, 5, 3, 0, 4, 1, 5, 5, 4, 8}, 
				{2147483647, 7, 7, 3, 4, 0, 5, 4, 1, 3, 4},
				{2147483647, 4, 4, 2, 1, 5, 0, 6, 6, 3, 7}, 
				{2147483647, 8, 6, 4, 5, 7, 6, 0, 3, 3, 6}, 
				{2147483647, 10, 9, 7, 7, 10, 6, 3, 0, 6, 3}, 
				{2147483647, 7, 7, 5, 4, 8, 3, 3, 6, 0, 4}, 
				{2147483647, 11, 11, 9, 8, 12, 7, 6, 3, 4, 0}};
				
			comeFromMatrixCase5 = new int[][]{
				{0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, 1, 1, 1, 1, 3, 4, 2, 5, 6, 8}, 
				{-1, 2, 2, 1, 1, 2, 2, 2, 5, 6, 8}, 
				{-1, 3, 1, 3, 6, 3, 3, 3, 5, 6, 8},
				{-1, 4, 1, 6, 4, 4, 4, 4, 5, 6, 8}, 
				{-1, 3, 5, 5, 5, 5, 3, 8, 5, 5, 8}, 
				{-1, 4, 6, 6, 6, 3, 6, 3, 6, 6, 9}, 
				{-1, 2, 7, 7, 7, 3, 3, 7, 7, 7, 8}, 
				{-1, 4, 7, 7, 6, 3, 8, 8, 8, 7, 8},
				{-1, 4, 6, 6, 6, 3, 9, 9, 7, 9, 9}, 
				{-1, 4, 6, 6, 6, 3, 9, 8, 10, 10, 10}};
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		case1 = null;
		case2 = null;
		case3 = null;
		case4 = null;
		case5 = null;
		
		adjacencyMatrixCase1 = null;
		adjacencyMatrixCase2 = null;
		adjacencyMatrixCase3 = null;
		adjacencyMatrixCase4 = null;
		adjacencyMatrixCase5 = null;
		
		comeFromMatrixCase1 = null;
		comeFromMatrixCase2 = null;
		comeFromMatrixCase3 = null;
		comeFromMatrixCase4 = null;
		comeFromMatrixCase5 = null;
	}

	@Test
	void testRunCase1() {
		
		case1.run();
		
		assertArrayEquals(adjacencyMatrixCase1, case1.getAdjacencyMatrix());
		assertArrayEquals(comeFromMatrixCase1, case1.getNextToMAtrix());
	}

	@Test
	void testRunCase2() {
		
		case2.run();
				
		assertArrayEquals(adjacencyMatrixCase2, case2.getAdjacencyMatrix());
		assertArrayEquals(comeFromMatrixCase2, case2.getNextToMAtrix());
	}
	
	@Test
	void testRunCase3() {
		
		case3.run();
				
		assertArrayEquals(adjacencyMatrixCase3, case3.getAdjacencyMatrix());
		assertArrayEquals(comeFromMatrixCase3, case3.getNextToMAtrix());
	}
	
	@Test
	void testRunCase4() {
		
		case4.run();
				
		assertArrayEquals(adjacencyMatrixCase4, case4.getAdjacencyMatrix());
		assertArrayEquals(comeFromMatrixCase4, case4.getNextToMAtrix());

	}
	
	@Test
	void testRunCase5() {
		
		case5.run();
				
		assertArrayEquals(adjacencyMatrixCase5, case5.getAdjacencyMatrix());
		assertArrayEquals(comeFromMatrixCase5, case5.getNextToMAtrix());

	}
	
	@Test
	void testPathWithNames() {
		
		case5.run();
		
		String [] names = new String[4];
		names = case5.printPath(1, 10).toArray(names);
		
		String []  names2 = new String[1];
		names2 = case5.printPath(5, 3).toArray(names2);
		
		String [] expectedNames = new String[] { 
				"San Carlos St", "20th St", "Service Rd", "Winter Pl"};
		
		String [] expectedNames2 = new String[] {"20th St"};
		
		assertArrayEquals(expectedNames, names);
		assertArrayEquals(expectedNames2, names2);
	}
}
