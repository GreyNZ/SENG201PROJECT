package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import person.Human;
import person.Person;

class PersonTest {

	private Person people;
	
	@BeforeEach
	public void init() {
		people = new Person();
	}
	
	@Test
	public void toLongStringTest() {
	    assertEquals(people.getName(), people.getName());
	}
	
	@Test
	public void toStringTest() {
		System.out.println(people.getPersonStatus());
	    assertEquals("unnamed crewmember", people.toString());
	}
	
	
	
	@Test
	public void getUniqueTest() {
	    assertEquals(9000, people.getUnique());
	}
	
	
	
	@Test
	public void isDeadTest() {
		Integer vigour = people.getMaxVigour();
	    assertEquals(false, people.isDead());
	}
	
	
	@Test
	public void alreadLabelledDeadTest() {
		people.increaseHunger(10);
		people.increaseHunger(9000);
		people.increaseHunger(-110);
	    assertEquals(false, people.alreadLabelledDead());
	}
	
	
	@Test
	public void increaseHungerTest() {
		people.increaseHunger(10);
	    assertEquals(people.getHunger(), people.getHunger());
	}
	
	
	
	@Test
	public void failedActionTest() {
	    assertEquals("Not enough actions", people.failedAction());
	}
	
	
	@Test
	public void plagueSicknessTest() {
		System.out.println(people.plagueSickness());
		System.out.println(people.endDayChanges());
		System.out.println(people.toLongString());
	    assertEquals(people.plagueSickness(), people.plagueSickness());
	}
	
	
	
	@Test
	public void setLabelledDeadTest() {
		people.setLabelledDead();
	    assertEquals(true, people.alreadLabelledDead());
	}
	

	
}
