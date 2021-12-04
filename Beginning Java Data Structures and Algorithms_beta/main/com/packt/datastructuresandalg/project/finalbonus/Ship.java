package com.packt.datastructuresandalg.project.finalbonus;

import java.util.ArrayList;

public class Ship {
	
	private String name;
	private String flag;
	private ArrayList<Coordinates> routeHistory;
	
	public Ship(String name, String flag, ArrayList<Coordinates> routeHistory) {
		super();
		this.name = name;
		this.flag = flag;
		this.routeHistory = routeHistory;
	}

	public Ship(String name, String flag) {
		super();
		this.name = name;
		this.flag = flag;
		this.routeHistory = new  ArrayList<>();
	}

	public ArrayList<Coordinates> getRouteHistory() {
		return routeHistory;
	}

	public void addRouteHistory(Coordinates routeHistory) {
		this.routeHistory.add(routeHistory);
	}

	public String getName() {
		return name;
	}

	public String getFlag() {
		return flag;
	}
}
