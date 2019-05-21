package main;

/**
 * ConsumeItem
 * @author Cameron Bodger, Grey Harris
 *
 */
public class ConsumeItem {
	
	/**
	 * Item to be consumed
	 */
	Consumable item;
	/**
	 * Person to consume item
	 */
	Person person;
	
	/**
	 * ConsumeItem constructor. Calls consume() method
	 * @param item            Consumable item to be consumed
	 * @param person          Person to consume item
	 */ 
	public ConsumeItem(Consumable item, Person person) {
		this.item = item;
		this.person = person;
		consume();
		
	}

	/**
	 * Applies the effects of the item on the person consuming it
	 * @return string representation of the result of consumption
	 */
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
