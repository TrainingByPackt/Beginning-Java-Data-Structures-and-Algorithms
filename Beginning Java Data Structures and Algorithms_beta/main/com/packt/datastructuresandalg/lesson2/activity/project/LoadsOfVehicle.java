package com.packt.datastructuresandalg.lesson2.activity.project;

import java.util.ArrayList;

/**
 * @author 
 *
 */
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
		//TODO getLoadReport()
		return null;
	}
	
	/**This method takes vehicles and their loadings as input and 
	 * generates report for each vehicle
	 * 
	 * @param loadsOfVehicles vehicle and loadings array
	 * @return a report for each vehicle showing loading sequence
	 */
	public static String[] getReports(LoadsOfVehicle[] loadsOfVehicles) {
		//TODO getReports()
		return null;
	}
}