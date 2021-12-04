package com.packt.datastructuresandalg.lesson6.activity.project.test.bonus;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.packt.datastructuresandalg.lesson6.activity.project.*;
import com.packt.datastructuresandalg.lesson6.activity.project.bonus.*;

class ShortestDeliveryPathWithHeuristicTest {
	
	public static FloydWarshall case1;
	
	public static int[][] adjacencyMatrixCase1;
	
	public static int[][] comeFromMatrixCase1;
	
	public static ArrayList<Shipment> deliveryList;
	
	public static String[] expectedRoute;

	public static String[] expectedRoute2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		case1 = new FloydWarshall(11);
		case1.addEdge(1, 2, 200, "Mission St");
		case1.addEdge(1, 3, 400, "San Carlos St");
		case1.addEdge(1, 4, 300, "Lexington St");
		case1.addEdge(2, 5, 700, "Valencia St");
		case1.addEdge(2, 6, 400, "18th St");
		case1.addEdge(2, 7, 600, "19th St");
		case1.addEdge(3, 5, 300, "20th St");
		case1.addEdge(3, 6, 200, "21th St");
		case1.addEdge(3, 7, 400, "Folsom St");
		case1.addEdge(4, 5, 400, "Grant Ave");
		case1.addEdge(4, 6, 100, "Industrial Way");
		case1.addEdge(4, 7, 500, "Spruce Ave");
		case1.addEdge(5, 8, 100, "Service Rd");
		case1.addEdge(5, 9, 300, "Morgan Rd");
		case1.addEdge(6, 8, 600, "Main St");
		case1.addEdge(6, 9, 300, "Keyes St");
		case1.addEdge(7, 8, 300, "Rancho Drive");
		case1.addEdge(7, 9, 300, "Oakley Blvd");
		case1.addEdge(8, 10, 300, "Winter Pl");
		case1.addEdge(9, 10, 400, "Nobles Alley");
		
		case1.addEdge(2, 1, 200, "Mission St");
		case1.addEdge(3, 1, 400, "San Carlos St");
		case1.addEdge(4, 1, 300, "Lexington St");
		case1.addEdge(5, 2, 700, "Valencia St");
		case1.addEdge(6, 2, 400, "18th St");
		case1.addEdge(7, 2, 600, "19th St");
		case1.addEdge(5, 3, 300, "20th St");
		case1.addEdge(6, 3, 200, "21th St");
		case1.addEdge(7, 3, 400, "Folsom St");
		case1.addEdge(5, 4, 400, "Grant Ave");
		case1.addEdge(6, 4, 100, "Industrial Way");
		case1.addEdge(7, 4, 500, "Spruce Ave");
		case1.addEdge(8, 6, 600, "Main St");
		case1.addEdge(9, 6, 300, "Keyes St");
		case1.addEdge(8, 7, 300, "Rancho Drive");
		case1.addEdge(9, 7, 300, "Oakley Blvd");
		case1.addEdge(10, 8, 300, "Winter Pl");
		case1.addEdge(10, 9, 400, "Nobles Alley");
		
		adjacencyMatrixCase1 = new int[][] {
			{0, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}, 
			{2147483647, 0, 200, 400, 300, 700, 400, 800, 800, 700, 1100}, 
			{2147483647, 200, 0, 600, 500, 700, 400, 600, 800, 700, 1100}, 
			{2147483647, 400, 600, 0, 300, 300, 200, 400, 400, 500, 700}, 
			{2147483647, 300, 500, 300, 0, 400, 100, 500, 500, 400, 800}, 
			{2147483647, 700, 700, 300, 400, 0, 500, 400, 100, 300, 400},
			{2147483647, 400, 400, 200, 100, 500, 0, 600, 600, 300, 700}, 
			{2147483647, 800, 600, 400, 500, 700, 600, 0, 300, 300, 600}, 
			{2147483647, 1000, 900, 700, 700, 1000, 600, 300, 0, 600, 300}, 
			{2147483647, 700, 700, 500, 400, 800, 300, 300, 600, 0, 400}, 
			{2147483647, 1100, 1100, 900, 800, 1200, 700, 600, 300, 400, 0}};
			
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

			deliveryList.add(new  Shipment(3, 7654382, 1, 3, LocalTime.of(16, 40)));
			deliveryList.add(new  Shipment(5, 764256682, 1, 5, LocalTime.of(16, 15)));
			
			expectedRoute = new String[] 
					{"San Carlos St (7654382)", "20th St (764256682)", "Service Rd",
							"Winter Pl (2051025601)", "Winter Pl", "Rancho Drive (105142566)", 
							"Spruce Ave (4561378)"};
			
			expectedRoute2 = new String[] 
					{"San Carlos St", "20th St", "Service Rd", "Winter Pl (2051025601)", 
					"Winter Pl", "Rancho Drive (105142566)", "Spruce Ave (4561378)",
					"Grant Ave (764256682)", "20th St (7654382)"};
			
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testHeuristic() {
		
		ArrayList<String> routeList = ShortestDeliveryPathWithHeuristic
				.getDeliveryRoute(case1, deliveryList, LocalTime.of(13, 00), 12, 10*60);

				
		String[] route = new String[7];
		
		route = routeList.toArray(route);
		
		assertArrayEquals(expectedRoute, route);
	}
	
	@Test
	void testHeuristic2() {
		
		ArrayList<String> routeList = ShortestDeliveryPathWithHeuristic
				.getDeliveryRoute(case1, deliveryList, LocalTime.of(14, 15), 5, 20*60);

				
		String[] route = new String[9];
		
		route = routeList.toArray(route);
		
		assertArrayEquals(expectedRoute2, route);
	}

}
