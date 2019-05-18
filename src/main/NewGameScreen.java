package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class NewGameScreen {

	JFrame frame;
	private JTextField txtEnterShipName;
	private JTextField txtEnterCrewMembers;
	private WindowManager manager;
	private InitGame initGame;
	private Crew crew;
	private String[] raceArray;
	private Random rand = new Random();
	private JComboBox comboBox;
	private JTextArea textField;
	private int maxCrewSize = 4;
	private JSpinner spinner_GameLength;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGameScreen window = new NewGameScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void launchNewGameScreen() {
		NewGameScreen newGame = new NewGameScreen();
		newGame.frame.setVisible(true);
	}
	
	public void launchStartScreen() {
		StartScreen StartScreen = new StartScreen();
		StartScreen.frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Create the application.
	 * @param windowManager 
	 */
	public NewGameScreen(WindowManager windowManager) {
		manager = windowManager;
		this.initGame = manager.getInitGame();
		this.crew = initGame.getCrew();
		buildRaceArray();
		initialize();
		frame.setVisible(true);
	}
	//Old constructor for testing 
	public NewGameScreen() {
		initialize();
		frame.setVisible(true);
	}
	
	public void checkStart() {
		String shipName = txtEnterShipName.getText();
		System.out.println(shipName);
		if (shipName.equals("Please enter a ship name 3-12 characters")) {
			textField.setText("Please enter a ship name");
		}
		else if (shipName.length() < 3 || shipName.length() > 12) {
			textField.setText("Ship name must be 3-12 characters");
		}
		
		else {
			if (crew.getCrewSize() < 2) {
				textField.setText("Add 2-4 crew members");
			}
			else {
				int gameLength = (int) spinner_GameLength.getValue();
				initGame.setGameLength(gameLength);
				initGame.setShipName(shipName);
				manager.launchMainScreen();
				closeWindow();		
			}
		}
	}
	
	
	public void setDefaultValues() {
		initGame.setShipName("The Enterprise");
		initGame.setGameLength(3);
		crew.destroyCrew();
		initGame.getCrew().buildDefaultCrew();
	}
	
	public void addMember() {
		if (crew.getCrewSize() < 4) {
			String race = (String) comboBox.getSelectedItem();
			String name = txtEnterCrewMembers.getText();
			if (name.equals("Enter Crew Members Name 3-12 characters")) {
				textField.setText("Please enter a name");
			}
			else if (name.length() > 12 || name.length() < 3){
				textField.setText("Please enter a name 3-12 characters");
				
			}
			else {
				crew.addCrewMember(name, race);
				textField.setText("A " + race + " named " + name + " joined your crew");
			}}
		else {
			textField.setText("Crew is full.");
			}
		
	}
	
	private void displayRaceInfo() {
		String race = (String) comboBox.getSelectedItem();
		String info = RaceInfo.getInfo(race);
		textField.setText(info);
	}
	
	public void addRandomCrewMember() {
		if (crew.getCrewSize() < maxCrewSize) {
			String name = randomName();
			String race = randomRace();
			crew.addCrewMember(name, race);
			textField.setText("A " + race + " named " + name + " has joined your crew");
		}
		else {
			textField.setText("Crew is full.");
		}
	}
	
	public void buildRaceArray() {
		raceArray = new String[] {"Human", "Rockman", "Grey", "Bugman", "Gazer", "Warbot"};
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblShipNameLabel = new JLabel("Ship Name: ");
		lblShipNameLabel.setBounds(12, 23, 115, 31);
		lblShipNameLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(lblShipNameLabel);
		
		txtEnterShipName = new JTextField();
		txtEnterShipName.setBounds(126, 27, 387, 24);
		txtEnterShipName.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtEnterShipName.setText("Please enter a ship name 3-12 characters");
		frame.getContentPane().add(txtEnterShipName);
		txtEnterShipName.setColumns(10);
		
		JLabel lblDays = new JLabel("Please select the number of days the game lasts:");
		lblDays.setBounds(12, 70, 470, 31);
		lblDays.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(lblDays);
		
		spinner_GameLength = new JSpinner();
		spinner_GameLength.setBounds(467, 77, 46, 20);
		spinner_GameLength.setModel(new SpinnerNumberModel(3, 3, 10, 1));
		frame.getContentPane().add(spinner_GameLength);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkStart();
				// closeWindow();   // bundle into if all working above
			}
		});
		btnStartGame.setBounds(957, 543, 231, 71);
		btnStartGame.setFont(new Font("L M Roman Caps10", Font.BOLD, 21));
		frame.getContentPane().add(btnStartGame);
		
		JButton btnResetScreen = new JButton("Reset Game");
		btnResetScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchNewGameScreen();
				closeWindow();
			}
		});
		btnResetScreen.setBounds(957, 616, 231, 71);
		btnResetScreen.setFont(new Font("L M Roman Caps10", Font.BOLD, 21));
		frame.getContentPane().add(btnResetScreen);
		
		JLabel label = new JLabel("");
		label.setBounds(303, 484, 66, 15);
		frame.getContentPane().add(label);
		
		JButton btnStartDefultGame = new JButton("Quick Play");
		btnStartDefultGame.setBounds(957, 689, 231, 71);
		btnStartDefultGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//initiate game with set values
				setDefaultValues();
				//open main game
				manager.launchMainScreen();
				closeWindow();
			}
		});
		

		
		btnStartDefultGame.setFont(new Font("L M Roman Caps10", Font.BOLD, 21));
		frame.getContentPane().add(btnStartDefultGame);
		
		txtEnterCrewMembers = new JTextField();
		txtEnterCrewMembers.setBounds(12, 209, 276, 31);
		txtEnterCrewMembers.setText("Enter Crew Members Name 3-12 characters");
		frame.getContentPane().add(txtEnterCrewMembers);
		txtEnterCrewMembers.setColumns(10);
		
		JButton btnAddCrewmember = new JButton("Add Crewmember");
		btnAddCrewmember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addMember();
			}
		});
		btnAddCrewmember.setBounds(12, 237, 276, 31);
		btnAddCrewmember.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(btnAddCrewmember);
		
		JButton btnDefaultCrewmember = new JButton("Add Random Crewmember");
		btnDefaultCrewmember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRandomCrewMember();
			}
		});
		btnDefaultCrewmember.setBounds(12, 266, 276, 31);
		btnDefaultCrewmember.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(btnDefaultCrewmember);
		
		comboBox = new JComboBox(raceArray);
		comboBox.setBounds(12, 185, 276, 24);
		frame.getContentPane().add(comboBox);
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        displayRaceInfo();
		    }
		});
		
		JLabel lblSelectCrewmembersRace = new JLabel("Select Crewmembers Race");
		lblSelectCrewmembersRace.setBounds(27, 157, 231, 31);
		lblSelectCrewmembersRace.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectCrewmembersRace.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(lblSelectCrewmembersRace);
		
		JButton btnReturnToStartScreen = new JButton("Back");
		btnReturnToStartScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchStartScreen();
				closeWindow();
			}
		});
		btnReturnToStartScreen.setFont(new Font("L M Roman Caps10", Font.BOLD, 21));
		btnReturnToStartScreen.setBounds(27, 689, 231, 71);
		frame.getContentPane().add(btnReturnToStartScreen);
		
		textField = new JTextArea();
		textField.setBackground(SystemColor.window);
		textField.setFocusable(false);
		textField.setBounds(351, 188, 563, 426);
		textField.setLineWrap(true);
		textField.setWrapStyleWord(true);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	protected String randomRace() {
		int index = rand.nextInt(6);
		return raceArray[index];
	}

	private String randomName() {
		String[] names = new String[]{"Talisha", "Lulu", "Sid", "Gracia", "Tomas", "Jamison", "Christeen", "Tammera", "Fatima", "Alec", "Slyvia", "Oscar", "Evelia", "Lynetta", "Elly", "Merlene", "Shaunna", "Artie", "Shanika", "Fred", "Maisha", "Kenton", "Lynell", "Sha", "Shantae", "Vina", "Laure", "Treena", "Belkis", "Terry", "Carlee", "Fernanda", "Sharon", "Birgit", "Nenita", "Jenee", "Laurie", "Stephenie", "Misty", "Mitchell", "Felix", "Ailene", "Jonie", "Amelia", "Jannet", "Dorathy", "Stewart", "Lauran", "Lucila", "Manual"};
		int index = rand.nextInt(50);
		return names[index];

	}

}
