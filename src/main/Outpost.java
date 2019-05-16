package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import main.AllConsumables;


public class Outpost {
	
	private ArrayList<String> itemNameArray = new ArrayList<String>();
	private int shopSize;
	private int minSize = 5;
	private int maxSize = 6;
//	private ArrayList<String> foodItems = new ArrayList<String>();
//	private ArrayList<String> healItems = new ArrayList<String>();
//	private ArrayList<String> allItems;
	private Random random = new Random();
	private int numTotalItems = 10;
	private ArrayList<Integer> shopPrices;
	private InitGame initGame;
	private ShopList shopList;
	private Integer totalItems;

	
	

	public Outpost(InitGame initGame) {
		
		this.initGame = initGame;
		shopPrices = buildShopPrices();
		buildItemNameArray();
		shopList = new ShopList(this.itemNameArray);

	}
		
		

	public void buildItemNameArray() {
		itemNameArray.add("Bandages");
		itemNameArray.add("Medkit");
		itemNameArray.add("Nanites");
		itemNameArray.add("PlagueCure");
		itemNameArray.add("RottenFood");
		itemNameArray.add("SpaceSausage");
		itemNameArray.add("SpaceCandy");
		itemNameArray.add("SpaceApple");
		itemNameArray.add("SpaceRoast");
		itemNameArray.add("MagicMushrooms");

	}
		
//	private void addItem(int rand) {
//		switch (rand) {
//		case 1:
//			shopList.add(new Bandages());
//			break;
//		case 2:
//			shopList.add(new Medkit());
//			break;
//		case 3:
//			shopList.add(new Nanties());
//			break;
//		case 4:
//			shopList.add(new PlagueCure());
//			break;
//		case 5:
//			shopList.add(new RottenFood());
//			break;
//		case 6:
//			shopList.add(new SpaceApple());
//			break;
//		case 7:
//			shopList.add(new SpaceSausage());
//			break;
//		case 8:
//			shopList.add(new SpaceCandy());
//			break;
//		case 9:
//			shopList.add(new SpaceRoast());
//			break;
//		case 10:
//			shopList.add(new MagicMushrooms());
//			break;
//		}
//		
//	}
	
//	public String toString() {
//		String result = "";
//		int i = 0;
//		for (Consumable e: shopList) {
//			result += "Item No." + i + ". \n"+ e.toString() + "\n";
//			i += 1;
//		}
//		return result;
//	}
//	public ArrayList<Consumable> getShopList(){
//		return this.shopList;
//	}
//	public void buyItem(int decision) {
//		// TODO Auto-generated method stub
//		
//	}
	public boolean buyItems(ArrayList<Integer> shopItems) {
		int price = calculatePrice(shopItems);
		System.out.println(price);
		if (price > initGame.getMoney()) {
			raiseNotEnoughMoney(price);
			return false;}
		else {
			initGame.subtractMoney(price);
			String purchase = populateShopList(shopItems);
//			initGame.getMainScreen().printToLog(shopList.toString());
			initGame.getMainScreen().printToLog(purchase);

			return true;
		}
	}
//	no see I want a dict like structure so if it's in the list already I can increment the amount
//	or add it if it isn't
	// ok it's called a hashmap
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
		System.out.println(shopList);
		if (!madePurchase) {
			purchase = "";
		}
		return purchase;
		
	}


	public ArrayList<Integer> buildShopPrices(){
		shopPrices = new ArrayList<Integer>();
		shopPrices.add(50);
		shopPrices.add(100);
		shopPrices.add(150);
		shopPrices.add(100);
		shopPrices.add(5);
		shopPrices.add(30);
		shopPrices.add(50);
		shopPrices.add(75);
		shopPrices.add(130);
		shopPrices.add(200);
		return shopPrices;
	}
	
	public int calculatePrice(ArrayList<Integer> shopItems) {
		int price = 0;
		for (int i=0; i < shopItems.size(); i++) {
			price += shopItems.get(i) * this.shopPrices.get(i);	
		}
		return price;
	}

	// PLACE HOLDER, fix me
	private String raiseNotEnoughMoney(int price) {
		return "Not enough money.\n Cost is $" + price + " but you only have $" + initGame.getMoney();
	}
	
	public String boughtItemString() {
		return "";
	}
	public ArrayList<String> getItemNameArray(){
		return this.itemNameArray;
	}



	public ShopList getShopList() {
		return this.shopList;
		
	}
	
	// pirates stole an item. 
	// currently horrible, refactor me plz
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
