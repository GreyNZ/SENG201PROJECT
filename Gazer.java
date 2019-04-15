package main;

public class Gazer extends Person {

	public Gazer(String tempName, int unqiue) {
		super(tempName, "Gazer", 100, 100, 100, 100, 0, 100, 1, 1, 1.0, 4.0, false, unqiue);
	}
	
	public static void main(String[] args) {
		Person gazzie = new Gazer("Gazzy the Gazer", 1);
		System.out.println(gazzie);

		
		// NAME TESTS
		System.out.println(String.format("Current Name = %s", gazzie.getName()));
		System.out.println(String.format("Current Race = %s", gazzie.getRace()));
		
		// HEALTH TESTS
		System.out.println(String.format("Current Health = %s", gazzie.getHealth()));
		System.out.println(String.format("Max Health = %s", gazzie.getMaxHealth()));
		gazzie.decreaseHealth(50);
		System.out.println(String.format("Current Health minus 50 = %s", gazzie.getHealth()));
		gazzie.increaseHealth(25);
		System.out.println(String.format("Current Health increase 25 = %s", gazzie.getHealth()));
		gazzie.increaseHealth(9000);
		System.out.println(String.format("Current Health increase 9000 = %s", gazzie.getHealth()));
		gazzie.decreaseHealth(9000);
		System.out.println(String.format("Current Health minus 9000= %s", gazzie.getHealth()));
		
		// HUNGER TESTS
		System.out.println(String.format("Current Hunger = %s", gazzie.getHunger()));
		System.out.println(String.format("Max Hunger = %s", gazzie.getMaxHunger()));
		gazzie.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after a day passes = %s", gazzie.getHunger()));
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		gazzie.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after 10+ days= %s", gazzie.getHunger()));
		gazzie.eatFood(20);
		System.out.println(String.format("Hunger after a meal of 20 = %s", gazzie.getHunger()));
		gazzie.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", gazzie.getHunger()));
		gazzie.increaseHunger(50);
		System.out.println(String.format("Hunger increased by 50 = %s", gazzie.getHunger()));
		gazzie.increaseHunger(50);
		System.out.println(String.format("Hunger increased by another 50 = %s", gazzie.getHunger()));
		gazzie.increaseHunger(9000);
		System.out.println(String.format("Hunger increased by 9000 = %s", gazzie.getHunger()));
		gazzie.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", gazzie.getHunger()));
		
		// VIGOUR TESTS
		System.out.println(String.format("Current Vigour = %s", gazzie.getVigour()));
		System.out.println(String.format("Max Vigour = %s", gazzie.getMaxVigour()));
		gazzie.decreaseVigourTravel();
		System.out.println(String.format("Vigour after day/travel end = %s", gazzie.getVigour()));
		gazzie.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", gazzie.getVigour()));
		gazzie.decreaseVigourTravel();
		gazzie.decreaseVigourTravel();
		gazzie.decreaseVigourTravel();
		gazzie.decreaseVigourTravel();
		gazzie.decreaseVigourTravel();
		gazzie.decreaseVigourTravel();
		System.out.println(String.format("Vigour after 6 days/travels = %s", gazzie.getVigour()));
		gazzie.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", gazzie.getVigour()));		
		gazzie.personSleep();
		System.out.println(String.format("Vigour after a sleep a second time = %s", gazzie.getVigour()));
		gazzie.decreaseVigourAction(50);
		System.out.println(String.format("Vigour decreased by 50 = %s", gazzie.getVigour()));
		gazzie.decreaseVigourAction(20);
		System.out.println(String.format("Vigour decreased by 20 = %s", gazzie.getVigour()));
		gazzie.decreaseVigourAction(9000);
		System.out.println(String.format("Vigour decreased by 9000 = %s", gazzie.getVigour()));
		gazzie.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", gazzie.getVigour()));
		
		
		// ACTIONS TESTS
		System.out.println(String.format("Current Actions = %s", gazzie.getActions()));
		System.out.println(String.format("Max Actions = %s", gazzie.getMaxActions()));
		System.out.println(String.format("Uses an Action = %s", gazzie.attemptAction()));
		System.out.println(String.format("remaining Actions = %s", gazzie.getActions()));
		System.out.println(String.format("Uses and action Action = %s", gazzie.attemptAction()));
		System.out.println(String.format("Current Actions = %s", gazzie.getActions()));
		System.out.println(String.format("Fails to use an action = %s", gazzie.attemptAction()));
		System.out.println(String.format("Current Actions after failed attempt = %s", gazzie.getActions()));
		gazzie.resetActions();
		System.out.println(String.format("Actions after reset= %s", gazzie.getActions()));
		
		// REPAIR AND SEARCH VALUES
		System.out.println(String.format("Repair Value= %s", gazzie.getRepairValue()));
		System.out.println(String.format("SearchValue = %s", gazzie.getSearchValue()));
		
		
	}
	
}


// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague