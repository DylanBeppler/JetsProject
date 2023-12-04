package com.skilldistillery.jets;

import java.util.ArrayList;

public class AirField {
	private ArrayList<Jet> hanger = new ArrayList<>();

	public void addJet(Jet jet) {
		hanger.add(jet);
	}

	public void removeJet(int index) {
		if (index >= 0 && index < hanger.size()) {
			hanger.remove(index);
			System.out.println("Jet removed from the fleet.");
		} else {
			System.out.println("Invalid index. No jet removed.");
		}

	}

	public ArrayList<Jet> getHanger() {
		return hanger;
	}

	public ArrayList<Jet> getFleet() {
		return hanger;
	}

}
