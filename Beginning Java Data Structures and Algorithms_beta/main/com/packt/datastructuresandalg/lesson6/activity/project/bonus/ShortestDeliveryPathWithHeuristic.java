package com.packt.datastructuresandalg.lesson6.activity.project.bonus;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import com.packt.datastructuresandalg.lesson6.activity.project.FloydWarshall;
import com.packt.datastructuresandalg.lesson6.activity.project.Shipment;

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

		return null;
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

		return null;
	}

	
	/**
	 * @param index
	 * @param finalRoute
	 * @param graph
	 * @return
	 */
	private static int getDriveLength(int index, Vector<Integer> finalRoute, FloydWarshall graph) {
		
		return -1;
	}
}
