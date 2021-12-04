package com.packt.datastructuresandalg.lesson2.activity.project.test.bonus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.packt.datastructuresandalg.lesson2.activity.project.Shipment;
import com.packt.datastructuresandalg.lesson2.activity.project.bonus.solution.DoubleSort;

class DoubleSortTest {

	private static Shipment[] shipmentArray;
	private static Shipment[] sortedShipmentArray;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		shipmentArray = new Shipment[20];
		
		shipmentArray[0] = new Shipment(3.1, 1_187_313_623, 34003, 6597);
		shipmentArray[1] = new Shipment(0.1, 1_187_313_624, 34003, 6600);
		shipmentArray[2] = new Shipment(5.4, 1_187_313_625, 34003, 6600);
		shipmentArray[3] = new Shipment(7.9, 1_187_313_626, 34003, 6595);
		shipmentArray[4] = new Shipment(11, 1_187_313_627, 34003, 6597);
		shipmentArray[5] = new Shipment(15, 1_187_313_628, 34003, 6595);
		shipmentArray[6] = new Shipment(14, 1_187_313_629, 34003, 6601);
		shipmentArray[7] = new Shipment(34, 1_187_313_630, 34003, 6597);
		shipmentArray[8] = new Shipment(45, 1_187_313_621, 34003, 6595);
		shipmentArray[9] = new Shipment(5, 1_187_313_622, 34003, 6601);
		shipmentArray[10] = new Shipment(3, 1_187_313_631, 34003, 6597);
		shipmentArray[11] = new Shipment(3.25, 1_187_313_632, 34003, 6601);
		shipmentArray[12] = new Shipment(3.13, 1_187_313_633, 34003, 6597);
		shipmentArray[13] = new Shipment(4.1, 1_187_313_634, 34003, 6596);
		shipmentArray[14] = new Shipment(2.1, 1_187_313_635, 34003, 6597);
		shipmentArray[15] = new Shipment(6.1, 1_187_313_636, 34003, 6596);
		shipmentArray[16] = new Shipment(3.7, 1_187_313_637, 34003, 6597);
		shipmentArray[17] = new Shipment(6.61, 1_187_313_638, 34003, 6596);
		shipmentArray[18] = new Shipment(4, 1_187_313_639, 34003, 6596);
		shipmentArray[19] = new Shipment(5, 1_187_313_640, 34003, 6596);
		
		sortedShipmentArray = new Shipment[20];
		
		sortedShipmentArray[0] = shipmentArray[6];
		sortedShipmentArray[1] = shipmentArray[9];
		sortedShipmentArray[2] = shipmentArray[11];
		sortedShipmentArray[3] = shipmentArray[2];
		sortedShipmentArray[4] = shipmentArray[1];
		sortedShipmentArray[5] = shipmentArray[7];
		sortedShipmentArray[6] = shipmentArray[4];
		sortedShipmentArray[7] = shipmentArray[16];
		sortedShipmentArray[8] = shipmentArray[12];
		sortedShipmentArray[9] = shipmentArray[0];
		sortedShipmentArray[10] = shipmentArray[10];
		sortedShipmentArray[11] = shipmentArray[14];
		sortedShipmentArray[12] = shipmentArray[17];
		sortedShipmentArray[13] = shipmentArray[15];
		sortedShipmentArray[14] = shipmentArray[19];
		sortedShipmentArray[15] = shipmentArray[13];
		sortedShipmentArray[16] = shipmentArray[18];
		sortedShipmentArray[17] = shipmentArray[8];
		sortedShipmentArray[18] = shipmentArray[5];
		sortedShipmentArray[19] = shipmentArray[3];
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		shipmentArray = null;
		sortedShipmentArray = null;
	}

	@Test
	void testSortShipmentsByPostalCodeAndWeight() {
		DoubleSort.sortShipmentsByPostalCodeAndWeight(shipmentArray);
		
		Shipment[] a2 = shipmentArray; 
		
		assertArrayEquals(sortedShipmentArray, shipmentArray);
	}

}
