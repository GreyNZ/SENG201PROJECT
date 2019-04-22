package main;

public class Bugman extends Person {
	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	public Bugman(String tempName, int unqiue) {
		super(tempName, "Bugman", 100, 100, 20, 20, 0, 200, 2, 2, 0.75, 0.5, false, unqiue);
	}
	
	public static void main(String[] args) {
		Person mantis = new Bugman("Buggie", 5);
		System.out.println(mantis);

		// NAME TESTS
		System.out.println(String.format("Current Name = %s", mantis.getName()));
		System.out.println(String.format("Current Race = %s", mantis.getRace()));
		
		// HEALTH TESTS
		System.out.println(String.format("Current Health = %s", mantis.getHealth()));
		System.out.println(String.format("Max Health = %s", mantis.getMaxHealth()));
		mantis.decreaseHealth(50);
		System.out.println(String.format("Current Health minus 50 = %s", mantis.getHealth()));
		mantis.increaseHealth(25);
		System.out.println(String.format("Current Health increase 25 = %s", mantis.getHealth()));
		mantis.increaseHealth(9000);
		System.out.println(String.format("Current Health increase 9000 = %s", mantis.getHealth()));
		mantis.decreaseHealth(9000);
		System.out.println(String.format("Current Health minus 9000= %s", mantis.getHealth()));
		
		// HUNGER TESTS
		System.out.println(String.format("Current Hunger = %s", mantis.getHunger()));
		System.out.println(String.format("Max Hunger = %s", mantis.getMaxHunger()));
		mantis.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after a day passes = %s", mantis.getHunger()));
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		mantis.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after 10+ days= %s", mantis.getHunger()));
		mantis.eatFood(20);
		System.out.println(String.format("Hunger after a meal of 20 = %s", mantis.getHunger()));
		mantis.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", mantis.getHunger()));
		mantis.increaseHunger(50);
		System.out.println(String.format("Hunger increased by 50 = %s", mantis.getHunger()));
		mantis.increaseHunger(50);
		System.out.println(String.format("Hunger increased by another 50 = %s", mantis.getHunger()));
		mantis.increaseHunger(9000);
		System.out.println(String.format("Hunger increased by 9000 = %s", mantis.getHunger()));
		mantis.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", mantis.getHunger()));
		
		// VIGOUR TESTS
		System.out.println(String.format("Current Vigour = %s", mantis.getVigour()));
		System.out.println(String.format("Max Vigour = %s", mantis.getMaxVigour()));
		mantis.decreaseVigourTravel();
		System.out.println(String.format("Vigour after day/travel end = %s", mantis.getVigour()));
		mantis.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", mantis.getVigour()));
		mantis.decreaseVigourTravel();
		mantis.decreaseVigourTravel();
		mantis.decreaseVigourTravel();
		mantis.decreaseVigourTravel();
		mantis.decreaseVigourTravel();
		mantis.decreaseVigourTravel();
		System.out.println(String.format("Vigour after 6 days/travels = %s", mantis.getVigour()));
		mantis.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", mantis.getVigour()));		
		mantis.personSleep();
		System.out.println(String.format("Vigour after a sleep a second time = %s", mantis.getVigour()));
		mantis.decreaseVigourAction(50);
		System.out.println(String.format("Vigour decreased by 50 = %s", mantis.getVigour()));
		mantis.decreaseVigourAction(20);
		System.out.println(String.format("Vigour decreased by 20 = %s", mantis.getVigour()));
		mantis.decreaseVigourAction(9000);
		System.out.println(String.format("Vigour decreased by 9000 = %s", mantis.getVigour()));
		mantis.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", mantis.getVigour()));
		
		
		// ACTIONS TESTS
		System.out.println(String.format("Current Actions = %s", mantis.getActions()));
		System.out.println(String.format("Max Actions = %s", mantis.getMaxActions()));
		System.out.println(String.format("Uses an Action = %s", mantis.attemptAction()));
		System.out.println(String.format("remaining Actions = %s", mantis.getActions()));
		System.out.println(String.format("Uses and action Action = %s", mantis.attemptAction()));
		System.out.println(String.format("Current Actions = %s", mantis.getActions()));
		System.out.println(String.format("Fails to use an action = %s", mantis.attemptAction()));
		System.out.println(String.format("Current Actions after failed attempt = %s", mantis.getActions()));
		mantis.resetActions();
		System.out.println(String.format("Actions after reset= %s", mantis.getActions()));
		
		// REPAIR AND SEARCH VALUES
		System.out.println(String.format("Repair Value= %s", mantis.getRepairValue()));
		System.out.println(String.format("SearchValue = %s", mantis.getSearchValue()));
	}
}
