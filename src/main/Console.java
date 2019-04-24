package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
	
	private InitGame newGame;
	private Crew crew;
	Scanner scanner = new Scanner(System.in);


	public Console(Crew crew, InitGame newGame) {
		this.crew = crew;
		this.newGame = newGame;
	}


	public void showOptions() {
		int decision = 0;
		String optionString = "What would you like to do? \n1. View crew member status\n2. View spaceship status\n";
		String optionString2 = "3. Visit nearest space outpost *Currently broken*\n4. Take action. *Does Nothing* \n5. End day.\n";
		System.out.println(optionString + optionString2);

		decision = getIntDecision();
		if (decision < 1 || decision > 5) {
			System.out.println("Please input a number between 1 and 5");
			showOptions();
		}
		else {
		    selectOption(decision);
		}
	}
	
	private void selectOption(int decision) {
		switch (decision) {
		case 1:
			viewCrewMemberStatus();
			break;
		case 2:
			viewSpaceShip();
			break;
		case 3:
			visitOutpost();
			break;
		case 4:
			takeAction();
			break;
		case 5:
			endDay();
			break;
		default:
			System.out.println("Invalid selection. Please enter a number between 1 and 5");
			showOptions();
			break;
		}
		
	}


	private void endDay() {
		this.newGame.endDay();
		
	}


	private void takeAction() {
		// TODO Auto-generated method stub
		
	}

	//severely broken. getIntDecision is fucking it up.
	private void visitOutpost() {
		System.out.println("Visiting outpost.");
		Outpost outpost = new Outpost();
		while (scanner.next() != "q") {
			System.out.println("Would you like to purchase an item? Press q to quit.");
			System.out.println(outpost);
			int decision = getIntDecision();
			if (decision < 0 || decision > 9) {
				System.out.println("Invalid input");
			}
			else {
				outpost.buyItem(decision);
			}
		}
	}


	private void viewSpaceShip() {
		System.out.println(crew.getShip());
		
	}

// Probably want to shift this to crew at some point
	private void viewCrewMemberStatus() {
		int decision = 0;
		System.out.println("Select crew member:\n");
		for (int i=0; i < this.newGame.getCrewSize(); i += 1) {
			System.out.println(i);
			System.out.println(i + ". " + crew.getMemberName(i));			
		}
		decision = getIntDecision();
		if (decision < 0 || decision > this.newGame.getCrewSize()) {
			System.out.println("Invalid input. Please select a crew member");
			viewCrewMemberStatus();
		}
		else {
			System.out.println(crew.getMember(decision));
		}
		
	}


	public int getIntDecision() {
		int decision = 0;
		try {
			decision = scanner.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid input. Try again");
			getIntDecision();
	}
		return decision;
	
	}
	


}
