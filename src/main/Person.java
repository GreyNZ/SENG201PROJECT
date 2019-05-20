package main;

import java.util.Random;

public class Person {
	
	protected Integer uniqueIdentifier;
	protected String personName;
	protected String personRace;
	protected Integer personHealth;
	protected Integer personMaxHealth;
	protected Integer personVigour;
	protected Integer person_max_vigour;
	protected Integer person_hunger;
	protected Integer person_max_hunger;
	protected Integer person_max_actions;
	protected Integer person_actions_remaining;
	protected Double person_repair_value;
	protected Double person_search_value;
	protected Boolean has_plague;
	private boolean hasDied = false;
	private boolean labelledDead = false;
	private String person_status = "Healthy";

	
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
	
	// is this necessary?
	public String toLongString() {
		String status = "\nName = %s\nRace = %s\n" + 
						"Health = %s\nVigour = %s\n" + 
						"Hunger = %s\nActions = %s\n" +
						"Has Plague = %s\n";
		return String.format(status,  this.getName(), this.getRace(), this.getHealth(), this.getVigour(), this.getHunger(), this.getActions(), this.getPlagueValue());
	}
	public String toString() {
		return this.personName;
	}
	
	// for crew tab status
	public String getPersonStatus() {
		Integer spaceValue = 20;
		String spacing = new String(new char[spaceValue]).replace("\0", " ");
		String status = "%s" + spacing + "%s" + spacing +"%s/%s"+ spacing +"%s/%s"+ spacing + "%s\n\n";
		status = String.format(status, personName, personRace, person_hunger, 
				person_max_hunger, personVigour, person_max_vigour, getStatus() );
		/// more to come
		return status;
	}
	


	
	
	public String getStatus() {
		return person_status;
	}
	
	public int getUnique() {
		return uniqueIdentifier;
	}
	
	public String getName() {
		return personName;
	}
	
	public String getRace() {
		return personRace;
	}
	
	public Integer getHealth() {
		return personHealth;
	}
	
	public Integer getMaxHealth() {
		return personMaxHealth;
	}
	
	public Integer getVigour() {
		return personVigour;
	}
	
	public Integer getMaxVigour() {
		return person_max_vigour;
	}
	
	public Integer getHunger() {
		return person_hunger;
	}
	
	public Integer getMaxHunger() {
		return person_max_hunger;
	}
	
	public Integer getMaxActions() {
		return person_max_actions;
	}
	
	public Integer getActions() {
		return person_actions_remaining;
	}
	
	public Double getRepairValue() {
		return person_repair_value;
	}
	
	public Double getSearchValue() {
		return person_search_value;
	}
	
	public Boolean getPlagueValue() {
		return has_plague;
	}
	
	public void addPlague() {
		person_status = "Plagued";
		this.has_plague = true;
		if (this.getPlagueValue()) {
			this.decreaseHealth(30);
		}
	}
	
	public void removePlague() {
		person_status = "Healthy";
		this.has_plague = false;			
	}
	
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
	
	public void kill() {
		hasDied = true;
		person_actions_remaining = 0;
		removePlague();
	}
	
	public boolean isDead() {
		return this.hasDied;
		
	}
	// redundant but stops constantly printing that person is dead
	public boolean alreadLabelledDead() {
		return this.labelledDead ;
	}

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
	
	public void resetActions() {
		if (!this.hasDied) {
			person_actions_remaining = person_max_actions;
		}
	}
	
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
	
	public String plagueSickness() {
		String s = "";
		if (has_plague) {
			Integer plagued = 30;
			decreaseHealth(plagued);
			s += personName + " lost " + plagued + " health from the plague";
		}
		return s;
	}
	
	public String endDayChanges() {
		increaseHungerEndDay();
		decreaseVigourTravel();
		resetActions();
		String s = plagueSickness();
		return s;

	}
	public void setLabelledDead() {
		labelledDead = true;
		
	}
	
	public static void main(String[] args) {
		Person grey = new Person("Captain Kirk", "Human", 100, 100, 100, 100, 0, 100, 2, 2, 1.0, 1.0, false, 1);
		
		// NAME TESTS
		System.out.println(String.format("Current Name = %s", grey.getName()));
		System.out.println(String.format("Current Race = %s", grey.getRace()));
		
		// HEALTH TESTS
		System.out.println(String.format("Current Health = %s", grey.getHealth()));
		System.out.println(String.format("Max Health = %s", grey.getMaxHealth()));
		grey.decreaseHealth(50);
		System.out.println(String.format("Current Health minus 50 = %s", grey.getHealth()));
		grey.increaseHealth(25);
		System.out.println(String.format("Current Health increase 25 = %s", grey.getHealth()));
		grey.increaseHealth(9000);
		System.out.println(String.format("Current Health increase 9000 = %s", grey.getHealth()));
		grey.decreaseHealth(9000);
		System.out.println(String.format("Current Health minus 9000= %s", grey.getHealth()));
		
		// HUNGER TESTS
		System.out.println(String.format("Current Hunger = %s", grey.getHunger()));
		System.out.println(String.format("Max Hunger = %s", grey.getMaxHunger()));
		grey.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after a day passes = %s", grey.getHunger()));
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		grey.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after 10+ days= %s", grey.getHunger()));
		grey.eatFood(20);
		System.out.println(String.format("Hunger after a meal of 20 = %s", grey.getHunger()));
		grey.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", grey.getHunger()));
		grey.increaseHunger(50);
		System.out.println(String.format("Hunger increased by 50 = %s", grey.getHunger()));
		grey.increaseHunger(50);
		System.out.println(String.format("Hunger increased by another 50 = %s", grey.getHunger()));
		grey.increaseHunger(9000);
		System.out.println(String.format("Hunger increased by 9000 = %s", grey.getHunger()));
		grey.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", grey.getHunger()));
		
		// VIGOUR TESTS
		System.out.println(String.format("Current Vigour = %s", grey.getVigour()));
		System.out.println(String.format("Max Vigour = %s", grey.getMaxVigour()));
		grey.decreaseVigourTravel();
		System.out.println(String.format("Vigour after day/travel end = %s", grey.getVigour()));
		grey.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", grey.getVigour()));
		grey.decreaseVigourTravel();
		grey.decreaseVigourTravel();
		grey.decreaseVigourTravel();
		grey.decreaseVigourTravel();
		grey.decreaseVigourTravel();
		grey.decreaseVigourTravel();
		System.out.println(String.format("Vigour after 6 days/travels = %s", grey.getVigour()));
		grey.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", grey.getVigour()));		
		grey.personSleep();
		System.out.println(String.format("Vigour after a sleep a second time = %s", grey.getVigour()));
		grey.decreaseVigourAction(50);
		System.out.println(String.format("Vigour decreased by 50 = %s", grey.getVigour()));
		grey.decreaseVigourAction(20);
		System.out.println(String.format("Vigour decreased by 20 = %s", grey.getVigour()));
		grey.decreaseVigourAction(9000);
		System.out.println(String.format("Vigour decreased by 9000 = %s", grey.getVigour()));
		grey.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", grey.getVigour()));
		
		
		// ACTIONS TESTS
		System.out.println(String.format("Current Actions = %s", grey.getActions()));
		System.out.println(String.format("Max Actions = %s", grey.getMaxActions()));
		System.out.println(String.format("Uses an Action = %s", grey.attemptAction()));
		System.out.println(String.format("remaining Actions = %s", grey.getActions()));
		System.out.println(String.format("Uses and action Action = %s", grey.attemptAction()));
		System.out.println(String.format("Current Actions = %s", grey.getActions()));
		System.out.println(String.format("Fails to use an action = %s", grey.attemptAction()));
		System.out.println(String.format("Current Actions after failed attempt = %s", grey.getActions()));
		grey.resetActions();
		System.out.println(String.format("Actions after reset= %s", grey.getActions()));
		
		// REPAIR AND SEARCH VALUES
		System.out.println(String.format("Repair Value= %s", grey.getRepairValue()));
		System.out.println(String.format("SearchValue = %s", grey.getSearchValue()));
		
		
		// PLAGUE TESTS
		System.out.println(String.format("Has Plague to begin = %s", grey.getPlagueValue()));
		grey.addPlague();
		System.out.println(String.format("Has Plague when added = %s", grey.getPlagueValue()));
		grey.removePlague();
		System.out.println(String.format("Has Plague after removal = %s", grey.getPlagueValue()));
		
		System.out.println("Print toString");
		System.out.println(grey);
		
	}





	
}
