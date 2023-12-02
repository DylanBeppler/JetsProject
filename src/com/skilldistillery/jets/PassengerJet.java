package com.skilldistillery.jets;

public class PassengerJet extends Jet {
	private int maxOccupant;

	public PassengerJet() {
		super();
	}

	public PassengerJet(int maxOccupant, String model, int speed, int range, int price) {
		super(model, speed, range, price);
		this.maxOccupant = maxOccupant;
	
	}

}
