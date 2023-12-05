package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.Scanner;

public class AirField {
	ArrayList<Jet> airfield = new ArrayList<Jet>();
	Scanner scanner = new Scanner(System.in);

	public void addJet(Jet jet) {
		airfield.add(jet);
	}

	public ArrayList<Jet> getFleet() {
		return airfield;
	}
	
	public void listFleet() {
		int index = 1;
		System.out.println();
		for (Jet j : airfield) {
			System.out.printf("Jet %d%n", index);
			System.out.println(j.toString());
			index++;

		}
	}
	
	public void flyAllJets() {
		System.out.println();
		for (Jet j : airfield) {
			j.fly();
		}
	}
	
	public void viewFastestJet() {
		Jet fastest = airfield.get(0);
		for (Jet j : airfield) {
			if (j.getSpeed() > fastest.getSpeed()) {
				fastest = j;
			}
		}
		System.out.println("\nThe fastest jet is:");
		System.out.println(fastest.toString());

	}
	
	public void viewJetWithLongestRange() {
		Jet longestRange = airfield.get(0);
		for (Jet j : airfield) {
			if (j.getRange() > longestRange.getRange()) {
				longestRange = j;
			}
		}
		System.out.println("\nThe jet with the longest range is:");
		System.out.println(longestRange.toString());
	}
	
	public void loadAllCargoJets() {
		System.out.println();
		for (Jet j : airfield) {
			if (j instanceof CargoJet) {
				CargoJet cargoJet = (CargoJet) j;
				cargoJet.loadCargo(cargoJet.getCarryingCapacity());
				;
			}
		}
	}
	
	public void dogfight() {
		// every fighter jet is going to be attacked by the fighter jet in front of it
		// in the array.
		// the first jet will be attacked by the last.
		
		ArrayList<FighterJet> fighterJets = new ArrayList<>();
		for (Jet jet : airfield) {
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

	public void addPassengerJet() {
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
		airfield.add(jet);

	}

	public void addFighterJet() {
		// Prompt user for passenger jet details (model, speed, range, price,
		// attackPower, hitPoints)
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
		FighterJet jet = new FighterJet(model, speed, range, price, new Pilot().generateRandomPilot(), attackPower,
				hitPoints);
		airfield.add(jet);
	}

	public void addCargoJet() {
		// Prompt user for cargo jet details (model, speed, range, price, carrying
		// capacity)
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
		airfield.add(jet);
	}

	public void removeJetFromFleet() {
		System.out.println("\nChoose a jet to remove from the fleet (type in the jet number): ");
		listFleet();
		int choice = scanner.nextInt();
		if (choice > airfield.size() || choice <= 0) {
			System.out.println("\nInvalid choice.");
			return;
		}
		airfield.remove(choice - 1);
	}

	public void flyIndividualJet() {
		System.out.println("\nChoose a jet to fly from the fleet (type in the jet number): ");
		listFleet();
		int choice = scanner.nextInt();
		if (choice > airfield.size() || choice <= 0) {
			System.out.println("\nInvalid choice.");
			return;
		}
		airfield.get(choice - 1).fly();
	}

	public void hirePilot() {
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
		listFleet();;
		int choice = scanner.nextInt();
		if (choice > airfield.size() || choice <= 0) {
			System.out.println("\nInvalid choice.");
			return;
		}
		airfield.get(choice - 1).setPilot(newPilot);

	}

}
