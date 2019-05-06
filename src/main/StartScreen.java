package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class StartScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
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
	public StartScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Space Explorer");
		lblTitle.setFont(new Font("L M Roman Caps10", Font.BOLD, 63));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(54, 12, 1083, 158);
		frame.getContentPane().add(lblTitle);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("L M Roman Caps10", Font.BOLD, 21));
		btnNewGame.setBounds(54, 670, 231, 71);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.setFont(new Font("L M Roman Caps10", Font.BOLD, 21));
		btnExitGame.setBounds(914, 670, 231, 71);
		frame.getContentPane().add(btnExitGame);
		
		JLabel lblStartScreenImage = new JLabel("holding text");
		lblStartScreenImage.setIcon(new ImageIcon(StartScreen.class.getResource("/images/WideRectangePlanetGIF.gif")));
		lblStartScreenImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartScreenImage.setBounds(246, 213, 796, 415);
		frame.getContentPane().add(lblStartScreenImage);
	}

}
