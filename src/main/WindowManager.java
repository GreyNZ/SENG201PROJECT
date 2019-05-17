package main;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
		GameOver gameOver = new GameOver(this);
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

	public void playSound(String url)
    {
      try 
      {
       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(url).getAbsoluteFile());
       Clip clip = AudioSystem.getClip();
       clip.open(audioInputStream);
       clip.start();
      }
      catch(Exception ex)
      {
        System.out.println("Error with playing sound.");
        ex.printStackTrace( );
      }
    }
}
