package main;

import java.util.Random;

public class Planet {
	
	Integer piecesOnPlanet = 2;
	Random random = new Random();


	public void foundPiece() {
		piecesOnPlanet -= 1;
		
	}
	
	public Integer pieces() {
		return this.piecesOnPlanet;
	}
	
	public static void main(String[] args) {
		Planet planet = new Planet();
//		System.out.println(planet.search());
	}

}
