package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JTable;

public class MainScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{145, 48, 126, 161, 144, 48, 128, 155, 173, 0};
		gridBagLayout.rowHeights = new int[]{29, 63, 236, 420, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblShipName = new JLabel("ShipName");
		lblShipName.setFont(new Font("Dialog", Font.BOLD, 18));
		GridBagConstraints gbc_lblShipName = new GridBagConstraints();
		gbc_lblShipName.fill = GridBagConstraints.BOTH;
		gbc_lblShipName.insets = new Insets(0, 0, 5, 5);
		gbc_lblShipName.gridx = 0;
		gbc_lblShipName.gridy = 0;
		frame.getContentPane().add(lblShipName, gbc_lblShipName);
		
		JLabel lblShipHull = new JLabel("Ship Hull: 100");
		lblShipHull.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblShipHull = new GridBagConstraints();
		gbc_lblShipHull.fill = GridBagConstraints.BOTH;
		gbc_lblShipHull.insets = new Insets(0, 0, 5, 5);
		gbc_lblShipHull.gridx = 2;
		gbc_lblShipHull.gridy = 0;
		frame.getContentPane().add(lblShipHull, gbc_lblShipHull);
		
		JLabel lblShipSheilds = new JLabel("Ship Sheilds: 100");
		lblShipSheilds.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblShipSheilds = new GridBagConstraints();
		gbc_lblShipSheilds.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblShipSheilds.insets = new Insets(0, 0, 5, 5);
		gbc_lblShipSheilds.gridx = 3;
		gbc_lblShipSheilds.gridy = 0;
		frame.getContentPane().add(lblShipSheilds, gbc_lblShipSheilds);
		
		JLabel lblPartsFound = new JLabel("Parts Found: 1/6");
		lblPartsFound.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblPartsFound = new GridBagConstraints();
		gbc_lblPartsFound.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPartsFound.insets = new Insets(0, 0, 5, 5);
		gbc_lblPartsFound.gridx = 6;
		gbc_lblPartsFound.gridy = 0;
		frame.getContentPane().add(lblPartsFound, gbc_lblPartsFound);
		
		JLabel lblSpaceCash = new JLabel("Space Cash: $100");
		lblSpaceCash.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblSpaceCash = new GridBagConstraints();
		gbc_lblSpaceCash.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSpaceCash.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpaceCash.gridx = 7;
		gbc_lblSpaceCash.gridy = 0;
		frame.getContentPane().add(lblSpaceCash, gbc_lblSpaceCash);
		
		JLabel lblDaysRemaining = new JLabel("Days Remaining: 5/10");
		lblDaysRemaining.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblDaysRemaining = new GridBagConstraints();
		gbc_lblDaysRemaining.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDaysRemaining.insets = new Insets(0, 0, 5, 5);
		gbc_lblDaysRemaining.gridwidth = 2;
		gbc_lblDaysRemaining.gridx = 8;
		gbc_lblDaysRemaining.gridy = 0;
		frame.getContentPane().add(lblDaysRemaining, gbc_lblDaysRemaining);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 0, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridheight = 2;
		gbc_tabbedPane.gridwidth = 6;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 2;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel CurrentPlanetPanel = new JPanel();
		tabbedPane.addTab("Current Planet", null, CurrentPlanetPanel, null);
		GridBagLayout gbl_CurrentPlanetPanel = new GridBagLayout();
		gbl_CurrentPlanetPanel.columnWidths = new int[]{336, 43, 18, 223, 0};
		gbl_CurrentPlanetPanel.rowHeights = new int[]{17, 23, 77, 296, 74, 15, 33, 0, 0};
		gbl_CurrentPlanetPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_CurrentPlanetPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		CurrentPlanetPanel.setLayout(gbl_CurrentPlanetPanel);
		
		JLabel lblCurrentPlanetName = new JLabel("Holding text for planetname");
		lblCurrentPlanetName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentPlanetName.setVerticalAlignment(SwingConstants.TOP);
		lblCurrentPlanetName.setFont(new Font("Dialog", Font.BOLD, 18));
		GridBagConstraints gbc_lblCurrentPlanetName = new GridBagConstraints();
		gbc_lblCurrentPlanetName.fill = GridBagConstraints.BOTH;
		gbc_lblCurrentPlanetName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrentPlanetName.gridheight = 2;
		gbc_lblCurrentPlanetName.gridx = 0;
		gbc_lblCurrentPlanetName.gridy = 0;
		CurrentPlanetPanel.add(lblCurrentPlanetName, gbc_lblCurrentPlanetName);
		
		JLabel label = new JLabel("Parts Found: 1/6");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTH;
		gbc_label.fill = GridBagConstraints.HORIZONTAL;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridwidth = 2;
		gbc_label.gridx = 3;
		gbc_label.gridy = 0;
		CurrentPlanetPanel.add(label, gbc_label);
		
		JLabel lblPartsRemainingOnPlanetLabel = new JLabel("Parts on Planet: 1/1");
		lblPartsRemainingOnPlanetLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblPartsRemainingOnPlanetLabel = new GridBagConstraints();
		gbc_lblPartsRemainingOnPlanetLabel.fill = GridBagConstraints.BOTH;
		gbc_lblPartsRemainingOnPlanetLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblPartsRemainingOnPlanetLabel.gridwidth = 2;
		gbc_lblPartsRemainingOnPlanetLabel.gridx = 3;
		gbc_lblPartsRemainingOnPlanetLabel.gridy = 1;
		CurrentPlanetPanel.add(lblPartsRemainingOnPlanetLabel, gbc_lblPartsRemainingOnPlanetLabel);
		
		JLabel lblPlanetImageLabel = new JLabel("Holding Text will take planetImage");
		GridBagConstraints gbc_lblPlanetImageLabel = new GridBagConstraints();
		gbc_lblPlanetImageLabel.fill = GridBagConstraints.BOTH;
		gbc_lblPlanetImageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlanetImageLabel.gridwidth = 4;
		gbc_lblPlanetImageLabel.gridx = 0;
		gbc_lblPlanetImageLabel.gridy = 3;
		CurrentPlanetPanel.add(lblPlanetImageLabel, gbc_lblPlanetImageLabel);
		
		JLabel lblAssignCrewMember = new JLabel("Assign Crew Member To Search Planet For Parts");
		lblAssignCrewMember.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblAssignCrewMember = new GridBagConstraints();
		gbc_lblAssignCrewMember.fill = GridBagConstraints.BOTH;
		gbc_lblAssignCrewMember.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssignCrewMember.gridwidth = 3;
		gbc_lblAssignCrewMember.gridx = 0;
		gbc_lblAssignCrewMember.gridy = 5;
		CurrentPlanetPanel.add(lblAssignCrewMember, gbc_lblAssignCrewMember);
		
		JButton btnSearchForPartsButton = new JButton("Search");
		GridBagConstraints gbc_btnSearchForPartsButton = new GridBagConstraints();
		gbc_btnSearchForPartsButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchForPartsButton.fill = GridBagConstraints.BOTH;
		gbc_btnSearchForPartsButton.gridheight = 2;
		gbc_btnSearchForPartsButton.gridx = 3;
		gbc_btnSearchForPartsButton.gridy = 5;
		CurrentPlanetPanel.add(btnSearchForPartsButton, gbc_btnSearchForPartsButton);
		
		JSpinner spinner_1 = new JSpinner();
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 0;
		gbc_spinner_1.gridy = 6;
		CurrentPlanetPanel.add(spinner_1, gbc_spinner_1);
		
		JPanel TradePanel = new JPanel();
		tabbedPane.addTab("Trade", null, TradePanel, null);
		TradePanel.setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Space Shop, fere for all you space needs");
		lblWelcomeToThe.setFont(new Font("Dialog", Font.BOLD, 14));
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setBounds(12, 12, 638, 43);
		TradePanel.add(lblWelcomeToThe);
		
		JButton btnPurchaseItems = new JButton("Purcahse Items");
		btnPurchaseItems.setBounds(401, 551, 249, 66);
		TradePanel.add(btnPurchaseItems);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(12, 67, 66, 15);
		TradePanel.add(label_1);
		
		JPanel TravelPanel = new JPanel();
		tabbedPane.addTab("Travel", null, TravelPanel, null);
		GridBagLayout gbl_TravelPanel = new GridBagLayout();
		gbl_TravelPanel.columnWidths = new int[]{85, 207, 72, 218, 0};
		gbl_TravelPanel.rowHeights = new int[]{108, 55, 31, 25, 45, 221, 86, 0};
		gbl_TravelPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_TravelPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		TravelPanel.setLayout(gbl_TravelPanel);
		
		JLabel lblCaptain = new JLabel("Captain");
		lblCaptain.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_lblCaptain = new GridBagConstraints();
		gbc_lblCaptain.fill = GridBagConstraints.VERTICAL;
		gbc_lblCaptain.insets = new Insets(0, 0, 5, 5);
		gbc_lblCaptain.gridx = 1;
		gbc_lblCaptain.gridy = 1;
		TravelPanel.add(lblCaptain, gbc_lblCaptain);
		
		JLabel lblCoPilot = new JLabel("Co Pilot");
		lblCoPilot.setFont(new Font("Dialog", Font.BOLD, 22));
		GridBagConstraints gbc_lblCoPilot = new GridBagConstraints();
		gbc_lblCoPilot.insets = new Insets(0, 0, 5, 0);
		gbc_lblCoPilot.gridx = 3;
		gbc_lblCoPilot.gridy = 1;
		TravelPanel.add(lblCoPilot, gbc_lblCoPilot);
		
		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.BOTH;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 3;
		TravelPanel.add(spinner, gbc_spinner);
		
		JSpinner spinner_2 = new JSpinner();
		GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
		gbc_spinner_2.fill = GridBagConstraints.BOTH;
		gbc_spinner_2.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_2.gridx = 3;
		gbc_spinner_2.gridy = 3;
		TravelPanel.add(spinner_2, gbc_spinner_2);
		
		JLabel lblCockpitImage = new JLabel("HoldingText for Cockpit Image");
		GridBagConstraints gbc_lblCockpitImage = new GridBagConstraints();
		gbc_lblCockpitImage.fill = GridBagConstraints.BOTH;
		gbc_lblCockpitImage.insets = new Insets(0, 0, 5, 0);
		gbc_lblCockpitImage.gridwidth = 3;
		gbc_lblCockpitImage.gridx = 1;
		gbc_lblCockpitImage.gridy = 5;
		TravelPanel.add(lblCockpitImage, gbc_lblCockpitImage);
		
		JButton btnTravelToNext = new JButton("Travel To Next Planet");
		GridBagConstraints gbc_btnTravelToNext = new GridBagConstraints();
		gbc_btnTravelToNext.fill = GridBagConstraints.BOTH;
		gbc_btnTravelToNext.gridwidth = 3;
		gbc_btnTravelToNext.gridx = 1;
		gbc_btnTravelToNext.gridy = 6;
		TravelPanel.add(btnTravelToNext, gbc_btnTravelToNext);
		
		JPanel ItemsPanel = new JPanel();
		tabbedPane.addTab("Items", null, ItemsPanel, null);
		ItemsPanel.setLayout(null);
		
		JPanel CrewPanel = new JPanel();
		tabbedPane.addTab("Crew", null, CrewPanel, null);
		CrewPanel.setLayout(null);
		
		JPanel ShipPanel = new JPanel();
		tabbedPane.addTab("Ship", null, ShipPanel, null);
		GridBagLayout gbl_ShipPanel = new GridBagLayout();
		gbl_ShipPanel.columnWidths = new int[]{638, 0};
		gbl_ShipPanel.rowHeights = new int[]{421, 151, 0};
		gbl_ShipPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_ShipPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		ShipPanel.setLayout(gbl_ShipPanel);
		
		JLabel lblShipimage = new JLabel("Holding Text for ship Image");
		GridBagConstraints gbc_lblShipimage = new GridBagConstraints();
		gbc_lblShipimage.fill = GridBagConstraints.BOTH;
		gbc_lblShipimage.insets = new Insets(0, 0, 5, 0);
		gbc_lblShipimage.gridx = 0;
		gbc_lblShipimage.gridy = 0;
		ShipPanel.add(lblShipimage, gbc_lblShipimage);
		
		JLabel lblTheshipname = new JLabel("The ShipName ");
		lblTheshipname.setFont(new Font("Dialog", Font.BOLD, 24));
		GridBagConstraints gbc_lblTheshipname = new GridBagConstraints();
		gbc_lblTheshipname.anchor = GridBagConstraints.NORTH;
		gbc_lblTheshipname.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTheshipname.insets = new Insets(0, 0, 5, 0);
		gbc_lblTheshipname.gridx = 0;
		gbc_lblTheshipname.gridy = 0;
		ShipPanel.add(lblTheshipname, gbc_lblTheshipname);
		
		JLabel label_3 = new JLabel("Ship Sheilds: 100");
		label_3.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.BOTH;
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 1;
		ShipPanel.add(label_3, gbc_label_3);
		
		JLabel label_2 = new JLabel("Ship Hull: 100");
		label_2.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.NORTH;
		gbc_label_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		ShipPanel.add(label_2, gbc_label_2);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridwidth = 3;
		gbc_panel.gridx = 6;
		gbc_panel.gridy = 2;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{456, 0};
		gbl_panel.rowHeights = new int[]{17, 0, 15, 144, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCrewStats = new JLabel("Crew Stats:");
		lblCrewStats.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCrewStats.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCrewStats.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCrewStats = new GridBagConstraints();
		gbc_lblCrewStats.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCrewStats.insets = new Insets(0, 0, 5, 0);
		gbc_lblCrewStats.gridx = 0;
		gbc_lblCrewStats.gridy = 1;
		panel.add(lblCrewStats, gbc_lblCrewStats);
		
		JLabel lblCrewstatisticsbreakdown = new JLabel("Name:                    Health:                  Action Points:");
		GridBagConstraints gbc_lblCrewstatisticsbreakdown = new GridBagConstraints();
		gbc_lblCrewstatisticsbreakdown.anchor = GridBagConstraints.NORTH;
		gbc_lblCrewstatisticsbreakdown.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCrewstatisticsbreakdown.insets = new Insets(0, 0, 5, 0);
		gbc_lblCrewstatisticsbreakdown.gridx = 0;
		gbc_lblCrewstatisticsbreakdown.gridy = 2;
		panel.add(lblCrewstatisticsbreakdown, gbc_lblCrewstatisticsbreakdown);
		
		JLabel lblCrewStatsLabelMainScreen = new JLabel("Holding Info For Crew Details");
		lblCrewStatsLabelMainScreen.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblCrewStatsLabelMainScreen = new GridBagConstraints();
		gbc_lblCrewStatsLabelMainScreen.fill = GridBagConstraints.BOTH;
		gbc_lblCrewStatsLabelMainScreen.gridx = 0;
		gbc_lblCrewStatsLabelMainScreen.gridy = 3;
		panel.add(lblCrewStatsLabelMainScreen, gbc_lblCrewStatsLabelMainScreen);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 6;
		gbc_scrollPane.gridy = 3;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		JLabel lblGamelog = new JLabel("Game Log:");
		lblGamelog.setFont(new Font("Dialog", Font.BOLD, 15));
		scrollPane.setColumnHeaderView(lblGamelog);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		JLabel ScrollableGameLog = new JLabel("holding text");
		scrollPane.setViewportView(ScrollableGameLog);
	}
}
