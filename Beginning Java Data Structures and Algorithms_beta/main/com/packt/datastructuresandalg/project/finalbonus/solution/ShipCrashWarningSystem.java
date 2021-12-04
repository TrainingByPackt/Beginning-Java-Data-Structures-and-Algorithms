package com.packt.datastructuresandalg.project.finalbonus.solution;

import java.util.ArrayList;
import com.packt.datastructuresandalg.project.finalbonus.Coordinates;
import com.packt.datastructuresandalg.project.finalbonus.Ship;

public class ShipCrashWarningSystem {
	
	/**This method gets a list of the ships and checks them with each other to find
	 * conflicts; which will result in crash of two ships
	 * 
	 * @param listOfShips list of ships
	 * 
	 * @return list of ship that will crash each other unless they change their routes
	 */
	public static ArrayList<ArrayList<Ship>> findConflictedShips(
			ArrayList<Ship> listOfShips) {
		
		//define return array
		ArrayList<ArrayList<Ship>> conflictList = new ArrayList<>();
		
		//check each ship pair
		for (int i = 0; i < listOfShips.size(); i++) {
			for (int j = i+1; j < listOfShips.size(); j++) {
				
				boolean willCrash = willCrash(listOfShips.get(i).getRouteHistory(),
						listOfShips.get(j).getRouteHistory());
				
				//if they will crash
				if (willCrash) {
					//add this pair to return list
					ArrayList<Ship> pair = new ArrayList<>();
					pair.add(listOfShips.get(i));
					pair.add(listOfShips.get(j));
					
					conflictList.add(pair);
				}
			}
		}
		
		return conflictList;
	}

	/**This method calculates gradient of the which goes 
	 * through coordinate1 and coordinate2
	 * 
	 * @param coordinates1 first point 
	 * @param coordinates2 second point 
	 * 
	 * @return gradient of the line crossing through two coordinates
	 */
	public static double calculateGradient(Coordinates coordinates1,
			Coordinates coordinates2) {

		return (coordinates2.getLongitude()-coordinates1.getLongitude())
				/(coordinates2.getLatitude()-coordinates1.getLatitude());
	}
	
	/**This method calculates the constant of a line with a coordinate 
	 * point and the gradient of the line
	 * 
	 * @param coordinates a point pair to calculate the constant of 
	 * the line
	 * @param gradient gradient of the line
	 * 
	 * @return constant of the line equation
	 */
	public static double calculateConstant(Coordinates coordinates,
			double gradient) {

		return coordinates.getLongitude() - gradient*coordinates.getLatitude();
	}
	
	/**This method will compare route history of two ships 
	 * and calculates whether they will crash each other or not
	 * 
	 * @param coordinateHistoryOfFirstShip route history of the first ship 
	 * @param coordinateHistoryOfSecondShip route history of the second ship
	 * 
	 * @return returns true if the two ship will crash
	 */
	public static boolean willCrash(ArrayList<Coordinates> coordinateHistoryOfFirstShip,
			ArrayList<Coordinates> coordinateHistoryOfSecondShip) {
		
		//define return boolean
		boolean willCrash = false;
		
		if (coordinateHistoryOfFirstShip.size() < 3 
				||coordinateHistoryOfSecondShip.size() < 3)
			return willCrash;
		
		//get the size of each matrix to identify last records
		int numberOfRecordsOfFirstShip = coordinateHistoryOfFirstShip.size();
		int numberOfRecordsOfSecondShip = coordinateHistoryOfSecondShip.size();
	
		Coordinates lastRecordOfFirstShip = coordinateHistoryOfFirstShip
				.get(numberOfRecordsOfFirstShip-1);
		Coordinates previousRecordOfFirstShip = coordinateHistoryOfFirstShip
				.get(numberOfRecordsOfFirstShip-2);
		
		Coordinates lastRecordOfSecondShip = coordinateHistoryOfSecondShip
				.get(numberOfRecordsOfSecondShip-1);
		Coordinates previousRecordOfSecondShip = coordinateHistoryOfSecondShip
				.get(numberOfRecordsOfSecondShip-2);
		
		//calculate gradient of first ship
		double firstGradient = calculateGradient(lastRecordOfFirstShip,
				previousRecordOfFirstShip);
		
		//calculate gradient of second ship
		double secondGradient = calculateGradient(lastRecordOfSecondShip,
				previousRecordOfSecondShip);
		
		//calculate constant of first ship
		double firstConstant = calculateConstant(lastRecordOfFirstShip,
				firstGradient);
	
		//calculate constant of second ship
		double secondConstant = calculateConstant(lastRecordOfSecondShip,
				secondGradient);
		
		//check if the gradients are equal
		boolean equalGradient = false;
		if ((Double.isInfinite(firstGradient)
				&& Double.isInfinite(secondGradient))
				||Math.abs(firstGradient - secondGradient) < 0.000_001) {
			equalGradient = true;
		}
		
		//check if they are parallel 
		if ( equalGradient 
				&& Math.abs(firstConstant-secondConstant) > 0.000_001) {
			return false;
		}
		
		//get last angle wrt coordinates
		double lastAngle = calculateAngleBetween(
				lastRecordOfFirstShip,
				previousRecordOfFirstShip,
				lastRecordOfSecondShip,
				lastRecordOfFirstShip);
		
		//get previous angle wrt coordinates
		double previousAngle = calculateAngleBetween(
				previousRecordOfFirstShip,
				coordinateHistoryOfFirstShip.get(numberOfRecordsOfFirstShip-3),
				previousRecordOfSecondShip,
				previousRecordOfFirstShip);
						
		//check if they are on the same line
		if ((Math.abs(lastAngle) <= 0.000_001 && Math.abs(previousAngle) <= 0.000_001) 
				||(lastAngle == 180 && previousAngle == 180)) {
		
			//calculate directions of ships
			int directionOfFirstShip = (int) Math.signum(lastRecordOfFirstShip.getLongitude()
					- previousRecordOfFirstShip.getLongitude());
			
			int directionOfSecondShip = 
					(int) Math.signum(lastRecordOfSecondShip.getLongitude()
							- previousRecordOfSecondShip.getLongitude());
			
			//if they are going towards each other
			if ((directionOfFirstShip >= 0 && directionOfSecondShip < 0 
					&& lastRecordOfFirstShip.getLongitude() 
					< lastRecordOfSecondShip.getLongitude()) 
					|| (directionOfSecondShip >= 0 && directionOfFirstShip < 0 
					&& lastRecordOfSecondShip.getLongitude()
					< lastRecordOfFirstShip.getLongitude())) {
				return true;
			}
			
		}
		
		//check if their routes intersect
		if (Math.abs(lastAngle - previousAngle) < 0.000_000_1) {
			//calculate intersection point
			Coordinates intersectionCoordinates = 
					calculateIntersectionCoordinates(
							lastRecordOfFirstShip, previousRecordOfFirstShip,
							lastRecordOfSecondShip, previousRecordOfSecondShip);
					
			//does first ship go towards that point ?
			boolean firstShipGoesToIntersection = 
					doesGoToIntersection(intersectionCoordinates, 
							coordinateHistoryOfFirstShip);

			//does second ship go towards that point?
			boolean secondShipGoesToIntersection = 
					doesGoToIntersection(intersectionCoordinates, 
							coordinateHistoryOfSecondShip);
			
			//they will crash if both going towards intersection point
			if (firstShipGoesToIntersection == true &&
					secondShipGoesToIntersection == true) {
				willCrash = true;
			}
		}
			
		
		return  willCrash;
	}

	/** This method checks if the ship goes towards the given intersection point
	 * or not
	 * 
	 * @param intersectionCoordinates coordinates of the expected intersection point
	 * @param coordinateHistoryOfTheShip route history of the ship
	 * 
	 * @return returns true if the ship goes towards the given intersection point
	 */
	public static boolean doesGoToIntersection(Coordinates intersectionCoordinates, 
			ArrayList<Coordinates> coordinateHistoryOfTheShip) {
		//define return boolean
		boolean doesGoToIntersectionPoint = false;
		
		//get longitude and latitude of intersection
		double longitudeOfIntersection = intersectionCoordinates.getLongitude();
		double latitudeOfIntersection = intersectionCoordinates.getLatitude();
		
		//get last longitude and latitude
		double lastLongitude = 
				coordinateHistoryOfTheShip.get(coordinateHistoryOfTheShip.size()-1)
				.getLongitude();		
		double lastLatitude = 
				coordinateHistoryOfTheShip.get(coordinateHistoryOfTheShip.size()-1)
				.getLatitude();
		
		//get previous longitude and latitude
		double previousLongitude = 
				coordinateHistoryOfTheShip.get(coordinateHistoryOfTheShip.size()-2)
				.getLongitude();
		double previousLatitude = 
				coordinateHistoryOfTheShip.get(coordinateHistoryOfTheShip.size()-2)
				.getLatitude();
		
		//check the direction
		if (Math.signum(lastLongitude-previousLongitude) 
				== Math.signum(longitudeOfIntersection - lastLongitude)) {
			doesGoToIntersectionPoint = true;
		}
		
		return doesGoToIntersectionPoint;
	}

	/**This method calculates the intersection of two lines by using 
	 * two point from each line
	 * 
	 * @param firstCoordinatesOfFirstLine first point of first line
	 * @param secondCoordinatesOfFirstLine second point of first line
	 * @param firstCoordinatesOfSecondLine first point of second line
	 * @param secondCoordinatesOfSecondLine second point of second line
	 * 
	 * @return coordinates of the intersection
	 */
	public static Coordinates calculateIntersectionCoordinates(
			Coordinates firstCoordinatesOfFirstLine, 
			Coordinates secondCoordinatesOfFirstLine,
			Coordinates firstCoordinatesOfSecondLine, 
			Coordinates secondCoordinatesOfSecondLine) {
		
		//define return variable
		Coordinates coordinatesOfIntersection = new Coordinates();
		
		//calculate gradient of first ship
		double firstGradient = calculateGradient(firstCoordinatesOfFirstLine,
				secondCoordinatesOfFirstLine);
		
		//calculate gradient of second ship
		double secondGradient = calculateGradient(firstCoordinatesOfSecondLine,
				secondCoordinatesOfSecondLine);
		
		//if one of the gradients is infinity
		if (Double.isInfinite(firstGradient)) {
			
			//calculate constant of first ship
			double secondConstant = 
					calculateConstant(firstCoordinatesOfSecondLine, secondGradient);
			
			//latitude is constant
			coordinatesOfIntersection.setLatitude(
					firstCoordinatesOfFirstLine.getLatitude());
			
			//calculate longitude of intersection
			coordinatesOfIntersection.setLongitude(
					secondGradient*coordinatesOfIntersection.getLatitude() 
					+ secondConstant);
			
		} else if (Double.isInfinite(secondGradient)) {
			
			//calculate constant of first ship
			double firstConstant = 
					calculateConstant(firstCoordinatesOfFirstLine, firstGradient);
			
			//latitude is constant
			coordinatesOfIntersection.setLatitude(
					firstCoordinatesOfSecondLine.getLatitude());
			
			//calculate longitude of intersection
			coordinatesOfIntersection.setLongitude(
					firstGradient*coordinatesOfIntersection.getLatitude() 
					+firstConstant);
			
		} else {//none of them is infinite
			
			//calculate constant of first ship
			double firstConstant = 
					calculateConstant(firstCoordinatesOfFirstLine, firstGradient);
			
			//calculate constant of first ship
			double secondConstant = 
					calculateConstant(firstCoordinatesOfSecondLine, secondGradient);
		
			//calculate latitude of intersection
			coordinatesOfIntersection.setLatitude((secondConstant-firstConstant)
					/(firstGradient-secondGradient));
			
			//calculate longitude of intersection
			coordinatesOfIntersection.setLongitude(
					firstGradient*coordinatesOfIntersection.getLatitude()
					+firstConstant);
		}
				
		return coordinatesOfIntersection;
	}

	/**This method will calculate the angle in degrees between the 
	 * two lines by using two point from each line 
	 * 
	 * @param firstCoordinatesOfFirstLine first point of first line
	 * @param secondCoordinatesOfFirstLine second point of first line
	 * @param firstCoordinatesOfSecondLine first point of second line
	 * @param secondCoordinatesOfSecondLine second point of second line
	 * 
	 * @return  the angle in degrees between the two lines
	 */
	public static double calculateAngleBetween(Coordinates firstCoordinatesOfFirstLine, 
			Coordinates secondCoordinatesOfFirstLine, Coordinates firstCoordinatesOfSecondLine, 
			Coordinates secondCoordinatesOfSecondLine) {
		
		//calculate gradient of first ship
		double firstGradient = calculateGradient(firstCoordinatesOfFirstLine, 
				secondCoordinatesOfFirstLine);
		
		//calculate gradient of second ship
		double secondGradient = calculateGradient(firstCoordinatesOfSecondLine,
				secondCoordinatesOfSecondLine);
		
		//calculate arctan of first route
		double angleFirst = Math.atan(firstGradient);
		
		//calculate arctan of second route
		double angleSecond = Math.atan(secondGradient);
				
		return Math.toDegrees(angleFirst-angleSecond);
	}	
}
