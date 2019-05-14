package main;


public class Person {
	
	protected Integer uniqueIdentifier;
	protected String person_name;
	protected String person_race;
	protected Integer person_health;
	protected Integer person_max_health;
	protected Integer person_vigour;
	protected Integer person_max_vigour;
	protected Integer person_hunger;
	protected Integer person_max_hunger;
	protected Integer person_max_actions;
	protected Integer person_actions_remaining;
	protected Double person_repair_value;
	protected Double person_search_value;
	protected Boolean has_plague;
	private boolean hasDied;
	
	public Person() {
		person_name = "unnamed crewmember";
		person_race = "unnamed race";
		person_health = 100;
		person_max_health = 100;
		person_vigour = 100;
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
		person_name = name;
		person_race = race;
		person_health = health;
		person_max_health = maxHealth;
		person_vigour = vigour;
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
	
	public String toLongString() {
		return String.format("\nName = %s\nRace = %s\nHealth = %s\nVigour = %s\nHunger = %s\nActions = %s\nHas Plague = %s\n", this.getName(), this.getRace(), this.getHealth(), this.getVigour(), this.getHunger(), this.getActions(), this.getPlagueValue());
	}
	public String toString() {
		return this.person_name;
	}
	
	public String getPersonStatus() {
		String initialString = "";
		initialString += person_name;
		/// more to come
		return initialString;
	}
	
	public int getUnique() {
		return uniqueIdentifier;
	}
	
	public String getName() {
		return person_name;
	}
	
	public String getRace() {
		return person_race;
	}
	
	public Integer getHealth() {
		return person_health;
	}
	
	public Integer getMaxHealth() {
		return person_max_health;
	}
	
	public Integer getVigour() {
		return person_vigour;
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
		this.has_plague = true;
	}
	
	public void removePlauge() {
		this.has_plague = false;			
	}
	
	public void increaseHealth(int increase) {
		int currentHealth = this.person_health;
		int maxHealth = this.getMaxHealth();
		currentHealth += increase;
		if (currentHealth >= maxHealth) {
			this.person_health = maxHealth;
		} 
		else {
			this.person_health = currentHealth;
		}
	}
	
	public void decreaseHealth(int decrease) {
		int minimumHealth = 0;
		int currentHealth = this.person_health;
		currentHealth -= decrease;
		if (currentHealth > minimumHealth) {
			this.person_health = currentHealth;
		}
		else {
			this.person_health = 0;
			this.isDead();
			System.out.println("Character has died, add death function to remove from crew");
			/// call death function, remove from crew
		}
		
	}
	
	private boolean isDead() {
		return this.hasDied;
		
	}

	public void personSleep() {
		this.person_vigour = this.person_max_vigour;
	}
	
	public void decreaseVigourAction(int decrease) { /// if enough vigour reduces vigor and returns true, if vigor to low returns false
		int currentVigour = this.person_vigour;
		currentVigour -= decrease;
		if (currentVigour >= 0) {
			this.person_vigour = currentVigour;
		}
		else {
			this.person_vigour = 0;
		}
		
	}
	
	public void decreaseVigourTravel() {
		int decrease = 20;
		int currentVigour = this.person_vigour;
		currentVigour -= decrease;
		if (currentVigour >= 0) {
			this.person_vigour = currentVigour;
		}
		else {
			this.person_vigour = 0;
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
		this.person_actions_remaining = this.person_max_actions;
	}
	
	public boolean attemptAction() {      /// attempts an action if there is actions remaining reduces by 1 and returns true, if not returns false
		int currentActions = this.person_actions_remaining;
		currentActions -= 1;
		if (currentActions >= 0) {
			this.person_actions_remaining = currentActions;
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public String plagueSickness() {
		String s = "";
		if (has_plague) {
			Integer plagued = 30;
			decreaseHealth(plagued);
			s += this.person_name + " lost " + plagued + " health from the plague";
		}
		return s;
	}
	
	public String endDayChanges() {
		increaseHungerEndDay();
		String s = plagueSickness();
		return s;

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
		grey.removePlauge();
		System.out.println(String.format("Has Plague after removal = %s", grey.getPlagueValue()));
		
		System.out.println("Print toString");
		System.out.println(grey);
		
	}
	
}
