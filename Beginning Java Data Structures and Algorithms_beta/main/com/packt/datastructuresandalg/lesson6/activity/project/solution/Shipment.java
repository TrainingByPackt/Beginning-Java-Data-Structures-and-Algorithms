package com.packt.datastructuresandalg.lesson6.activity.project.solution;

import java.time.LocalTime;

public class Shipment {

	private double weight;
	private long barcodeNumber;
	private int fromNode;
	private int toNode;
	private LocalTime deliveryTimeDue;
	
	public Shipment(double weight, long barcodeNumber, int fromNode, int toNode, LocalTime deliveryTimeDue) {
		super();
		this.weight = weight;
		this.barcodeNumber = barcodeNumber;
		this.fromNode = fromNode;
		this.toNode = toNode;
		this.deliveryTimeDue = deliveryTimeDue;
	}

	public int getFromNode() {
		return fromNode;
	}

	public double getWeight() {
		return weight;
	}

	public long getBarcodeNumber() {
		return barcodeNumber;
	}

	public int getToNode() {
		return toNode;
	}

	public LocalTime getDeliveryTimeDue() {
		return deliveryTimeDue;
	}
	
}
