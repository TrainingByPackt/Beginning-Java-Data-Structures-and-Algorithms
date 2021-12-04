package com.packt.datastructuresandalg.project.finalbonus.extra.solution;

import java.util.ArrayList;
import java.util.Collections;

import com.packt.datastructuresandalg.project.finalbonus.Ship;
import com.packt.datastructuresandalg.project.finalbonus.extra.ShipPair;

public class Sort {

	/**This method sorts the given ship conflict list
	 * wrt distance between ship pairs. (From smallest to biggest).
	 * 
	 * @param shipPairsList list of ship pairs that will crash
	 * 
	 * @return sorted list of ship pairs, from smallest distance 
	 * to biggest distance between ship pairs 
	 */
	public static ArrayList<ShipPair> sortByDistance(
			ArrayList<ArrayList<Ship>> shipPairsList) {
		
		//define ship pairs
		ArrayList<ShipPair> shipPairs = new ArrayList<>();
		
		//add ship pairs
		for (int i = 0; i < shipPairsList.size(); i++) {
			shipPairs.add(new ShipPair(shipPairsList.get(i).get(0), 
					shipPairsList.get(i).get(1)));
		}
		
		//sort wrt their distance from smallest to biggest
		Collections.sort(shipPairs, 
				(a,b)-> a.getDistanceBetween()<b.getDistanceBetween()?-1
						:a.getDistanceBetween() == b.getDistanceBetween() ?0:1);
		
		return shipPairs;
	}
}
