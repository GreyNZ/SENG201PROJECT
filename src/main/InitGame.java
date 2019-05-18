package main;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class InitGame {
	
	Scanner scanner = new Scanner(System.in);
	private String shipName;
	private int days;
	private int pieces;
	private int currentPieces = 0;
	private int crewSize;
	private int currentDay = 0;
	private int money = 1000;
	private Crew crew = new Crew(this);
	private Outpost outpost = new Outpost(this);
	private WindowManager manager;
	private MainScreen mainScreen;
	private Planet planet = new Planet();
	private Random rand = new Random();
	private Ship ship;
	private boolean gameHeckinOver = false;
	private int points = 0;

	

	

	
	// legacy console
	public void initializeGame() {
		setShipName();
		setGameLength();
		setPieces();
		setCrewSize();
//		this.crew = new Crew(this.crewSize, this.shipName);
//		Game game = new Game(crew, this. days, this.pieces);
//		game.mainLoop();
		
		
	}
	//console
	public void setShipName() {
		System.out.println("Enter the name of your ship");
		try {
			shipName = scanner.next();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Defaulting to Betty.");
			shipName = "Betty";
		}
	}
	// gui
	public void setShipName(String shipName) {
		this.shipName = shipName;
		this.ship = new Ship(shipName);
	}
	
	public void setGameLength() {
		System.out.println("How many days would you like to adventure for? (3-10)");
		try {
			days = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Defaulting to 6.");
			days = 6;
		}
	}
	
	public void setCrewSize() {
		System.out.println("How many crew members? (2-4)");
		try {
			crewSize = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Defaulting to 4.");
			crewSize = 4;
		}
	}
	
	public String getShipName() {
		return this.shipName;
	}
	public int getCrewSize() {
		return this.crewSize;
	}
	public int getDays() {
		return this.days;
	}
	public void setPieces() {
		this.pieces = (2 * this.days) / 3;
	}
	public int getPieces() {
		return this.pieces;
	}
	
	public int getCurrentPieces() {
		return this.currentPieces;
	}
	
	public void getAddCurrentPieces() {
		this.currentPieces = this.getCurrentPieces() + 1;
	}

	public void endDay() {
		this.currentDay += 1;
		if (currentDay > days) {
			gameOver();
		}
		String s = crew.endDayActions();
		mainScreen.printToLog(s);
		randomEvent();
		
	}

	private void gameOver() {
		this.gameHeckinOver = true;
		
	}
	public boolean isGameOver() {
		return this.gameHeckinOver;
	}
	public void defaultForTesting() {
		this.shipName = "space boi";
		this.days = 3;
		this.crewSize = 2;
		setPieces();
		
	}

	public int getCurrentDay() {
		// TODO Auto-generated method stub
		return this.currentDay;
	}
	
	// gui
	public void setGameLength(int i) {
		this.days = i;
		setPieces();
		// TODO Auto-generated method stub
		
	}
	public Crew getCrew() {
		return this.crew;
	}
	public Outpost getOutpost() {
		return this.outpost;
	}
	public void addMoney(int newMoney) {
		this.money += newMoney;
	}
	
	public void subtractMoney(int spentMoney) {
		this.money -= spentMoney;
	}
	
	public int getMoney() {
		return this.money;
	}
	public void setWindowManager(WindowManager manager) {
		this.manager = manager;
		
	}
	public WindowManager getWindowManager() {
		return this.manager;
		
	}
	public void setMainScreen(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
		
	}
	public MainScreen getMainScreen() {
		return this.mainScreen;
	}
	public String searchPlanet(String name) {
		Person crewMember = crew.getMember(name);
		System.out.println(crewMember.getRace());
		Integer foundNum = rand.nextInt(15);
		String searchResult = "";
		if (crewMember.attemptAction()) {
			if (foundNum < 8) {
				String item = outpost.getItemNameArray().get(foundNum);
				outpost.getShopList().addItem(item, 1);
				searchResult = "Found " + item;
			}
			else if (foundNum == 9) {
				searchResult = "Found nothing";
			}
			else if (foundNum > 9 && foundNum < 13){
				Integer goldAmount = randomGold();
				addMoney(goldAmount);
				searchResult = "Found " + goldAmount + " gold";
				mainScreen.refreshMoney();
			}
			else {
				// find piece, update pieces found, decrement pieces left on planet.
				if (planet.foundPiece()) {
					searchResult = "Found piece!";
					this.currentPieces += 1;
				}
				else {
					searchResult = "Found an ornate mahogany set of drawers";
				}
				
			}
		}
		else {
			searchResult = name + " has no actions left.";
		}
		return searchResult;

	}
	
	public Integer randomGold() {
		Integer goldAmount = 100 + rand.nextInt(900);
		Integer bigWinChance = rand.nextInt(100);
		if (bigWinChance == 0) {
			goldAmount = 1000000;
		}
		return goldAmount;
		
	}

	// add checks for pilots and such. 



	public boolean travelToNewPlanet(Person pilot1, Person pilot2) {
		if (pilot1.getActions() > 0 && pilot2.getActions() > 0 ) {
			this.planet = new Planet();
			String planetName = planet.getName();
			mainScreen.updatePlanetName(planetName);
			asteroidBelt();
			//random event for testing, remove
			randomEvent();
			pilot1.attemptAction();
			pilot2.attemptAction();
			mainScreen.printToLog("Made it to planet " + planetName);
			return true;
		}
		else {
			String s = "Not enough actions.";
			mainScreen.printToLog(s);
			return false;
		}
	}
	//adjust nextInt(range) range to decrease likeliness of event occurring

	private void randomEvent() {
		Integer event = rand.nextInt(4);
		switch (event) {
		case 0:
			pirateAttack();
			break;
		case 1:
			spacePlague();
			break;
		default:
			break;
		}
		
	}
	private void asteroidBelt() {
		Integer chance = rand.nextInt(3);
		if (chance != 0) {
			String s = "Oh no, we're passing through an asteroid belt. Hold on tight";
			ship.takeDamage(10.0);
			System.out.println(ship.getShipHealth() + "" + ship.getShipSheild());
			mainScreen.printToLog(s);
		}
		
	}
	private void spacePlague() {
		Integer plaguedIndex = rand.nextInt(crew.getCrewSize());
		Person plaguedGuy = crew.getCrewMemberArray().get(plaguedIndex);
		plaguedGuy.addPlague();
		// 10 % of a second plague victim
		Integer secondChance = rand.nextInt(10);
		Integer secondIndex = rand.nextInt(crew.getCrewSize());
		if (secondChance == 9 && plaguedIndex != secondIndex) {
			Person secondGuy = crew.getCrewMemberArray().get(secondIndex);
			secondGuy.addPlague();
			String s = plaguedGuy + " and " + secondGuy + " contracted space plague!";
			mainScreen.printToLog(s);
		}
		else {
			String s = plaguedGuy + " contracted space plague!";
			mainScreen.printToLog(s);
		}
		
	}
	public void pirateAttack() {
		String s = "Pirates are attacking!";
		System.out.println(s);
		mainScreen.printToLog(s);
		String attack = outpost.stealItem();
		mainScreen.printToLog(attack);
		System.out.println(s);
		
		
	}
	public Ship getShip() {
		// TODO Auto-generated method stub
		return ship;
	}
	public Planet getPlanet() {
		
		return this.planet;
	}
	
	public void calculatePoints() {
		points += pieces * 100;
		points += crew.crewPoints();
	}
	
}
