package main;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * Loss Screen
 * 
 * @author Grey Harris, Cameron Bodger
 *
 */
public class LossScreen {


	JFrame frame;
	/**
	 * {@code WindowManager} handles opening closing windows
	 */
	private WindowManager manager;
	/**
	 * JLabel displays player score
	 */
	private JLabel lblScoreMessage;
	private JLabel lblHeader;
	
	/**
	 * LossScreen constructor
	 * @param incomingManager    WindowManager handles opening closing windows
	 */
	public LossScreen(WindowManager incomingManager) {
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
				frame.dispose();
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
		String loss = "You Lose";
		lblHeader = new JLabel(manager.getInitGame().getCauseOfDeath());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Dialog", Font.BOLD, 66));
		lblHeader.setBounds(12, 12, 1176, 86);
		frame.getContentPane().add(lblHeader);
		
		JLabel lblBottom = new JLabel("On the up side, in space nobody can hear you crying.....");
		lblBottom.setHorizontalAlignment(SwingConstants.CENTER);
		lblBottom.setBounds(308, 689, 584, 53);
		frame.getContentPane().add(lblBottom);
		
		JLabel lblImage = new JLabel("holding text will replace with image");
		lblImage.setIcon(new ImageIcon(LossScreen.class.getResource("/images/SadSpaceman.jpg")));
		lblImage.setBounds(206, 145, 898, 532);
		frame.getContentPane().add(lblImage);
		
		lblScoreMessage = new JLabel(String.format("You found %s/%s parts using %s days, Your score was: %s", manager.getInitGame().getCurrentPieces(), manager.getInitGame().getPieces(), manager.getInitGame().getCurrentDay() - 1, manager.getInitGame().getPoints())); //note to push
		lblScoreMessage.setFont(new Font("Dialog", Font.BOLD, 30));
		lblScoreMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreMessage.setBounds(22, 88, 1166, 71);
		frame.getContentPane().add(lblScoreMessage);
	}
}
