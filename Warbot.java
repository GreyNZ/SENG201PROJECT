package main;

public class Warbot extends Person {
	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	public Warbot(String tempName, int unqiue) {
		super(tempName, "Warbot", 150, 150, 100, 100, 0, 100, 2, 2, 0.5, 0.25, false, unqiue);
	}
	
	public void addPlague() {
		this.has_plague = false;
	}
	
	public static void main(String[] args) {
		Person terminator = new Warbot("T-800", 6);
		System.out.println(terminator);

		// NAME TESTS
		System.out.println(String.format("Current Name = %s", terminator.getName()));
		System.out.println(String.format("Current Race = %s", terminator.getRace()));
		
		// HEALTH TESTS
		System.out.println(String.format("Current Health = %s", terminator.getHealth()));
		System.out.println(String.format("Max Health = %s", terminator.getMaxHealth()));
		terminator.decreaseHealth(50);
		System.out.println(String.format("Current Health minus 50 = %s", terminator.getHealth()));
		terminator.increaseHealth(25);
		System.out.println(String.format("Current Health increase 25 = %s", terminator.getHealth()));
		terminator.increaseHealth(9000);
		System.out.println(String.format("Current Health increase 9000 = %s", terminator.getHealth()));
		terminator.decreaseHealth(9000);
		System.out.println(String.format("Current Health minus 9000= %s", terminator.getHealth()));
		
		// HUNGER TESTS
		System.out.println(String.format("Current Hunger = %s", terminator.getHunger()));
		System.out.println(String.format("Max Hunger = %s", terminator.getMaxHunger()));
		terminator.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after a day passes = %s", terminator.getHunger()));
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		terminator.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after 10+ days= %s", terminator.getHunger()));
		terminator.eatFood(20);
		System.out.println(String.format("Hunger after a meal of 20 = %s", terminator.getHunger()));
		terminator.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", terminator.getHunger()));
		terminator.increaseHunger(50);
		System.out.println(String.format("Hunger increased by 50 = %s", terminator.getHunger()));
		terminator.increaseHunger(50);
		System.out.println(String.format("Hunger increased by another 50 = %s", terminator.getHunger()));
		terminator.increaseHunger(9000);
		System.out.println(String.format("Hunger increased by 9000 = %s", terminator.getHunger()));
		terminator.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", terminator.getHunger()));
		
		// VIGOUR TESTS
		System.out.println(String.format("Current Vigour = %s", terminator.getVigour()));
		System.out.println(String.format("Max Vigour = %s", terminator.getMaxVigour()));
		terminator.decreaseVigourTravel();
		System.out.println(String.format("Vigour after day/travel end = %s", terminator.getVigour()));
		terminator.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", terminator.getVigour()));
		terminator.decreaseVigourTravel();
		terminator.decreaseVigourTravel();
		terminator.decreaseVigourTravel();
		terminator.decreaseVigourTravel();
		terminator.decreaseVigourTravel();
		terminator.decreaseVigourTravel();
		System.out.println(String.format("Vigour after 6 days/travels = %s", terminator.getVigour()));
		terminator.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", terminator.getVigour()));		
		terminator.personSleep();
		System.out.println(String.format("Vigour after a sleep a second time = %s", terminator.getVigour()));
		terminator.decreaseVigourAction(50);
		System.out.println(String.format("Vigour decreased by 50 = %s", terminator.getVigour()));
		terminator.decreaseVigourAction(20);
		System.out.println(String.format("Vigour decreased by 20 = %s", terminator.getVigour()));
		terminator.decreaseVigourAction(9000);
		System.out.println(String.format("Vigour decreased by 9000 = %s", terminator.getVigour()));
		terminator.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", terminator.getVigour()));
		
		
		// ACTIONS TESTS
		System.out.println(String.format("Current Actions = %s", terminator.getActions()));
		System.out.println(String.format("Max Actions = %s", terminator.getMaxActions()));
		System.out.println(String.format("Uses an Action = %s", terminator.attemptAction()));
		System.out.println(String.format("remaining Actions = %s", terminator.getActions()));
		System.out.println(String.format("Uses and action Action = %s", terminator.attemptAction()));
		System.out.println(String.format("Current Actions = %s", terminator.getActions()));
		System.out.println(String.format("Fails to use an action = %s", terminator.attemptAction()));
		System.out.println(String.format("Current Actions after failed attempt = %s", terminator.getActions()));
		terminator.resetActions();
		System.out.println(String.format("Actions after reset= %s", terminator.getActions()));
		
		// REPAIR AND SEARCH VALUES
		System.out.println(String.format("Repair Value= %s", terminator.getRepairValue()));
		System.out.println(String.format("SearchValue = %s", terminator.getSearchValue()));		
		
		System.out.println(String.format("Has Plague to begin = %s", terminator.getPlagueValue()));
		terminator.addPlague();
		System.out.println(String.format("Has Plague when added = %s", terminator.getPlagueValue()));
		terminator.removePlauge();
		System.out.println(String.format("Has Plague after removal = %s", terminator.getPlagueValue()));		
		
	}
}
