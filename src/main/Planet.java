package main;

import java.util.Random;

/**
 * Planet
 * @author Grey Harris, Cameron Bodger
 *
 */
public class Planet {
	
	/**
	 * Number of pieces on the planet to be found
	 */
	Integer piecesOnPlanet = 1;
	/**
	 * Random number generator
	 */
	Random random = new Random();
	/**
	 * Name of the planet
	 */
	String name;
	
	/**
	 * Planet constructor. Sets a random name to the planet.
	 */
	public Planet() {
		name = randomName();
	}

	/**
	 * Gets the planet name
	 * @return String planet name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Returns {@code true} if there is a piece to be found on the planet, {@code false} otherwise
	 * @return  {@code true} if there is a piece to be found on the planet, {@code false} otherwise
	 */
	public boolean hasPiece() {
		return piecesOnPlanet > 0;
	}
	/**
	 * If piece is there to be found, decrement the amount of pieces left. Returns {@code true} if successful
	 * @return {@code true} if pieces on planet decremented, {@code false} otherwise
	 */
	public boolean foundPiece() {
		if (piecesOnPlanet > 0) {
			piecesOnPlanet -= 1;
			return true;
	}
		else {
			return false;
		}
		}
	
	/**
	 * Gets number of pieces remaining on the planet
	 * @return number of pieces remaining on the planet
	 */
	public Integer pieces() {
		return this.piecesOnPlanet;
	}
	

	/**
	 * Uses a random number generator to choose a planet name from an Array of names.
	 * @return randomly selected planet name
	 */
	private String randomName() {
		String[] names = new String[] {"Rugouclite", "Decestea", "Ginilles", 
				"Bosippe", "Gaoruta", "Rotania", "Drairus", "Giaphus", "Monoe", 
				"T", "Nomia", "8A8", "Veccoavis", "Vothetov", "Cenzapus", "Munvilia", 
				"Tuerus", "Chuanerth", "Zotinope", "Suducury", "Gomia", "Wrs", "Llerth", 
				"Agof", "Datreunides", "Sethenerth", "Kizeshan", "Bignore", "Xoutania", 
				"Riuyama", "Dramumia", "Meicury", "Strade", "7P", "Colla", "31", 
				"Secceigantu", "Duphilia", "Yemosie", "Chelruna", "Zithea", "Maphus", 
				"Mohalea", "Sacagawa", "Vides", "W", "Llypso", "Hj6", "Danreutania", 
				"Ocorus", "Peccuna", "Cecrade", "Thunov", "Oicury", "Voyowei", "Vosater", 
				"Mars", "1Mzw", "Drolla", "45O7"};
		Integer i = random.nextInt(60);
		return names[i];
	}

}
