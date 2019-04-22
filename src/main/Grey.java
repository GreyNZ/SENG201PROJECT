package main;

public class Grey extends Person {
	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	public Grey(String tempName, int unqiue) {
		super(tempName, "Grey", 50, 50, 100, 100, 0, 100, 2, 2, 2.0, 1.5, false, unqiue);
	}
	
	public static void main(String[] args) {
		Person greyzilla = new Grey("Bighead of Woswell", 4);
		System.out.println(greyzilla);
		
		// NAME TESTS
		System.out.println(String.format("Current Name = %s", greyzilla.getName()));
		System.out.println(String.format("Current Race = %s", greyzilla.getRace()));
		
		// HEALTH TESTS
		System.out.println(String.format("Current Health = %s", greyzilla.getHealth()));
		System.out.println(String.format("Max Health = %s", greyzilla.getMaxHealth()));
		greyzilla.decreaseHealth(50);
		System.out.println(String.format("Current Health minus 50 = %s", greyzilla.getHealth()));
		greyzilla.increaseHealth(25);
		System.out.println(String.format("Current Health increase 25 = %s", greyzilla.getHealth()));
		greyzilla.increaseHealth(9000);
		System.out.println(String.format("Current Health increase 9000 = %s", greyzilla.getHealth()));
		greyzilla.decreaseHealth(9000);
		System.out.println(String.format("Current Health minus 9000= %s", greyzilla.getHealth()));
		
		// HUNGER TESTS
		System.out.println(String.format("Current Hunger = %s", greyzilla.getHunger()));
		System.out.println(String.format("Max Hunger = %s", greyzilla.getMaxHunger()));
		greyzilla.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after a day passes = %s", greyzilla.getHunger()));
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		greyzilla.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after 10+ days= %s", greyzilla.getHunger()));
		greyzilla.eatFood(20);
		System.out.println(String.format("Hunger after a meal of 20 = %s", greyzilla.getHunger()));
		greyzilla.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", greyzilla.getHunger()));
		greyzilla.increaseHunger(50);
		System.out.println(String.format("Hunger increased by 50 = %s", greyzilla.getHunger()));
		greyzilla.increaseHunger(50);
		System.out.println(String.format("Hunger increased by another 50 = %s", greyzilla.getHunger()));
		greyzilla.increaseHunger(9000);
		System.out.println(String.format("Hunger increased by 9000 = %s", greyzilla.getHunger()));
		greyzilla.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", greyzilla.getHunger()));
		
		// VIGOUR TESTS
		System.out.println(String.format("Current Vigour = %s", greyzilla.getVigour()));
		System.out.println(String.format("Max Vigour = %s", greyzilla.getMaxVigour()));
		greyzilla.decreaseVigourTravel();
		System.out.println(String.format("Vigour after day/travel end = %s", greyzilla.getVigour()));
		greyzilla.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", greyzilla.getVigour()));
		greyzilla.decreaseVigourTravel();
		greyzilla.decreaseVigourTravel();
		greyzilla.decreaseVigourTravel();
		greyzilla.decreaseVigourTravel();
		greyzilla.decreaseVigourTravel();
		greyzilla.decreaseVigourTravel();
		System.out.println(String.format("Vigour after 6 days/travels = %s", greyzilla.getVigour()));
		greyzilla.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", greyzilla.getVigour()));		
		greyzilla.personSleep();
		System.out.println(String.format("Vigour after a sleep a second time = %s", greyzilla.getVigour()));
		greyzilla.decreaseVigourAction(50);
		System.out.println(String.format("Vigour decreased by 50 = %s", greyzilla.getVigour()));
		greyzilla.decreaseVigourAction(20);
		System.out.println(String.format("Vigour decreased by 20 = %s", greyzilla.getVigour()));
		greyzilla.decreaseVigourAction(9000);
		System.out.println(String.format("Vigour decreased by 9000 = %s", greyzilla.getVigour()));
		greyzilla.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", greyzilla.getVigour()));
		
		
		// ACTIONS TESTS
		System.out.println(String.format("Current Actions = %s", greyzilla.getActions()));
		System.out.println(String.format("Max Actions = %s", greyzilla.getMaxActions()));
		System.out.println(String.format("Uses an Action = %s", greyzilla.attemptAction()));
		System.out.println(String.format("remaining Actions = %s", greyzilla.getActions()));
		System.out.println(String.format("Uses and action Action = %s", greyzilla.attemptAction()));
		System.out.println(String.format("Current Actions = %s", greyzilla.getActions()));
		System.out.println(String.format("Fails to use an action = %s", greyzilla.attemptAction()));
		System.out.println(String.format("Current Actions after failed attempt = %s", greyzilla.getActions()));
		greyzilla.resetActions();
		System.out.println(String.format("Actions after reset= %s", greyzilla.getActions()));
		
		// REPAIR AND SEARCH VALUES
		System.out.println(String.format("Repair Value= %s", greyzilla.getRepairValue()));
		System.out.println(String.format("SearchValue = %s", greyzilla.getSearchValue()));		
		
	}

}
