package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * Outpost shop
 * @author Cameron Bodger, Grey Harris
 *
 */
public class Outpost {
	
	/**
	 * Random number generator
	 */
	private Random random = new Random();
	/**
	 * Game environment
	 */
	private InitGame initGame;
	/**
	 * ShopList items owned
	 */
	private ShopList shopList;
	/**
	 * ArrayList of all available Consumable objects
	 */
	private ArrayList<Consumable> itemArray = new ArrayList<Consumable>();
	/**
	 * ArrayList of all Consumable name strings
	 */
	private ArrayList<String> itemNameArray;
	/**
	 * ArrayList of all Consumable prices
	 */
	private ArrayList<Integer> shopPrices;



	
	

	/**
	 * Outpost constructor. Builds the item, name, and price arraylists on init
	 * @param initGame
	 */
	public Outpost(InitGame initGame) {
		this.initGame = initGame;
		buildItemArray();
		buildNameAndPriceArrays();
		shopList = new ShopList(this.itemNameArray, itemArray);

	}
		



	/**
	 * Builds the item arraylist
	 */
	public void buildItemArray() {
		for (int i = 1; i < 11; i++) {
			addItem(i);
		}
	}
	
	/**
	 * Builds the name and price arraylists
	 */
	private void buildNameAndPriceArrays() {
		shopPrices = new ArrayList<Integer>();
		itemNameArray = new ArrayList<String>();
		for(Consumable item : itemArray) {
			itemNameArray.add(item.getName());
			shopPrices.add(item.getValue());
		}
		
	}
	
	/**
	 * Uses a switch statement to add Consumables to the item ArrayList
	 * @param i       int switch case, comes from arraylist index
	 */
	private void addItem(int i) {
		switch (i) {
		case 1:
			itemArray.add(new Bandages());
			break;
		case 2:
			itemArray.add(new Medkit());
			break;
		case 3:
			itemArray.add(new Nanites());
			break;
		case 4:
			itemArray.add(new PlagueCure());
			break;
		case 5:
			itemArray.add(new RottenFood());
			break;
		case 6:
			itemArray.add(new SpaceApple());
			break;
		case 7:
			itemArray.add(new SpaceSausage());
			break;
		case 8:
			itemArray.add(new SpaceCandy());
			break;
		case 9:
			itemArray.add(new SpaceRoast());
			break;
		case 10:
			itemArray.add(new MagicMushrooms());
			break;
		}
		
	}
	

	/**
	 * Buys items selected items from the shop. Receives an ArrayList with number of items to buy at each index.
	 * Calculates cost then checks if enough money is available. Returns true if purchase is successful, false otherwise
	 * @param shopItems         ArrayList<Integer> of amounts of each item to buy
	 * @return
	 */
	public boolean buyItems(ArrayList<Integer> shopItems) {
		int price = calculatePrice(shopItems);
		if (price > initGame.getMoney()) {
			raiseNotEnoughMoney(price);
			return false;}
		else {
			initGame.subtractMoney(price);
			String purchase = populateShopList(shopItems);
			initGame.getMainScreen().printToLog(purchase);
			return true;
		}
	}

	/**
	 * Adds each purchased item to the shopList HashMap. 
	 * Returns the string representing a successful purchase, or empty string otherwise
	 * @param shopItems         ArrayList<Integer> of amounts of each item to buy
	 * @return string representing a successful purchase, or empty string otherwise
	 */
	private String populateShopList(ArrayList<Integer> shopItems) {
		int index = 0;
		String purchase = "Purchased: \n";
		boolean madePurchase = false;
		for (int amount : shopItems) {
			//can do it with a for 
			if (amount > 0) {
				String item = itemNameArray.get(index);
				shopList.addItem(item, amount);
				purchase += amount + " " + item + "\n";
				madePurchase = true;
			}
			index += 1;
			
			
		}
		if (!madePurchase) {
			purchase = "";
		}
		return purchase;
		
	}
	
	
	/**
	 * Calculates the price of the total purchase amount
	 * @param shopItems         ArrayList<Integer> of amounts of each item to buy
	 * @return the price of the items to be purchased
	 */
	public int calculatePrice(ArrayList<Integer> shopItems) {
		int price = 0;
		for (int i=0; i < shopItems.size(); i++) {
			price += shopItems.get(i) * this.shopPrices.get(i);	
		}
		return price;
	}

	/**
	 * Returns a warning to the play about failure to purchase
	 * @param price          int total price of items
	 * @return String warning to the play about failure to purchase
	 */
	private String raiseNotEnoughMoney(int price) {
		return "Not enough money.\n Cost is $" + price + " but you only have $" + initGame.getMoney();
	}
	
	/**
	 * Gets the arraylist of item names
	 * @return arraylist of item names
	 */
	public ArrayList<String> getItemNameArray(){
		return this.itemNameArray;
	}

	
	/**
	 * Gets the food items that the play owns
	 * @return arraylist of food items the player owns
	 */
	public ArrayList<Consumable> refreshFoodList(){
		return shopList.getFoodItems();
	}
	
	/**
	 * Gets the healing items that the play owns
	 * @return arraylist of healing items the player owns
	 */
	public ArrayList<Consumable> refreshHealList(){
		return shopList.getMedicalItems();
	}


	/**
	 * Gets the {@code ShopList} object
	 * @return
	 */
	public ShopList getShopList() {
		return this.shopList;
		
	}
	

	/**
	 * Pirate attack! Pirates steal a random item. If item doesn't exist, damage all crew members and steal money instead.
	 * Returns the result of the attack
	 * 
	 * @return string of the result of the pirates attacking
	 */
	public String stealItem() {
		HashMap<String, Integer> items = shopList.getShopMap();
		Integer i = random.nextInt(9);
		//check if there is an item to steal
		Integer total = 0;
		String s = "";
		for (int value : items.values()) {
			total += value;
		}
		if (total == 0) {
			initGame.subtractMoney(200);
			initGame.getCrew().beatUpCrew();
			return "No item to steal. The pirates beat up your crew and took $200";
		}
		else {
			while (s == "") {
				String item = itemNameArray.get(i);
				if (items.get(item) > 0) {
					shopList.removeItem(item);
					s = item;
			}
				else {
					i = random.nextInt(10);
				}
			}
		}
		return "The pirates stole one " + s;
	}	
}
