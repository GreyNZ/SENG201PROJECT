package main;

import java.util.Random;

public class PlagueSick {
	
	Random rand = new Random();
	private InitGame initGame;
	private Crew crew;
	
	public PlagueSick(InitGame initGame) {
		this.initGame = initGame;
		crew = initGame.getCrew();
		spacePlague();
	}
	
	
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
	
	private boolean canBePlagued(Person person) {
		if (person.getRace().equals("Rockman") || person.getRace().equals("Warbot")){
			return false;
		}
		else {
			return true;
		}
	}

}
