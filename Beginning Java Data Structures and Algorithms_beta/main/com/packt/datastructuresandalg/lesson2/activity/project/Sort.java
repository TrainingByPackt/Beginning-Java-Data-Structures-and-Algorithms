package com.packt.datastructuresandalg.lesson2.activity.project;

public class Sort {
	

	/**
	 * @param shipments
	 * @param vehicles
	 * @return
	 */
	public static LoadsOfVehicle[] getLoadingArray(Shipment[] shipments, Vehicle[] vehicles) {
		//TODO getLoadingArray()
		return null;
	}
	

	/**
	 * @param shipmentsToSort
	 */
	public static void sortShipmentsByWeight(Shipment[] shipmentsToSort) {
		//TODO 	sortShipmentsByWeight()			
	}	
	
    /**
     * @param shipmentsToSort
     * @param start
     * @param end
     */
    private static void mergeSortShipmentsByWeight(Shipment[] shipmentsToSort, int start, int end) {
    	//TODO mergeSortShipmentsByWeight()
	}

	/**
	 * @param array
	 * @param start
	 * @param middle
	 * @param end
	 */
	private static void merge(Shipment[] array, int start, int middle, int end) {
		//TODO merge()
    }

	/**
	 * @param sortedShipments
	 * @param vehicles
	 * @return
	 */
	public static LoadsOfVehicle[] distributeShipmentsToVehicles(
			Shipment[] sortedShipments, Vehicle[] vehicles) {
		//TODO distributeShipmentsToVehicles()
		
		//calculate total weight of shipments

		
		//calculate total weight capacity of vehicles

		
		//if capacity of vehicles is not enough add more turns for vehicles

		
		//define return array with extra vehicle turns

			
			//use modulus to add vehicles more than once if needed

		//distribute weight to vehicles

		
		return null;
	}

	/**
	 * @param vehicleListToLoad
	 * @param sortedShipments
	 */
	public static void loadTheVehicles(LoadsOfVehicle[] vehicleListToLoad, Shipment[] sortedShipments) {
		//TODO loadTheVehicles()
		
		//while there is more cargo to load
			
			//distribute weight over vehicles
				
				//calculate total weight if current weight is loaded
				
				//there is a cargo to load and vehicle has the capacity
					
					//load cargo to vehicle
					
					//If no more cargo to load break while loop
		
	}
	
}