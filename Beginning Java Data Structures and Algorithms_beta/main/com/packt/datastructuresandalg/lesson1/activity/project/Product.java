package com.packt.datastructuresandalg.lesson1.activity.project;

public class Product {

	private String name;
	private double price;
	private int manufacturerCode;
	private int dataMatrixColumn;
	private int dataMatrixIndex;
	
	public Product(String name, double price, int manufacturerCode, int dataMatrixColumn) {
		super();
		this.name = name;
		this.price = price;
		this.manufacturerCode = manufacturerCode;
		this.dataMatrixColumn = dataMatrixColumn;
		this.dataMatrixIndex = this.dataMatrixColumn -1;
	}
		
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getManufacturerCode() {
		return manufacturerCode;
	}
	public int getDataMatrixIndex() {
		return dataMatrixIndex;
	}
}
