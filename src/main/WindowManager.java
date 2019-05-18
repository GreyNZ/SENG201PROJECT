package main;

public class WindowManager {
	
	private InitGame initGame;
	
	public WindowManager(InitGame initGame) {
		this.initGame = initGame;
	}
	
	public void launchStartScreen() {
		StartScreen start = new StartScreen(this);
		}
	
	public void closeStartScreen(StartScreen startScreen) {
		startScreen.closeWindow();
		
	}
	
	public void launchNewGameScreen() {
		NewGameScreen newGame = new NewGameScreen(this);
	}
	
	public void closeNewGameScreen(NewGameScreen newGame) {
		newGame.closeWindow();
		
	}
	public void launchMainScreen() {
		MainScreen mainScreen = new MainScreen(this);
		initGame.setMainScreen(mainScreen);
	}
	
	public void closeMainScreen(MainScreen mainScreen) {
		mainScreen.closeWindow();
	}
	
	public void launchGameOverScreen() {
		if (initGame.hasWonGame()){
			VictoryScreen victory = new VictoryScreen(this);
	}
		else {
			LossScreen loss = new LossScreen(this);
		}
	}
	public void closeGameOverScreen(GameOver gameOver) {
		gameOver.closeWindow();
	}
	
//	public static void main(String[] args) {
//		WindowManager manager = new WindowManager();
//		manager.launchNewGameScreen();
//
//	}
	public InitGame getInitGame() {
		return this.initGame;
	}

}
