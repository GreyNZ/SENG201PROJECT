package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



/**
 * Builds and stores an ArrayList of Person types. Stores their ship, food, medical items and cash. 
 * @author cam, grey
 * 
 */
public class Crew {
	
	private ArrayList<Person> crewMemberArray;
	private ArrayList<Items> foodArray;
	private ArrayList<Items> medicalArray;

	private int crewSize;
	private Ship ship;
	private Double money = 2.0;
	Scanner scanner = new Scanner(System.in);
//	private int raceNum;
	
	//testing variables
	Person bruce = new Human("Bruce", 0);
	Person pineapple = new Warbot("Pineapple", 1);



	// default Crew for testing
	public Crew() {
		this.crewMemberArray = new ArrayList<Person>(crewSize);

		this.crewSize = 2;
		this.crewMemberArray.add(this.bruce);
		this.crewMemberArray.add(this.pineapple);
		this.ship = new Ship("The Bowie");

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
		this.buildCrew();
		
		
		//this will eventually be a switch statement inside the for loop

		}


	/**
	 * Adds Person objects to addCrewMember ArrayList
	 */
	public void buildCrew() {
		for (int i = 0; i <this.crewSize; i+=1) {
//			Person newMember = new Person();
			this.crewMemberArray.add(addCrewMember(i));
//			this.addCrewMember(i);
		}
		System.out.println(this.crewMemberArray);
		}
	/**
	 * Receives user input to select the race of Person object
	 * @param i         unique identifier for the Person object, based on what index they were added to crewMemberArray
	 * @return          Person object, specifically the user the selected subclass (race)
	 */
	public Person addCrewMember(int i) {
		int raceNum = 1;
		System.out.println("Name? ");
		String name = scanner.next();
		System.out.println("Please select a race.\n1. Human\n2. Rockman\n3. Grey\n4. Bugman\n5. Gazer\n6. Warbot");
		try {
			raceNum = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid selection. Defaulting to human");
//			int raceNum = 1;
		}
		return createCrewMember(name, i, raceNum);
	}
	/**
	 * Switch statement to create a Person object of specific race. 
	 * Uses int's from 1-6 as cases. 
	 * Defaults to Human to make invalid user input easier to deal with for command-line mode.
	 * @param name              String that holds crew member's name
	 * @param i                 Unique identifying int
	 * @param raceNum           Switch case int
	 * @return                  Person object 
	 */
	public Person createCrewMember(String name, int i, int raceNum) {
		switch (raceNum) {
		case 1:
			return new Human(name, i);
		case 2:
			return new Rockman(name, i);
		case 3:
			return new Grey(name, i);
		case 4:
			return new Bugman(name, i);
		case 5:
			return new Gazer(name, i);
		case 6:
			return new Warbot(name, i);
		default:
			System.out.println("Invalid selection. Defaulting to human.");
			return new Human(name, i);
		}
		
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
	
	public Person getMember(int i) {
		return this.crewMemberArray.get(i);
	}

	public Ship getShip() {
		// TODO Auto-generated method stub
		return this.ship;
	}
	
}

