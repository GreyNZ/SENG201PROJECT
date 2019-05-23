package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import items.SpaceSausage;


class SpaceSausageTest {
	
	@Test
	public void nameTest() {
		SpaceSausage item = new SpaceSausage();
		assertEquals((String)"SpaceSausage", (String)item.getName());
	}
	
	@Test
	public void healingTest() {
		SpaceSausage item = new SpaceSausage();
		assertEquals((int)20, (int)item.getHunger());
	}
	
	@Test
	public void valueTest() {
		SpaceSausage item = new SpaceSausage();
		assertEquals((int)30, (int)item.getValue());
	}
	

}
