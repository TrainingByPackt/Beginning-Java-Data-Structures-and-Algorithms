package com.packt.datastructuresandalg.lesson1.activity.project.bonus;

import com.packt.datastructuresandalg.lesson1.activity.project.Product;

public class SoldItemCounter {
	private Product product;
	private int counter = 0;
			
	public SoldItemCounter(Product product) {
		super();
		this.product = product;
	}

	public int getCounter() {
		return counter;
	}
	
	public void addCounter(int add) {
		counter += add;
	}
	
	public Product getProduct() {
		return product;
	}
}
