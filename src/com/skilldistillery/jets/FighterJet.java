package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {
	private double attackPower;
	private double hitPoints;
   
	public FighterJet(String model, double speed, double range, double price, Pilot pilot, double attackPower, double hitPoints) {
        super(model, speed, range, price, pilot);
        this.attackPower = attackPower;
        this.hitPoints = hitPoints;
    }
    
	@Override
    public void fly() {
		double flightTime = getRange()/getSpeed();
    	System.out.printf("%nThe %s is flying at a speed of %.2f MPH, with a range of %.2f miles the estimated flight time is %.2f hours. "
    			+ "The %s costs $%.2f.%npiloted by %s%n", getModel(), getSpeed(),
    			getRange(), flightTime, getModel(), getPrice(), getPilot().toString());
    }
    
    @Override
    public void fight(double damageRecieved) {
        if (damageRecieved <= hitPoints) {
        	hitPoints -= damageRecieved;
        	System.out.printf("%s recieved %.2f damage and has %.2f HP remaining%n", getModel(), damageRecieved, hitPoints);
        } else {
        	System.out.printf("%.2f damage is greater than %.2f HP remaining, you're going down!%n", damageRecieved, hitPoints);
        	hitPoints = 0;
        }
    }

	public double getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(double attackPower) {
		this.attackPower = attackPower;
	}

	public double getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(double hitPoints) {
		this.hitPoints = hitPoints;
	}
    
    
}
