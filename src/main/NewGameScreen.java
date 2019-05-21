package main;

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
import java.awt.SystemColor;
import javax.swing.JTextArea;

/**
 * NewGameScreen
 * @author Cameron Bodger, Grey Harris
 *
 */
public class NewGameScreen {


	JFrame frame;

	/**
	 * {@code WindowManager} handles opening closing windows
	 */
	private WindowManager manager;
	/**
	 * The game environment
	 */
	private InitGame initGame;
	/**
	 * The Crew object
	 */
	private Crew crew;
	/**
	 * Maximum crew size is 4
	 */
	private int maxCrewSize = 4;
	/**
	 * Array of selectable races 
	 */
	private String[] raceArray;
	/**
	 * Random number generator
	 */
	private Random rand = new Random();
	/**
	 * Spinner to select number of days
	 */
	private JSpinner spinner_GameLength;
	/**
	 * TextField to enter ship name
	 */
	private JTextField txtEnterShipName;
	/**
	 * TextField to enter crew member name
	 */
	private JTextField txtEnterCrewMembers;
	/**
	 * Displays information about the races, and error messages
	 */
	private JTextArea textField;
	/**
	 * Combobox to select race
	 */
	private JComboBox<String> comboBox;





	
	/**
	 * Closes the window by disposing the JFrame
	 */
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Create the application.
	 * @param windowManager          {@code WindowManager} handles opening closing windows
	 */
	public NewGameScreen(WindowManager windowManager) {
		manager = windowManager;
		this.initGame = manager.getInitGame();
		this.crew = initGame.getCrew();
		buildRaceArray();
		initialize();
		frame.setVisible(true);
	}

	
	/**
	 * Checks if start game variables are set. Either displays what needs to be fixed, or starts the game
	 */
	public void checkStart() {
		String shipName = txtEnterShipName.getText();
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
	
	
	/**
	 * Sets the default game values for quick play
	 */
	public void setDefaultValues() {
		initGame.setShipName("The Enterprise");
		initGame.setGameLength(3);
		crew.destroyCrew();
		initGame.getCrew().buildDefaultCrew();
	}
	
	/**
	 * Adds a person to the crew
	 */
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
	
	/**
	 * Display information about the race classes when selected in combobox
	 */
	private void displayRaceInfo() {
		String race = (String) comboBox.getSelectedItem();
		String info = RaceInfo.getInfo(race);
		textField.setText(info);
	}
	
	/**
	 * Adds a randomly generated person to the crew
	 */
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
	
	/**
	 * Adds the names of the races to the race array
	 */
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
		
		comboBox = new JComboBox<String>(raceArray);
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
	
	/**
	 * Uses RNG to select a random race
	 * @return randomly selected race
	 */
	protected String randomRace() {
		int index = rand.nextInt(6);
		return raceArray[index];
	}

	/**
	 * Uses RNG to select a random name from an array of names
	 * @return random name string
	 */
	private String randomName() {
		String[] names = new String[]{"Talisha", "Lulu", "Sid", "Gracia", 
				"Tomas", "Jamison", "Christeen", "Tammera", "Fatima", "Alec", 
				"Slyvia", "Oscar", "Evelia", "Lynetta", "Elly", "Merlene", "Shaunna", 
				"Artie", "Shanika", "Fred", "Maisha", "Kenton", "Lynell", "Sha", "Shantae", 
				"Vina", "Laure", "Treena", "Belkis", "Terry", "Carlee", "Fernanda", "Sharon", 
				"Birgit", "Nenita", "Jenee", "Laurie", "Stephenie", "Misty", "Mitchell", "Felix", 
				"Ailene", "Jonie", "Amelia", "Jannet", "Dorathy", "Stewart", "Lauran", "Lucila", "Manual"};
		int index = rand.nextInt(50);
		return names[index];

	}

}
