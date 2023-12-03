package com.skilldistillery.jets;

public class CargoJet extends Jet implements CargoCarrier {
	private double carryingCapacity;
	private double spaceRemaining;
	
	public CargoJet(String model, double speed, double range, double price, Pilot pilot, double carryingCapacity) {
        super(model, speed, range, price, pilot);
        this.carryingCapacity = carryingCapacity;
        this.spaceRemaining = carryingCapacity;
    }

	@Override
    public void fly() {
		double flightTime = getRange()/getSpeed();
    	System.out.printf("%nThe %s is flying at a speed of %.2f MPH, with a range of %.2f miles the estimated flight time is %.2f hours. "
    			+ "The %s costs $%.2f.%npiloted by %s%n", getModel(), getSpeed(),
    			getRange(), flightTime, getModel(), getPrice(), getPilot().toString());
    }
    
    @Override
    public void loadCargo(double cargoWeight) {
        if (cargoWeight <= spaceRemaining) {
            // If there is enough space, load the cargo
            System.out.println("Loading the " + getModel() + " with " + cargoWeight + " tons of cargo");
            spaceRemaining -= cargoWeight; // Update spaceRemaining
            System.out.println("Space remaining: " + spaceRemaining + " tons");
        } else {
            System.out.println("Not enough space to load " + cargoWeight + " tons of cargo.");
        }
    }

    public double getCarryingCapacity() {
		return carryingCapacity;
	}


	public void setCarryingCapacity(double carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}


	public double getSpaceRemaining() {
		return spaceRemaining;
	}


	public void setSpaceRemaining(double spaceRemaining) {
		this.spaceRemaining = spaceRemaining;
	}


}
