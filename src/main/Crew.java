package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Crew {
	
	private ArrayList<Person> crewMemberArray;
	private ArrayList<Item> foodArray;
	private ArrayList<Item> medicalArray;

	private int numberOfCrewMembers;
	private Ship ship;
	private Double money = 2.0;
	Scanner scanner = new Scanner(System.in);
//	private int raceNum;


	
	
	//needs medical and food
	public Crew(int numberOfCrewMembers, String shipName) {
//		private ArrayList<Person> crewMemberArray = new ArrayList<Person>(numberOfCrewMembers);
		this.crewMemberArray = new ArrayList<Person>(numberOfCrewMembers);
		this.numberOfCrewMembers = numberOfCrewMembers;
		this.ship = new Ship(shipName);
		
		
		//this will eventually be a switch statement inside the for loop

		}
	public void buildCrew() {
		for (int i = 0; i <numberOfCrewMembers; i+=1) {
//			Person newMember = new Person();
			this.crewMemberArray.add(addCrewMember(i));
//			this.addCrewMember(i);
		}
		System.out.println(this.crewMemberArray);
		}
	
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
		Crew crew = new Crew(4, "Betty");
		crew.buildCrew();
	}
	
}

