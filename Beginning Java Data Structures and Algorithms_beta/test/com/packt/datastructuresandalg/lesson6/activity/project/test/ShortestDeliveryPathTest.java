package com.packt.datastructuresandalg.lesson6.activity.project.test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.packt.datastructuresandalg.lesson6.activity.project.*;


class ShortestDeliveryPathTest {
	
	public static FloydWarshall case1;
	
	public static int[][] adjacencyMatrixCase1;
	
	public static int[][] comeFromMatrixCase1;
	
	public static ArrayList<Shipment> deliveryList;
	
	public static String[] expectedRoute;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		case1 = new FloydWarshall(11);
		case1.addEdge(1, 2, 2, "Mission St");
		case1.addEdge(1, 3, 4, "San Carlos St");
		case1.addEdge(1, 4, 3, "Lexington St");
		case1.addEdge(2, 5, 7, "Valencia St");
		case1.addEdge(2, 6, 4, "18th St");
		case1.addEdge(2, 7, 6, "19th St");
		case1.addEdge(3, 5, 3, "20th St");
		case1.addEdge(3, 6, 2, "21th St");
		case1.addEdge(3, 7, 4, "Folsom St");
		case1.addEdge(4, 5, 4, "Grant Ave");
		case1.addEdge(4, 6, 1, "Industrial Way");
		case1.addEdge(4, 7, 5, "Spruce Ave");
		case1.addEdge(5, 8, 1, "Service Rd");
		case1.addEdge(5, 9, 3, "Morgan Rd");
		case1.addEdge(6, 8, 6, "Main St");
		case1.addEdge(6, 9, 3, "Keyes St");
		case1.addEdge(7, 8, 3, "Rancho Drive");
		case1.addEdge(7, 9, 3, "Oakley Blvd");
		case1.addEdge(8, 10, 3, "Winter Pl");
		case1.addEdge(9, 10, 4, "Nobles Alley");
		
		case1.addEdge(2, 1, 2, "Mission St");
		case1.addEdge(3, 1, 4, "San Carlos St");
		case1.addEdge(4, 1, 3, "Lexington St");
		case1.addEdge(5, 2, 7, "Valencia St");
		case1.addEdge(6, 2, 4, "18th St");
		case1.addEdge(7, 2, 6, "19th St");
		case1.addEdge(5, 3, 3, "20th St");
		case1.addEdge(6, 3, 2, "21th St");
		case1.addEdge(7, 3, 4, "Folsom St");
		case1.addEdge(5, 4, 4, "Grant Ave");
		case1.addEdge(6, 4, 1, "Industrial Way");
		case1.addEdge(7, 4, 5, "Spruce Ave");
		case1.addEdge(8, 6, 6, "Main St");
		case1.addEdge(9, 6, 3, "Keyes St");
		case1.addEdge(8, 7, 3, "Rancho Drive");
		case1.addEdge(9, 7, 3, "Oakley Blvd");
		case1.addEdge(10, 8, 3, "Winter Pl");
		case1.addEdge(10, 9, 4, "Nobles Alley");
		
		adjacencyMatrixCase1 = new int[][] {
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
			
		comeFromMatrixCase1 = new int[][]{
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

			deliveryList = new ArrayList<>();
			deliveryList.add(new Shipment(3, 2051025601, 1, 10, LocalTime.of(14, 25)));
			deliveryList.add(new Shipment(1.2, 105142566, 1, 7, LocalTime.of(15, 10)));
			deliveryList.add(new Shipment(2, 4561378, 1, 4, LocalTime.of(15, 30)));
			
			expectedRoute = new String[] 
					{"San Carlos St", "20th St", "Service Rd", "Winter Pl", "Winter Pl", "Rancho Drive", "Spruce Ave"};
			
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		
		ArrayList<String> routeList = ShortestDeliveryPath.getDeliveryRoute(case1, deliveryList);
				
		String[] route = new String[7];
		
		route = routeList.toArray(route);
		
		assertArrayEquals(expectedRoute, route);
	}

}
