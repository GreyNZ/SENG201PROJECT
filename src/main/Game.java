package main;

import java.util.ArrayList;

public class Game {
	
//	private boolean gameHeckinOver= false;
//	private Crew crew;
//	private int pieces;
//	private int days;
	private InitGame initGame;
	private WindowManager manager;
	
//	public Game(int days, int pieces) {
////		this.crew = crew;
//		this.days = days;
//		this.pieces = pieces;
//	}

	public Game() {
		// TODO Auto-generated constructor stub
	}


	//gui
	public void mainLoop(InitGame newGame) {
		manager = new WindowManager(newGame);
		newGame.setWindowManager(manager);
		manager.launchStartScreen();
		}
	


	
	public static void main(String[] args) {
		InitGame newGame = new InitGame();
		
//		newGame.initializeGame();
//		newGame.defaultForTesting();
//		uncomment these for console testing, using default constructor to save having to put in everything.
//		Crew crew = new Crew(newGame.getCrewSize(), newGame.getShipName());
//		game.mainLoop();
//		Game game = new Game(newGame.getDays(), newGame.getPieces());
//		Crew crew = new Crew(newGame);
		Game game = new Game();
//		Crew crew = newGame.getCrew();
//		crew.buildCrew();
		game.mainLoop(newGame);
	}
	

}
