package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {

	Scanner sc = new Scanner(System.in);
	private AirField airField = new AirField();

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.run();
		
	}

	public void run() {
		Jet f16 = null;
		f16 = new FighterJet("F16", 700, 3000, 1_000_000);
		
		airField.addPlane(f16);
	
	}

}
