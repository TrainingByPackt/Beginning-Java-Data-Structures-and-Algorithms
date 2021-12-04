package com.packt.datastructuresandalg.lesson2.activity.project;

public class Shipment {

	private double weight;
	private long barcodeNumber;
	private int fromPostalCode;
	private int toPostalCode;
	
	public Shipment(double weight, long barcodeNumber, int fromPostalCode, int toPostalCode) {
		super();
		this.weight = weight;
		this.barcodeNumber = barcodeNumber;
		this.fromPostalCode = fromPostalCode;
		this.toPostalCode = toPostalCode;
	}

	public int getFromPostalCode() {
		return fromPostalCode;
	}

	public double getWeight() {
		return weight;
	}

	public long getBarcodeNumber() {
		return barcodeNumber;
	}

	public int getToPostalCode() {
		return toPostalCode;
	}
	
}
