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
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class NewGameScreen {

	JFrame frame;
	private JTextField txtEnterShipName;
	private JTextField txtEnterCrewMembers;
	private WindowManager manager;
	private InitGame initGame;

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
		initialize();
		frame.setVisible(true);
	}
	//Old constructor for testing 
	public NewGameScreen() {
		initialize();
		frame.setVisible(true);
	}
	
	
	public void setDefaultValues() {
		initGame.setShipName("The Enterprise");
		initGame.setGameLength(3);
		initGame.getCrew().buildDefaultCrew();
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
		
		JButton btnConfirmShipName = new JButton("Confirm");
		btnConfirmShipName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String shipName = txtEnterShipName.getText();
				if (shipName != "Please enter a ship name 3-12 characters") {
					initGame.setShipName(shipName);
				}
				else {
					initGame.setShipName("The Enterprise");
				}
				
			}
		});
		btnConfirmShipName.setBounds(525, 27, 114, 25);
		btnConfirmShipName.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(btnConfirmShipName);
		
		JLabel lblDays = new JLabel("Please select the number of days the game lasts:");
		lblDays.setBounds(12, 70, 470, 31);
		lblDays.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(lblDays);
		
		JButton btn_ConfirmDays = new JButton("Confirm");
		btn_ConfirmDays.setBounds(525, 74, 114, 25);
		btn_ConfirmDays.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(btn_ConfirmDays);
		
		JSpinner spinner_GameLength = new JSpinner();
		spinner_GameLength.setBounds(467, 77, 46, 20);
		spinner_GameLength.setModel(new SpinnerNumberModel(3, 3, 12, 1));
		frame.getContentPane().add(spinner_GameLength);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if all inputs completed close window and open mane game running it will all inputs
				// else: throw error saying your missing shit
				// closeWindow();   // bundle into if all working above
			}
		});
		btnStartGame.setBounds(957, 689, 231, 71);
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
		btnStartDefultGame.setBounds(957, 543, 231, 71);
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
		btnAddCrewmember.setBounds(12, 237, 276, 31);
		btnAddCrewmember.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(btnAddCrewmember);
		
		JButton btnDefaultCrewmember = new JButton("Add Default Crewmember");
		btnDefaultCrewmember.setBounds(12, 266, 276, 31);
		btnDefaultCrewmember.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(btnDefaultCrewmember);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 185, 276, 24);
		frame.getContentPane().add(comboBox);
		
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
		
		JLabel pickCrewSizeLabel = new JLabel("Please select the number of days the game lasts:");
		pickCrewSizeLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		pickCrewSizeLabel.setBounds(12, 114, 470, 31);
		frame.getContentPane().add(pickCrewSizeLabel);
		
		JSpinner crewSizeSpiner = new JSpinner();
		crewSizeSpiner.setModel(new SpinnerNumberModel(2, 2, 4, 1));
		crewSizeSpiner.setBounds(467, 121, 46, 20);
		frame.getContentPane().add(crewSizeSpiner);
		
		JButton btnCrewSizeConfirm = new JButton("Confirm");
		btnCrewSizeConfirm.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCrewSizeConfirm.setBounds(525, 118, 114, 25);
		frame.getContentPane().add(btnCrewSizeConfirm);
	}
	

}
