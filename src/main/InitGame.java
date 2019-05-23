package main;

import java.util.Random;

import gui.MainScreen;
import gui.WindowManager;
import outpost.Outpost;
import person.Person;

/**
 * InitGame. The game environment
 * @author Cameron Bodger, Grey Harris
 *
 */
public class InitGame {
	
	/**
	 * The name of the space vessel
	 */
	private String shipName;
	/**
	 * How many days total to complete the game
	 */
	private int days;
	/**
	 * How many pieces needed to be found to win
	 */
	private int pieces;
	/**
	 * How many pieces have currently been found
	 */
	private int currentPieces = 0;
	/**
	 * How many are onboard your ship
	 */
	private int crewSize;
	/**
	 * The number of days passed since the game started
	 */
	private int currentDay = 0;
	/**
	 * Available funds
	 */
	private int money = 1000;
	/**
	 * Crew object, holds the crew and related methods and attributes
	 */
	private Crew crew = new Crew(this);
	/**
	 * Outpost object, holds the shop and your items
	 */
	private Outpost outpost = new Outpost(this);
	/**
	 * WindowManager object, manages opening and closing windows
	 */
	private WindowManager manager;
	/**
	 * MainScreen object, primary gui window for the game
	 */
	private MainScreen mainScreen;
	/**
	 * The current Planet object, to be searched for parts
	 */
	private Planet planet = new Planet();
	/**
	 * Random number generator
	 */
	private Random rand = new Random();
	/**
	 * You Ship object, for spacefaring
	 */
	private Ship ship;
	/**
	 * Game isn't completed while false
	 */
	private boolean gameHeckinOver = false;
	/**
	 * False is failure. True is victory
	 */
	private boolean wonGame = false;
	/**
	 * Game points. Accrue at the end of each day and on game over
	 */
	private int points = 0;
	/**
	 * How the player died, updated on death
	 */
	private String causeOfDeath = "";
	/**
	 * Randomly generated space junk
	 */
	private MiscItems miscItems = new MiscItems();

	
	

	/**
	 * Sets the ship name on initialization
	 * 
	 * @param shipName	String name of the ship
	 */
	public void setShipName(String shipName) {
		this.shipName = shipName;
		this.ship = new Ship(shipName);
	}
	
	/**
	 * Gets the ship name string
	 * 
	 * @return shipName  String name of the ship
	 */
	public String getShipName() {
		return shipName;
	}
	
	/**
	 * Gets the number of crew members
	 * 
	 * @return crewSize  int size of the crew
	 */
	public int getCrewSize() {
		return crewSize;
	}
	
	/**
	 * Gets the total number of game days
	 * 
	 * @return days     int number of days
	 */
	public int getDays() {
		return days;
	}
	
	/**
	 * Sets the number of pieces to be found for victory
	 * (2 * days) / 3
	 */
	public void setPieces() {
		pieces = (2 * this.days) / 3;
	}
	
	/**
	 * Returns the number of pieces to be found
	 * 
	 * @return pieces     int number of pieces
	 */
	public int getPieces() {
		return pieces;
	}
	
	/**
	 * Returns the current number of pieces found
	 * 
	 * @return the number of pieces currently found
	 */
	public int getCurrentPieces() {
		return currentPieces;
	}
	
	/**
	 * Increments the current pieces if one has been found while searching<p>
	 * If current pieces is equal to the total number of pieces being looked for the game is over.
	 * wonGame boolean is set to true, bonus points are added and gameOver(String s) is called with an empty string
	 */
	public void getAddCurrentPieces() {
		currentPieces += 1;
		if (currentPieces >= pieces) {
			wonGame = true;
			points += 10000;
			gameOver("");
		}
	}

	/**
	 * Ends the current day. <p>
	 * Increments the day, calculates points to add to the score. If that was the last day, game is over. 
	 * Otherwise, resets the crew members actions and potentially triggers a random event
	 */
	public void endDay() {
		this.currentDay += 1;
		calculatePoints();
		if (currentDay > days) {
			gameOver("You ran out of days");
		}
		else {
			String s = crew.endDayActions();
			mainScreen.printToLog(s);
			randomEvent();
		}
	}

	/**
	 * Ends the game, by setting the game over boolean to true, which is checked by MainWindow.
	 * Takes cause of death String as input and calculates points, to be used for the game over screen.
	 * 
	 * @param death    String the cause of death 
	 */
	public void gameOver(String death) {
		causeOfDeath = death;
		calculatePoints();
		points += money;
		gameHeckinOver = true;
		
	}
	/**
	 * Returns true if the game is over, false otherwise
	 * 
	 * @return boolean that is {@code true} if the game is over, {@code false} otherwise
	 */
	public boolean isGameOver() {
		return this.gameHeckinOver;
	}


	/**
	 * Gets the current day
	 * 
	 * @return the current day int
	 */
	public int getCurrentDay() {
		return currentDay;
	}
	
	/**
	 * Sets the number of days the game will last.
	 * 
	 * Calls {@link setPieces()} to set the number of pieces to be found
	 */
	public void setGameLength(int i) {
		this.days = i;
		setPieces();
		
	}
	/**
	 * Gets the crew object
	 * 
	 * @return {@link Crew} object
	 */
	public Crew getCrew() {
		return crew;
	}
	/**
	 * Gets the outpost object
	 * 
	 * @return {@link Outpost} object
	 */
	public Outpost getOutpost() {
		return this.outpost;
	}
	/**
	 * Adds found money to the players amount
	 * 
	 * @param newMoney      int money to add
	 */
	public void addMoney(int newMoney) {
		money += newMoney;
	}
	
	/**
	 * Subtracts money from the player
	 * 
	 * @param spentMoney    int money to subtract
	 */
	public void subtractMoney(int spentMoney) {
		this.money -= spentMoney;
	}
	
	/**
	 * Gets the current amount of money
	 * 
	 * @return the amount of money the player has
	 */
	public int getMoney() {
		return this.money;
	}
	/**
	 * Sets the {@link WindowManager} attribute 
	 * 
	 * @param manager       WindowManager for opening and closing windows
	 */
	public void setWindowManager(WindowManager manager) {
		this.manager = manager;
		
	}
	/**
	 * Gets the WindowManager
	 * 
	 * @return the window manager
	 */
	public WindowManager getWindowManager() {
		return this.manager;
		
	}
	/**
	 * Sets the main screen
	 * 
	 * @param mainScreen      {@link MainScreen} the main gui window
	 */
	public void setMainScreen(MainScreen mainScreen) {
		this.mainScreen = mainScreen;
		
	}
	/**
	 * Gets the main screen
	 * 
	 * @return the {@link MainScreen} object
	 */
	public MainScreen getMainScreen() {
		return this.mainScreen;
	}
	
	/**
	 * Searches the planet for a piece.<p>
	 * Takes a crew member name String as input, then generates a random number between 0-25 to
	 * corresponding to what item is found 0-8 gets an item, 9 gets nothing, 10-15 gets gold,
	 * greater than 15 gets the chance to find either a piece or a random junk item. If there are no pieces 
	 * left to find on the planet and the number greater than 15, the player is rewarded with an ornate set of 
	 * mahogany drawers.
	 * 
	 * @param name     String the crew members name
	 * @return The String result of the search
	 */
	public String searchPlanet(Person crewMember) {
//		Person crewMember = crew.getMember(name);
		Integer foundNum = rand.nextInt(26);
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
			else if (foundNum > 9 && foundNum < 16){
				Integer goldAmount = randomGold();
				addMoney(goldAmount);
				searchResult = "Found " + goldAmount + " gold";
				mainScreen.refreshMoney();
			}
			else {
				// find piece, update pieces found, decrement pieces left on planet.
				searchResult = "Found an ornate mahogany set of drawers";
				if (planet.hasPiece()) {
					boolean roll = crewMember.rollForPiece(rand);
					if (roll){
						searchResult = "Found piece!";
						this.getAddCurrentPieces();
						planet.foundPiece();
					}
					else {
						searchResult = miscItems.getMiscItem();
					}
				}				
			}
		}
		else {
			searchResult = crewMember.failedAction();
		}
		return searchResult;

	}
	
	/**
	 * Generates a random amount of gold for the player to receive. 
	 * 1% chance of million dollar jackpot
	 * @return the amount of randomly generated gold
	 */
	public Integer randomGold() {
		Integer goldAmount = 100 + rand.nextInt(900);
		Integer bigWinChance = rand.nextInt(100);
		if (bigWinChance == 0) {
			goldAmount = 1000000;
		}
		return goldAmount;
		
	}


	/**
	 * Two pilots fly the ship to a new planet. 
	 * Checks that both pilots have enough actions and if true generates a new planet.
	 * Then rolls for asteroid belt and random event.
	 * 
	 * @param pilot1   Person the first pilot
	 * @param pilot2   Person the second pilot
	 * @return {@code true} if flight was successful, {@code false} otherwise
	 */
	public boolean travelToNewPlanet(Person pilot1, Person pilot2) {
		if (pilot1.getActions() > 0 && pilot2.getActions() > 0 ) {
			if (pilot1.tiredOrHungryCheck() && pilot2.tiredOrHungryCheck()) {
				this.planet = new Planet();
				String planetName = planet.getName();
				mainScreen.updatePlanetName(planetName);
				asteroidBelt();
				//random event for testing, remove
				randomEvent();
				pilot1.attemptAction();
				pilot2.attemptAction();
				mainScreen.printToLog("Made it to planet " + planetName);
				return true;}
			else {
				mainScreen.printToLog("Pilots are sleepy. Driving tired is dangerous");
				return false;
			}
		}
		else {
			String s = "Not enough actions.";
			mainScreen.printToLog(s);
			return false;
		}
	}
	
	/**
	 * Randomly generates either a pirate attack, space plague or nothing
	 */
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
		mainScreen.updateAll();
		
	}
	

	/**
	 * Asteroid belt random event. 25% chance of taking damage
	 */
	private void asteroidBelt() {
		Integer chance = rand.nextInt(3);
		if (chance != 0) {
			String s = "Oh no, we're passing through an asteroid belt. Hold on tight";
			ship.takeDamage(50.0);
			mainScreen.printToLog(s);
			if (ship.getShipHealth() <= 0) {
				gameOver("Your ship exploded");
			}
		}
	}
	

	/**
	 * Pirate attack event. Steals item if player has one, else injures all crew and steals gold
	 */
	public void pirateAttack() {
		String s = "Pirates are attacking!";
		mainScreen.printToLog(s);
		String attack = outpost.stealItem();
		mainScreen.printToLog(attack);
		
		
	}
	/**
	 * Returns the {@code Ship} object
	 * 
	 * @return the {@code Ship} object
	 */
	public Ship getShip() {
		return ship;
	}
	
	/**
	 * Returns the current {@code Planet} object
	 * 
	 * @return the {@code Planet}  object
	 */
	public Planet getPlanet() {
		
		return planet;
	}
	
	/**
	 * Calculates and increments game points
	 */
	public void calculatePoints() {
		points += pieces * 100;
		points += crew.crewPoints();
	}
	
	/**
	 * Returns the winning state of the game. {@code true} if won, {@code false} otherwise
	 * 
	 * @return {@code true} if game was won, {@code false} otherwise
	 */
	public boolean hasWonGame() {
		return wonGame;
	}
	/**
	 * Gets the amount of game points the player has earned
	 * 
	 * @return the int amount of game points
	 */
	public int getPoints() {
		
		return points;
	}
	
	
	/**
	 * Initializes a new {@code PlagueSick} event
	 */
	@SuppressWarnings("unused")
	private void spacePlague() {
		PlagueSick spacePlague = new PlagueSick(this);
	}
	
	/**
	 * Gets the cause of death string
	 * @return String cause of death
	 */
	public String getCauseOfDeath() {
		return causeOfDeath ;
	}
	
}
