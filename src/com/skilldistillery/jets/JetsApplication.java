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
				listFleet(airfield);
				break;
			case 2:
				flyAllJets(airfield);
				break;
			case 3:
				viewFastestJet(airfield);
				break;
			case 4:
				viewJetWithLongestRange(airfield);
				break;
			case 5:
				loadAllCargoJets(airfield);
				break;
			case 6:
				dogfight(airfield);
				break;
			case 7:
				int jetChoice = -1;
				do {
					displayAddJetMenu();
					jetChoice = scanner.nextInt();

					switch (jetChoice) {
					case 1:
						addPassengerJet(airfield, scanner);
						break;
					case 2:
						addFighterJet(airfield, scanner);
						break;
					case 3:
						addCargoJet(airfield, scanner);
						break;
					case 4:
						System.out.println("\nReturning to main menu...");
						break;
					default:
						System.out.println("Invalid choice. Please try again.");
						break;
					}
				} while (jetChoice != 1 && jetChoice !=2 && jetChoice != 3 && jetChoice != 4);
				break;
			case 8:
				removeJetFromFleet(airfield, scanner);
				break;
			case 9:
				flyIndividualJet(airfield, scanner);
				break;
			case 10:
				hirePilot(airfield, scanner);
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

	private void listFleet(AirField airfield) {
		int index = 1;
		System.out.println();
		for (Jet j : airfield.getFleet()) {
			System.out.printf("Jet %d%n", index);
			System.out.println(j.toString());
			index++;

		}
	}

	private void flyAllJets(AirField airfield) {
		System.out.println();
		for (Jet j : airfield.getFleet()) {
			j.fly();
		}
	}

	private void viewFastestJet(AirField airfield) {
		ArrayList<Jet> fleet = airfield.getFleet();
		Jet fastest = fleet.get(0);
		for (Jet j : fleet) {
			if (j.getSpeed() > fastest.getSpeed()) {
				fastest = j;
			}
		}
		System.out.println("\nThe fastest jet is:");
		System.out.println(fastest.toString());
//		System.out.printf("The %s%nspeed: %.2f MPH, range: %.2f miles, price: $%.2f%n", fastest.getModel(), fastest.getSpeed(),
//				fastest.getRange(), fastest.getPrice());

	}

	private void viewJetWithLongestRange(AirField airfield) {
		ArrayList<Jet> fleet = airfield.getFleet();
		Jet longestRange = fleet.get(0);
		for (Jet j : fleet) {
			if (j.getRange() > longestRange.getRange()) {
				longestRange = j;
			}
		}
		System.out.println("\nThe jet with the longest range is:");
		System.out.println(longestRange.toString());
//		System.out.printf("The %s%nspeed: %.2fMPH, range: %.2f miles, price: $%.2f%n", longestRange.getModel(),
//				longestRange.getSpeed(), longestRange.getRange(), longestRange.getPrice());
	}

	private void loadAllCargoJets(AirField airfield) {
		ArrayList<Jet> fleet = airfield.getFleet();
		System.out.println();
		for (Jet j : fleet) {
			if (j instanceof CargoJet) {
				CargoJet cargoJet = (CargoJet) j;
				cargoJet.loadCargo(cargoJet.getCarryingCapacity());
				;
			}
		}
	}

	private void dogfight(AirField airfield) {
		// every fighter jet is going to be attacked by the fighter jet in front of it
		// in the array.
		// the first jet will be attacked by the last.
		ArrayList<Jet> fleet = airfield.getFleet();
		ArrayList<FighterJet> fighterJets = new ArrayList<>();
		for (Jet jet : fleet) {
			if (jet instanceof FighterJet) {
				fighterJets.add((FighterJet) jet);
			}
		}
		int numFighterJets = fighterJets.size();
		if (fighterJets.size() < numFighterJets) {
			System.out.println("\nNot enough fighters in the fleet for a dogfight");
			return;
		}
		
		System.out.println("\nStarting the dogfight!!!");

		for (int i = 0; i < fighterJets.size(); i++) {
			FighterJet currentFighterJet = fighterJets.get(i);
			FighterJet precedingFighterJet = fighterJets.get((i - 1 + numFighterJets) % numFighterJets);
			currentFighterJet.fight(precedingFighterJet.getAttackPower());
		}

		System.out.println("Dogfight finished");

	}

	private void displayAddJetMenu() {
		System.out.println("\nMenu Options:");
		System.out.println("1. Add Passenger Jet");
		System.out.println("2. Add Fighter Jet");
		System.out.println("3. Add Cargo Jet");
		System.out.println("4. Return to main menu");
	}

	private void addPassengerJet(AirField airfield, Scanner scanner) {
	    // Prompt user for passenger jet details (model, speed, range, price)
	    // Create a new PassengerJet instance with the provided details
	    // Call addJet to add the new jet to the airfield
		System.out.println("Enter the passenger jet model: ");
		String model = scanner.next();
		System.out.println("Enter the passenger jet speed (MPh): ");
		Double speed = scanner.nextDouble();
		System.out.println("Enter the passenger jet range: ");
		Double range = scanner.nextDouble();
		System.out.println("Enter the passenger jet price: ");
		Double price = scanner.nextDouble();
		PassengerJet jet = new PassengerJet(model, speed, range, price, new Pilot().generateRandomPilot());
		airfield.addJet(jet);
		
		
		
	}

	private void addFighterJet(AirField airfield, Scanner scanner) {
	    // Prompt user for passenger jet details (model, speed, range, price, attackPower, hitPoints)
	    // Create a new FighterJet instance with the provided details
	    // Call addJet to add the new jet to the airfield
		System.out.println("Enter the fighter jet model: ");
		String model = scanner.next();
		System.out.println("Enter the fighter jet speed (MPH): ");
		Double speed = scanner.nextDouble();
		System.out.println("Enter the fighter jet range: ");
		Double range = scanner.nextDouble();
		System.out.println("Enter the fighter jet price: ");
		Double price = scanner.nextDouble();
		System.out.println("Enter the fighter jet attack power: ");
		Double attackPower = scanner.nextDouble();
		System.out.println("Enter the fighter jet hit points: ");
		Double hitPoints = scanner.nextDouble();
		FighterJet jet = new FighterJet(model, speed, range, price, new Pilot().generateRandomPilot(), attackPower, hitPoints);
		airfield.addJet(jet);
	}

	private void addCargoJet(AirField airfield, Scanner scanner) {
	    // Prompt user for cargo jet details (model, speed, range, price, carrying capacity)
	    // Create a new CargoJet instance with the provided details
	    // Call addJetto add the new jet to the airfield
		System.out.println("Enter the cargo jet model: ");
		String model = scanner.next();
		System.out.println("Enter the cargo jet speed (MPH): ");
		Double speed = scanner.nextDouble();
		System.out.println("Enter the cargo jet range: ");
		Double range = scanner.nextDouble();
		System.out.println("Enter the cargo jet price: ");
		Double price = scanner.nextDouble();
		System.out.println("Enter the cargo jet carrying capacity in tons: ");
		Double carryingCapacity = scanner.nextDouble();

		CargoJet jet = new CargoJet(model, speed, range, price, new Pilot().generateRandomPilot(), carryingCapacity);
		airfield.addJet(jet);
	}

	private void removeJetFromFleet(AirField airfield, Scanner scanner) {
		System.out.println("\nChoose a jet to remove from the fleet (type in the jet number): ");
		listFleet(airfield);
		int choice = scanner.nextInt();
		if (choice > airfield.getFleet().size() || choice <= 0) {
			System.out.println("\nInvalid choice.");
			return;
		}
		airfield.getFleet().remove(choice-1);		
	}
	
	private void flyIndividualJet(AirField airfield, Scanner scanner) {
		System.out.println("\nChoose a jet to fly from the fleet (type in the jet number): ");
		listFleet(airfield);
		int choice = scanner.nextInt();
		if (choice > airfield.getFleet().size() || choice <= 0) {
			System.out.println("\nInvalid choice.");
			return;
		} 
		airfield.getFleet().get(choice-1).fly();
	}

    private void hirePilot(AirField airfield, Scanner scanner) {
    	System.out.println("Enter the pilots first name: ");
    	String firstName = scanner.nextLine();
    	System.out.println("Enter the pilots last name: ");
    	String lastName = scanner.nextLine();
    	System.out.println("Enter the pilots age: ");
    	int age = scanner.nextInt();
    	System.out.println("Enter the pilots salary: ");
    	double salary = scanner.nextDouble();
    	Pilot newPilot = new Pilot(firstName, lastName, age, salary);
    	System.out.println("Pick the aircraft (enter the plane number) for this pilot:");
    	listFleet(airfield);
		int choice = scanner.nextInt();
		if (choice > airfield.getFleet().size() || choice <= 0) {
			System.out.println("\nInvalid choice.");
			return;
		} 
		airfield.getFleet().get(choice-1).setPilot(newPilot);
    	
    	
    }
}
















