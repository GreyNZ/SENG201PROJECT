package main;

public class Rockman extends Person{
	// example inputs (name, race, health, maxHealth, vigour, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	public Rockman(String tempName, int unqiue) {
		super(tempName, "Rockman", 200, 200, 200, 200, 0, 150, 1, 1, 0.5, 1.0, false, unqiue);
	}
	
	public void addPlague() {
		this.has_plague = false;
	}
	
	
	public static void main(String[] args) {
		Person rocky = new Rockman("Mr Granite", 3);
		System.out.println(rocky);

		// NAME TESTS
		System.out.println(String.format("Current Name = %s", rocky.getName()));
		System.out.println(String.format("Current Race = %s", rocky.getRace()));
		
		// HEALTH TESTS
		System.out.println(String.format("Current Health = %s", rocky.getHealth()));
		System.out.println(String.format("Max Health = %s", rocky.getMaxHealth()));
		rocky.decreaseHealth(50);
		System.out.println(String.format("Current Health minus 50 = %s", rocky.getHealth()));
		rocky.increaseHealth(25);
		System.out.println(String.format("Current Health increase 25 = %s", rocky.getHealth()));
		rocky.increaseHealth(9000);
		System.out.println(String.format("Current Health increase 9000 = %s", rocky.getHealth()));
		rocky.decreaseHealth(9000);
		System.out.println(String.format("Current Health minus 9000= %s", rocky.getHealth()));
		
		// HUNGER TESTS
		System.out.println(String.format("Current Hunger = %s", rocky.getHunger()));
		System.out.println(String.format("Max Hunger = %s", rocky.getMaxHunger()));
		rocky.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after a day passes = %s", rocky.getHunger()));
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		rocky.increaseHungerEndDay();
		System.out.println(String.format("Current Hunger after 10+ days= %s", rocky.getHunger()));
		rocky.eatFood(20);
		System.out.println(String.format("Hunger after a meal of 20 = %s", rocky.getHunger()));
		rocky.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", rocky.getHunger()));
		rocky.increaseHunger(50);
		System.out.println(String.format("Hunger increased by 50 = %s", rocky.getHunger()));
		rocky.increaseHunger(50);
		System.out.println(String.format("Hunger increased by another 50 = %s", rocky.getHunger()));
		rocky.increaseHunger(9000);
		System.out.println(String.format("Hunger increased by 9000 = %s", rocky.getHunger()));
		rocky.eatFood(9000);
		System.out.println(String.format("Hunger after a meal of 9000 = %s", rocky.getHunger()));
		
		// VIGOUR TESTS
		System.out.println(String.format("Current Vigour = %s", rocky.getVigour()));
		System.out.println(String.format("Max Vigour = %s", rocky.getMaxVigour()));
		rocky.decreaseVigourTravel();
		System.out.println(String.format("Vigour after day/travel end = %s", rocky.getVigour()));
		rocky.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", rocky.getVigour()));
		rocky.decreaseVigourTravel();
		rocky.decreaseVigourTravel();
		rocky.decreaseVigourTravel();
		rocky.decreaseVigourTravel();
		rocky.decreaseVigourTravel();
		rocky.decreaseVigourTravel();
		System.out.println(String.format("Vigour after 6 days/travels = %s", rocky.getVigour()));
		rocky.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", rocky.getVigour()));		
		rocky.personSleep();
		System.out.println(String.format("Vigour after a sleep a second time = %s", rocky.getVigour()));
		rocky.decreaseVigourAction(50);
		System.out.println(String.format("Vigour decreased by 50 = %s", rocky.getVigour()));
		rocky.decreaseVigourAction(20);
		System.out.println(String.format("Vigour decreased by 20 = %s", rocky.getVigour()));
		rocky.decreaseVigourAction(9000);
		System.out.println(String.format("Vigour decreased by 9000 = %s", rocky.getVigour()));
		rocky.personSleep();
		System.out.println(String.format("Vigour after a sleep = %s", rocky.getVigour()));
		
		
		// ACTIONS TESTS
		System.out.println(String.format("Current Actions = %s", rocky.getActions()));
		System.out.println(String.format("Max Actions = %s", rocky.getMaxActions()));
		System.out.println(String.format("Uses an Action = %s", rocky.attemptAction()));
		System.out.println(String.format("remaining Actions = %s", rocky.getActions()));
		System.out.println(String.format("Uses and action Action = %s", rocky.attemptAction()));
		System.out.println(String.format("Current Actions = %s", rocky.getActions()));
		System.out.println(String.format("Fails to use an action = %s", rocky.attemptAction()));
		System.out.println(String.format("Current Actions after failed attempt = %s", rocky.getActions()));
		rocky.resetActions();
		System.out.println(String.format("Actions after reset= %s", rocky.getActions()));
		
		// REPAIR AND SEARCH VALUES
		System.out.println(String.format("Repair Value= %s", rocky.getRepairValue()));
		System.out.println(String.format("SearchValue = %s", rocky.getSearchValue()));
		
		System.out.println(String.format("Has Plague to begin = %s", rocky.getPlagueValue()));
		rocky.addPlague();
		System.out.println(String.format("Has Plague when added = %s", rocky.getPlagueValue()));
//		rocky.removePlauge();
		System.out.println(String.format("Has Plague after removal = %s", rocky.getPlagueValue()));
		
		
	}
}
