package main;

public class Human extends Person {

	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	public Human(String tempName, int unqiue) {
		super(tempName, "Human", 100, 100, 100, 100, 0, 100, 2, 2, 1.0, 1.0, false, unqiue);
	}
	
	public static void main(String[] args) {
		Person kirk = new Human("Captain Kirk", 2);
		System.out.println(kirk);

		// NAME TESTS
		System.out.println(String.format("Current Name = %s", kirk.getName()));
		System.out.println(String.format("Current Race = %s", kirk.getRace()));
		
		// HEALTH TESTS
		System.out.println(String.format("Current Health = %s", kirk.getHealth()));
		System.out.println(String.format("Max Health = %s", kirk.getMaxHealth()));
		kirk.decreaseHealth(50);
		System.out.println(String.format("Current Health minus 50 = %s", kirk.getHealth()));
		kirk.increaseHealth(25);
		System.out.println(String.format("Current Health increase 25 = %s", kirk.getHealth()));
		kirk.increaseHealth(9000);
		System.out.println(String.format("Current Health increase 9000 = %s", kirk.getHealth()));
		kirk.decreaseHealth(9000);
		System.out.println(String.format("Current Health minus 9000= %s", kirk.getHealth()));
		
		// HUNGER TESTS
		System.out.println(String.format("Current Hunger = %s", kirk.getHunger()));
		System.out.println(String.format("Max Hunger = %s", kirk.getMaxHunger()));
		kirk.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after a day passes = %s", kirk.getHunger()));
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		kirk.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after 10+ days= %s", kirk.getHunger()));
		kirk.eatFood(20);
		System.out.println(String.format("Hunger after a meal of 20 = %s", kirk.getHunger()));
		kirk.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", kirk.getHunger()));
		kirk.increaseHunger(50);
		System.out.println(String.format("Hunger increased by 50 = %s", kirk.getHunger()));
		kirk.increaseHunger(50);
		System.out.println(String.format("Hunger increased by another 50 = %s", kirk.getHunger()));
		kirk.increaseHunger(9000);
		System.out.println(String.format("Hunger increased by 9000 = %s", kirk.getHunger()));
		kirk.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", kirk.getHunger()));
		
		// VIGOUR TESTS
		System.out.println(String.format("Current Vigour = %s", kirk.getVigour()));
		System.out.println(String.format("Max Vigour = %s", kirk.getMaxVigour()));
		kirk.decreaseVigourTravel();
		System.out.println(String.format("Vigour after day/travel end = %s", kirk.getVigour()));
		kirk.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", kirk.getVigour()));
		kirk.decreaseVigourTravel();
		kirk.decreaseVigourTravel();
		kirk.decreaseVigourTravel();
		kirk.decreaseVigourTravel();
		kirk.decreaseVigourTravel();
		kirk.decreaseVigourTravel();
		System.out.println(String.format("Vigour after 6 days/travels = %s", kirk.getVigour()));
		kirk.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", kirk.getVigour()));		
		kirk.personSleep();
		System.out.println(String.format("Vigour after a sleep a second time = %s", kirk.getVigour()));
		kirk.decreaseVigourAction(50);
		System.out.println(String.format("Vigour decreased by 50 = %s", kirk.getVigour()));
		kirk.decreaseVigourAction(20);
		System.out.println(String.format("Vigour decreased by 20 = %s", kirk.getVigour()));
		kirk.decreaseVigourAction(9000);
		System.out.println(String.format("Vigour decreased by 9000 = %s", kirk.getVigour()));
		kirk.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", kirk.getVigour()));
		
		
		// ACTIONS TESTS
		System.out.println(String.format("Current Actions = %s", kirk.getActions()));
		System.out.println(String.format("Max Actions = %s", kirk.getMaxActions()));
		System.out.println(String.format("Uses an Action = %s", kirk.attemptAction()));
		System.out.println(String.format("remaining Actions = %s", kirk.getActions()));
		System.out.println(String.format("Uses and action Action = %s", kirk.attemptAction()));
		System.out.println(String.format("Current Actions = %s", kirk.getActions()));
		System.out.println(String.format("Fails to use an action = %s", kirk.attemptAction()));
		System.out.println(String.format("Current Actions after failed attempt = %s", kirk.getActions()));
		kirk.resetActions();
		System.out.println(String.format("Actions after reset= %s", kirk.getActions()));
		
		// REPAIR AND SEARCH VALUES
		System.out.println(String.format("Repair Value= %s", kirk.getRepairValue()));
		System.out.println(String.format("SearchValue = %s", kirk.getSearchValue()));
		
		
	}
}
