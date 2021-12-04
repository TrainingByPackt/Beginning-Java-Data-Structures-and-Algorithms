package com.packt.datastructuresandalg.lesson6.activity.project.solution;

import java.util.ArrayList;
import java.util.Collections;

public class ShortestDeliveryPath {


	/**This method gets FloydWarshall object as the graph representation of 
	 * the map and the delivery list and sorts the deliveries according to 
	 * delivery time due. Then returns a route based on shortest paths 
	 * between each delivery point
	 * 
	 * @param graph FloydWarshall class representation of the map
	 * @param deliveryList packages to be delivered
	 * 
	 * @return a route based on shortest paths between each delivery point
	 */
	public static ArrayList<String> getDeliveryRoute(FloydWarshall graph,
			ArrayList<Shipment> deliveryList) {
		
		//define return
		ArrayList<String> deliveryRoute = new ArrayList<>();
		
		//run the shortest paths
		graph.run();
		
		//sort deliveries
		Collections.sort(deliveryList, (a,b) ->
			a.getDeliveryTimeDue().toSecondOfDay() < b.getDeliveryTimeDue().toSecondOfDay() ? -1:
				a.getDeliveryTimeDue() == b.getDeliveryTimeDue()? 0: 1);
		
		/*
		 * add routes
		 */
		//start from 1; warehouse
		int fromNode = 1;
		
		//for each delivery
		for (int i = 0; i < deliveryList.size(); i++) {
			
			//get destination
			int toNode = deliveryList.get(i).getToNode();
			
			//get route
			deliveryRoute.addAll(graph.printPath(fromNode, toNode));
			
			//update fromNode for next destination
			fromNode = toNode;
		}
		
		return deliveryRoute;
	}
}
