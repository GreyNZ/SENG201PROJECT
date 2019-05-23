package main;

import gui.WindowManager;

/**
 * Starts the game
 * @author Cameron Bodger, Grey Harris
 *
 */
public class Game {
	

	/**
	 * Initializes {@code WindowMaker} and starts the game
	 * @param newGame
	 */
	public void startGame(InitGame newGame) {
		WindowManager manager = new WindowManager(newGame);
		newGame.setWindowManager(manager);
		manager.launchStartScreen();
		}
	
	/**
	 * Main 
	 * @param args
	 */
	public static void main(String[] args) {
		InitGame newGame = new InitGame();
		Game game = new Game();
		game.startGame(newGame);
	}
	

}
