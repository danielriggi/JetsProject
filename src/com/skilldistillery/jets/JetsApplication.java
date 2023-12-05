package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.Scanner;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		jetApp.run();

	}

	public void run() {
		AirField airfield = new AirField();

		// Create instances of different Jet types-
		Jet c17 = new CargoJet("C17", 500.0, 2400.0, 218_000_000.0, new Pilot().generateRandomPilot(), 80.0);
		Jet c130 = new CargoJet("C130", 340.0, 2000.0, 100_000_000.0, new Pilot().generateRandomPilot(), 23.0);
		Jet f22 = new FighterJet("F22", 2400, 1800, 150_000_000, new Pilot().generateRandomPilot(), 90, 900);
		Jet f35 = new FighterJet("F35", 1200, 1500, 90_000_000, new Pilot().generateRandomPilot(), 100, 1000);
		Jet boeing737 = new PassengerJet("737", 600, 3000, 90_000_000, new Pilot().generateRandomPilot());

		// Add the created jets to the AirField
		airfield.addJet(c17);
		airfield.addJet(c130);
		airfield.addJet(f22);
		airfield.addJet(f35);
		airfield.addJet(boeing737);

		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			displayMenu();
			System.out.print("\nEnter your choice: \n");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				airfield.listFleet();
				break;
			case 2:
				airfield.flyAllJets();
				break;
			case 3:
				airfield.viewFastestJet();
				break;
			case 4:
				airfield.viewJetWithLongestRange();
				break;
			case 5:
				airfield.loadAllCargoJets();
				break;
			case 6:
				airfield.dogfight();
				break;
			case 7:
				int jetChoice = -1;
				do {
					displayAddJetMenu();
					jetChoice = scanner.nextInt();

					switch (jetChoice) {
					case 1:
						airfield.addPassengerJet();
						break;
					case 2:
						airfield.addFighterJet();
						break;
					case 3:
						airfield.addCargoJet();
						break;
					case 4:
						System.out.println("\nReturning to main menu...");
						break;
					default:
						System.out.println("Invalid choice. Please try again.");
						break;
					}
				} while (jetChoice != 1 && jetChoice != 2 && jetChoice != 3 && jetChoice != 4);
				break;
			case 8:
				airfield.removeJetFromFleet();
				break;
			case 9:
				airfield.flyIndividualJet();
				break;
			case 10:
				airfield.hirePilot();
				break;
			case 11:
				System.out.println("\nExiting the program. Goodbye!");
				break;
			default:
				System.out.println("\nInvalid choice. Please try again.");
				break;
			}

		} while (choice != 11);

		scanner.close();
	}

	private void displayMenu() {
		System.out.println("\nMenu Options:");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Add a jet to Fleet");
		System.out.println("8. Remove a jet from Fleet");
		System.out.println("9. Fly individual jet");
		System.out.println("10. Hire a pilot");
		System.out.println("11. Quit");
	}


	private void displayAddJetMenu() {
		System.out.println("\nMenu Options:");
		System.out.println("1. Add Passenger Jet");
		System.out.println("2. Add Fighter Jet");
		System.out.println("3. Add Cargo Jet");
		System.out.println("4. Return to main menu");
	}


}
