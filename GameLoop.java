package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLoop {
	
	Scanner scanner = new Scanner(System.in);
	private String shipName;
	private int days;
	private int pieces;

	
	public void initializeGame() {
		setShipName();
		setGameLength();
		setPieces();
		Crew crew = new Crew();
		Game game = new Game();
		game.mainLoop();
		Game game = new Game();
		
		
	}
	
	public void setShipName() {
		System.out.println("Enter the name of your ship");
		try {
			shipName = scanner.next();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Defaulting to Betty.");
			shipName = "Betty";
		}
	}
	
	public void setGameLength() {
		System.out.println("How many days would you like to adventure for? (3-10)");
		try {
			days = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Defaulting to 6.");
			days = 6;
		}
	}
	
	public String getShipName() {
		return this.shipName;
	}
	
	public int getDays() {
		return this.days;
	}
	public void setPieces() {
		this.pieces = (2 * this.days) / 3;
	}
	public int getPieces() {
		return this.pieces;
	}

}
