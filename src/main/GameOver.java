
//* marked for deletion*//


package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class GameOver {

	private JFrame frame;
	private WindowManager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOver window = new GameOver();
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
	public GameOver() {
		initialize();
	}

	public GameOver(WindowManager windowManager) {
		this.manager = windowManager;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGameOver = new JLabel("Game Over");
		lblGameOver.setBounds(158, 59, 89, 39);
		frame.getContentPane().add(lblGameOver);
		
		JButton btnPlayAgain = new JButton("Play again");
		btnPlayAgain.setBounds(138, 114, 115, 29);
		frame.getContentPane().add(btnPlayAgain);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(138, 159, 115, 29);
		frame.getContentPane().add(btnQuit);
	}

	public void closeWindow() {
		frame.dispose();
		
	}
}
