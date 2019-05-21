package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ShopList. Holds items owned by the player
 * @author c
 *
 */
public class ShopList {
	
	/**
	 * HashMap that maps all items to the amount owned.
	 */
	private HashMap<String, Integer> shopList = new HashMap<String, Integer>();
	/**
	 * ArrayList containing food objects that are owned. Used for JComboboxes in {@code MainScreen}
	 */
	private ArrayList<Consumable> foodItems = new ArrayList<Consumable>();
	/**
	 * ArrayList containing healing objects that are owned. Used for JComboboxes in {@code MainScreen}
	 */
	private ArrayList<Consumable> healItems = new ArrayList<Consumable>();
	/**
	 * ArrayList of all consumable items found in game
	 */
	private ArrayList<Consumable> itemArray;

	
	/**
	 * ShopList constructor. Builds shopList HashMap on init
	 * @param buildList
	 * @param itemArray
	 */
	public ShopList(ArrayList<String> buildList, ArrayList<Consumable> itemArray) {
		this.itemArray = itemArray;
		for (String s : buildList) {
			shopList.put(s, 0);
		}
		buildCurrentItems();
	}
	
	/**
	 * Gets the amount of a particular item owned, based on String name input
	 * @param item      String name of item
	 * @return          int how many owned
	 */
	public int getItem(String item) {
		return shopList.get(item);
	}
	
	/**
	 * Adds item to the shop. Increments the shopList HashMap value of the item.
	 * @param item             String name of item
	 * @param amount           int amount of the item bought
	 */
	public void addItem(String item, int amount) {
		Integer value = shopList.get(item);
		shopList.put(item, value + amount);
	}
	
	/**
	 * Removes an item. Decrements the shopList HashMap value of the item.
	 * 
	 * @param item        String name of item to remove
	 */
	public void removeItem(String item) {
		Integer value = shopList.get(item);
		if (value == 0) {
			System.out.println("Bug. removeItem in shopList tried to decrement an item that doesn't exist");
		}
		else {
			shopList.put(item, value - 1);
	}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format("Bandages: %s\n Medkits: %s\n " + 
								" Nanites: %s\n  Plague Cures: %s\n  " +
				                "Rotten Food: %s\n  Space Sausages: %s\n  " +
								"Space Candy: %s \n  Space Apples: %s \n  " +
				                "Space Roasts: %s \n  Magic Mushrooms: %s",
				                shopList.get("Bandages"), shopList.get("Medkit"),
				                shopList.get("Nanites"),shopList.get("PlagueCure"),
				                shopList.get("RottenFood"),shopList.get("SpaceSausage"),
								shopList.get("SpaceCandy"),shopList.get("SpaceApple"),
				                shopList.get("SpaceRoast"),shopList.get("MagicMushrooms"));		
	}
	/**
	 * Gets the HashMap of player owned items
	 * @return        HashMap of player owned items
	 */
	public HashMap<String, Integer> getShopMap() {
		return this.shopList;
	}
	
	/**
	 * Gets the ArrayList of food items owned by the player
	 * @return
	 */
	public ArrayList<Consumable> getFoodItems(){
		return foodItems;
	}
	
	/**
	 * Gets the ArrayList of healing items owned by the player
	 * @return
	 */
	public ArrayList<Consumable> getMedicalItems(){
		return healItems;
	}
	
	
	
	/**
	 * Reset and build the ArrayLists of food items and healing items. 
	 */
	public void buildCurrentItems(){
		foodItems = new ArrayList<Consumable>();
		healItems = new ArrayList<Consumable>();

		for (Consumable item : itemArray) {
			String name = item.getName();
			if (shopList.get(name) > 0) {
				if (item.getType() == "food") {
					foodItems.add(item);}
				else {
					healItems.add(item);
					}
			}
		}
	}	
}
