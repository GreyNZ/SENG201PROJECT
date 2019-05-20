package main;

import java.util.Random;

/**
 * @author c
 *
 */
public class Person {
	
	/**
	 * unique integer to distinguish crew members 0-4
	 */
	protected Integer uniqueIdentifier;
	/**
	 * Name of the person
	 */
	protected String personName;
	/**
	 * Race of the person
	 */
	protected String personRace;
	/**
	 * current health 
	 */
	protected Integer personHealth;
	/**
	 * maximum health
	 */
	protected Integer personMaxHealth;
	/**
	 * current tiredness
	 */
	protected Integer personVigour;
	/**
	 * maximum tiredness
	 */
	protected Integer person_max_vigour;
	/**
	 * current hunger level
	 */
	protected Integer person_hunger;
	/**
	 * maximum hunger level
	 */
	protected Integer person_max_hunger;
	/**
	 * Maximum number of action
	 */
	protected Integer person_max_actions;
	/**
	 * Current number of actions remaining
	 */
	protected Integer person_actions_remaining;
	/**
	 * repair modifier
	 */
	protected Double person_repair_value;
	/**
	 * search ability modifier
	 */
	protected Double person_search_value;
	/**
	 * {@code true} if person has plague, {@code false} otherwise
	 */
	protected Boolean has_plague;
	/**
	 * {@code false} if still alive, {@code true} otherwise
	 */
	private boolean hasDied = false;
	/**
	 * {@code true} if death has been announced to log, {@code false} otherwise
	 */
	private boolean labelledDead = false;
	/**
	 * Status string. Can be healthy, plagued or dead
	 */
	private String person_status = "Healthy";

	
	/**
	 * Person constructor with default values
	 */
	public Person() {
		personName = "unnamed crewmember";
		personRace = "unnamed race";
		personHealth = 100;
		personMaxHealth = 100;
		personVigour = 100;
		person_max_vigour = 100;
		person_hunger = 0;
		person_max_hunger = 100;
		person_max_actions = 2;
		person_actions_remaining = 2;
		person_repair_value = 1.0d;
		person_search_value = 1.0d;
		has_plague = false;
		uniqueIdentifier = 9000;
		
	}
	
	/**
	 * Person constructor
	 * 
	 * @param name            Persons name string
	 * @param race            Persons race string
	 * @param health          current health amount
	 * @param maxHealth       maximum health
	 * @param vigour          current tiredness level
	 * @param maxVigour       maximum tiredness level
	 * @param hunger          current hunger
	 * @param maxHunger       maximum hunger
	 * @param maxActions      maximum actions
	 * @param currentActions  current amount of actions
	 * @param repairValue     repair ability modifier
	 * @param searchValue     search ability modifier
	 * @param hasPlague       boolean person has plague
	 * @param unique          int unique identifier
	 */
	public Person(String name, String race, int health, int maxHealth, int vigour, int maxVigour, int hunger, int maxHunger, int maxActions, int currentActions, double repairValue, double searchValue, boolean hasPlague, int unique) {
		personName = name;
		personRace = race;
		personHealth = health;
		personMaxHealth = maxHealth;
		personVigour = vigour;
		person_max_vigour = maxVigour;
		person_hunger = hunger;
		person_max_hunger = maxHunger;
		person_max_actions = maxActions;
		person_actions_remaining = currentActions;
		person_repair_value = repairValue;
		person_search_value = searchValue;
		has_plague = hasPlague;
		uniqueIdentifier = unique;
	}
	
	/**
	 * Returns formatted string of persons attributes
	 * @return formatted string of crew members attributes
	 */
	public String toLongString() {
		String status = "\nName = %s\nRace = %s\n" + 
						"Health = %s\nVigour = %s\n" + 
						"Hunger = %s\nActions = %s\n" +
						"Has Plague = %s\n";
		return String.format(status,  this.getName(), this.getRace(), this.getHealth(), this.getVigour(), this.getHunger(), this.getActions(), this.getPlagueValue());
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.personName;
	}
	
	/**
	 * gets the status of the person for the crew tab
	 * @return formatted string of the status of the crew member
	 */
	public String getPersonStatus() {
		Integer spaceValue = 20;
		String spacing = new String(new char[spaceValue]).replace("\0", " ");
		String status = "%s" + spacing + "%s" + spacing +"%s/%s"+ spacing +"%s/%s"+ spacing + "%s\n\n";
		status = String.format(status, personName, personRace, person_hunger, 
				person_max_hunger, personVigour, person_max_vigour, getStatus() );
		/// more to come
		return status;
	}
	


	
	
	/**
	 * Gets the current status. Can be healthy, plagued or dead
	 * @return the crew members status
	 */
	public String getStatus() {
		return person_status;
	}
	
	/**
	 * Gets the unique id
	 * @return int unique id
	 */
	public int getUnique() {
		return uniqueIdentifier;
	}
	
	/**
	 * Gets the crew members name
	 * @return persons name string
	 */
	public String getName() {
		return personName;
	}
	
	/**
	 * Gets the crew members race
	 * @return persons race string
	 */
	public String getRace() {
		return personRace;
	}
	
	/**
	 * Gets the crew members current health
	 * @return persons current health
	 */
	public Integer getHealth() {
		return personHealth;
	}
	
	/**
	 * Gets the crew members maximum health
	 * @return persons maximum health
	 * 	 
	 */
	public Integer getMaxHealth() {
		return personMaxHealth;
	}
	
	/**
	 * Gets the crew members current vigour
	 * @return persons current vigour
	 */
	public Integer getVigour() {
		return personVigour;
	}
	
	/**
	 * Gets the crew members maximum vigour
	 * @return persons maximum vigour
	 */
	public Integer getMaxVigour() {
		return person_max_vigour;
	}
	
	/**
	 * Gets the crew members current hunger
	 * @return persons current hunger
	 */
	public Integer getHunger() {
		return person_hunger;
	}
	
	/**
	 * Gets the crew members maximum hunger
	 * @return persons maximum hunger
	 */
	public Integer getMaxHunger() {
		return person_max_hunger;
	}
	
	/**
	 * Gets the crew members maximum actions
	 * @return persons maximum actions
	 */
	public Integer getMaxActions() {
		return person_max_actions;
	}
	
	/**
	 * Gets the crew members current actions
	 * @return persons current actions
	 */
	public Integer getActions() {
		return person_actions_remaining;
	}
	
	/**
	 * Gets the crew members repair value modifier
	 * @return persons repair value modifier
	 */
	public Double getRepairValue() {
		return person_repair_value;
	}
	
	/**
	 * Gets the crew members search value modifier
	 * @return persons search value modifier
	 */
	public Double getSearchValue() {
		return person_search_value;
	}
	
	/**
	 * Gets the crew members plague boolean
	 * @return persons plague boolean
	 */
	public Boolean getPlagueValue() {
		return has_plague;
	}
	
	/**
	 * Gives plague to the person. Sets plagued boolean to {@code true}
	 */
	public void addPlague() {
		person_status = "Plagued";
		this.has_plague = true;
		if (this.getPlagueValue()) {
			this.decreaseHealth(30);
		}
	}
	
	/**
	 * Removes plague from the person. Sets plagued boolean to {@code false}
	 */
	public void removePlague() {
		person_status = "Healthy";
		this.has_plague = false;			
	}
	
	/**
	 * Heals the person by the increase amount
	 * @param increase       int amount to heal
	 */
	public void increaseHealth(int increase) {
		int currentHealth = this.personHealth;
		int maxHealth = this.getMaxHealth();
		currentHealth += increase;
		if (currentHealth >= maxHealth) {
			this.personHealth = maxHealth;
		} 
		else {
			this.personHealth = currentHealth;
		}
	}
	
	/**
	 * Damages persons health by the decrease amount, kills person if health falls below 0
	 * 
	 * @param decrease    int amount of health to decrease
	 * @return {@code true} if damage results in death, {@code false} otherwise
	 */
	public boolean decreaseHealth(int decrease) {
		int minimumHealth = 0;
		int currentHealth = this.personHealth;
		currentHealth -= decrease;
		if (currentHealth > minimumHealth) {
			this.personHealth = currentHealth;
			return false; // not dead
		}
		else {
			this.personHealth = 0;
			person_status = "Dead";
			kill();
			person_actions_remaining = 0;
			System.out.println(personName + " has died.");
			return true;
			/// call death function, remove from crew
		}
		
	}
	
	/**
	 * Kills the person. Sets hasDied to true, strips actions and removes plague
	 */
	public void kill() {
		hasDied = true;
		person_actions_remaining = 0;
		removePlague();
	}
	
	/**
	 * Gets has died boolean
	 * @return has died boolean
	 */
	public boolean isDead() {
		return this.hasDied;
		
	}
	// redundant but stops constantly printing that person is dead
	/**
	 * Gets labeled dead boolean. Useful to stop unnecessary logging
	 * @return labelled dead boolean
	 */
	public boolean alreadLabelledDead() {
		return this.labelledDead ;
	}

	/**
	 * Person sleeps, if they have actions, to reduce tiredness. 
	 * Returns a string of the sleep result
	 * @return string of the sleep result
	 */
	public String personSleep() {
		boolean canSleep = attemptAction();
		if (canSleep) {
			this.personVigour = this.person_max_vigour;
			return personName + " had a nice rest.";
		}
		else {
			return "Not enough action points";
		}
	}
	
	/**
	 *  Makes the person sleepy
	 * @param decrease        int amount of vigour to decrease
	 */
	public void decreaseVigourAction(int decrease) { /// if enough vigour reduces vigor and returns true, if vigor to low returns false
		int currentVigour = this.personVigour;
		currentVigour -= decrease;
		if (currentVigour >= 0) {
			this.personVigour = currentVigour;
		}
		else {
			this.personVigour = 0;
		}
		
	}
	
	/**
	 * Decreases vigour on travel
	 */
	public void decreaseVigourTravel() {
		int decrease = 20;
		int currentVigour = this.personVigour;
		currentVigour -= decrease;
		if (currentVigour >= 0) {
			this.personVigour = currentVigour;
		}
		else {
			this.personVigour = 0;
		}
	}
	
	
	/**
	 * Increases the hunger at the end of the day, by 10
	 */
	public void increaseHungerEndDay() {
		int increase = 10;
		int maxHunger = this.person_max_hunger;
		int currentHunger = this.person_hunger;
		currentHunger += increase;
		if (currentHunger >= maxHunger) {
			this.person_hunger = maxHunger;
		}
		else {
			this.person_hunger = currentHunger;
		}
	}
	
	
	/**
	 * Consumes food to decrease hunger
	 * @param foodValue      int amount of food satiation
	 */
	public void eatFood(int foodValue) {
		int currentHunger = this.person_hunger;
		currentHunger -= foodValue;
		if (currentHunger >= 0) {
			this.person_hunger = currentHunger;
		}
		else {
			this.person_hunger = 0;
		}
		
	}
	
	/**
	 * Makes the person more hunger
	 * @param increase      amount of hunger to increase
	 */
	public void increaseHunger(int increase) {
		int currentHunger = this.person_hunger;
		int maxHunger = this.person_max_hunger;
		currentHunger += increase;
		if (currentHunger > maxHunger) {
			this.person_hunger = maxHunger;
		}
		else {
			this.person_hunger = currentHunger;
		}
	}
	
	/**
	 * Refreshes persons actions to maximum
	 */
	public void resetActions() {
		if (!this.hasDied) {
			person_actions_remaining = person_max_actions;
		}
	}
	
	/**
	 * Uses an action. Returns {@code true} if action is available, {@code false} otherwise
	 * @return
	 */
	public boolean attemptAction() {      /// attempts an action if there is actions remaining reduces by 1 and returns true, if not returns false
		int currentActions = person_actions_remaining;
		currentActions -= 1;
		if (currentActions >= 0) {
			person_actions_remaining = currentActions;
			increaseHungerEndDay();
			decreaseVigourTravel();
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * Random chance to find a piece
	 * @param rand      {@link Random} number generator object
	 * @return          {@code true} if can find piece, {@code false} otherwise
	 */
	public boolean rollForPiece(Random rand) {
		Double roll = rand.nextInt(100) * person_search_value;
		System.out.println(roll);
		if (roll >= 50) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Reports why the action failed. Either too tired or not enough action points
	 * @return      String explaining why action failed
	 */
	public String failedAction() {
		String failedReason = "";
		if (personVigour <= 0) {
			failedReason = personName + " is too tired to follow your orders. Let them sleep";
		}
		else {
			failedReason = "Not enough actions";
		}
		return failedReason;
	}
	
	/**
	 * Plague sickness damages health by 30 at the end of each day
	 * @return        String person name and health lost
	 */
	public String plagueSickness() {
		String s = "";
		if (has_plague) {
			Integer plagued = 30;
			decreaseHealth(plagued);
			s += personName + " lost " + plagued + " health from the plague";
		}
		return s;
	}
	
	/**
	 * Performs end of day changes for person. Makes hungry and tired, refreshes action points
	 * and applies plague sickness
	 * @return
	 */
	public String endDayChanges() {
		increaseHungerEndDay();
		decreaseVigourTravel();
		resetActions();
		String s = plagueSickness();
		return s;

	}
	/**
	 * Sets labeled dead boolean to {@code true} if death has been
	 * reported to log
	 */
	public void setLabelledDead() {
		labelledDead = true;
		
	}
}
