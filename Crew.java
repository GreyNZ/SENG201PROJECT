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
	private Double money;
	Scanner scanner = new Scanner(System.in);


	
	
	//needs medical and food
	public Crew(int numberOfCrewMembers, String shipName, Double money) {
//		private ArrayList<Person> crewMemberArray = new ArrayList<Person>(numberOfCrewMembers);
		this.crewMemberArray = new ArrayList<Person>(numberOfCrewMembers);
		this.numberOfCrewMembers = numberOfCrewMembers;
		this.money = money;
		this.ship = new Ship(shipName);
		
		
		//this will eventually be a switch statement inside the for loop

		}
	public void buildCrew() {
		for (int i = 0; i <numberOfCrewMembers; i+=1) {
			Person newMember = new Person();
			this.crewMemberArray.add(newMember);
			this.addCrewMember(i);
		}
		}
	
	public void addCrewMember(int i) {
		System.out.println("Name? ");
		String name = scanner.next();
		System.out.println("Please select a race.\n1. Human\n2. Rockman\n3. Egghead\n4. Bugman\n5. Gazer\n6. Warbot");
		try {
			int raceNum = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Not a valid selection. Defaulting to human");
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
		Crew crew = new Crew(4, "Betty", 2.0);
		crew.buildCrew();
	}
	
}

