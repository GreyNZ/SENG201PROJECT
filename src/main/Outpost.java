package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import main.AllConsumables;


public class Outpost {
	
	private ArrayList<Consumable> shopList = new ArrayList<Consumable>();
	private int shopSize;
	private int minSize = 5;
	private int maxSize = 6;
//	private ArrayList<String> foodItems = new ArrayList<String>();
//	private ArrayList<String> healItems = new ArrayList<String>();
//	private ArrayList<String> allItems;
	private Random random = new Random();
	private int numTotalItems = 10;
	

	public Outpost() {
		this.shopSize = setShopSize(this.minSize, this.maxSize);
		buildShop();

		
		//waste of time lol
//		this.foodItems.add("Magic Mushrooms");
//		this.foodItems.add("Rotten Food");
//		this.foodItems.add("Space Apple");
//		this.foodItems.add("Space Candy");
//		this.foodItems.add("Space Roast");
//		this.foodItems.add("Space Sausage");
//		
//		this.healItems.add("Bandages");
//		this.healItems.add("Medkit");
//		this.healItems.add("Nanties");
//		this.healItems.add("Plague Cure");
//		allItems.addAll(foodItems);
//		allItems.addAll(healItems);

	}
	public int setShopSize(int min, int max) {
		int rand = new Random().nextInt(max) + min;
		return rand;
				
	}
	
	public void buildShop() {
		for (int i = 0; i < this.shopSize; i += 1) {
			int rand = random.nextInt(this.numTotalItems);
			addItem(rand);
		}
	}
		

		
	private void addItem(int rand) {
		switch (rand) {
		case 0:
			shopList.add(new MagicMushrooms());
			break;
		case 1:
			shopList.add(new RottenFood());
			break;
		case 3:
			shopList.add(new SpaceApple());
			break;
		case 4:
			shopList.add(new SpaceCandy());
			break;
		case 5:
			shopList.add(new SpaceRoast());
			break;
		case 6:
			shopList.add(new SpaceSausage());
			break;
		case 7:
			shopList.add(new Bandages());
			break;
		case 8:
			shopList.add(new Medkit());
			break;
		default:
			shopList.add(new Nanties());
			break;

			

		}
		
	}
	
	public String toString() {
		String result = "";
		int i = 0;
		for (Consumable e: shopList) {
			result += "Item No." + i + ". \n"+ e.toString() + "\n";
			i += 1;
		}
		return result;
	}
	public ArrayList<Consumable> getShopList(){
		return this.shopList;
	}
	public void buyItem(int decision) {
		// TODO Auto-generated method stub
		
	}

}