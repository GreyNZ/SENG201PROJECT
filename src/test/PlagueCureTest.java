package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;


import main.PlagueCure;


class PlagueCureTest {
	
	@Test
	public void nameTest() {
		PlagueCure item = new PlagueCure();
		assertEquals((String)"PlagueCure", (String)item.getName());
	}
	
	@Test
	public void plagueTest() {
		PlagueCure item = new PlagueCure();
		assertTrue(item.getCurePlague());
	}
	
	@Test
	public void valueTest() {
		PlagueCure item = new PlagueCure();
		assertEquals((int)100, (int)item.getValue());
	}
	
	@Test
	public void healingTest() {
		PlagueCure item = new PlagueCure();
		assertEquals((int)0, (int)item.getHealing());
	}
	
	@Test
	public void namingTest() {
		PlagueCure item = new PlagueCure();
		assertEquals((String)"PlagueCure", (String)item.toString());
	}
	@Test
	public void toLongStringTest() {
		PlagueCure item = new PlagueCure();
		assertEquals((String)item.toLongString(), (String)item.toLongString());
	}
	


}
