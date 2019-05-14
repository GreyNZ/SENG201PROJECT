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
	private HashMap<String, Person> crewMemberMap;
	private ArrayList<Items> foodArray;
	private ArrayList<Items> medicalArray;

	private int crewSize = 0;
	private Ship ship;
	private Double money = 2.0;
	Scanner scanner = new Scanner(System.in);
//	private int raceNum;
	
	//testing variables
	Person bruce = new Human("Bruce", 0);
	Person pineapple = new Warbot("Pineapple", 1);



	// constructor
	public Crew() {
		this.crewMemberArray = new ArrayList<Person>();
		this.crewMemberMap = new HashMap<String, Person>();


	}	
	
	/**
	 * 
	 * @param crewSize      integer defined from GameInit class between 2-4 that specifies 
	 *                      how many Person objects will be added to crewMemberArray.
	 *                      
	 * @param shipName      String defined from GameInit class, name of the ship
	 */
	public Crew(int crewSize, String shipName) {
//		private ArrayList<Person> crewMemberArray = new ArrayList<Person>(numberOfCrewMembers);
		this.crewMemberArray = new ArrayList<Person>(crewSize);
		this.crewSize = crewSize;
		this.ship = new Ship(shipName);
//		this.buildCrew();
		
		
		//this will eventually be a switch statement inside the for loop

		}


	/**
	 * Adds Person objects to addCrewMember ArrayList
	 */
//	public void buildCrew() {
//		for (int i = 0; i <this.crewSize; i+=1) {
////			Person newMember = new Person();
//			this.crewMemberArray.add(addCrewMember(i));
////			this.addCrewMember(i);
//		}
//		System.out.println(this.crewMemberArray);
//		}
	/**
	 * Receives user input to select the race of Person object
	 * @param i         unique identifier for the Person object, based on what index they were added to crewMemberArray
	 * @return          Person object, specifically the user the selected subclass (race)
	 */
//	public Person addCrewMember(int i) {
//		int raceNum = 1;
//		System.out.println("Name? ");
//		String name = scanner.next();
//		System.out.println("Please select a race.\n1. Human\n2. Rockman\n3. Grey\n4. Bugman\n5. Gazer\n6. Warbot");
//		try {
//			raceNum = scanner.nextInt();
//		} catch (InputMismatchException e) {
//			System.out.println("Invalid selection. Defaulting to human");
////			int raceNum = 1;
//		}
//		return createCrewMember(name, i, raceNum);
//	}
	/**
	 * Switch statement to create a Person object of specific race. 
	 * Uses int's from 1-6 as cases. 
	 * Defaults to Human to make invalid user input easier to deal with for command-line mode.
	 * @param name              String that holds crew member's name
	 * @param i                 Unique identifying int
	 * @param raceNum           Switch case int
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
		case "Grazer":
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
	
	
	// dam I want to keep the crew in a dictionary for easy name look ups, but that means names have to 
	// be unique. 
//	public void addCrewMember(String name, String race) {
//		Person newMember = createCrewMember(name, this.crewSize, race);
//		this.crewSize += 1;
//		this.crewMemberMap.put(name, newMember);
//	}
	
	// array version
	public void addCrewMember(String name, String race) {
	Person newMember = createCrewMember(name, this.crewSize, race);
	this.crewSize += 1;
	this.crewMemberArray.add(newMember);
}
	
	public void addMoney(Double cost) {
		this.money -= cost;
	}
	public void removeMoney(Double cost) {
		this.money += cost;
	}
	
	public Double getMoney() {
		return this.money;
	}
	
	public static void main(String[] args) {
//		Crew crew = new Crew(4, "Betty");
		Crew crew = new Crew();
//		crew.buildCrew();
		System.out.println(crew);
	
	}

	public String getMemberName(int i) {
		// TODO Auto-generated method stub
		return this.crewMemberArray.get(i).getName();
	}
	
	public Person getMember(String name) {
		for (Person person : this.crewMemberArray) {
			if (person.getName() == name) {
				return person;	
				}
		}
		// I hate this line, but I can't think of a way to avoid it
		// The combobox should always give a valid name, so I'm not too concerned about bugs
		return this.crewMemberArray.get(0);	

	}	
	
	// Tried to get person object. not good.
//	public Person getMember(String s) {
//		for (Person person : this.crewMemberArray) {
//			if (person.getName() == s) {
//				return person;
//			}
//			else {
//				System.out.println("Invalid person selection from getMember");
//			}
//		}
//	}

	public Ship getShip() {
		// TODO Auto-generated method stub
		return this.ship;
	}
	public ArrayList<Person> getCrewMemberArray() {
		return this.crewMemberArray;
	}
	public Integer getCrewSize() {
		return this.crewSize;
	}
	
	// for when the pirates gank you with no item
	public void beatUpCrew() {
		for (Person person : crewMemberArray) {
			person.decreaseHealth(40);
		}
		
	}

	public String endDayActions() {
		String s = "";
		for (Person person: crewMemberArray) {
			s += person.endDayChanges();
		}
		return s;
	}
	
}

