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
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import net.miginfocom.swing.MigLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainScreen {

	private JFrame frame;
	private WindowManager manager;
	private InitGame initGame;
	private Crew crew;
	private JLabel lblCrewStatsLabelMainScreen;
	private JLabel lblHealthLabelMainScreen;
	private JLabel lblActionsLabelMainScreen;
	private JLabel refreshedCrewStats;
	private JLabel refreshedCrewHealth;
	private JLabel refreshedCrewActions;
	private JComboBox assignCrewMemberSearchPartsComboBox;
	private JSpinner spinner_RottenFood;
	private JSpinner spinner_SpaceSausage;
	private JSpinner spinner_SpaceCandy;
	private JSpinner spinner_SpaceApple;
	private JSpinner spinner_SpaceRoast;
	private JSpinner spinner_Bandages;
	private JSpinner spinner_Medkit;
	private JSpinner spinner_Nanites;
	private JSpinner spinner_PlagueCure;
	private ArrayList<JSpinner> spinnerArrayList = new ArrayList<JSpinner>();
	private Outpost outpost;




	/* Launch the application.
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

	public MainScreen(WindowManager windowManager) {
		manager = windowManager;
		this.initGame = manager.getInitGame();
		this.crew = initGame.getCrew();
		this.outpost = initGame.getOutpost();
		initialize();
		frame.setVisible(true);
		}

	/**
	 * Initialize the contents of the frame.
	 */
	public void refreshCrewNameLabel() {
		String s = "";
		String format = "%s<br/>";
//		for (Person person : crew.getCrewMemberArray()) {
//			s += person.getName() + "  " + person.getHealth() + " " + "holding action points" + "<br/>";
//		}
		for (Person person : crew.getCrewMemberArray()) {
			s += String.format(format, person.getName());
		}
//		lblCrewStatsLabelMainScreen.setText(crew.getCrewMemberArray());
		refreshedCrewStats.setText("<html>" + s + "</html>");

	}

	public void refreshCrewHealth() {
		String s = "";
		String format = "%s<br/>";
//		for (Person person : crew.getCrewMemberArray()) {
//			s += person.getName() + "  " + person.getHealth() + " " + "holding action points" + "<br/>";
//		}
		for (Person person : crew.getCrewMemberArray()) {
			s += String.format(format, person.getHealth());
		}
//		lblCrewStatsLabelMainScreen.setText(crew.getCrewMemberArray());
		refreshedCrewHealth.setText("<html>" + s + "</html>");

	}

	public void refreshCrewActions() {
		String s = "";
		String format = "%s<br/>";
//		for (Person person : crew.getCrewMemberArray()) {
//			s += person.getName() + "  " + person.getHealth() + " " + "holding action points" + "<br/>";
//		}
		for (Person person : crew.getCrewMemberArray()) {
			s += String.format(format, person.getActions());
		}
//		lblCrewStatsLabelMainScreen.setText(crew.getCrewMemberArray());
		refreshedCrewActions.setText("<html>" + s + "</html>");

	}

	public void updateAll() {
		refreshCrewNameLabel();
		refreshCrewHealth();
		refreshCrewActions();
	}

	public String[] buildCrewArrayForCombos() {
		ArrayList<Person> crewArrayList = crew.getCrewMemberArray();
		String[] crewMembers = new String[crewArrayList.size()];
		for (int i=0; i < crewArrayList.size(); i++ ) {
			crewMembers[i] = crewArrayList.get(i).toString();
		}
		return crewMembers;


	}


	public void getSpinnerValues() {
		ArrayList<Integer> shopItems = new ArrayList<>();
		for (JSpinner spinner: this.spinnerArrayList) {
			int value = (int) spinner.getValue();
			shopItems.add(value);
//			System.out.println(spinner.getValue());
		}
		outpost.buyItems(shopItems);

	}
	public void resetSpinnerValues() {
		for (JSpinner spinner: this.spinnerArrayList) {
			spinner.setValue(0);
		}
	}


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

		JLabel lblShipName = new JLabel(initGame.getShipName());
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

		JLabel lblPartsFound = new JLabel("Parts Found: " + initGame.getCurrentPieces() + "/" + initGame.getPieces());
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

		JLabel lblDaysRemaining = new JLabel("Current Day : " + initGame.getCurrentDay() + "/" + initGame.getDays());
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
		gbl_CurrentPlanetPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_CurrentPlanetPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		CurrentPlanetPanel.setLayout(gbl_CurrentPlanetPanel);

		JLabel lblCurrentPlanetName = new JLabel("Current Planet");
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

		JLabel label = new JLabel("Parts Found: " + initGame.getCurrentPieces() + "/" + initGame.getPieces());
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

		JLabel lblPlanetImageLabel = new JLabel("");
		lblPlanetImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanetImageLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/images/SquarePlanetGIF.gif")));
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

		assignCrewMemberSearchPartsComboBox = new JComboBox(buildCrewArrayForCombos());
		GridBagConstraints gbc_assignCrewMemberSearchPartsComboBox = new GridBagConstraints();
		gbc_assignCrewMemberSearchPartsComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_assignCrewMemberSearchPartsComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_assignCrewMemberSearchPartsComboBox.gridx = 0;
		gbc_assignCrewMemberSearchPartsComboBox.gridy = 6;
		CurrentPlanetPanel.add(assignCrewMemberSearchPartsComboBox, gbc_assignCrewMemberSearchPartsComboBox);

		JPanel TradePanel = new JPanel();
		tabbedPane.addTab("Trade", null, TradePanel, null);
		TradePanel.setLayout(null);

		JLabel lblWelcomeToThe = new JLabel("Welcome to the Space Shop, here for all you space needs");
		lblWelcomeToThe.setFont(new Font("Dialog", Font.BOLD, 14));
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setBounds(22, 12, 638, 43);
		TradePanel.add(lblWelcomeToThe);

		JButton btnPurchaseItems = new JButton("Purchase Items");
		btnPurchaseItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getSpinnerValues();
				resetSpinnerValues();
			}
		});
		btnPurchaseItems.setBounds(401, 551, 249, 66);
		TradePanel.add(btnPurchaseItems);

		JLabel VenderNotelbl = new JLabel("Dear customer please select the items your wish to purchase and then confirm your order");
		VenderNotelbl.setBounds(22, 67, 628, 43);
		TradePanel.add(VenderNotelbl);

		JLabel lblHealingItems = new JLabel("Healing Items");
		lblHealingItems.setFont(new Font("Dialog", Font.BOLD, 17));
		lblHealingItems.setBounds(22, 122, 146, 24);
		TradePanel.add(lblHealingItems);

		JLabel lblBandagesHeal = new JLabel("Item Name:                 Heaing:                    Cost:");
		lblBandagesHeal.setVerticalAlignment(SwingConstants.TOP);
		lblBandagesHeal.setBounds(22, 158, 349, 15);
		TradePanel.add(lblBandagesHeal);

		JLabel lblNewLabel = new JLabel("Bandages                    20                             $50");
		lblNewLabel.setBounds(22, 185, 349, 15);
		TradePanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Medkit                         75                             $100");
		lblNewLabel_1.setBounds(22, 212, 329, 15);
		TradePanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nanites                       200                            $150 ");
		lblNewLabel_2.setBounds(22, 239, 329, 15);
		TradePanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Plague Cure                                                 $100");
		lblNewLabel_3.setBounds(22, 266, 329, 15);
		TradePanel.add(lblNewLabel_3);

		JLabel lblFoodItems = new JLabel("Food Items");
		lblFoodItems.setFont(new Font("Dialog", Font.BOLD, 17));
		lblFoodItems.setBounds(22, 293, 267, 24);
		TradePanel.add(lblFoodItems);

		JLabel lblNewLabel_4 = new JLabel("Rotten Food                  2                               $5");
		lblNewLabel_4.setBounds(22, 361, 349, 15);
		TradePanel.add(lblNewLabel_4);

		JLabel lblItemNameHeaing = new JLabel("Food Name:                 Hunger:                    Cost:");
		lblItemNameHeaing.setBounds(22, 334, 329, 15);
		TradePanel.add(lblItemNameHeaing);

		JLabel lblNewLabel_5 = new JLabel("Space Sausage            20                              $30");
		lblNewLabel_5.setBounds(22, 385, 329, 15);
		TradePanel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Space Candy                10                              $50");
		lblNewLabel_6.setBounds(22, 412, 349, 15);
		TradePanel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Space Apple                 25                              $75");
		lblNewLabel_7.setBounds(22, 439, 329, 15);
		TradePanel.add(lblNewLabel_7);

		JLabel lblSpaceRoast = new JLabel("Space Roast                 100                            $130");
		lblSpaceRoast.setBounds(22, 466, 329, 15);
		TradePanel.add(lblSpaceRoast);

		spinner_Bandages = new JSpinner();
		spinner_Bandages.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_Bandages.setBounds(357, 183, 29, 20);
		TradePanel.add(spinner_Bandages);
		spinnerArrayList.add(spinner_Bandages);

		spinner_Medkit = new JSpinner();
		spinner_Medkit.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_Medkit.setBounds(357, 210, 29, 20);
		TradePanel.add(spinner_Medkit);
		spinnerArrayList.add(spinner_Medkit);

		spinner_Nanites = new JSpinner();
		spinner_Nanites.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_Nanites.setBounds(357, 237, 29, 20);
		TradePanel.add(spinner_Nanites);
		spinnerArrayList.add(spinner_Nanites);

		spinner_PlagueCure = new JSpinner();
		spinner_PlagueCure.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_PlagueCure.setBounds(357, 264, 29, 20);
		TradePanel.add(spinner_PlagueCure);
		spinnerArrayList.add(spinner_PlagueCure);

		spinner_RottenFood = new JSpinner();
		spinner_RottenFood.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_RottenFood.setBounds(357, 359, 29, 20);
		TradePanel.add(spinner_RottenFood);
		spinnerArrayList.add(spinner_RottenFood);

		spinner_SpaceSausage = new JSpinner();
		spinner_SpaceSausage.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_SpaceSausage.setBounds(357, 383, 29, 20);
		TradePanel.add(spinner_SpaceSausage);
		spinnerArrayList.add(spinner_SpaceSausage);

		spinner_SpaceCandy = new JSpinner();
		spinner_SpaceCandy.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_SpaceCandy.setBounds(357, 410, 29, 20);
		TradePanel.add(spinner_SpaceCandy);
		spinnerArrayList.add(spinner_SpaceCandy);

		spinner_SpaceApple = new JSpinner();
		spinner_SpaceApple.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_SpaceApple.setBounds(357, 439, 29, 20);
		TradePanel.add(spinner_SpaceApple);
		spinnerArrayList.add(spinner_SpaceApple);

		spinner_SpaceRoast = new JSpinner();
		spinner_SpaceRoast.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_SpaceRoast.setBounds(357, 464, 29, 20);
		TradePanel.add(spinner_SpaceRoast);
		spinnerArrayList.add(spinner_SpaceRoast);


		JLabel lblSubTotal = new JLabel("Holding Vlaue, subtotal");
		lblSubTotal.setBounds(22, 551, 238, 54);
		TradePanel.add(lblSubTotal);

		JPanel TravelPanel = new JPanel();
		tabbedPane.addTab("Travel", null, TravelPanel, null);
		TravelPanel.setLayout(null);

		JLabel lblCaptain = new JLabel("Captain");
		lblCaptain.setBounds(126, 0, 97, 90);
		lblCaptain.setFont(new Font("Dialog", Font.BOLD, 22));
		TravelPanel.add(lblCaptain);

		JLabel lblCoPilot = new JLabel("Co Pilot");
		lblCoPilot.setBounds(439, 31, 97, 27);
		lblCoPilot.setFont(new Font("Dialog", Font.BOLD, 22));
		TravelPanel.add(lblCoPilot);

		JComboBox comboBox = new JComboBox(buildCrewArrayForCombos());
		comboBox.setBounds(51, 95, 247, 24);
		TravelPanel.add(comboBox);

		JComboBox comboBox_1 = new JComboBox(buildCrewArrayForCombos());
		comboBox_1.setBounds(348, 95, 280, 24);
		TravelPanel.add(comboBox_1);

		JLabel lblCockpitImage = new JLabel("HoldingText for Cockpit Image");
		lblCockpitImage.setIcon(new ImageIcon(MainScreen.class.getResource("/images/hyperspace.jpg")));
		lblCockpitImage.setBounds(12, 175, 638, 211);
		TravelPanel.add(lblCockpitImage);

		JButton btnTravelToNext = new JButton("Travel To Next Planet");
		btnTravelToNext.setBounds(51, 479, 577, 86);
		TravelPanel.add(btnTravelToNext);

		JPanel MedbayPanel = new JPanel();
		tabbedPane.addTab("Medbay", null, MedbayPanel, null);
		MedbayPanel.setLayout(null);

		JComboBox comboBox_Medbay_Select_Crewmember = new JComboBox(buildCrewArrayForCombos() );
		comboBox_Medbay_Select_Crewmember.setToolTipText("Select Crewmember\n");
		comboBox_Medbay_Select_Crewmember.setBounds(12, 487, 313, 24);
		MedbayPanel.add(comboBox_Medbay_Select_Crewmember);

		JButton btnUseHealingItem = new JButton("Use Healing Item");
		btnUseHealingItem.setBounds(359, 487, 291, 68);
		MedbayPanel.add(btnUseHealingItem);

		JLabel lblSelectCrewmember = new JLabel("Select Crewmember");
		lblSelectCrewmember.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectCrewmember.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSelectCrewmember.setBounds(12, 459, 301, 24);
		MedbayPanel.add(lblSelectCrewmember);

		JLabel lblSelectHealingItem = new JLabel("Select Healing Item");
		lblSelectHealingItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectHealingItem.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSelectHealingItem.setBounds(24, 535, 301, 24);
		MedbayPanel.add(lblSelectHealingItem);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setToolTipText("Select Crewmember\n");
		comboBox_3.setBounds(12, 571, 313, 24);
		MedbayPanel.add(comboBox_3);

		JLabel lbl_MedicalBay_Image = new JLabel("Nice Big medical bay image");
		lbl_MedicalBay_Image.setIcon(new ImageIcon(MainScreen.class.getResource("/images/medbaysnip.png")));
		lbl_MedicalBay_Image.setFont(new Font("Dialog", Font.BOLD, 19));
		lbl_MedicalBay_Image.setBounds(12, 12, 638, 439);
		MedbayPanel.add(lbl_MedicalBay_Image);

		JPanel CrewPanel = new JPanel();
		tabbedPane.addTab("Crew", null, CrewPanel, null);
		CrewPanel.setLayout(null);

		JComboBox comboBox_SelectCrewmember_CrewTab = new JComboBox(buildCrewArrayForCombos());
		comboBox_SelectCrewmember_CrewTab.setToolTipText("Select Crewmember\n");
		comboBox_SelectCrewmember_CrewTab.setBounds(12, 502, 313, 24);
		CrewPanel.add(comboBox_SelectCrewmember_CrewTab);

		JComboBox comboBox_SelectFood_CrewTab = new JComboBox();
		comboBox_SelectFood_CrewTab.setToolTipText("Select Crewmember\n");
		comboBox_SelectFood_CrewTab.setBounds(12, 560, 313, 24);
		CrewPanel.add(comboBox_SelectFood_CrewTab);

		JButton button_Sleep_CrewTab = new JButton("Sleep");
		button_Sleep_CrewTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshCrewNameLabel();
			}
		});
		button_Sleep_CrewTab.setBounds(359, 502, 291, 60);
		CrewPanel.add(button_Sleep_CrewTab);

		JButton btnEatFood = new JButton("Eat Food");
		btnEatFood.setBounds(359, 560, 291, 68);
		CrewPanel.add(btnEatFood);

		JLabel label_1 = new JLabel("Select Crewmember");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBounds(22, 478, 301, 24);
		CrewPanel.add(label_1);

		JLabel lblSelectFoodTo = new JLabel("Select Food To Eat");
		lblSelectFoodTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectFoodTo.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSelectFoodTo.setBounds(22, 538, 301, 24);
		CrewPanel.add(lblSelectFoodTo);

		JLabel LblCrewTabHeader = new JLabel("Name:                    Health:                  Action Points:");
		LblCrewTabHeader.setBounds(12, 12, 638, 24);
		CrewPanel.add(LblCrewTabHeader);

		JPanel ShipPanel = new JPanel();
		tabbedPane.addTab("Ship", null, ShipPanel, null);
		ShipPanel.setLayout(null);

		JLabel ShipImageShipTab = new JLabel("HoldingTextShipImage");
		ShipImageShipTab.setIcon(new ImageIcon(MainScreen.class.getResource("/images/FireflyResized.png")));
		ShipImageShipTab.setBounds(12, 0, 638, 404);
		ShipPanel.add(ShipImageShipTab);

		JLabel ShipTabSheildsValue = new JLabel("Shields:  100/100");
		ShipTabSheildsValue.setFont(new Font("Dialog", Font.BOLD, 18));
		ShipTabSheildsValue.setBounds(117, 416, 199, 34);
		ShipPanel.add(ShipTabSheildsValue);

		JLabel ShipTabHullValue = new JLabel("Hull:  100/100");
		ShipTabHullValue.setFont(new Font("Dialog", Font.BOLD, 18));

		ShipTabHullValue.setBounds(352, 416, 169, 34);
		ShipPanel.add(ShipTabHullValue);

		JComboBox ShipTabAsignRepairman = new JComboBox(buildCrewArrayForCombos());
		ShipTabAsignRepairman.setBounds(237, 493, 199, 24);
		ShipPanel.add(ShipTabAsignRepairman);

		JLabel ShipTabAssignRepairmanLabel = new JLabel("Assign Repairman");
		ShipTabAssignRepairmanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ShipTabAssignRepairmanLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		ShipTabAssignRepairmanLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		ShipTabAssignRepairmanLabel.setBounds(237, 462, 199, 24);
		ShipPanel.add(ShipTabAssignRepairmanLabel);

		JButton ShipTabRepairSheildButton = new JButton("Repair Shields");
		ShipTabRepairSheildButton.setBounds(117, 527, 199, 45);
		ShipPanel.add(ShipTabRepairSheildButton);

		JButton ShipTabRepairHull = new JButton("Repair Hull");
		ShipTabRepairHull.setBounds(352, 529, 169, 43);
		ShipPanel.add(ShipTabRepairHull);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridwidth = 3;
		gbc_panel.gridx = 6;
		gbc_panel.gridy = 2;
		frame.getContentPane().add(panel, gbc_panel);

		JLabel lblCrewStats = new JLabel("Crew Stats:");
		lblCrewStats.setBounds(0, 30, 92, 17);
		lblCrewStats.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCrewStats.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCrewStats.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblCrewStats);

		JLabel lblCrewstatisticsbreakdown = new JLabel("Name:                    Health:                  Action Points:");
		lblCrewstatisticsbreakdown.setBounds(0, 52, 456, 15);
		panel.add(lblCrewstatisticsbreakdown);



		lblCrewStatsLabelMainScreen = new JLabel("Holding Info For Crew Details");
		lblCrewStatsLabelMainScreen.setBounds(0, 72, 122, 144);
		lblCrewStatsLabelMainScreen.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblCrewStatsLabelMainScreen);
		refreshedCrewStats = lblCrewStatsLabelMainScreen;
		refreshCrewNameLabel();


		lblHealthLabelMainScreen = new JLabel("");
		lblHealthLabelMainScreen.setBounds(123, 72, 113, 144);
		lblHealthLabelMainScreen.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblHealthLabelMainScreen);
		refreshedCrewHealth = lblHealthLabelMainScreen;
		refreshCrewHealth();

		lblActionsLabelMainScreen = new JLabel("");
		lblActionsLabelMainScreen.setBounds(248, 72, 122, 144);
		lblActionsLabelMainScreen.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblActionsLabelMainScreen);
		refreshedCrewActions = lblActionsLabelMainScreen;
		refreshCrewActions();

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
