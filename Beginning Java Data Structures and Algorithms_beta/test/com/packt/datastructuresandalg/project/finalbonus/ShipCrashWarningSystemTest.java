package com.packt.datastructuresandalg.project.finalbonus;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import com.packt.datastructuresandalg.project.finalbonus.solution.ShipCrashWarningSystem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShipCrashWarningSystemTest {

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
	private static ArrayList<Coordinates> coordinatesHistorySixFS; 
	private static ArrayList<Coordinates> coordinatesHistorySixSS; 
	private static ArrayList<Coordinates> coordinatesHistorySevenFS; 
	private static ArrayList<Coordinates> coordinatesHistorySevenSS; 
	private static ArrayList<Coordinates> coordinatesHistoryEightFS; 
	private static ArrayList<Coordinates> coordinatesHistoryEightSS; 
	private static ArrayList<Coordinates> coordinatesHistoryNineFS; 
	private static ArrayList<Coordinates> coordinatesHistoryNineSS; 
	private static ArrayList<Coordinates> coordinatesHistoryTenFS; 
	private static ArrayList<Coordinates> coordinatesHistoryTenSS; 
	private static ArrayList<Coordinates> coordinatesHistoryElevenFS; 
	private static ArrayList<Coordinates> coordinatesHistoryElevenSS; 
	
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
	
		coordinatesHistorySixFS = new ArrayList<>();
		coordinatesHistorySixFS.add(new Coordinates(35.596133,	30.556595));
		coordinatesHistorySixFS.add(new Coordinates(35.596143,	30.556605));
		coordinatesHistorySixFS.add(new Coordinates(35.596153,	30.556615)); 
	
		coordinatesHistorySixSS = new ArrayList<>();
		coordinatesHistorySixSS.add(new Coordinates(35.596163,	30.556655));
		coordinatesHistorySixSS.add(new Coordinates(35.596173,	30.556645));
		coordinatesHistorySixSS.add(new Coordinates(35.596183,	30.556635)); 
	
		coordinatesHistorySevenFS = new ArrayList<>();
		coordinatesHistorySevenFS.add(new Coordinates(35.596133,	30.556595));
		coordinatesHistorySevenFS.add(new Coordinates(35.596143,	30.556605));
		coordinatesHistorySevenFS.add(new Coordinates(35.596153,	30.556615)); 
	
		coordinatesHistorySevenSS = new ArrayList<>();
		coordinatesHistorySevenSS.add(new Coordinates(35.596163,	30.556655));
		coordinatesHistorySevenSS.add(new Coordinates(35.596173,	30.556645));
		coordinatesHistorySevenSS.add(new Coordinates(35.596193,	30.556635)); 
		
		coordinatesHistoryEightFS = new ArrayList<>();
		coordinatesHistoryEightFS.add(new Coordinates(35.596133,	30.556595));
		coordinatesHistoryEightFS.add(new Coordinates(35.596143, 30.556605));
		coordinatesHistoryEightFS.add(new Coordinates(35.596153,	30.556615)); 
	
		coordinatesHistoryEightSS = new ArrayList<>();
		coordinatesHistoryEightSS.add(new Coordinates(35.596193,	30.556625));
		coordinatesHistoryEightSS.add(new Coordinates(35.596183,	30.556625));
		coordinatesHistoryEightSS.add(new Coordinates(35.596173,	30.556625)); 
		
		coordinatesHistoryNineFS = new ArrayList<>();
		coordinatesHistoryNineFS.add(new Coordinates(35.596133,	30.556595));
		coordinatesHistoryNineFS.add(new Coordinates(35.596143,	30.556605));
		coordinatesHistoryNineFS.add(new Coordinates(35.596153,	30.556615)); 
	
		coordinatesHistoryNineSS = new ArrayList<>();
		coordinatesHistoryNineSS.add(new Coordinates(35.596193,	30.556325));
		coordinatesHistoryNineSS.add(new Coordinates(35.596183,	30.556425));
		coordinatesHistoryNineSS.add(new Coordinates(35.596173,	30.556525)); 
		
		coordinatesHistoryTenFS = new ArrayList<>();
		coordinatesHistoryTenFS.add(new Coordinates(35.596133,	30.556595));
		coordinatesHistoryTenFS.add(new Coordinates(35.596143, 30.556605));
		coordinatesHistoryTenFS.add(new Coordinates(35.596153,	30.556615)); 
	
		coordinatesHistoryTenSS = new ArrayList<>();
		coordinatesHistoryTenSS.add(new Coordinates(35.596163,	30.556595));
		coordinatesHistoryTenSS.add(new Coordinates(35.596163,	30.556605));
		coordinatesHistoryTenSS.add(new Coordinates(35.596163,	30.556615)); 
		

		coordinatesHistoryElevenFS = new ArrayList<>();
		coordinatesHistoryElevenFS.add(new Coordinates(35.596133,	30.556595));
		coordinatesHistoryElevenFS.add(new Coordinates(35.596143, 30.556605));
		coordinatesHistoryElevenFS.add(new Coordinates(35.596153,	30.556615)); 
	
		coordinatesHistoryElevenSS = new ArrayList<>();
		coordinatesHistoryElevenSS.add(new Coordinates(35.596163,	30.556595));
		coordinatesHistoryElevenSS.add(new Coordinates(35.596163,	30.556605));

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
		coordinatesHistorySixFS = null; 
		coordinatesHistorySixSS = null; 
		coordinatesHistorySevenFS = null; 
		coordinatesHistorySevenSS = null; 
		coordinatesHistoryEightFS = null; 
		coordinatesHistoryEightSS = null; 
		coordinatesHistoryNineFS = null; 
		coordinatesHistoryNineSS = null; 
		coordinatesHistoryTenFS = null; 
		coordinatesHistoryTenSS  = null; 		
	}

	@Test
	void testCalculateGradient() {
		
		double gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryOneFS.get(2), 
						coordinatesHistoryOneFS.get(1));
					
		assertTrue(Double.isInfinite(gradient));
		
		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryOneSS.get(2), 
						coordinatesHistoryOneSS.get(1));
		
		assertTrue(Double.isInfinite(gradient));
		
		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryTwoFS.get(2), 
						coordinatesHistoryTwoFS.get(1));
		
		assertTrue(Double.isInfinite(gradient));				

		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryTwoSS.get(2), 
						coordinatesHistoryTwoSS.get(1));
		
		assertTrue(Double.isInfinite(gradient));
		
		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryThreeFS.get(2), 
						coordinatesHistoryThreeFS.get(1));
		
		assertEquals(0, gradient, 0.000_001);				

		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryThreeSS.get(2), 
						coordinatesHistoryThreeSS.get(1));
		
		assertEquals(0, gradient, 0.000_001);
		
		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryFourFS.get(2), 
						coordinatesHistoryFourFS.get(1));
		
		assertEquals(0, gradient, 0.000_001);				

		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryFourSS.get(2), 
						coordinatesHistoryFourSS.get(1));
		
		assertEquals(0, gradient, 0.000_001);
		
		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryFiveFS.get(2), 
						coordinatesHistoryFiveFS.get(1));
		
		assertEquals(1.0000000003552714, gradient, 0.000_001);				

		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryFiveSS.get(2), 
						coordinatesHistoryFiveSS.get(1));
		
		assertEquals(1.0000000003552714, gradient, 0.000_001);
		
		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistorySixFS.get(2), 
						coordinatesHistorySixFS.get(1));
		
		assertEquals(1.0000000003552714, gradient, 0.000_001);				

		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistorySixSS.get(2), 
						coordinatesHistorySixSS.get(1));
		
		assertEquals(-1.0000000003552714, gradient, 0.000_001);
		
		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistorySevenFS.get(2), 
						coordinatesHistorySevenFS.get(1));
		
		assertEquals(1.0000000003552714, gradient, 0.000_001);				

		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistorySevenSS.get(2), 
						coordinatesHistorySevenSS.get(1));
		
		assertEquals(-2.0, gradient, 0.000_001);
		
		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryEightFS.get(2), 
						coordinatesHistoryEightFS.get(1));
		
		assertEquals(1.0000000003552714, gradient, 0.000_001);				

		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryEightSS.get(2), 
						coordinatesHistoryEightSS.get(1));
		
		assertTrue(Double.isInfinite(gradient));
		
		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryNineFS.get(2), 
						coordinatesHistoryNineFS.get(1));
		
		assertEquals(1.0000000003552714, gradient, 0.000_001);				

		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryNineSS.get(2), 
						coordinatesHistoryNineSS.get(1));
		
		assertEquals(-0.10000000003197443, gradient, 0.000_001);
		
		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryTenFS.get(2), 
						coordinatesHistoryTenFS.get(1));
		
		assertEquals(1.0000000003552714, gradient, 0.000_001);				

		gradient = ShipCrashWarningSystem
				.calculateGradient(coordinatesHistoryTenSS.get(2), 
						coordinatesHistoryTenSS.get(1));
		
		assertEquals(0, gradient, 0.000_001);		
	}

	@Test
	void testCalculateConstant() {
		double constant = ShipCrashWarningSystem
				.calculateConstant(coordinatesHistoryThreeFS.get(2),
					ShipCrashWarningSystem.calculateGradient(
						coordinatesHistoryThreeFS.get(2), 
						coordinatesHistoryThreeFS.get(1)));
		
		assertEquals(35.5961330, constant, 0.000_001);	
		

		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistoryThreeSS.get(2),
			ShipCrashWarningSystem.calculateGradient(coordinatesHistoryThreeSS.get(2), 
						coordinatesHistoryThreeSS.get(1)));
		
		assertEquals(35.5961330, constant, 0.000_001);
		
		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistoryFourFS.get(2),
			ShipCrashWarningSystem.calculateGradient(coordinatesHistoryFourFS.get(2), 
						coordinatesHistoryFourFS.get(1)));
		
		assertEquals(35.5961330, constant, 0.000_001);				

		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistoryFourSS.get(2), 
			ShipCrashWarningSystem.calculateGradient(coordinatesHistoryFourSS.get(2), 
						coordinatesHistoryFourSS.get(1)));
		
		assertEquals(35.5962330, constant, 0.000_001);
		
		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistoryFiveFS.get(2),
			ShipCrashWarningSystem.calculateGradient(coordinatesHistoryFiveFS.get(2), 
						coordinatesHistoryFiveFS.get(1)));
		
		assertEquals(5.0395379, constant, 0.000_001);				

		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistoryFiveSS.get(2),
			ShipCrashWarningSystem.calculateGradient(coordinatesHistoryFiveSS.get(2), 
						coordinatesHistoryFiveSS.get(1)));
		
		assertEquals(5.0395379, constant, 0.000_001);
		

		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistorySixFS.get(2),
			ShipCrashWarningSystem.calculateGradient(coordinatesHistorySixFS.get(2), 
						coordinatesHistorySixFS.get(1)));
		
		assertEquals(5.0395379, constant, 0.000_001);				

		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistorySixSS.get(2),
			ShipCrashWarningSystem.calculateGradient(coordinatesHistorySixSS.get(2), 
						coordinatesHistorySixSS.get(1)));
		
		assertEquals(66.1528180, constant, 0.000_001);
		
		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistorySevenFS.get(2),
			ShipCrashWarningSystem.calculateGradient(coordinatesHistorySevenFS.get(2), 
						coordinatesHistorySevenFS.get(1)));
		
		assertEquals(5.0395379, constant, 0.000_001);				

		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistorySevenSS.get(2),
			ShipCrashWarningSystem.calculateGradient(coordinatesHistorySevenSS.get(2), 
						coordinatesHistorySevenSS.get(1)));
		
		assertEquals(96.7094630, constant, 0.000_001);
		
		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistoryEightFS.get(2),
			ShipCrashWarningSystem.calculateGradient(coordinatesHistoryEightFS.get(2), 
						coordinatesHistoryEightFS.get(1)));
		
		assertEquals(5.0395379, constant, 0.000_001);				
		
		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistoryNineFS.get(2),
			ShipCrashWarningSystem.calculateGradient(coordinatesHistoryNineFS.get(2), 
						coordinatesHistoryNineFS.get(1)));
		
		assertEquals(5.0395379, constant, 0.000_001);				

		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistoryNineSS.get(2),
			ShipCrashWarningSystem.calculateGradient(coordinatesHistoryNineSS.get(2), 
						coordinatesHistoryNineSS.get(1)));
		
		assertEquals(38.6518255, constant, 0.000_001);
		
		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistoryTenFS.get(2),
			ShipCrashWarningSystem.calculateGradient(coordinatesHistoryTenFS.get(2), 
						coordinatesHistoryTenFS.get(1)));
		
		assertEquals(5.0395379, constant, 0.000_001);				

		constant = ShipCrashWarningSystem.calculateConstant(
			coordinatesHistoryTenSS.get(2), 
			ShipCrashWarningSystem.calculateGradient(coordinatesHistoryTenSS.get(2), 
						coordinatesHistoryTenSS.get(1)));
		
		assertEquals(35.5961630, constant, 0.000_001);
	}

	@Test
	void testWillCrash() {
		
		boolean willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistoryOneFS, coordinatesHistoryOneSS);
		
		assertFalse(willCrash);
		
		willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistoryTwoFS, coordinatesHistoryTwoSS);
		
		assertFalse(willCrash);
		
		willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistoryThreeFS, coordinatesHistoryThreeSS);
		
		assertFalse(willCrash);
		
		willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistoryFourFS, coordinatesHistoryFourSS);
		
		assertFalse(willCrash);		
		
		willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistoryFiveFS, coordinatesHistoryFiveSS);
		
		assertTrue(willCrash);
		
		//switch case 5
		willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistoryFiveSS, coordinatesHistoryFiveFS);
		
		assertTrue(willCrash);
		
		willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistorySixFS, coordinatesHistorySixSS);
		
		assertFalse(willCrash);		
		
		willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistorySevenFS, coordinatesHistorySevenSS);
		
		assertFalse(willCrash);
		
		willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistoryEightFS, coordinatesHistoryEightSS);
		
		assertTrue(willCrash);
		
		//switch case 8
		willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistoryEightSS, coordinatesHistoryEightFS);
		
		assertTrue(willCrash);
		
		willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistoryNineFS, coordinatesHistoryNineSS);
		
		assertTrue(willCrash);
		
		willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistoryTenFS, coordinatesHistoryTenSS);
		
		assertTrue(willCrash);
		
		willCrash = ShipCrashWarningSystem.willCrash(
				coordinatesHistoryElevenFS, coordinatesHistoryElevenSS);
		
		assertFalse(willCrash);

	}

	@Test
	void testDoesGoToIntersection() {

		Coordinates intersectionCoordinates = ShipCrashWarningSystem
				.calculateIntersectionCoordinates(coordinatesHistoryNineFS.get(2), 
						coordinatesHistoryNineFS.get(1),
						coordinatesHistoryNineSS.get(2),
						coordinatesHistoryNineSS.get(1));
		
		boolean doesGoToIntersection = ShipCrashWarningSystem.
				doesGoToIntersection(intersectionCoordinates, coordinatesHistoryNineFS);
		
		assertTrue(doesGoToIntersection);
		
		intersectionCoordinates = ShipCrashWarningSystem
				.calculateIntersectionCoordinates(coordinatesHistoryTenFS.get(2), 
						coordinatesHistoryTenFS.get(1),
						coordinatesHistoryTenSS.get(2),
						coordinatesHistoryTenSS.get(1));
		
		doesGoToIntersection = ShipCrashWarningSystem.
				doesGoToIntersection(intersectionCoordinates, coordinatesHistoryTenFS);
		
		assertTrue(doesGoToIntersection);
		
		intersectionCoordinates = ShipCrashWarningSystem
				.calculateIntersectionCoordinates(coordinatesHistoryEightFS.get(2), 
						coordinatesHistoryEightFS.get(1),
						coordinatesHistoryEightSS.get(2),
						coordinatesHistoryEightSS.get(1));
		
		doesGoToIntersection = ShipCrashWarningSystem.
				doesGoToIntersection(intersectionCoordinates, coordinatesHistoryEightFS);
		
		assertTrue(doesGoToIntersection);
	}

	@Test
	void testCalculateIntersectionCoordinates() {
		Coordinates intersection = ShipCrashWarningSystem
				.calculateIntersectionCoordinates(coordinatesHistoryNineFS.get(2), 
						coordinatesHistoryNineFS.get(1),
						coordinatesHistoryNineSS.get(2),
						coordinatesHistoryNineSS.get(1));
		
		assertEquals(35.5961629, intersection.getLongitude(), 0.000_001);		
		assertEquals(30.5566249, intersection.getLatitude(), 0.000_001);			

		intersection = ShipCrashWarningSystem
				.calculateIntersectionCoordinates(coordinatesHistoryTenFS.get(2), 
						coordinatesHistoryTenFS.get(1),
						coordinatesHistoryTenSS.get(2),
						coordinatesHistoryTenSS.get(1));
		
		assertEquals(35.596163, intersection.getLongitude(), 0.000_001);		
		assertEquals(30.5566249, intersection.getLatitude(), 0.000_001);	
		
		intersection = ShipCrashWarningSystem
				.calculateIntersectionCoordinates(coordinatesHistoryEightFS.get(2), 
						coordinatesHistoryEightFS.get(1),
						coordinatesHistoryEightSS.get(2),
						coordinatesHistoryEightSS.get(1));
		
		assertEquals(35.596163, intersection.getLongitude(), 0.000_001);		
		assertEquals(30.556625, intersection.getLatitude(), 0.000_001);	
	}

	@Test
	void testCalculateAngleBetween() {
		double angle = ShipCrashWarningSystem
				.calculateAngleBetween(coordinatesHistoryNineFS.get(2), 
						coordinatesHistoryNineFS.get(1),
						coordinatesHistoryNineSS.get(2),
						coordinatesHistoryNineSS.get(1));
		
		assertEquals(50.710593, angle, 0.000_001);				

		angle = ShipCrashWarningSystem
				.calculateAngleBetween(coordinatesHistoryTenFS.get(2), 
						coordinatesHistoryTenFS.get(1),
						coordinatesHistoryTenSS.get(2),
						coordinatesHistoryTenSS.get(1));
		
		assertEquals(45.000000, angle, 0.000_001);			
		
		angle = ShipCrashWarningSystem
				.calculateAngleBetween(coordinatesHistoryEightFS.get(2), 
						coordinatesHistoryEightFS.get(1),
						coordinatesHistoryEightSS.get(2),
						coordinatesHistoryEightSS.get(1));
		
		assertEquals(-44.999999, angle, 0.000_001);		

	}
	
	@Test
	void testFindConflictedShips() {
		
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
		
		assertEquals(2, conflictList.size());
		
		assertTrue(conflictList.get(0).get(0).getName().equals("Ship8"));		
		assertTrue(conflictList.get(0).get(1).getName().equals("Ship9"));
		
		assertTrue(conflictList.get(1).get(0).getName().equals("Ship9"));		
		assertTrue(conflictList.get(1).get(1).getName().equals("Ship10"));
		
	}

}
