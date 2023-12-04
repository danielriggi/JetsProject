package com.skilldistillery.jets;

import java.util.ArrayList;

public class AirField {
	ArrayList<Jet> jets = new ArrayList<Jet>();

	public void addJet(Jet jet) {
		jets.add(jet);
	}

	public ArrayList<Jet> getFleet() {
		return jets;
	}

}
