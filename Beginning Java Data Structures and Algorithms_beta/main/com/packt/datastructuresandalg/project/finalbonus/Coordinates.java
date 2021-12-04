package com.packt.datastructuresandalg.project.finalbonus;

public class Coordinates {

	private double longitude;
	private double latitude;
	
	
	public Coordinates(double longitude, double latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Coordinates() {
		super();
		this.longitude = 0;
		this.latitude = 0;
	}
	
	public double getLongitude() {
		return longitude;
	}
	public double getLatitude() {
		return latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	
	
	
}
