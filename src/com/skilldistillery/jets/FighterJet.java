package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet() {
		super();

	}

	public FighterJet(String model, int speed, int range, double price) {
		super(model, speed, range, price);

	}

	public void dogFight() {
		System.out.println("PSHH PSHHH PSHHHH WHOOOOOOOOSH");

	}

}
