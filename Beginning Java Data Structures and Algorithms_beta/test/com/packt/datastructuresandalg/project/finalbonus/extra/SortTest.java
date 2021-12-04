package com.packt.datastructuresandalg.project.finalbonus.extra;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.packt.datastructuresandalg.project.finalbonus.Coordinates;
import com.packt.datastructuresandalg.project.finalbonus.Ship;
import com.packt.datastructuresandalg.project.finalbonus.extra.ShipPair;
import com.packt.datastructuresandalg.project.finalbonus.extra.solution.Sort;
import com.packt.datastructuresandalg.project.finalbonus.solution.ShipCrashWarningSystem;

class SortTest {

	private static ArrayList<Coordinates> coordinatesHistoryOneFS; 
	private static ArrayList<Coordinates> coordinatesHistoryOneSS; 
	private static ArrayList<Coordinates> coordinatesHistoryTwoFS; 
	private static ArrayList<Coordinates> coordinatesHistoryTwoSS; 
	private static ArrayList<Coordinates> coordinatesHistoryThreeFS; 
	private static ArrayList<Coordinates> coordinatesHistoryThreeSS; 
	private static ArrayList<Coordinates> coordinatesHistoryFourFS; 
	private static ArrayList<Coordinates> coordinatesHistoryFourSS; 
	private static ArrayList<Coordinates> coordinatesHistoryFiveFS; 
	private static ArrayList<Coordinates> coordinatesHistoryFiveSS; 
	private static ArrayList<Coordinates> coordinatesHistorySixSS; 
	private static ArrayList<Coordinates> coordinatesHistorySevenSS; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		coordinatesHistoryOneFS = new ArrayList<>();
		coordinatesHistoryOneFS.add(new Coordinates(35.596133,	30.556595));
		coordinatesHistoryOneFS.add(new Coordinates(35.596143,	30.556595));
		coordinatesHistoryOneFS.add(new Coordinates(35.596153,	30.556595));
		
		coordinatesHistoryOneSS = new ArrayList<>();
		coordinatesHistoryOneSS.add(new Coordinates(35.596253,	30.556595));
		coordinatesHistoryOneSS.add(new Coordinates(35.596243,	30.556595));
		coordinatesHistoryOneSS.add(new Coordinates(35.596233,	30.556595));	
	
		coordinatesHistoryTwoFS = new ArrayList<>();
		coordinatesHistoryTwoFS.add(new Coordinates(35.596133,	30.556595));
		coordinatesHistoryTwoFS.add(new Coordinates(35.596143,	30.556595));
		coordinatesHistoryTwoFS.add(new Coordinates(35.596153,	30.556595)); 


		coordinatesHistoryTwoSS = new ArrayList<>();
		coordinatesHistoryTwoSS.add(new Coordinates(35.596253,	30.556495));
		coordinatesHistoryTwoSS.add(new Coordinates(35.596243,	30.556495));
		coordinatesHistoryTwoSS.add(new Coordinates(35.596233,	30.556495)); 


		coordinatesHistoryThreeFS = new ArrayList<>();
		coordinatesHistoryThreeFS.add(new Coordinates(35.596133,	30.556595));
		coordinatesHistoryThreeFS.add(new Coordinates(35.596133,	30.556605));
		coordinatesHistoryThreeFS.add(new Coordinates(35.596133,	30.556615)); 
	
		coordinatesHistoryThreeSS = new ArrayList<>();
		coordinatesHistoryThreeSS.add(new Coordinates(35.596133,	30.556895));
		coordinatesHistoryThreeSS.add(new Coordinates(35.596133,	30.556875));
		coordinatesHistoryThreeSS.add(new Coordinates(35.596133,	30.556855)); 
	
		coordinatesHistoryFourFS = new ArrayList<>();
		coordinatesHistoryFourFS.add(new Coordinates(35.596133,	30.556595));
		coordinatesHistoryFourFS.add(new Coordinates(35.596133,	30.556605));
		coordinatesHistoryFourFS.add(new Coordinates(35.596133,	30.556615)); 
	
		coordinatesHistoryFourSS = new ArrayList<>();
		coordinatesHistoryFourSS.add(new Coordinates(35.596233,	30.556895));
		coordinatesHistoryFourSS.add(new Coordinates(35.596233,	30.556875));
		coordinatesHistoryFourSS.add(new Coordinates(35.596233,	30.556855)); 
	
		coordinatesHistoryFiveFS = new ArrayList<>();
		coordinatesHistoryFiveFS.add(new Coordinates(35.596133,	30.556595));
		coordinatesHistoryFiveFS.add(new Coordinates(35.596143,	30.556605));
		coordinatesHistoryFiveFS.add(new Coordinates(35.596153,	30.556615));
	
		coordinatesHistoryFiveSS = new ArrayList<>();
		coordinatesHistoryFiveSS.add(new Coordinates(35.596193,	30.556655));
		coordinatesHistoryFiveSS.add(new Coordinates(35.596183,	30.556645));
		coordinatesHistoryFiveSS.add(new Coordinates(35.596173,	30.556635)); 
	
		coordinatesHistorySixSS = new ArrayList<>();
		coordinatesHistorySixSS.add(new Coordinates(35.596163,	30.556655));
		coordinatesHistorySixSS.add(new Coordinates(35.596173,	30.556645));
		coordinatesHistorySixSS.add(new Coordinates(35.596183,	30.556635)); 
	
		coordinatesHistorySevenSS = new ArrayList<>();
		coordinatesHistorySevenSS.add(new Coordinates(35.596163,	30.556655));
		coordinatesHistorySevenSS.add(new Coordinates(35.596173,	30.556645));
		coordinatesHistorySevenSS.add(new Coordinates(35.596193,	30.556635)); 
	}
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		coordinatesHistoryOneFS = null; 
		coordinatesHistoryOneSS = null; 
		coordinatesHistoryTwoFS = null; 
		coordinatesHistoryTwoSS = null; 
		coordinatesHistoryThreeFS = null; 
		coordinatesHistoryThreeSS = null; 
		coordinatesHistoryFourFS = null; 
		coordinatesHistoryFourSS = null; 
		coordinatesHistoryFiveFS = null; 
		coordinatesHistoryFiveSS = null; 
		coordinatesHistorySixSS = null;  
		coordinatesHistorySevenSS = null; 
	}

	@Test
	void testSortByDistance() {
		
		ArrayList<Ship> listOfShips = new ArrayList<>();
		listOfShips.add(new Ship("Ship1", "UK", coordinatesHistoryOneFS));
		listOfShips.add(new Ship("Ship2", "USA", coordinatesHistoryOneSS));
		listOfShips.add(new Ship("Ship3", "AU", coordinatesHistoryTwoFS));	
		listOfShips.add(new Ship("Ship4", "NZ", coordinatesHistoryTwoSS));
		listOfShips.add(new Ship("Ship5", "GR", coordinatesHistoryThreeFS));
		listOfShips.add(new Ship("Ship6", "UK", coordinatesHistoryThreeSS));
		listOfShips.add(new Ship("Ship7", "GR", coordinatesHistoryFourFS));
		listOfShips.add(new Ship("Ship8", "UK", coordinatesHistoryFourSS));
		listOfShips.add(new Ship("Ship9", "USA", coordinatesHistoryFiveFS));
		listOfShips.add(new Ship("Ship10", "USA", coordinatesHistoryFiveSS));
		listOfShips.add(new Ship("Ship12", "AU", coordinatesHistorySixSS));		
		listOfShips.add(new Ship("Ship14", "NZ", coordinatesHistorySevenSS));

					
		ArrayList<ArrayList<Ship>> conflictList = 
				ShipCrashWarningSystem.findConflictedShips(listOfShips);
		
		ArrayList<ShipPair> shipPairs = Sort.sortByDistance(conflictList);
		
		assertEquals(2, shipPairs.size());
		
		assertTrue(shipPairs.get(0).getFirstShip().getName().equals("Ship9"));		
		assertTrue(shipPairs.get(0).getSecondShip().getName().equals("Ship10"));
		
		assertTrue(shipPairs.get(1).getFirstShip().getName().equals("Ship8"));		
		assertTrue(shipPairs.get(1).getSecondShip().getName().equals("Ship9"));
	}

}
