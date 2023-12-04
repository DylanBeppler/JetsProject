package com.skilldistillery.jets;

public abstract class Jet {
	private String model;
	private int speed;
	private int range;
	private double price;
	private double skyTime;

	public int fly() {
		System.out.println("Jet Model: " + model + " Speed: " + speed + " Range: " + range + " Price: " + price);
		skyTime = range / speed;

		System.out.println("The amount of time this jet could fly before fuel depletion is: " + skyTime + " hours.");
		System.out.println("-------------------------------------------------------------------");
		return 0;
	}

	public Jet(String model, int speed, int range, double price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;

	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Jet() {
		super();
	}

	@Override
	public String toString() {
		return "Jet Model = " + model + ", Speed = " + speed + ", Range = " + range + ", Price = " + price;
	}

}
