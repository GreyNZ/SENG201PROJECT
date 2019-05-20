package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Outpost {
	
	private Random random = new Random();
	private InitGame initGame;
	private ShopList shopList;
	private ArrayList<Consumable> itemArray = new ArrayList<Consumable>();
	private ArrayList<String> itemNameArray;
	private ArrayList<Integer> shopPrices;



	
	

	public Outpost(InitGame initGame) {
		this.initGame = initGame;
		buildItemArray();
		buildNameAndPriceArrays();
		shopList = new ShopList(this.itemNameArray, itemArray);

	}
		



	public void buildItemArray() {
		for (int i = 1; i < 11; i++) {
			addItem(i);
		}
	}
	
	private void buildNameAndPriceArrays() {
		shopPrices = new ArrayList<Integer>();
		itemNameArray = new ArrayList<String>();
		for(Consumable item : itemArray) {
			itemNameArray.add(item.getName());
			shopPrices.add(item.getValue());
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
//	public String useItem(Consumable item, Person person) {
//		ConsumeItem consume = new ConsumeItem(item, person);
//		String result = consume.consume();
//		return result;
//	}

	
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
	
	public ArrayList<String> getItemNameArray(){
		return this.itemNameArray;
	}

	
	public ArrayList<Consumable> refreshFoodList(){
		return shopList.getFoodItems();
	}
	
	public ArrayList<Consumable> refreshHealList(){
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
}
