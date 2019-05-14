package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShopList {
	
	Map<String, Integer> shopList = new HashMap<String, Integer>();


	
	public ShopList(ArrayList<String> buildList) {
		for (String s : buildList) {
			shopList.put(s, 0);
		}
	}
	
	public Integer getItem(String item) {
		return shopList.get(item);
	}
	
	public void addItem(String item) {
		Integer value = shopList.get(item);
		shopList.put(item, value + 1);
	}
	
	public String toString() {
		return String.format("<html>Bandages: %s<br/> Medkits: %s<br/> " + 
								" Nanites: %s<br/>  Plague Cures: %s<br/>  " +
				                "Rotten Food: %s<br/>  Space Sausages: %s<br/>  " +
								"Space Candy: %s <br/>  Space Apples: %s <br/>  " +
				                "Space Roasts: %s <br/>  Magic Mushrooms: %s <html>",
				                shopList.get("Bandages"), shopList.get("Medkit"),
				                shopList.get("Nanites"),shopList.get("PlagueCure"),
				                shopList.get("RottenFood"),shopList.get("SpaceSausage"),
								shopList.get("SpaceCandy"),shopList.get("SpaceApple"),
				                shopList.get("SpaceRoast"),shopList.get("MagicMuchrooms"));		
	}
	public Map<String, Integer> getShopMap() {
		return this.shopList;
	}
	

	
}
