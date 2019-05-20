package main;

import java.util.Random;

public class Planet {
	
	Integer piecesOnPlanet = 1;
	Random random = new Random();
	String name;
	
	public Planet() {
		name = randomName();
	}

	public String getName() {
		return name;
	}


	public boolean hasPiece() {
		return piecesOnPlanet > 0;
	}
	public boolean foundPiece() {
		if (piecesOnPlanet > 0) {
			piecesOnPlanet -= 1;
			return true;
	}
		else {
			return false;
		}
		}
	
	public Integer pieces() {
		return this.piecesOnPlanet;
	}
	

	private String randomName() {
		String[] names = new String[] {"Rugouclite", "Decestea", "Ginilles", "Bosippe", "Gaoruta", "Rotania", "Drairus", "Giaphus", "Monoe", "T", "Nomia", "8A8", "Veccoavis", "Vothetov", "Cenzapus", "Munvilia", "Tuerus", "Chuanerth", "Zotinope", "Suducury", "Gomia", "Wrs", "Llerth", "Agof", "Datreunides", "Sethenerth", "Kizeshan", "Bignore", "Xoutania", "Riuyama", "Dramumia", "Meicury", "Strade", "7P", "Colla", "31", "Secceigantu", "Duphilia", "Yemosie", "Chelruna", "Zithea", "Maphus", "Mohalea", "Sacagawa", "Vides", "W", "Llypso", "Hj6", "Danreutania", "Ocorus", "Peccuna", "Cecrade", "Thunov", "Oicury", "Voyowei", "Vosater", "Mars", "1Mzw", "Drolla", "45O7"};
		Integer i = random.nextInt(60);
		return names[i];
	}

}
