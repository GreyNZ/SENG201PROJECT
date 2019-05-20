package main;


public class Game {
	

	public void startGame(InitGame newGame) {
		WindowManager manager = new WindowManager(newGame);
		newGame.setWindowManager(manager);
		manager.launchStartScreen();
		}
	
	public static void main(String[] args) {
		InitGame newGame = new InitGame();
		Game game = new Game();
		game.startGame(newGame);
	}
	

}
