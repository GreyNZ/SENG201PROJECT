package main;

import java.util.ArrayList;

import person.Bugman;
import person.Gazer;
import person.Grey;
import person.Human;
import person.Person;
import person.Rockman;
import person.Warbot;



/**
 * Builds and stores an ArrayList of Person types. Stores their ship, food, medical items and cash. 
 * @author cam, grey
 * 
 */
public class Crew {
	
	/**
	 * Stores the Person objects in an ArrayList
	 */
	private ArrayList<Person> crewMemberArray;

	
	/**
	 * The number of crew members on board
	 */
	private int crewSize = 0;
	/**
	 * The ship object
	 */
	private Ship ship;
	/**
	 * The game environment
	 */
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
			//Should never happen
			return new Human(name, i);
		}
		
	}
	
	/**
	 * Adds the default crew to the crew member array. Used for quick start
	 */
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
	
	
	/**
	 * Adds new {@code Person} object to the crew member array.
	 * Takes name and race as input and creates a new Person object by calling
	 *  {@code Crew.addCrewMember}, increments crew size then adds the person to the crew member arraylist 
	 * 
	 * @param name	 String name of the new crew member
	 * @param race   String race of the new crew member
	 */
	public void addCrewMember(String name, String race) {
		Person newMember = createCrewMember(name, this.crewSize, race);
		this.crewSize += 1;
		this.crewMemberArray.add(newMember);
}
	
	/**
	 * Gets the {@code Person} object from the crewMemberArray, based on the index
	 * @param i         int index of the person to return
	 * @return          the person object from the given index in crewMemberArray
	 */
	public String getMemberName(int i) {
		return this.crewMemberArray.get(i).getName();
	}
	
	/**
	 * Gets the {@code Person} object from the crewMemberArray, based on the name
	 * @param name      String name of the person to return
	 * @return          the person object with the given name in crewMemberArray
	 * @return
	 */
	public Person getMember(String name) {
		for (Person person : this.crewMemberArray) {
			if (person.getName() == name) {
				return person;	
				}
		}
		return this.crewMemberArray.get(0);	
	}	
	
	/**
	 * Gets the ship object
	 * @return        {@code Ship} object
 	 */
	public Ship getShip() {
		return this.ship;
	}
	/**
	 * Gets the crew member ArrayList
	 * @return     The ArrayList containing the {@code Person} objects
	 */
	public ArrayList<Person> getCrewMemberArray() {
		return this.crewMemberArray;
	}
	/**
	 * Gets how many crew members are on board
	 * @return int the size of the crew
	 */
	public Integer getCrewSize() {
		return this.crewSize;
	}
	
	/**
	 * Takes person object who has died and warns the player by printing to game log
	 * @param person    Person who has died
	 */
	public void sendDeath(Person person) {
		if (!person.alreadLabelledDead()) {
			String s = person.getName() +" has died!";
			person.setLabelledDead();
			this.initGame.getMainScreen().printToLog(s);
			this.initGame.getMainScreen().buildCrewMemberCombos();
		}
	}
	
	// for when the pirates gank you with no item
	/**
	 * If pirates attack when player has no items, they attack the crew for 40 hp each
	 */
	public void beatUpCrew() {
		for (Person person : crewMemberArray) {
			boolean death = person.decreaseHealth(40);
			if (death) {
				sendDeath(person);
			}
		}
		
	}

	/**
	 * Applies the end of day changes to each crew member, adding any status changes to a string which is returned.
	 * @return String s any status changes that crew members experienced ending the day
	 */
	public String endDayActions() {
		String s = "";
		for (Person person: crewMemberArray) {
			s += person.endDayChanges();
		}
		return s;
	}

	/**
	 * Calculates points scored related to crew members
	 * 
	 * @return
	 */
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
	/**
	 * Removes all {@code Person} objects from the crewMemberArray. Used for resetting the ArrayList before quick start.
	 */
	public void destroyCrew() {
		if (crewSize > 0) {
			crewMemberArray = new ArrayList<Person>();
			crewSize = 0;
		}
		
	}
	
}

