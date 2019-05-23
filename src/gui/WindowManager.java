package gui;

import main.InitGame;

/**
 * Manages the opening and closing of the gui windows
 * 
 * @author Grey Harris, Cameron Bodger
 *
 */
public class WindowManager {
	
	boolean lostalready = true;

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
	 * Closes the {@link MainScreen}
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
			if (lostalready) {
			VictoryScreen victory = new VictoryScreen(this);
			lostalready = false;
			}
			
	}
		else {
			if (lostalready) {
			LossScreen loss = new LossScreen(this);
			lostalready = false;
			}
		}
	}
	/**
	 * Closes the {@link LossScreen} screen
	 * 
	 * @param loss          LossScreen to be closed
	 */
	public void closeLossScreen(LossScreen loss) {
		loss.closeWindow();
	}
	/**
	 * Closes the {@link VictoryScreen} screen
	 * 
	 * @param victory 	VictoryScreen to be closed
	 */
	public void closeVictoryScreen(VictoryScreen victory) {
		victory.closeWindow();
	}
	
	/**
	 * @return InitGame     returns the InitGame object, which holds the gameplay objects 
	 */
	public InitGame getInitGame() {
		return this.initGame;
	}
}
