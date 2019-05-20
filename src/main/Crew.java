package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;



/**
 * Builds and stores an ArrayList of Person types. Stores their ship, food, medical items and cash. 
 * @author cam, grey
 * 
 */
public class Crew {
	
	private ArrayList<Person> crewMemberArray;


	private int crewSize = 0;
	private Ship ship;
	private InitGame initGame;



	// constructor
	public Crew(InitGame initGame) {
		this.initGame = initGame;
		this.crewMemberArray = new ArrayList<Person>();
	}	
	
	/**
	 * 
	 * @param crewSize      integer defined from GameInit class between 2-4 that specifies 
	 *                      how many Person objects will be added to crewMemberArray.
	 *                      
	 * @param shipName      String defined from GameInit class, name of the ship
	 */
	public Crew(int crewSize, String shipName) {
		this.crewMemberArray = new ArrayList<Person>(crewSize);
		this.crewSize = crewSize;
		this.ship = new Ship(shipName);
		}


	/**
	 * Switch statement to create a Person object of specific race. 
	 * Uses int's from 1-6 as cases. 
	 * Defaults to Human to make invalid user input easier to deal with for command-line mode.
	 * @param name              String that holds crew member's name
	 * @param i                 Unique identifying int
	 * @param race           	String race to select
	 * @return                  Person object 
	 */
	public Person createCrewMember(String name, int i, String race) {
		switch (race) {
		case "Human":
			return new Human(name, i); 
		case "Rockman":
			return new Rockman(name, i);
		case "Grey":
			return new Grey(name, i);
		case "Bugman":
			return new Bugman(name, i);
		case "Gazer":
			return new Gazer(name, i);
		case "Warbot":
			return new Warbot(name, i);
		default:
			System.out.println("Invalid selection. Defaulting to human.");
			return new Human(name, i);
		}
		
	}
	
	public void buildDefaultCrew() {
		Person bruce = new Human("Bruce", 0);
		Person pancakes = new Warbot("Pancakes", 1);
		Person trevor = new Rockman("Trevor", 2);
		Person bob = new Grey("Bob", 3);
		this.crewSize = 4;
		this.crewMemberArray.add(bruce);
		this.crewMemberArray.add(pancakes);
		this.crewMemberArray.add(trevor);
		this.crewMemberArray.add(bob);
	}
	
	
	public void addCrewMember(String name, String race) {
	Person newMember = createCrewMember(name, this.crewSize, race);
	this.crewSize += 1;
	this.crewMemberArray.add(newMember);
}
	
	public String getMemberName(int i) {
		return this.crewMemberArray.get(i).getName();
	}
	
	public Person getMember(String name) {
		for (Person person : this.crewMemberArray) {
			if (person.getName() == name) {
				return person;	
				}
		}
		return this.crewMemberArray.get(0);	
	}	
	
	public Ship getShip() {
		return this.ship;
	}
	public ArrayList<Person> getCrewMemberArray() {
		return this.crewMemberArray;
	}
	public Integer getCrewSize() {
		return this.crewSize;
	}
	// testing removing dead person from array
	public void sendDeath(Person person) {
		if (!person.alreadLabelledDead()) {
			String s = person.getName() +" has died!";
			person.setLabelledDead();
			this.initGame.getMainScreen().printToLog(s);
			this.initGame.getMainScreen().buildCrewMemberCombos();
		}
	}
	
	// for when the pirates gank you with no item
	public void beatUpCrew() {
		for (Person person : crewMemberArray) {
			boolean death = person.decreaseHealth(40);
			if (death) {
				sendDeath(person);
			}
		}
		
	}

	public String endDayActions() {
		String s = "";
		for (Person person: crewMemberArray) {
			s += person.endDayChanges();
		}
		return s;
	}

	public int crewPoints() {
		int points = 0;
		for (Person person : crewMemberArray) {
			points += person.getHealth();
			if (person.getPlagueValue()) {
				points -= 50;
			}
		}
		return points;
	}
	
	// for new game screen, can quick start after already selecting members
	public void destroyCrew() {
		if (crewSize > 0) {
			crewMemberArray = new ArrayList<Person>();
		}
		
	}
	
}

