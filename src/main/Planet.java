package main;

import java.util.Random;

public class Planet {
	
	Integer piecesOnPlanet = 1;
	Random random = new Random();


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
	
	public static void main(String[] args) {
		Planet planet = new Planet();
//		System.out.println(planet.search());
	}

}
