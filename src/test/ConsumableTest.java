package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import items.Consumable;
import items.FoodConsumable;
import items.HealingConsumeable;

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
	    assertNotEquals(cons.getType(), Hcons.toString());
	}
	
	@Test
	public void StringTest() {
	    assertNotEquals(Fcons.toLongString(), Hcons.getType());
	}
	@Test
	public void StringTest2() {
	    assertNotEquals(Fcons.toLongString(), Hcons.toLongString());
	}
}
