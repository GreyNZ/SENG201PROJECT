package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import items.SpaceRoast;


class SpaceRoastTest {
	
	@Test
	public void nameTest() {
		SpaceRoast item = new SpaceRoast();
		assertEquals((String)"SpaceRoast", (String)item.getName());
	}
	
	@Test
	public void healingTest() {
		SpaceRoast item = new SpaceRoast();
		assertEquals((int)100, (int)item.getHunger());
	}
	
	@Test
	public void valueTest() {
		SpaceRoast item = new SpaceRoast();
		assertEquals((int)130, (int)item.getValue());
	}
	

}
