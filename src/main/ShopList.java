package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShopList {
	
	private HashMap<String, Integer> shopList = new HashMap<String, Integer>();
	private ArrayList<String> foodList;
	private ArrayList<String> medicalList;


	
	public ShopList(ArrayList<String> buildList) {
		for (String s : buildList) {
			shopList.put(s, 0);
		}
	}
	
	public Integer getItem(String item) {
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
				                shopList.get("SpaceRoast"),shopList.get("MagicMuchrooms"));		
	}
	public HashMap<String, Integer> getShopMap() {
		return this.shopList;
	}
	
	
	//doesn't do much. need to seperate the food and medical items somehow
	public ArrayList<String> buildFoodItems(){
		ArrayList<String> foodItems = new ArrayList<String>();
		for (Map.Entry<String, Integer> item: shopList.entrySet()) {
			if (item.getValue() > 0) {
				foodItems.add(item.getKey());
			}
		}
		return foodItems;
	}
	

	
}
