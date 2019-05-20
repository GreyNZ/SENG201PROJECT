package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShopList {
	
	private HashMap<String, Integer> shopList = new HashMap<String, Integer>();
	private ArrayList<Consumable> foodItems = new ArrayList<Consumable>();
	private ArrayList<Consumable> healItems = new ArrayList<Consumable>();
	private ArrayList<Consumable> itemArray;
	private ArrayList<Consumable> foodList;
	private ArrayList<Consumable> medicalList;


	
	public ShopList(ArrayList<String> buildList, ArrayList<Consumable> itemArray) {
		this.itemArray = itemArray;
		for (String s : buildList) {
			shopList.put(s, 0);
		}
		buildCurrentItems();
	}
	
	public int getItem(String item) {
		return shopList.get(item);
	}
	
	public void addItem(String item, int amount) {
		Integer value = shopList.get(item);
		shopList.put(item, value + amount);
	}
	
	// no checks on this currently
	public void removeItem(String item) {
		Integer value = shopList.get(item);
		if (value == 0) {
			System.out.println("Bug. removeItem in shopList tried to decrement an item that doesn't exist");
		}
		else {
			shopList.put(item, value - 1);
	}
	}
	
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
	public HashMap<String, Integer> getShopMap() {
		return this.shopList;
	}
	
	public ArrayList<Consumable> getFoodItems(){
		return foodItems;
	}
	
	public ArrayList<Consumable> getMedicalItems(){
		return healItems;
	}
	
	
	
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
