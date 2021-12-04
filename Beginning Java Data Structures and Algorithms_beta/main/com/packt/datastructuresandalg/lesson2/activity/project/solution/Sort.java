package com.packt.datastructuresandalg.lesson2.activity.project.solution;

import com.packt.datastructuresandalg.lesson2.activity.project.solution.LoadsOfVehicle;
import com.packt.datastructuresandalg.lesson2.activity.project.Shipment;
import com.packt.datastructuresandalg.lesson2.activity.project.Vehicle;

public class Sort {
	
	/**This method takes shipments and vehicles as input and distributes shipments
	 * to the vehicles and returns them as a work order/report showing loading sequence
	 * for each vehicle.
	 * 
	 * @param shipments	list of the shipments/cargo to be loaded
	 * @param vehicles list of the available vehicles
	 * @return a LoadsOfVehicle class for each vehicle showing loading sequence
	 */
	public static LoadsOfVehicle[] getLoadingArray(Shipment[] shipments, Vehicle[] vehicles) {
		
		//sort the shipments
		sortShipmentsByWeight(shipments);
		
		//Distribute the sorted shipments to vehicles
		LoadsOfVehicle[] loadsOfVehicles = distributeShipmentsToVehicles(shipments, vehicles);
					
		return loadsOfVehicles;
	}
	
	/**This method takes shipments and sorts form heaviest to lightest
	 * 
	 * @param shipmentsToSort list of the shipments which will be sorted
	 */
	public static void sortShipmentsByWeight(Shipment[] shipmentsToSort) {
		mergeSortShipmentsByWeight(shipmentsToSort, 0, shipmentsToSort.length-1);
				
	}	
	
    /**This method uses merge sort method to sort given part of the shipment array
     * 
     * @param shipmentsToSort array containing shipments
     * @param start	starting index of the array part which will be sorted
     * @param end ending index of the array part which will be sorted
     */
    private static void mergeSortShipmentsByWeight(Shipment[] shipmentsToSort, int start, int end) {
    	//check if the array is only one element or not
		if (start < end) {
		//divide from middle
		int middle = (end - start) / 2 + start;
		
		mergeSortShipmentsByWeight(shipmentsToSort, start, middle);
		mergeSortShipmentsByWeight(shipmentsToSort, middle + 1, end);

		//merge two parts            
		merge(shipmentsToSort, start, middle, end);
        }		
	}

	/**This method merges two sorted parts of an array
	 * 
	 * @param array array to be operated on
	 * @param start starting index of the array part which will be sorted
	 * @param middle middle point index of array part to be sorted
	 * @param end end point index of the array part which will be sorted
	 */
	private static void merge(Shipment[] array, int start, int middle, int end) {
        int i = start;
        int j = middle + 1;

        //define temporary array        
        Shipment[] arrayTemp = new Shipment[end - start + 1];

        for (int k = 0; k < arrayTemp.length; k++) {
        	
        	//merge small value and increment the pointer
            if (i <= middle && (j > end || array[i].getWeight() >= array[j].getWeight())) {
                arrayTemp[k] = array[i];
                i++;
            } else {
                arrayTemp[k] = array[j];
                j++;
            }
        }
        System.arraycopy(arrayTemp, 0, array, start, arrayTemp.length);
    }

	/**This method takes sorted shipments and distributes weight to the given vehicles.
	 * If capacity is not enough a vehicle can be used more than once
	 * The main purpose of this method is to balance total cargo weight and the 
	 * total weight capacity of the vehicles. Shipment distribution to each vehicle
	 * is done by calling loadTheVehicles() method
	 * 
	 * @param sortedShipments list of shipments sorted from heaviest to lightest 
	 * @param vehicles list of vehicle available to load
	 * 
	 * @return distributed cargo list for each vehicle
	 */
	public static LoadsOfVehicle[] distributeShipmentsToVehicles(
			Shipment[] sortedShipments, Vehicle[] vehicles) {
		
		//calculate total weight of shipments
		double totalCargoWeight = 0;
		for (int i = 0; i < sortedShipments.length; i++) {
			totalCargoWeight += sortedShipments[i].getWeight();
		}
		
		//calculate total weight capacity of vehicles
		double totalWeightCapacity = 0;
		for (int i = 0; i < vehicles.length; i++) {
			totalWeightCapacity += vehicles[i].getWeightCapacity();
		}
		
		//if capacity of vehicles is not enough add more turns for vehicles
		int counter = 0;
		while (totalWeightCapacity<=totalCargoWeight) {
			
			int i = counter % vehicles.length;
			
			totalWeightCapacity += vehicles[i].getWeightCapacity();
			counter++;
		}
		
		//define return array with extra vehicle turns
		LoadsOfVehicle[] returnArray = new LoadsOfVehicle[vehicles.length+counter];
		
		for (int i = 0; i < returnArray.length; i++) {
			
			//use modulus to add vehicles more than once if needed
			returnArray[i] = new LoadsOfVehicle(vehicles[i%vehicles.length]);
		}
		
		//distribute weight to vehicles
		loadTheVehicles(returnArray, sortedShipments);
		
		return returnArray;
	}

	/**This method takes vehicle list and a sorted shipment list and distributes shipments to 
	 * the given vehicles sequentially. 
	 * 
	 * @param vehicleListToLoad vehicle list, total capacity of the vehicles must be bigger than
	 * the total weight of shipments.	 * 
	 * @param sortedShipments shipment list to distribute between vehicles
	 */
	public static void loadTheVehicles(LoadsOfVehicle[] vehicleListToLoad, Shipment[] sortedShipments) {
		
		int cargoCounter = 0;
				
		//while there is more cargo to load
		WHILE_LOOP: while (cargoCounter < sortedShipments.length) {
			
			//distribute weight over vehicles
			for (int i = 0; i < vehicleListToLoad.length; i++) {
				
				//calculate total weight if current weight is loaded
				double estimatedWeight = vehicleListToLoad[i].getLoadedWeight()
						+ sortedShipments[cargoCounter].getWeight();
				
				//there is a cargo to load and vehicle has the capacity
				if (estimatedWeight <= vehicleListToLoad[i].getVehicleCapacity()) {
					
					//load cargo to vehicle
					vehicleListToLoad[i].addCargo(sortedShipments[cargoCounter]);
					cargoCounter++;
					
					//If no more cargo to load break while loop
					if (cargoCounter >= sortedShipments.length) {
						break WHILE_LOOP;
					}
				}				
			}
		}		
	}
	
}