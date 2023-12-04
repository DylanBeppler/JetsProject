package com.skilldistillery.jets;

public class PassengerJet extends Jet {
	private int maxOccupant;

	public PassengerJet() {
		super();
	}

	public PassengerJet(String model, int speed, int range, double price, int maxOccupantint) {
		super(model, speed, range, price);
		this.maxOccupant = maxOccupant;

	}

}
