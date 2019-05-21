package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import net.miginfocom.swing.MigLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

/**
 * Main gameplay window
 *
 */
public class MainScreen {


	private JFrame frame;
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
	 * Jlabel displays crew stat title
	 */
	private JLabel lblCrewStatsLabelMainScreen;
	/**
	 * JLabel displays crew members health
	 */
	private JLabel lblHealthLabelMainScreen;
	/**
	 * JLabel displays crew members actions
	 */
	private JLabel lblActionsLabelMainScreen;
	private JLabel refreshedCrewStats;
	private JLabel refreshedCrewHealth;
	private JLabel refreshedCrewActions;
	/**
	 * JComboBox assign crew member to search planet
	 */
	private JComboBox<Person> assignCrewMemberSearchPartsComboBox;
	private JSpinner spinner_RottenFood;
	private JSpinner spinner_SpaceSausage;
	private JSpinner spinner_SpaceCandy;
	private JSpinner spinner_SpaceApple;
	private JSpinner spinner_SpaceRoast;
	private JLabel lblHealingOwnedItems;
	private JLabel lblFoodItemsOwned;
	private JSpinner spinner_Bandages;
	private JSpinner spinner_Medkit;
	private JSpinner spinner_Nanites;
	private JSpinner spinner_PlagueCure;
	private JSpinner spinner_MagicMushrooms;
	/**
	 * ArrayList that holds the spinners for buying items
	 */
	private ArrayList<JSpinner> spinnerArrayList = new ArrayList<JSpinner>();
	/**
	 * Outpost object 
	 */
	private Outpost outpost;
	private JTextArea ScrollableGameLog;
	private JLabel labelPieces;
	/**
	 * JComboBox select first pilot
	 */
	private JComboBox<Person> comboBox;
	/**
	 * JComboBox select second pilot
	 */
	private JComboBox<Person> comboBoxPilot2;
	/**
	 * JComboBox select person to heal
	 */
	private JComboBox<Person> comboBox_Medbay_Select_Crewmember;
	/**
	 * JComboBox select crew member to sleep or eat
	 */
	private JComboBox<Person> comboBox_SelectCrewmember_CrewTab;
	/**
	 * JComboBox select crew member to repair
	 */
	private JComboBox<Person> ShipTabAsignRepairman;
	/**
	 * JComboBox select heal item
	 */
	private JComboBox<Consumable> comboBoxHealItem;
	/**
	 * JComboBox to select food items in the crew tab
	 */
	private JComboBox<Consumable> comboBox_SelectFood_CrewTab;
	private JLabel lblPartsFound;
	private JLabel lblShipHull;
	private JLabel lblShipSheilds;
	private JLabel lblSpaceCash;
	private JLabel lblPartsRemainingOnPlanetLabel;
	private JLabel lblDaysRemaining;
	private JLabel lblCurrentPlanetName;
	private JTextArea textAreaCrewStatus;
	private JLabel lblFoodInfo;
	private JLabel lblItemInfo;
	private JLabel ShipTabSheildsValue;
	private JLabel ShipTabHullValue;



	/**
	 * MainScreen constructor. Initialize window and set visible
	 * @param windowManager        {@code WindowManager} handles opening and closing windows
	 */
	public MainScreen(WindowManager windowManager) {
		manager = windowManager;
		this.initGame = manager.getInitGame();
		this.crew = initGame.getCrew();
		this.outpost = initGame.getOutpost();
		initialize();
		frame.setVisible(true);
		}


	
	
	/**
	 * Close the window by disposing the JFrame
	 */
	public void closeWindow() {
		frame.dispose();
		
	}

	/**
	 * Updates the planet name after flying to a new planet
	 * @param planetName         String planet name
	 */
	public void updatePlanetName(String planetName) {
		lblCurrentPlanetName.setText(planetName);
		
	}
	
	/**
	 * Refresh the days passed label
	 */
	public void updateDay() {
		String s = "Current Day : " + initGame.getCurrentDay() + "/" + initGame.getDays();
		lblDaysRemaining.setText(s);
	}
	
	/**
	 * Causes the selected crew member to have a nice nap
	 */
	protected void sleepPerson() {
		Person person = (Person) comboBox_SelectCrewmember_CrewTab.getSelectedItem();
		String sleepResult = person.personSleep();
		printToLog(sleepResult);
		updateAll();
	}
	
	/**
	 * Refresh the Crew Stats info in the main window
	 */
	public void refreshCrewNameLabel() {
		String name = "";
		String actions = "";
		String health = "";
		String format = "%s<br/>";
		String healthFormat = "%s/%s<br/>";
		for (Person person : crew.getCrewMemberArray()) {
			name += String.format(format, person.getName());
			health += String.format(healthFormat, person.getHealth(), person.getMaxHealth());
			actions += String.format(format, person.getActions());
		}
		refreshedCrewStats.setText("<html>" + name + "</html>");
		refreshedCrewHealth.setText("<html>" + health + "</html>");
		refreshedCrewActions.setText("<html>" + actions + "</html>");
	}

	/**
	 * Updates the crew status label
	 */
	public void refreshCrewStatus() {
		ArrayList<Person> crewArray = crew.getCrewMemberArray();
		String crewStatusText = "";
		for (Person person : crewArray) {
			crewStatusText += person.getPersonStatus();
		}
		textAreaCrewStatus.setText(crewStatusText);
		
	}
	
	/**
	 * Displays information about the selected food item
	 */
	public void displayFoodInfo() {
		if (comboBox_SelectFood_CrewTab.getItemCount() > 0){
			Consumable food = (Consumable) comboBox_SelectFood_CrewTab.getSelectedItem();
			int amount = outpost.getShopList().getItem(food.getName());
			String s = "<html>" + food.getName() + " satiate " + food.getHunger() + 
					" hunger.</br> You currently own " + amount + "</html>";
			lblFoodInfo.setText(s);}
	}

	/**
	 * Displays information about the selected medical item
	 */
	public void displayHealItemInfo() {
		if (comboBoxHealItem.getItemCount() > 0) {
			Consumable item = (Consumable) comboBoxHealItem.getSelectedItem();
			int amount = outpost.getShopList().getItem(item.getName());
			String s = "<html>" + item.getName() + " heals " + item.getHealing() + 
					" health.</br> You currently own " + amount + "</html>";
			lblItemInfo.setText(s);
		}
	}
	
	/**
	 * calls the updateFoodCombo() and updateMedicalCombo() methods 
	 */
	public void updateItemCombos() {
		updateFoodCombo();
		updateMedicalCombo();
	}
	
	/**
	 * Refreshes the food combo box items
	 */
	protected void updateFoodCombo() {
		comboBox_SelectFood_CrewTab.removeAllItems();
		outpost.getShopList().buildCurrentItems();
		ArrayList<Consumable> foodList = outpost.getShopList().getFoodItems();
		if (foodList.size() > 0){
			for (Consumable item : foodList) {
				comboBox_SelectFood_CrewTab.addItem(item);
			}
		}
	}
	
	/**
	 * Refreshes the medical combo box items
	 */
	protected void updateMedicalCombo() {
		comboBoxHealItem.removeAllItems();
		outpost.getShopList().buildCurrentItems();
		ArrayList<Consumable> healList = outpost.getShopList().getMedicalItems();
		for (Consumable item :healList) {
			comboBoxHealItem.addItem(item);
		}
	}
	
	/**
	 * Eat food item on button click. Checks if item exist, gets item and person, attempts action then either eats or fails
	 */
	protected void eatFood() {
		if (comboBox_SelectFood_CrewTab.getItemCount() == 0){
			printToLog("You have no food. \nThe Space Shop has a selection of snacks for hungry space explorers");
		}
		else {
			Person person = (Person) comboBox_SelectCrewmember_CrewTab.getSelectedItem();
			Consumable item = (Consumable) comboBox_SelectFood_CrewTab.getSelectedItem();
			if (person.attemptSleepOrEat()) {
				ConsumeItem consume = new ConsumeItem(item, person);
				String result = consume.consume();
				outpost.getShopList().removeItem(item.getName());
				printToLog(result);
				updateFoodCombo();
			}
			else {
				printToLog(person.failedAction());
			}
		}
	}

	
	/**
	 * Use healing item on heal button click. Checks if item exist, gets item and person, attempts action then either heals or fails
	 */
	public void useHeal() {
		if (comboBoxHealItem.getItemCount() == 0){
			printToLog("You have no heal items. \nThe friendly Space Shop will have what you need");
		}
		else {
			
			Person person = (Person) comboBox_Medbay_Select_Crewmember.getSelectedItem();
			Consumable item = (Consumable) comboBoxHealItem.getSelectedItem();
			if (person.attemptAction()) {
				ConsumeItem consume = new ConsumeItem(item, person);
				String result = consume.consume();
				outpost.getShopList().removeItem(item.getName());
				printToLog(result);
				updateMedicalCombo();
			}
			else {
				printToLog(person.failedAction());
			}
		}
	}
	
	/**
	 * Refresh found pieces label
	 */
	public void refreshPieces() {
		String s = "Parts Found: " + initGame.getCurrentPieces() + "/" + initGame.getPieces();
		labelPieces.setText(s);
	}
	
	/**
	 * Refresh owned items labels
	 */
	public void refreshOwnedItems() { 
		String h = "";
		String f = "";
		for(Consumable Item : outpost.getShopList().getMedicalItems()) {
			h += Item + ": " + outpost.getShopList().getItem(Item.getName());
			h += "<br/>";
		String heal = "<html>Healing Items Owned:<br/>";
		heal += h + "</html>";
		lblHealingOwnedItems.setText(heal);
		}
		for(Consumable ConsumableItem : outpost.getShopList().getFoodItems()) {
			f += ConsumableItem + ": " + outpost.getShopList().getItem(ConsumableItem.getName());
			f += "<br/>";
		String food = "<html>Food Items Owned:<br/>";
		food += f + "</html>";
		lblFoodItemsOwned.setText(food); 
		}

		
		
	}
	
	/**
	 * Refresh ship health label
	 */
	public void refreshShipHealth() {
		
		String hullFormat = "Ship Hull: %.0f/100";
		String shieldFormat = "Ship Shield: %.0f/100";
		String hullText = String.format(hullFormat, initGame.getShip().getShipHealth());
		String shieldText = String.format(shieldFormat, initGame.getShip().getShipSheild());
		lblShipHull.setText(hullText);
		ShipTabHullValue.setText(hullText);
		lblShipSheilds.setText(shieldText);
		ShipTabSheildsValue.setText(shieldText);
	}
	
	/**
	 * Repairs ship hull on button click. Gets selected crew member, attempts action and either repairs or fails
	 */
	public void repairHullClick() {
		Person person = (Person) ShipTabAsignRepairman.getSelectedItem();
		String result = "";
		if (person.attemptAction()) {
			Ship ship = initGame.getShip();
			RepairShip repair = new RepairShip(ship, person);
			result = repair.repairShipHull();
			updateAll();
			
		}
		else {
			result =  person.failedAction();
		}
		printToLog(result);
	}
	
	/**
	 * Repairs ship shield on button click. Gets selected crew member, attempts action and either repairs or fails
	 */
	public void repairShieldClick() {
		Person person = (Person) ShipTabAsignRepairman.getSelectedItem();
		String result = "";
		if (person.attemptAction()) {
			Ship ship = initGame.getShip();
			RepairShip repair = new RepairShip(ship, person);
			result = repair.repairShipShield();
			updateAll();
		}
		else {
			result = person.failedAction();
		}
		printToLog(result);
	}
	
	/**
	 * Refresh the space cash label after state change
	 */
	public void refreshMoney() {
		String s = "Space Cash: $" + initGame.getMoney();
		lblSpaceCash.setText(s);
	}


	
	/**
	 * Update the parts found labels if a piece is found
	 */
	public void updatePartsFound() {
		String s = "Parts Found: " + initGame.getCurrentPieces() + "/" + initGame.getPieces();
		lblPartsFound.setText(s);
		String parts = "Parts on Planet: "+ initGame.getPlanet().pieces() + "/1";
		lblPartsRemainingOnPlanetLabel.setText(parts);
	}

	/**
	 * Updates all necessary labels after a state change, and checks for game over
	 */
	public void updateAll() {
		refreshOwnedItems();
		refreshCrewStatus();
		refreshCrewNameLabel();
		refreshPieces();
		refreshShipHealth();
		updatePartsFound();
		updateDay();
		refreshMoney();
		updateItemCombos();
		if (initGame.isGameOver()) {
			manager.launchGameOverScreen();
			closeWindow();
		}
		
	}

	/**
	 * Builds the JComboBox crew members. On rebuild, skips dead crew
	 */
	public void buildCrewMemberCombos() {
		assignCrewMemberSearchPartsComboBox.removeAllItems();
		comboBox.removeAllItems();
		comboBoxPilot2.removeAllItems();
		comboBox_Medbay_Select_Crewmember.removeAllItems();
		comboBox_SelectCrewmember_CrewTab.removeAllItems();
		ShipTabAsignRepairman.removeAllItems();

		for (Person person : crew.getCrewMemberArray()) {
			//add person to all combos, except if dead
			if (!person.isDead()) {
				assignCrewMemberSearchPartsComboBox.addItem(person);
				comboBox.addItem(person);
				comboBoxPilot2.addItem(person);
				comboBox_Medbay_Select_Crewmember.addItem(person);
				comboBox_SelectCrewmember_CrewTab.addItem(person);
				ShipTabAsignRepairman.addItem(person);
			}
		}
		if (comboBoxPilot2.getItemCount() == 0) {
			initGame.gameOver("Everyone's dead");
			updateAll();
		}
		
	}

	/**
	 * Gets the shop spinner values and attempts to buy selected items
	 */
	public void getSpinnerValues() {
		ArrayList<Integer> shopItems = new ArrayList<>();
		for (JSpinner spinner: this.spinnerArrayList) {
			int value = (int) spinner.getValue();
			shopItems.add(value);
		}
		if (outpost.buyItems(shopItems)) {
			System.out.println("Success");
		}
		else {
			printToLog("Not enough cash");
		};
		updateItemCombos();

	}
	/**
	 * Resets the shop purchase spinners to 0
	 */
	public void resetSpinnerValues() {
		for (JSpinner spinner: this.spinnerArrayList) {
			spinner.setValue(0);
		}
	}
	/**
	 * Print message to scollable log
	 * 
	 * @param s          String message to print
	 */
	public void printToLog(String s) {
		String currentLog = ScrollableGameLog.getText();
		ScrollableGameLog.setText(currentLog + s + "\n");
		
	}
	/**
	 * Get selected crew member and search the planet
	 */
	private void searchPlanet() {
		String name = assignCrewMemberSearchPartsComboBox.getSelectedItem().toString();
		String searchResult = initGame.searchPlanet(name);
		printToLog(searchResult);
		updateAll();
	}
	
	/**
	 * Get 2 selected pilots and travel to a new planet
	 */
	protected void travelToPlanet() {
		Person pilot1 = (Person) comboBox.getSelectedItem();
		Person pilot2 = (Person) comboBoxPilot2.getSelectedItem();
		if (pilot1 == pilot2) {
			printToLog("Select two pilots.");
		}
		else if (initGame.travelToNewPlanet(pilot1, pilot2)) {
			System.out.println("Let's go!");		
		}
		updateAll();

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

		JLabel lblShipName = new JLabel(initGame.getShipName());
		lblShipName.setFont(new Font("Dialog", Font.BOLD, 18));
		GridBagConstraints gbc_lblShipName = new GridBagConstraints();
		gbc_lblShipName.fill = GridBagConstraints.BOTH;
		gbc_lblShipName.insets = new Insets(0, 0, 5, 5);
		gbc_lblShipName.gridx = 0;
		gbc_lblShipName.gridy = 0;
		frame.getContentPane().add(lblShipName, gbc_lblShipName);

		lblShipHull = new JLabel("Ship Hull: 100");
		lblShipHull.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblShipHull = new GridBagConstraints();
		gbc_lblShipHull.fill = GridBagConstraints.BOTH;
		gbc_lblShipHull.insets = new Insets(0, 0, 5, 5);
		gbc_lblShipHull.gridx = 2;
		gbc_lblShipHull.gridy = 0;
		frame.getContentPane().add(lblShipHull, gbc_lblShipHull);

		lblShipSheilds = new JLabel("Ship Shield: 100");
		lblShipSheilds.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblShipSheilds = new GridBagConstraints();
		gbc_lblShipSheilds.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblShipSheilds.insets = new Insets(0, 0, 5, 5);
		gbc_lblShipSheilds.gridx = 3;
		gbc_lblShipSheilds.gridy = 0;
		frame.getContentPane().add(lblShipSheilds, gbc_lblShipSheilds);

		lblPartsFound = new JLabel("Parts Found: " + initGame.getCurrentPieces() + "/" + initGame.getPieces());
		lblPartsFound.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblPartsFound = new GridBagConstraints();
		gbc_lblPartsFound.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPartsFound.insets = new Insets(0, 0, 5, 5);
		gbc_lblPartsFound.gridx = 6;
		gbc_lblPartsFound.gridy = 0;
		frame.getContentPane().add(lblPartsFound, gbc_lblPartsFound);

		lblSpaceCash = new JLabel("Space Cash: $" + initGame.getMoney());
		lblSpaceCash.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblSpaceCash = new GridBagConstraints();
		gbc_lblSpaceCash.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSpaceCash.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpaceCash.gridx = 7;
		gbc_lblSpaceCash.gridy = 0;
		frame.getContentPane().add(lblSpaceCash, gbc_lblSpaceCash);

		lblDaysRemaining = new JLabel("Current Day : " + initGame.getCurrentDay() + "/" + initGame.getDays());
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

		lblCurrentPlanetName = new JLabel("Current Planet");
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

		labelPieces = new JLabel("Parts Found: " + initGame.getCurrentPieces() + "/" + initGame.getPieces());
		labelPieces.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTH;
		gbc_label.fill = GridBagConstraints.HORIZONTAL;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridwidth = 2;
		gbc_label.gridx = 3;
		gbc_label.gridy = 0;
		CurrentPlanetPanel.add(labelPieces, gbc_label);

		lblPartsRemainingOnPlanetLabel = new JLabel("Parts on Planet: 1/1");
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
		btnSearchForPartsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchPlanet();
				updateAll();
			}


		});
		GridBagConstraints gbc_btnSearchForPartsButton = new GridBagConstraints();
		gbc_btnSearchForPartsButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchForPartsButton.fill = GridBagConstraints.BOTH;
		gbc_btnSearchForPartsButton.gridheight = 2;
		gbc_btnSearchForPartsButton.gridx = 3;
		gbc_btnSearchForPartsButton.gridy = 5;
		CurrentPlanetPanel.add(btnSearchForPartsButton, gbc_btnSearchForPartsButton);

		assignCrewMemberSearchPartsComboBox = new JComboBox<Person>();
		GridBagConstraints gbc_assignCrewMemberSearchPartsComboBox = new GridBagConstraints();
		gbc_assignCrewMemberSearchPartsComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_assignCrewMemberSearchPartsComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_assignCrewMemberSearchPartsComboBox.gridx = 0;
		gbc_assignCrewMemberSearchPartsComboBox.gridy = 6;
		CurrentPlanetPanel.add(assignCrewMemberSearchPartsComboBox, gbc_assignCrewMemberSearchPartsComboBox);

		JPanel TradePanel = new JPanel();
		tabbedPane.addTab("Space Outpost", null, TradePanel, null);
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
				refreshMoney();
				updateFoodCombo();
				updateMedicalCombo();
				updateAll();
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

		JLabel lblBandagesHeal = new JLabel("Item Name:                 Heaing:                    Cost:  ");
		lblBandagesHeal.setVerticalAlignment(SwingConstants.TOP);
		lblBandagesHeal.setBounds(22, 158, 558, 15);
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

		spinner_MagicMushrooms = new JSpinner();
		spinner_MagicMushrooms.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_MagicMushrooms.setBounds(357, 491, 29, 17);
		TradePanel.add(spinner_MagicMushrooms);
		spinnerArrayList.add(spinner_MagicMushrooms);

		JLabel lblSubTotal = new JLabel("");
		lblSubTotal.setBounds(22, 551, 238, 54);
		TradePanel.add(lblSubTotal);
		
		JLabel LblMushrooms = new JLabel("Magic Mushrooms       200                            $200");
		LblMushrooms.setBounds(22, 493, 329, 15);
		TradePanel.add(LblMushrooms);
		
		lblHealingOwnedItems = new JLabel("No Healing items owned");
		lblHealingOwnedItems.setVerticalAlignment(SwingConstants.TOP);
		lblHealingOwnedItems.setBounds(422, 171, 215, 129);
		//ArrayList<Consumable> healList = outpost.getShopList().getMedicalItems();
		
		TradePanel.add(lblHealingOwnedItems);
		
		lblFoodItemsOwned = new JLabel("No Food items owned");
		lblFoodItemsOwned.setVerticalAlignment(SwingConstants.TOP);
		lblFoodItemsOwned.setBounds(422, 341, 215, 186);
		TradePanel.add(lblFoodItemsOwned);

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

		comboBox = new JComboBox<Person>();
		comboBox.setBounds(51, 95, 247, 24);
		TravelPanel.add(comboBox);

		comboBoxPilot2 = new JComboBox<Person>();
		comboBoxPilot2.setBounds(348, 95, 280, 24);
		TravelPanel.add(comboBoxPilot2);

		JLabel lblCockpitImage = new JLabel("HoldingText for Cockpit Image");
		lblCockpitImage.setIcon(new ImageIcon(MainScreen.class.getResource("/images/hyperspace.jpg")));
		lblCockpitImage.setBounds(12, 175, 638, 211);
		TravelPanel.add(lblCockpitImage);

		JButton btnTravelToNext = new JButton("Travel To Next Planet");
		btnTravelToNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				travelToPlanet();
				updateAll();
			}
		});
		btnTravelToNext.setBounds(51, 479, 577, 86);
		TravelPanel.add(btnTravelToNext);

		JPanel MedbayPanel = new JPanel();
		tabbedPane.addTab("Medbay", null, MedbayPanel, null);
		MedbayPanel.setLayout(null);

		comboBox_Medbay_Select_Crewmember = new JComboBox<Person>();
		comboBox_Medbay_Select_Crewmember.setToolTipText("Select Crewmember\n");
		comboBox_Medbay_Select_Crewmember.setBounds(12, 487, 313, 24);
		MedbayPanel.add(comboBox_Medbay_Select_Crewmember);

		JButton btnUseHealingItem = new JButton("Use Healing Item");
		btnUseHealingItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				useHeal();
				updateAll();
			}
		});
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

		comboBoxHealItem = new JComboBox<Consumable>();
		comboBoxHealItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayHealItemInfo();
			}
		});
		comboBoxHealItem.setToolTipText("Select Crewmember\n");
		comboBoxHealItem.setBounds(12, 571, 313, 24);
		MedbayPanel.add(comboBoxHealItem);

		JLabel lbl_MedicalBay_Image = new JLabel("Nice Big medical bay image");
		lbl_MedicalBay_Image.setIcon(new ImageIcon(MainScreen.class.getResource("/images/medbaysnip.png")));
		lbl_MedicalBay_Image.setFont(new Font("Dialog", Font.BOLD, 19));
		lbl_MedicalBay_Image.setBounds(12, 12, 638, 439);
		MedbayPanel.add(lbl_MedicalBay_Image);
		
		lblItemInfo = new JLabel("");
		lblItemInfo.setBounds(22, 607, 303, 30);
		MedbayPanel.add(lblItemInfo);

		JPanel CrewPanel = new JPanel();
		tabbedPane.addTab("Crew", null, CrewPanel, null);
		CrewPanel.setLayout(null);

		comboBox_SelectCrewmember_CrewTab = new JComboBox<Person>();
		comboBox_SelectCrewmember_CrewTab.setToolTipText("Select Crewmember\n");
		comboBox_SelectCrewmember_CrewTab.setBounds(12, 502, 313, 24);
		CrewPanel.add(comboBox_SelectCrewmember_CrewTab);
		
		
		comboBox_SelectFood_CrewTab = new JComboBox<Consumable>();
		comboBox_SelectFood_CrewTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayFoodInfo();
			}
		});
		comboBox_SelectFood_CrewTab.setToolTipText("Select Crewmember\n");
		comboBox_SelectFood_CrewTab.setBounds(12, 560, 313, 24);
		CrewPanel.add(comboBox_SelectFood_CrewTab);

		JButton button_Sleep_CrewTab = new JButton("Sleep");
		button_Sleep_CrewTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sleepPerson();
			}
		});
		button_Sleep_CrewTab.setBounds(359, 502, 291, 60);
		CrewPanel.add(button_Sleep_CrewTab);

		JButton btnEatFood = new JButton("Eat Food");
		btnEatFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eatFood();
				updateAll();
			}
		});
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
		
		Integer spaceValue = 20;
		String spacing = new String(new char[spaceValue]).replace("\0", " ");
		String headerString = "Name:" + spacing + "Race:" + spacing + "Hunger:"+ spacing + "Vigour:"+ spacing + "Status:";
		JLabel LblCrewTabHeader = new JLabel(headerString);
		LblCrewTabHeader.setBounds(12, 12, 638, 24);
		CrewPanel.add(LblCrewTabHeader);
		
		textAreaCrewStatus = new JTextArea();
		textAreaCrewStatus.setBounds(12, 52, 635, 387);
		CrewPanel.add(textAreaCrewStatus);
		
		lblFoodInfo = new JLabel("");
		lblFoodInfo.setBounds(12, 587, 313, 41);
		CrewPanel.add(lblFoodInfo);
		refreshCrewStatus();

		JPanel ShipPanel = new JPanel();
		tabbedPane.addTab("Ship", null, ShipPanel, null);
		ShipPanel.setLayout(null);

		JLabel ShipImageShipTab = new JLabel("HoldingTextShipImage");
		ShipImageShipTab.setIcon(new ImageIcon(MainScreen.class.getResource("/images/FireflyResized.png")));
		ShipImageShipTab.setBounds(12, 0, 638, 404);
		ShipPanel.add(ShipImageShipTab);

		ShipTabSheildsValue = new JLabel("Shields:  100/100");
		ShipTabSheildsValue.setFont(new Font("Dialog", Font.BOLD, 18));
		ShipTabSheildsValue.setBounds(117, 416, 199, 34);
		ShipPanel.add(ShipTabSheildsValue);

		ShipTabHullValue = new JLabel("Hull:  100/100");
		ShipTabHullValue.setFont(new Font("Dialog", Font.BOLD, 18));

		ShipTabHullValue.setBounds(352, 416, 185, 34);
		ShipPanel.add(ShipTabHullValue);

		ShipTabAsignRepairman = new JComboBox<Person>();
		ShipTabAsignRepairman.setBounds(237, 493, 199, 24);
		ShipPanel.add(ShipTabAsignRepairman);

		JLabel ShipTabAssignRepairmanLabel = new JLabel("Assign Repairman");
		ShipTabAssignRepairmanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ShipTabAssignRepairmanLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		ShipTabAssignRepairmanLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		ShipTabAssignRepairmanLabel.setBounds(237, 462, 199, 24);
		ShipPanel.add(ShipTabAssignRepairmanLabel);

		JButton ShipTabRepairSheildButton = new JButton("Repair Shields");
		ShipTabRepairSheildButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repairShieldClick();
			}
		});
		ShipTabRepairSheildButton.setBounds(117, 527, 199, 45);
		ShipPanel.add(ShipTabRepairSheildButton);

		JButton ShipTabRepairHull = new JButton("Repair Hull");
		ShipTabRepairHull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repairHullClick();
			}
		});
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


		lblHealthLabelMainScreen = new JLabel("");
		lblHealthLabelMainScreen.setBounds(123, 72, 113, 144);
		lblHealthLabelMainScreen.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblHealthLabelMainScreen);
		refreshedCrewHealth = lblHealthLabelMainScreen;
//		refreshCrewHealth();

		lblActionsLabelMainScreen = new JLabel("");
		lblActionsLabelMainScreen.setBounds(248, 72, 122, 144);
		lblActionsLabelMainScreen.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblActionsLabelMainScreen);
		refreshedCrewActions = lblActionsLabelMainScreen;
		refreshCrewNameLabel();

		JButton btnEndDay = new JButton("End day");
		btnEndDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initGame.endDay();
				updateAll();
			}
		});
		btnEndDay.setBounds(333, 187, 115, 29);
		panel.add(btnEndDay);
		
		JLabel lblNextDay = new JLabel("Proceed to next day:");
		lblNextDay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNextDay.setBounds(168, 187, 154, 29);
		panel.add(lblNextDay);
//		refreshCrewActions();

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

		ScrollableGameLog = new JTextArea("");
		scrollPane.setViewportView(ScrollableGameLog);
		buildCrewMemberCombos();

	}

}
