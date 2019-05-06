package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InitGame {
	
	Scanner scanner = new Scanner(System.in);
	private String shipName;
	private int days;
	private int pieces;
	private int crewSize;
	private int currentDay = 0;

	
	public void initializeGame() {
		setShipName();
		setGameLength();
		setPieces();
		setCrewSize();
//		Crew crew = new Crew(this.crewSize, this.shipName);
//		Game game = new Game(crew, this. days, this.pieces);
//		game.mainLoop();
		
		
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
	
	public void setCrewSize() {
		System.out.println("How many crew members? (2-4)");
		try {
			crewSize = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Defaulting to 4.");
			crewSize = 4;
		}
	}
	
	public String getShipName() {
		return this.shipName;
	}
	public int getCrewSize() {
		return this.crewSize;
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

	public void endDay() {
		this.days -= 1;
		this.currentDay += 1;
		
	}

	public void defaultForTesting() {
		this.shipName = "space boi";
		this.days = 3;
		this.crewSize = 2;
		setPieces();
		
	}

	public int getCurrentDay() {
		// TODO Auto-generated method stub
		return this.currentDay;
	}

}