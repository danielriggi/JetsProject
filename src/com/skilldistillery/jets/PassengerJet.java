package com.skilldistillery.jets;

public class PassengerJet extends Jet implements CargoCarrier {
	private double cargoCarryingCapacity;
	private double cargoSpaceRemaining;

	public PassengerJet(String model, double speed, double range, double price, Pilot pilot) {
		super(model, speed, range, price, pilot);
		this.cargoCarryingCapacity = 0.0;
		this.cargoSpaceRemaining = 0.0;
	}

	public PassengerJet(String model, double speed, double range, double price, Pilot pilot,
			double cargoCarryingCapacity) {
		super(model, speed, range, price, pilot);
		this.cargoCarryingCapacity = cargoCarryingCapacity;
		this.cargoSpaceRemaining = cargoCarryingCapacity;
	}

	@Override
	public void fly() {
		double flightTime = getRange() / getSpeed();
		System.out.printf(
				"%nThe %s is flying at a speed of %.2f MPH, with a range of %.2f miles the estimated flight time is %.2f hours. "
						+ "The %s costs $%.2f.%npiloted by %s%n",
				getModel(), getSpeed(), getRange(), flightTime, getModel(), getPrice(), getPilot().toString());
	}

	@Override
	public void loadCargo(double cargoWeight) {
		if (cargoWeight <= cargoSpaceRemaining) {
			// If there is enough space, load the cargo
			System.out.println("Loading cargo: " + cargoWeight + " tons");
			cargoSpaceRemaining -= cargoWeight; // Update spaceRemaining
			System.out.println("Space remaining: " + cargoSpaceRemaining + " tons");
		} else {
			System.out.println("Not enough space to load " + cargoWeight + " tons of cargo.");
		}
	}

	public void printDetails() {
		System.out.println();
	}

	public double getCarryingCapacity() {
		return cargoCarryingCapacity;
	}

	public void setCarryingCapacity(double carryingCapacity) {
		this.cargoCarryingCapacity = carryingCapacity;
	}

	public double getSpaceRemaining() {
		return cargoSpaceRemaining;
	}

	public void setSpaceRemaining(double spaceRemaining) {
		this.cargoSpaceRemaining = spaceRemaining;
	}

}
