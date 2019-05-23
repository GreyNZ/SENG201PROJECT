package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import items.SpaceCandy;


class SpaceCandyTest {
	
	@Test
	public void nameTest() {
		SpaceCandy item = new SpaceCandy();
		assertEquals((String)"SpaceCandy", (String)item.getName());
	}
	
	@Test
	public void healingTest() {
		SpaceCandy item = new SpaceCandy();
		assertEquals((int)10, (int)item.getHunger());
	}
	
	@Test
	public void valueTest() {
		SpaceCandy item = new SpaceCandy();
		assertEquals((int)50, (int)item.getValue());
	}
	

}
