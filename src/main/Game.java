package main;


/**
 * Starts the game
 * @author c
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
