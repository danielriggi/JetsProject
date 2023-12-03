package com.skilldistillery.jets;

public abstract class Jet {
	private String model;
	private double speed;
	private double range;
	private double price;
	private Pilot pilot;


	public Jet(String model, double speed, double range, double price, Pilot pilot) {
    	this.model = model;
    	this.speed = speed;
    	this.range = range; 
    	this.price = price;
    	this.pilot = pilot;
    }
    
	
	
    public abstract void fly();
    
    public double calculateFlightTime() {
        return range / speed;
    }


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public double getSpeed() {
		return speed;
	}

	
	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public double getRange() {
		return range;
	}


	public void setRange(double range) {
		this.range = range;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}  
	
	public  Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}   
	
	public String toString() {
		return String.format("The %s%nspeed: %.2f MPH, range: %.2f miles, price: $%.2f%npiloted by: %s%n", model, speed,
				range, price, pilot.toString());
	}
    
    
    
}
