package main;

public class ConsumeItem {
	
	Consumable item;
	Person person;
	
	public ConsumeItem(Consumable item, Person person) {
		this.item = item;
		this.person = person;
		consume();
		
	}

	public String consume() {
		String consumeResult = "";
		if (item.getName() == "PlagueCure"){
			person.removePlague();
			consumeResult = person.getName() + " is cured of the plague";
		}
		else {
			if (item.getType() == "food") {
				person.eatFood(item.getHunger());
				consumeResult = person.getName() + " ate one " + item.getName() + "\nTasty";
			}
			else {
				person.increaseHealth(item.getHealing());
				consumeResult = person.getName() + " is healed for " + item.getHealing();
			}
		}
	
		return consumeResult;
	}

}
