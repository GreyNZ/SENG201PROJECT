package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class VictoryScreen {

	JFrame frame;
	private WindowManager manager;
	private JLabel lblScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VictoryScreen window = new VictoryScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
//	public VictoryScreen(WindowManager incomingManager) {
//		manager = incomingManager;
//		initialize();
//		frame.setVisible(true);
//	}
	
	public VictoryScreen() {
		initialize();
	}
	
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeWindow();
			}
		});
		btnExitGame.setFont(new Font("L M Roman Caps10", Font.BOLD, 21));
		btnExitGame.setBounds(957, 689, 231, 71);
		frame.getContentPane().add(btnExitGame);
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchStartScreen();
				closeWindow();
			}
		});
		btnPlayAgain.setFont(new Font("L M Roman Caps10", Font.BOLD, 21));
		btnPlayAgain.setBounds(12, 689, 231, 71);
		frame.getContentPane().add(btnPlayAgain);
		
		JLabel lblHeader = new JLabel("YOU WON!");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Dialog", Font.BOLD, 51));
		lblHeader.setBounds(12, 12, 1176, 86);
		frame.getContentPane().add(lblHeader);
		
		JLabel lblWhyNotTry = new JLabel("Why not try again for a better score?");
		lblWhyNotTry.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhyNotTry.setBounds(304, 689, 584, 53);
		frame.getContentPane().add(lblWhyNotTry);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(VictoryScreen.class.getResource("/images/SpaceDisco.png")));
		lblImage.setBounds(83, 202, 996, 475);
		frame.getContentPane().add(lblImage);
		
//		lblCrewStatsLabelMainScreen = new JLabel("Holding Info For Crew Details");
//		lblCrewStatsLabelMainScreen.setBounds(0, 72, 122, 144);
//		lblCrewStatsLabelMainScreen.setVerticalAlignment(SwingConstants.TOP);
//		panel.add(lblCrewStatsLabelMainScreen);
//		refreshedCrewStats = lblCrewStatsLabelMainScreen;
//		refreshCrewNameLabel(); //note to push
		
		lblScore = new JLabel("Your score was:   Holding value");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Dialog", Font.BOLD, 30));
		lblScore.setBounds(304, 110, 647, 71);
		frame.getContentPane().add(lblScore);
	}

}
