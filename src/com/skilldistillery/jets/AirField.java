package com.skilldistillery.jets;

import java.util.ArrayList;

public class AirField {
	private ArrayList<Jet> hanger = new ArrayList<>();

	public void addPlane(Jet jet) {
		hanger.add(jet);
		hanger.add(jet);
		hanger.add(jet);
		hanger.add(jet);
		hanger.add(jet);
	}

	public void removePlane() {

	}

}
