package gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.Game;
import main.InitGame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * Victory Screen
 * @author Cameron Bodger, Grey Harris
 *
 */
public class VictoryScreen {


	JFrame frame;
	/**
	 * {@code WindowManager} handles opening closing windows
	 */
	private WindowManager manager;
	/**
	 * JLabel displays player score
	 */
	private JLabel lblScore;



	/**
	 * VictoryScreen constructor
	 * @param incomingManager    WindowManager handles opening closing windows
	 */
	public VictoryScreen(WindowManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Closes the window by disposing the JFrame
	 */
	public void closeWindow() {
		frame.dispose();
	}
	/**
	 * Starts a new game
	 */
	public void newGame() {
		InitGame newGame = new InitGame();
		Game game = new Game();
		game.startGame(newGame);
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
				newGame();
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
		lblImage.setBounds(85, 167, 996, 510);
		frame.getContentPane().add(lblImage);
		
		
		lblScore = new JLabel(String.format("You found %s/%s parts in %s days, Your score was: %s", manager.getInitGame().getCurrentPieces(), manager.getInitGame().getPieces(), manager.getInitGame().getCurrentDay(), manager.getInitGame().getPoints()));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Dialog", Font.BOLD, 30));
		lblScore.setBounds(34, 64, 1133, 105);
		frame.getContentPane().add(lblScore);
	}

}
