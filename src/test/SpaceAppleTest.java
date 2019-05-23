package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import items.SpaceApple;


class SpaceAppleTest {
	
	@Test
	public void nameTest() {
		SpaceApple item = new SpaceApple();
		assertEquals((String)"SpaceApple", (String)item.getName());
	}
	
	@Test
	public void healingTest() {
		SpaceApple item = new SpaceApple();
		assertEquals((int)25, (int)item.getHunger());
	}
	
	@Test
	public void valueTest() {
		SpaceApple item = new SpaceApple();
		assertEquals((int)75, (int)item.getValue());
	}
	

}
