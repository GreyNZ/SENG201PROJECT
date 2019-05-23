package main;

import java.util.Random;

import gui.MainScreen;
import person.Person;

/**
 * PlagueSick
 * @author Grey Harris, Cameron Bodger
 *
 */
public class PlagueSick {
	
	/**
	 * Random number generator
	 */
	Random rand = new Random();
	/**
	 * Game environment object
	 */
	private InitGame initGame;
	/**
	 * Crew object
	 */
	private Crew crew;
	
	/**
	 * PlagueSick constructor. Calls the spacePlague() method
	 * @param initGame
	 */
	public PlagueSick(InitGame initGame) {
		this.initGame = initGame;
		crew = initGame.getCrew();
		spacePlague();
	}
	
	
	/**
	 * Uses RNG to select a crew member to be plagued.<p>
	 * 10% chance of a second plague victim
	 */
	private void spacePlague() {
		Integer plaguedIndex = rand.nextInt(crew.getCrewSize());
		Person plaguedGuy = crew.getCrewMemberArray().get(plaguedIndex);
		MainScreen mainScreen = initGame.getMainScreen();
		plaguedGuy.addPlague();
		// 10 % of a second plague victim
		Integer secondChance = rand.nextInt(10);
		Integer secondIndex = rand.nextInt(crew.getCrewSize());
		if (canBePlagued(plaguedGuy)) {
			if (secondChance == 9 && plaguedIndex != secondIndex) {
				Person secondGuy = crew.getCrewMemberArray().get(secondIndex);
				secondGuy.addPlague();
				if (canBePlagued(secondGuy)) {
					String s = plaguedGuy + " and " + secondGuy + " contracted space plague!";
					mainScreen.printToLog(s);
			}}
			else {
				String s = plaguedGuy + " contracted space plague!";
				mainScreen.printToLog(s);
		}
		}
	}
	
	/**
	 * Checks if crew member can be plagued. Rockman and Warbot cannot be plagued
	 * @param person        Person crew member to be plague checked
	 * @return {@code true} if can be plagued, {@code false} otherwise
	 */
	private boolean canBePlagued(Person person) {
		if (person.getRace().equals("Rockman") || person.getRace().equals("Warbot")){
			return false;
		}
		else {
			return true;
		}
	}

}
