package main;

import java.util.Random;

/**
 * MiscItems. Randomly generated space junk
 * @author Cameron Bodger, Grey Harris
 *
 */
public class MiscItems {
	
	/**
	 * Array of miscellaneous items
	 */
	String[] items;
	/**
	 * Array of miscellaneous adjectives
	 */
	String[] adjectives;
	/**
	 * Random number generator
	 */
	Random rand = new Random();
	/**
	 * MiscItems constructor
	 */
	public MiscItems() {
		buildItems();
		buildAdjectives();
		
	}
	
	/**
	 * Gets a random combination of adjective + item
	 * @return random miscellaneous item string
	 */
	public String getMiscItem() {
		int itemIndex = rand.nextInt(50);
		int adjIndex = rand.nextInt(50);
		String result = "Found one " + adjectives[adjIndex] + " " + items[itemIndex];
		return result;
	}
	
	/**
	 * Creates the array of miscellaneous items
	 */
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
	
	/**
	 * Creates the array of miscellaneous adjectives
	 */
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
