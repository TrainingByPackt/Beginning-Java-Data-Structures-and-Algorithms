package com.packt.datastructuresandalg.lesson2.activity.project.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.packt.datastructuresandalg.lesson2.activity.project.solution.LoadsOfVehicle;

import com.packt.datastructuresandalg.lesson2.activity.project.Shipment;
import com.packt.datastructuresandalg.lesson2.activity.project.Vehicle;

class LoadsOfVehicleTest {
	
	private static Shipment[] shipmentArraySmall;
	private static Shipment[] sortedShipmentArraySmall;
	
	private static Vehicle[] vehicleArraySmall;
	
	private static LoadsOfVehicle[] vehicleListToLoadShipment;
	
	private static String[] expectedReports;

	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		shipmentArraySmall = new Shipment[6];
		
		shipmentArraySmall[0] = new Shipment(20, 2_147_013_624, 10020, 34546);
		shipmentArraySmall[1] = new Shipment(2, 2_147_253_625, 70001, 34547);
		shipmentArraySmall[2] = new Shipment(0.5, 2_147_014_626, 71064, 34542);
		shipmentArraySmall[3] = new Shipment(.75, 2_147_043_627, 16178, 34543);
		shipmentArraySmall[4] = new Shipment(1.25, 2_147_013_628, 35468, 34543);
		shipmentArraySmall[5] = new Shipment(15, 2_147_313_623, 34971, 34543);
		
		sortedShipmentArraySmall = new Shipment[6];
		
		sortedShipmentArraySmall[0] = shipmentArraySmall[0];
		sortedShipmentArraySmall[1] = shipmentArraySmall[5];
		sortedShipmentArraySmall[2] = shipmentArraySmall[1];
		sortedShipmentArraySmall[3] = shipmentArraySmall[4];
		sortedShipmentArraySmall[4] = shipmentArraySmall[3];
		sortedShipmentArraySmall[5] = shipmentArraySmall[2];
		
		vehicleArraySmall = new Vehicle[3];
		vehicleArraySmall[0] = new Vehicle(10, "KZ66 ZYT", "John Locke");
		vehicleArraySmall[1] = new Vehicle(20, "SBG 984", "Down Brown");
		vehicleArraySmall[2] = new Vehicle(50, "EKI6 LLO", "Adam Smith");
				
		vehicleListToLoadShipment = new LoadsOfVehicle[3];
		for (int i = 0; i < vehicleListToLoadShipment.length; i++) {
			vehicleListToLoadShipment[i] = new LoadsOfVehicle(vehicleArraySmall[i]);
		}
		vehicleListToLoadShipment[0].addCargo(sortedShipmentArraySmall[2]);//2, 2_147_253_625, 70001, 34547
		vehicleListToLoadShipment[0].addCargo(sortedShipmentArraySmall[4]);//.75, 2_147_043_627, 16178, 34543
		vehicleListToLoadShipment[1].addCargo(sortedShipmentArraySmall[0]);//20, 2_147_013_624, 10020, 34546
		vehicleListToLoadShipment[2].addCargo(sortedShipmentArraySmall[1]);//15, 2_147_313_623, 34971, 34543
		vehicleListToLoadShipment[2].addCargo(sortedShipmentArraySmall[3]);//1.25, 2_147_013_628, 35468, 34543
		vehicleListToLoadShipment[2].addCargo(sortedShipmentArraySmall[5]);//0.5, 2_147_014_626, 71064, 34542
		
		
		expectedReports = new String[3]; 
		
		expectedReports[0] = 
			"Vehicle Plate : KZ66 ZYT\n" + //10, "KZ66 ZYT", "John Locke"
			"Weight Limit  : 10.00\n" +
			"Driver        : John Locke\n\n" +
			
			"Loading Sequence\tBarcode Number\tWeight\tDelivery Address Postal Code\n" +
			"---------------\t--------------\t------\t----------------------------\n" +
			"1\t2147253625\t2.000\t34547\n"+
			"2\t2147043627\t0.750\t34543\n"+		
			"---------------\t--------------\t------\t----------------------------\n"+
			"2\t--------------\t2.750\t----------------------------\n";

		expectedReports[1] = 
				"Vehicle Plate : SBG 984\n" + //20, "SBG 984", "Down Brown"
				"Weight Limit  : 20.00\n" +
				"Driver        : Down Brown\n\n" +
						
				"Loading Sequence\tBarcode Number\tWeight\tDelivery Address Postal Code\n" +
				"---------------\t--------------\t------\t----------------------------\n" +
				"1\t2147013624\t20.000\t34546\n"+				
				"---------------\t--------------\t------\t----------------------------\n"+
				"1\t--------------\t20.000\t----------------------------\n";
					
		expectedReports[2] =
				"Vehicle Plate : EKI6 LLO\n" + //50, "EKI6 LLO", "Adam Smith"
				"Weight Limit  : 50.00\n" +
				"Driver        : Adam Smith\n\n" +
						
				"Loading Sequence\tBarcode Number\tWeight\tDelivery Address Postal Code\n" +
				"---------------\t--------------\t------\t----------------------------\n" +
				"1\t2147313623\t15.000\t34543\n"+
				"2\t2147013628\t1.250\t34543\n"+
				"3\t2147014626\t0.500\t34542\n"+
				"---------------\t--------------\t------\t----------------------------\n"+
				"3\t--------------\t16.750\t----------------------------\n";
		
		

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		shipmentArraySmall = null;
		sortedShipmentArraySmall = null;
		
		vehicleArraySmall = null;
		
		vehicleListToLoadShipment = null;
		
		expectedReports = null;
	}

	@Test
	void testGetLoadReport() {
		Vehicle vehicle = vehicleArraySmall[0];
		
		LoadsOfVehicle testLoad = new LoadsOfVehicle(vehicle);
		
		testLoad.addCargo(sortedShipmentArraySmall[2]);
		testLoad.addCargo(sortedShipmentArraySmall[4]);
		
		assertArrayEquals(expectedReports[0].toCharArray(), testLoad.getLoadReport().toCharArray());

	}

	@Test
	void testGetReports() {
		String[] reports = LoadsOfVehicle.getReports(vehicleListToLoadShipment);
		
		assertArrayEquals(expectedReports[0].toCharArray(), reports[0].toCharArray());
		assertArrayEquals(expectedReports[1].toCharArray(), reports[1].toCharArray());
		assertArrayEquals(expectedReports[2].toCharArray(), reports[2].toCharArray());
		
		//print expected reports 
		System.out.println(expectedReports[0]);
		System.out.println(expectedReports[1]);
		System.out.println(expectedReports[2]);
		
	}
}
