package com.skilldistillery.jets;

public class CargoJet extends Jet implements CargoCarrier {
	private int loadCapacity;

	public CargoJet() {
		super();
	}

	public CargoJet(String model, int speed, int range, double price, int loadCapacity) {
		super(model, speed, range, price);
		this.loadCapacity = loadCapacity;
	}

	public int getLoadCapacity() {
		return loadCapacity;
	}

	public void setLoadCapacity(int loadCapacity) {
		this.loadCapacity = loadCapacity;
	}

	public void loadCargo() {
		System.out.println("Load cargo!!");
	}

}
