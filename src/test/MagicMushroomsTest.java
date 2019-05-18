package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;


import main.MagicMushrooms;


class MagicMushroomsTest {
	
	@Test
	public void nameTest() {
		MagicMushrooms item = new MagicMushrooms();
		assertEquals((String)"MagicMushrooms", (String)item.getName());
	}
	
	@Test
	public void healingTest() {
		MagicMushrooms item = new MagicMushrooms();
		assertEquals((int)200, (int)item.getHunger());
	}
	
	@Test
	public void valueTest() {
		MagicMushrooms item = new MagicMushrooms();
		assertEquals((int)200, (int)item.getValue());
	}
	

}
