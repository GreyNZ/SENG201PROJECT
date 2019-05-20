package main;

/**
 * Manages the opening and closing of the gui windows
 * 
 * @author Grey Harris, Cameron Bodger
 *
 */
public class WindowManager {
	

	private InitGame initGame;
	
	/**
	 * @param initGame		InitGame object. Holds game objects for the 
	 *                      windows to interact with
	 */
	public WindowManager(InitGame initGame) {
		this.initGame = initGame;
	}
	
	/**
	 * Creates and initializes the {@link StartScreen}
	 */
	public void launchStartScreen() {
		StartScreen start = new StartScreen(this);
		}
	
	/**
	 * Closes the {@link StartScreen} 
	 * 
	 * @param startScreen
	 */
	public void closeStartScreen(StartScreen startScreen) {
		startScreen.closeWindow();
		
	}
	
	/**
	 * Creates and initializes the {@link NewGameScreen}
	 */
	public void launchNewGameScreen() {
		NewGameScreen newGame = new NewGameScreen(this);
	}
	
	/**
	 * Closes the {@link NewGameScreen}
	 * 
	 * @param newGame
	 */
	public void closeNewGameScreen(NewGameScreen newGame) {
		newGame.closeWindow();
		
	}
	/**
	 * Launches and initializes the {@link MainScreen}
	 * Sets the window to be available to the InitGame object
	 */
	public void launchMainScreen() {
		MainScreen mainScreen = new MainScreen(this);
		initGame.setMainScreen(mainScreen);
	}
	
	/**
	 * Closes the {@link MainScreen.class}
	 * 
	 * @param mainScreen
	 */
	public void closeMainScreen(MainScreen mainScreen) {
		mainScreen.closeWindow();
	}
	
	/**
	 * Launches either {@link VictoryScreen} or {@link LossScreen}
	 * depending on whether the player has won or lost
	 */
	public void launchGameOverScreen() {
		if (initGame.hasWonGame()){
			VictoryScreen victory = new VictoryScreen(this);
	}
		else {
			LossScreen loss = new LossScreen(this);
		}
	}
	/**
	 * Closes the {@link GameOver} screen
	 * 
	 * @param gameOver
	 */
	public void closeGameOverScreen(GameOver gameOver) {
		gameOver.closeWindow();
	}
	
	/**
	 * @return InitGame     returns the InitGame object, which holds the gameplay objects 
	 */
	public InitGame getInitGame() {
		return this.initGame;
	}
}
