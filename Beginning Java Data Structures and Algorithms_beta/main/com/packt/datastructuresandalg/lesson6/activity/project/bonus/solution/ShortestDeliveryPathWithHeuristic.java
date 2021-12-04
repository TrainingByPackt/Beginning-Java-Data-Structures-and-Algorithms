package com.packt.datastructuresandalg.lesson6.activity.project.bonus.solution;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import com.packt.datastructuresandalg.lesson6.activity.project.solution.*;


public class ShortestDeliveryPathWithHeuristic {


	/**
	 * @param graph
	 * @param deliveryList
	 * @param startTime
	 * @param speed
	 * @param deliveryProcessingTime
	 * 
	 * @return
	 */
	public static ArrayList<String> getDeliveryRoute(FloydWarshall graph,
			ArrayList<Shipment> deliveryList, LocalTime startTime, 
			int speed, int deliveryProcessingTime) {

		//run the shortest paths
		graph.run();
		
		//sort deliveries wrt delivery time
		Collections.sort(deliveryList, (a,b) ->
			a.getDeliveryTimeDue().toSecondOfDay() < b.getDeliveryTimeDue().toSecondOfDay() ? -1:
				a.getDeliveryTimeDue() == b.getDeliveryTimeDue()? 0: 1);	
						
		//start from 1; warehouse
		int fromNode = 1;
		
		//define routes
		Vector<Integer>  route =new Vector<>();
		
		//get the first shipment
		Shipment firstShipment = deliveryList.get(0);
		
		//get destination node
		int toNode = firstShipment.getToNode();
		
		//get route
		Vector<Integer> pathInteger = graph.path(fromNode, toNode);
		
		//add route
		route.addAll(pathInteger);	
	
		//define  an index for stop&deliver points
		int[] addedIndex = new int[route.size()];
		
		//assign -1 
		for (int i = 0; i < addedIndex.length; i++) {
			addedIndex[i] = -1;
		}
		
		//index update for first delivery
		addedIndex[0] = route.size() - 1;
		
		//For each delivery; except first one 
		for (int i = 1; i < deliveryList.size(); i++) {
			
			//continue if already added
			if(addedIndex[i]!=-1)
				continue;
			
			//get the shipment
			Shipment shipment = deliveryList.get(i);
			
			//check if this node already exists
			int destinationNode = shipment.getToNode();
					
			if (route.contains(destinationNode)) {
				
				//get potential stop index
				int potentialStopIndex = route.indexOf(destinationNode);
				
				//define feasibility Boolean and assign true
				boolean canBeAdded = true;
				
				//for each stop
				for (int j = 0; j < addedIndex.length; j++) {
					
					//check if it effects
					if(addedIndex[j] == -1 
							||addedIndex[j] < potentialStopIndex)
						continue;//if not continue
					
					//get current stop index on route
					int index = addedIndex[j];
					
					//count number of stops
					int numberOfStops = 0;
					
					for (int k = 0; k < addedIndex.length; k++) {
						if(addedIndex[k]!= -1 && addedIndex[k] <= index)
							numberOfStops++;
					}
					
					//calculate drive length
					int driveLength = getDriveLength(index, route, graph);
					
					//calculate the new delivery time
					int newDeliveryTime = startTime.toSecondOfDay() + driveLength/speed + 
							(numberOfStops+1)*deliveryProcessingTime;
							
					//check if feasible
					if (newDeliveryTime > deliveryList.get(j).getDeliveryTimeDue().toSecondOfDay() ) {
						canBeAdded = false;
					}					
				}
				
				if (canBeAdded) {
					//update index
					addedIndex[i] = potentialStopIndex;
				} else {
					//get route
					Vector<Integer> path = graph.path(route.lastElement(), destinationNode);
					
					//add all - remove last to prevent duplicates
					route.remove(route.size()-1);
					route.addAll(path);

					//update index
					addedIndex[i] = route.size() - 1;
				}
				
			} else {//if not add directly to the end
				
				//get route
				Vector<Integer> path = graph.path(route.lastElement(), destinationNode);
				
				//add all - remove last to prevent duplicates
				route.remove(route.size()-1);
				route.addAll(path);

				//update index
				addedIndex[i] = route.size() - 1;
			}			
		}
		
		return getStreetNames(route, graph, addedIndex, deliveryList);
	}

	
	/**
	 * @param finalRoute
	 * @param graph
	 * @param stopIndex
	 * @param deliveryList
	 * @return
	 */
	private static ArrayList<String> getStreetNames(Vector<Integer> finalRoute,
			FloydWarshall graph, int[] stopIndex, ArrayList<Shipment> deliveryList) {
		
		// define return list
		ArrayList<String> returnList = new ArrayList<>();
		
		for (int i = 0; i < finalRoute.size()- 1; i++) {
			
			int fromNode = finalRoute.get(i);
			
			int toNode = finalRoute.get(i+1);
			
			StringBuilder sb = new StringBuilder();
			sb.append(graph.getNameOfStreets()[fromNode][toNode]);
			
			
			//check if i+1 is delivery point
			for (int j = 0; j < stopIndex.length; j++) {
				
				if (stopIndex[j] == i+1 ) {
					sb.append(" (");
					sb.append(deliveryList.get(j).getBarcodeNumber());
					sb.append(")");
				}
			}
			
			returnList.add(sb.toString());
		}
		
		return returnList;
	}

	
	/**
	 * @param index
	 * @param finalRoute
	 * @param graph
	 * @return
	 */
	private static int getDriveLength(int index, Vector<Integer> finalRoute, FloydWarshall graph) {
		//define return sum
		int totalLength = 0;
		
		//add all length until index
		for (int i = 0; i < index; i++) {
			
			int fromNode = finalRoute.get(i);
			
			int toNode = finalRoute.get(i+1);
			
			totalLength += graph.getAdjacencyMatrix()[fromNode][toNode];
		}
		
		return totalLength;
	}
}
