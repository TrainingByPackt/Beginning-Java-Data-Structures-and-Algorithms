package com.packt.datastructuresandalg.lesson2.activity.project.bonus.solution;

import com.packt.datastructuresandalg.lesson2.activity.project.Shipment;
import com.packt.datastructuresandalg.lesson2.activity.project.solution.Sort;

public class DoubleSort {
	
	public static void sortShipmentsByPostalCodeAndWeight(Shipment[] shipmentsToSort) {
		//sort wrt weight
		Sort.sortShipmentsByWeight(shipmentsToSort);
		
		//sort wrt postal code
		mergeSortShipmentsByPostalCode(shipmentsToSort, 0, shipmentsToSort.length-1);
	}

    /**This method uses merge sort method to sort given part of the shipment array
     * 
     * @param shipmentsToSort array containing shipments
     * @param start	starting index of array part to be sorted
     * @param end ending index of array part to be sorted
     */
    private static void mergeSortShipmentsByPostalCode(
    		Shipment[] shipmentsToSort, int start, int end) {
    	
    	//check if the array is only one element or not
		if (start < end) {
		//divide from middle
		int middle = (end - start) / 2 + start;
		
		mergeSortShipmentsByPostalCode(shipmentsToSort, start, middle);
		mergeSortShipmentsByPostalCode(shipmentsToSort, middle + 1, end);

		//merge two parts            
		mergeByPostalCode(shipmentsToSort, start, middle, end);
        }		
	}
    
	/**This method merges two sorted parts of an array
	 * 
	 * @param array array to be operated on
	 * @param start starting index of array part to be sorted
	 * @param middle middle point index of array part to be sorted
	 * @param end end point index of array part to be sorted
	 */
	private static void mergeByPostalCode(Shipment[] array, int start, int middle, int end) {
        int i = start;
        int j = middle + 1;

        //define temporary array        
        Shipment[] arrayTemp = new Shipment[end - start + 1];

        for (int k = 0; k < arrayTemp.length; k++) {
        	        	
        	//merge small value and increment the pointer
            if (i <= middle && 
            		(j > end || 
            				array[i].getToPostalCode() >= array[j].getToPostalCode())) {
            	
                arrayTemp[k] = array[i];
                i++;
            } else {
                arrayTemp[k] = array[j];
                j++;
            }
        }
        System.arraycopy(arrayTemp, 0, array, start, arrayTemp.length);
    }
}
