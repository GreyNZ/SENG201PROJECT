package main;

import java.util.Random;

public class MiscItems {
	
	String[] items;
	String[] adjectives;
	Random rand = new Random();
	public MiscItems() {
		buildItems();
		buildAdjectives();
		
	}
	
	public String getMiscItem() {
		int itemIndex = rand.nextInt(50);
		int adjIndex = rand.nextInt(50);
		String result = "Found one " + adjectives[adjIndex] + " " + items[itemIndex];
		return result;
	}
	
	private void buildItems() {
		items = new String[] {"toe ring",
			"carrots",
			"sharpie",
			"couch",
			"packing peanuts",
			"deodorant",
			"eye liner",
			"key chain",
			"mop",
			"stop sign",
			"bottle cap",
			"cup",
			"ring",
			"clay pot",
			"door",
			"headphones",
			"camera",
			"needle",
			"bottle",
			"television",
			"shoe lace",
			"picture frame",
			"coasters",
			"tv",
			"lip gloss",
			"piano",
			"street lights",
			"lace",
			"washing machine",
			"pillow",
			"bow",
			"clothes",
			"cookie jar",
			"computer",
			"thermometer",
			"fridge",
			"face wash",
			"table",
			"grid paper",
			"sand paper",
			"CD",
			"rubber duck",
			"radio",
			"lamp shade",
			"vase",
			"balloon",
			"chapter book",
			"rug",
			"bracelet",
			"monitor"};
	}
	
	private void buildAdjectives() {
		adjectives = new String[] {"quarrelsome",
				"impartial",
				"quaint",
				"silent",
				"young",
				"combative",
				"second",
				"useful",
				"wonderful",
				"unwritten",
				"luxuriant",
				"hulking",
				"ready",
				"knowing",
				"bouncy",
				"straight",
				"dashing",
				"adaptable",
				"green",
				"ritzy",
				"gainful",
				"used",
				"rude",
				"animated",
				"nervous",
				"nosy",
				"nifty",
				"like",
				"fierce",
				"meek",
				"overconfident",
				"scarce",
				"classy",
				"eager",
				"spotty",
				"even",
				"faithful",
				"youthful",
				"military",
				"functional",
				"adventurous",
				"unhealthy",
				"adorable",
				"melted",
				"imaginary",
				"old",
				"sturdy",
				"nippy",
				"agonizing",
				"neighborly"};
	}
	

}
