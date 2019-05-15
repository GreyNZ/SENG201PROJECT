package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenericErrorScreen {
	
	JFrame frmError;
	private WindowManager manager;
	private JLabel lblHeaderError;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenericErrorScreen window = new GenericErrorScreen();
					window.frmError.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GenericErrorScreen() {
		initialize();
	}
	
	public void closeWindow() {
		frmError.dispose();
	}
	
	public void setErrorTitle(String input) {
		frmError.setTitle(input);         // Should allow error message put through to overwrite the Title
	}
	
	public void setLabelText(String input) {
		lblHeaderError.setText(input);   // i think i might have made this wrong....
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmError = new JFrame();
		frmError.setTitle("ERROR");
		frmError.setBounds(100, 100, 400, 200);
		frmError.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmError.getContentPane().setLayout(null);
		
		JLabel lblHeaderError = new JLabel("GenericError Pass me message");
		lblHeaderError.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHeaderError.setBounds(0, 23, 400, 53);
		lblHeaderError.setHorizontalAlignment(SwingConstants.CENTER);
		frmError.getContentPane().add(lblHeaderError);
		
		JButton btnCloseWindow = new JButton("Close Error Message");
		btnCloseWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeWindow();
			}
		});
		btnCloseWindow.setBounds(105, 124, 181, 36);
		frmError.getContentPane().add(btnCloseWindow);
	}
}
