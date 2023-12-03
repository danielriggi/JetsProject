package com.skilldistillery.jets;

import java.util.Random;

public class Pilot {
	private String firstName;
	private String lastName;
	private int age;
	public double salary;
    
	public Pilot() {
		
	}
	
	public Pilot(String firstName, String lastName, int age, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
	}

	public Pilot generateRandomPilot() {
		RandomNameGenerator rng = new RandomNameGenerator();
		Random random = new Random();
		int age = random.nextInt((65-25) +1) + 25;
		double salary = (double) random.nextInt((200000-60000) +1) + 60000;
		Pilot pilot = new Pilot(rng.generateFirstName(), rng.generateLastName(), age, salary);
		return pilot; 
	}
	
	@Override
	public String toString() {
		return String.format("%s %s, age %d with a $%.2f salary", firstName, lastName, age, salary);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
