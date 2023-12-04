package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.Scanner;

public class JetsApplication {
	private AirField airField = new AirField();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.populateAirField();
		app.run();
	}

	private void populateAirField() {
		airField.addJet(new CargoJet("EADS CASA C-295 ", 300, 966, 28_000_000, 15_543));
		airField.addJet(new CargoJet("Antonov An-225 Mriya ", 530, 9_600, 500_000_000, 420_000));
		airField.addJet(new FighterJet("Lockheed SR-71 Blackbird ", 2_500, 3_000, 34_000_000));
		airField.addJet(new FighterJet("Mig-25 Foxbbat", 2_190, 3200, 60_000_000));
		airField.addJet(new PassengerJet("Boeing 737 Max 7 ", 634, 3_850, 99_700_000, 172));
	}

	private void run() {
		int option;
		do {
			displayMenu();
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1:
				listFleet();
				break;
			case 2:
				flyAllJets();
				break;
			case 3:
				viewFastestJet();
				break;
			case 4:
				viewJetWithLongestRange();
				break;
			case 5:
				loadAllCargoJets();
				break;
			case 6:
				dogfight();
				break;
			case 7:
				addJetToFleet();
				break;
			case 8:
				removeJetFromFleet();
				break;
			case 9:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		} while (option != 9);
	}

	private void displayMenu() {
		System.out.println("______ Menu ______");
		System.out.println("1. List fleet ");
		System.out.println("2. Fly all jets ");
		System.out.println("3. View fastest jet ");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all Cargo jets");
		System.out.println("6. Dogfight");
		System.out.println("7. Add a jet to Fleet ");
		System.out.println("8. Remove a jet from Fleet ");
		System.out.println("9. Quit ");
	}

	private void listFleet() {
		ArrayList<Jet> fleet = airField.getFleet();
		System.out.println("______ List of jets ______");
		for (int i = 0; i < fleet.size(); i++) {
			Jet jet = fleet.get(i);
			System.out.println((i + 1) + ". " + jet.getModel() + " | Speed: " + jet.getSpeed() + " MPH | Range: "
					+ jet.getRange() + " | Price: $" + jet.getPrice());
			System.out.println("-----------------------------------------------------------------------");
		}
	}

	private void flyAllJets() {
		ArrayList<Jet> fleet = airField.getFleet();
		System.out.println("______ Flying all jets ______");
		for (Jet jet : fleet) {
			jet.fly();
		}
	}

	private void viewFastestJet() {
		ArrayList<Jet> fleet = airField.getFleet();
		Jet fastestJet = findFastestJet(fleet);
		displayJetDetails("Fastest Jet", fastestJet);
	}

	private void viewJetWithLongestRange() {
		ArrayList<Jet> fleet = airField.getFleet();
		Jet longestRangeJet = findJetWithLongestRange(fleet);
		displayJetDetails("Jet with Longest Range", longestRangeJet);
	}

	private void loadAllCargoJets() {
		ArrayList<Jet> fleet = airField.getFleet();
		System.out.println("______ Loading all Cargo jets ______");
		for (Jet jet : fleet) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	private void dogfight() {
		ArrayList<Jet> fleet = airField.getFleet();
		System.out.println("______ Engaging in a dogfight ______");
		for (Jet jet : fleet) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).dogFight();
			}
		}
	}

	private void addJetToFleet() {
		System.out.println("Enter Jet details:");
		System.out.print("Model: ");
		String model = sc.nextLine();
		System.out.print("Speed (in MPH): ");
		int speed = sc.nextInt();
		System.out.print("Range: ");
		int range = sc.nextInt();
		System.out.print("Price: ");
		double price = sc.nextDouble();

		System.out.println("Select Jet type:");
		System.out.println("1. Passenger Jet");
		System.out.println("2. Cargo Jet");
		System.out.println("3. Fighter Jet");
		int type = sc.nextInt();

		Jet newJet;
		switch (type) {
		case 1:
			newJet = new PassengerJet(model, speed, range, price, type);
			break;
		case 2:
			newJet = new CargoJet(model, speed, range, price, type);
			break;
		case 3:
			newJet = new FighterJet(model, speed, range, price);
			break;
		default:
			System.out.println("Invalid type. Jet not added to the hanger.");
			return;
		}

		airField.addJet(newJet);
		System.out.println("Jet added to the hanger.");
	}

	private void removeJetFromFleet() {
		ArrayList<Jet> fleet = airField.getFleet();
		System.out.println("Select a Jet to remove:");
		listFleet();

		int index = sc.nextInt();
		airField.removeJet(index - 1); 
	}

	private Jet findFastestJet(ArrayList<Jet> fleet) {
		Jet fastestJet = null;
		int maxSpeed = Integer.MIN_VALUE;

		for (Jet jet : fleet) {
			if (jet.getSpeed() > maxSpeed) {
				maxSpeed = jet.getSpeed();
				fastestJet = jet;
			}
		}

		return fastestJet;
	}

	private Jet findJetWithLongestRange(ArrayList<Jet> fleet) {
		Jet longestRangeJet = null;
		int maxRange = Integer.MIN_VALUE;

		for (Jet jet : fleet) {
			if (jet.getRange() > maxRange) {
				maxRange = jet.getRange();
				longestRangeJet = jet;
			}
		}

		return longestRangeJet;
	}

	private void displayJetDetails(String title, Jet jet) {
		if (jet != null) {
			System.out.println("______ " + title + " ______");
			System.out.println(" Model: " + jet.getModel());
			System.out.println(" Speed: " + jet.getSpeed() + " MPH");
			System.out.println(" Range: " + jet.getRange());
			System.out.println(" Price: $" + jet.getPrice());
		} else {
			System.out.println("No jets found.");
		}
	}
}
