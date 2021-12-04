package com.packt.datastructuresandalg.lesson2.activity.project.solution;

import java.util.ArrayList;
import com.packt.datastructuresandalg.lesson2.activity.project.Shipment;
import com.packt.datastructuresandalg.lesson2.activity.project.Vehicle;

public class LoadsOfVehicle {
	
	private Vehicle vehicle;
	private ArrayList<Shipment> cargoList;
	

	public LoadsOfVehicle(Vehicle vehicle) {
		super();
		this.vehicle = vehicle;
		this.cargoList = new ArrayList<>();
	}

	public ArrayList<Shipment> getCargoList() {
		return cargoList;
	}

	public void addCargo(Shipment shipment) {
		cargoList.add(shipment);	
	}

	public double getLoadedWeight() {
		double totalWeight = 0;
		
		for (int i = 0; i < cargoList.size(); i++) {
			totalWeight += cargoList.get(i).getWeight();
		}
		
		return totalWeight;
	}
	
	public double getVehicleCapacity() {
		return vehicle.getWeightCapacity();
	}

	public String getVehiclePlate() {
		return vehicle.getPlate();
	}
	
	public String getVehicleDriver() {
		return vehicle.getDriverName();
	}

	/**This methods generates report for the vehicle and the 
	 * the shipments in it wrt weight (from heaviest to lightest)
	 * 
	 * @return generated report
	 */
	public String getLoadReport() {
		
		//define a stringbuilder
		StringBuilder sb = new StringBuilder();
		
		//add vehicle details
		String deatilsOfVehicle = String.format(
				  "Vehicle Plate : %s\n"
				+ "Weight Limit  : %.2f\n"
				+ "Driver        : %s\n\n"
				, getVehiclePlate(), getVehicleCapacity(), getVehicleDriver());
				
		
		//add vehicle details
		sb.append(deatilsOfVehicle);
		
		//add headlines
		sb.append("Loading Sequence\tBarcode Number\t")
				.append("Weight\tDelivery Address Postal Code\n");
		
		sb.append("---------------\t--------------\t")
				.append("------\t----------------------------\n");
		
		//iterate over cargo list
		for (int i = 0; i < cargoList.size(); i++) {
			//get cargo
			Shipment cargo = cargoList.get(i);
			
			//format the line
			String string = String.format("%d\t"+"%d\t"+"%.3f\t"+"%d\n", 
					i+1, cargo.getBarcodeNumber(), cargo.getWeight(), cargo.getToPostalCode());
			
			//add to report
			sb.append(string);
		}
		
		sb.append("---------------\t--------------\t")
				.append("------\t----------------------------\n");
		
		//calculate totals
		int totalNumberOfCargo = cargoList.size();
		double totalWeight = getLoadedWeight();
		
		//write totals
		sb.append(String.format("%d\t--------------\t"+"%.3f\t----------------------------\n", 
				totalNumberOfCargo, totalWeight));	
		
		return sb.toString();
	}
	
	/**This method takes vehicles and their loadings as input and 
	 * generates report for each vehicle
	 * 
	 * @param loadsOfVehicles vehicle and loadings array
	 * @return a report for each vehicle showing loading sequence
	 */
	public static String[] getReports(LoadsOfVehicle[] loadsOfVehicles) {
				
		//Generate a return string array (a string for each vehicle)
		String[] returnStrings = new String[loadsOfVehicles.length];
		
		//get reports for each vehicle load
		for (int i = 0; i < returnStrings.length; i++) {
			returnStrings[i] = loadsOfVehicles[i].getLoadReport();
		}
		
		return returnStrings;
	}
}