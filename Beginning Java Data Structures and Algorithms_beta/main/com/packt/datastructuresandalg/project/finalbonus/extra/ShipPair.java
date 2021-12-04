package com.packt.datastructuresandalg.project.finalbonus.extra;

import com.packt.datastructuresandalg.project.finalbonus.Coordinates;
import com.packt.datastructuresandalg.project.finalbonus.Ship;

public class ShipPair {

	private Ship firstShip;
	private Ship secondShip;
	
	public ShipPair(Ship firstShip, Ship secondShip) {
		super();
		this.firstShip = firstShip;
		this.secondShip = secondShip;
	}
	
	public double getDistanceBetween() {
		
		Coordinates firstCoordinates = 
				firstShip.getRouteHistory().get(firstShip.getRouteHistory().size()-1);
		
		Coordinates secondCoordinates = 
				secondShip.getRouteHistory().get(secondShip.getRouteHistory().size()-1);
		
		double squareOflongDif = (firstCoordinates.getLongitude()
				-secondCoordinates.getLongitude())* (firstCoordinates.getLongitude()
						-secondCoordinates.getLongitude());
		
		double squareOflatDif = (firstCoordinates.getLatitude()
				-secondCoordinates.getLatitude()) * (firstCoordinates.getLatitude()
						-secondCoordinates.getLatitude());
		
		return Math.sqrt(squareOflongDif + squareOflatDif);
	}

	public Ship getFirstShip() {
		return firstShip;
	}

	public Ship getSecondShip() {
		return secondShip;
	}
	
	
	
	
}
