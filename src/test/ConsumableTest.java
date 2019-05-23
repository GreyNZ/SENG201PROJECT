package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import items.Consumable;
import items.FoodConsumable;
import items.HealingConsumeable;
import person.Gazer;
import person.Person;

class ConsumableTest {

	private Consumable cons;
	private HealingConsumeable Hcons;
	private FoodConsumable Fcons;
	
	
	@BeforeEach
	public void init() {
		cons = new Consumable("con", 1);
		Hcons = new HealingConsumeable("hcon", 10, 20);
		Fcons = new FoodConsumable("Fcon", 10, 20);
	}
	
	
	@Test
	public void nameTest() {
		String type1 = cons.getType();
	    assertEquals(Hcons.toString(), Hcons.toString());
	}
	
	@Test
	public void StringTest() {
		String type2 = Hcons.toLongString();
		String type3 = Fcons.toLongString();
	    assertEquals(Hcons.getType(), Hcons.getType());
	}
}
