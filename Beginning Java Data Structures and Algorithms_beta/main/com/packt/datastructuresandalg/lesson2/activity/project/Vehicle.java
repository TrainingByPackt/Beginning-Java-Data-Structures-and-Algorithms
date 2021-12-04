package com.packt.datastructuresandalg.lesson2.activity.project;

public class Vehicle {
	
	private double weightCapacity;
	private String plate;
	private String driverName;
	
	public Vehicle(double weightCapacity, String plate, String driverName) {
		super();
		this.weightCapacity = weightCapacity;
		this.plate = plate;
		this.driverName = driverName;
	}

	public double getWeightCapacity() {
		return weightCapacity;
	}

	public String getPlate() {
		return plate;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
}
