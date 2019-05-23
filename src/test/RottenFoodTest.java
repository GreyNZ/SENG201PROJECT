package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import items.RottenFood;


class RottenFoodTest {
	
	@Test
	public void nameTest() {
		RottenFood item = new RottenFood();
		assertEquals((String)"RottenFood", (String)item.getName());
	}
	
	@Test
	public void healingTest() {
		RottenFood item = new RottenFood();
		assertEquals((int)2, (int)item.getHunger());
	}
	
	@Test
	public void valueTest() {
		RottenFood item = new RottenFood();
		assertEquals((int)5, (int)item.getValue());
	}
	

}
