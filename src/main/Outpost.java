package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


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
	private ArrayList<Consumable> itemArray = new ArrayList<Consumable>();

	
	

	public Outpost(InitGame initGame) {
		
		this.initGame = initGame;
		shopPrices = buildShopPrices();
		buildItemNameArray();
		buildItemArray();
		shopList = new ShopList(this.itemNameArray, itemArray);

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
	
	public void buildItemArray() {
		for (int i = 1; i < 11; i++) {
			addItem(i);
		}
	}
	
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
		if (!madePurchase) {
			purchase = "";
		}
		return purchase;
		
	}
	
	// probably not necessary, can do it in MainScreen
	public String useItem(Consumable item, Person person) {
//		Integer index = itemNameArray.indexOf(itemName);
//		Consumable item = itemArray.get(index);
		ConsumeItem consume = new ConsumeItem(item, person);
		String result = consume.consume();
		return result;
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

	
	public ArrayList<Consumable> refreshFoodList(){
//		shopList.buildCurrentItems();
		return shopList.getFoodItems();
	}
	
	public ArrayList<Consumable> refreshHealList(){
//		shopList.buildCurrentItems();
		return shopList.getMedicalItems();
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
	
	

	
	
	
	
	
	public static void main(String[] args) {
		InitGame init = new InitGame();
		Outpost outpost = new Outpost(init);
		outpost.buildItemArray();
		ArrayList<Consumable> foodItems = new ArrayList<Consumable>();
		foodItems.add(new Nanites());
		foodItems.add(new SpaceApple());
		ShopList shopList = new ShopList(outpost.getItemNameArray(), foodItems);
		shopList.buildCurrentItems();
		
	}
	
}
