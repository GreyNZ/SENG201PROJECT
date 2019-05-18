package main;

public class RaceInfo {
	
	
	public static String getInfo(String race) {
		switch (race){
		case "Human":
			return getHuman();
		case "Bugman":
			return getBugman();
		case "Rockman":
			return getRockman();
		case "Gazer":
			return getGazer();
		case "Warbot":
			return getWarbot();
		case "Grey":
			return getGrey();
		default:
			return "";
		}
	}
	

	private static String getBugman() {
		String bugman = "Race: Bugman  \n" + 
				"\n" + 
				"Home Planet: UNKOWN, Subjects reference belonging to the grand hive \n" + 
				"\n" + 
				"Skills and Abilities: Quick to fight but fast to tire, Bugmen require more rest" 
				+ " and food to survive but make up for this with their ability to fight and "
				+ "willingness to sacrifice for the cause. \n" + 
				"\n" + 
				"Misc: Also bad at repairing, have you tried using a spanner with no thumbs? ";
		return bugman;
	}
	
	private static String getHuman() {
		String human = "Race: Human \n" + 
				"\n" + 
				"Home Planet: Dirt  “Advised this is a translation error” \n" + 
				"\n" + 
				"Skills and Abilities: Totally average in every way. They are the base the rest of the universe rates itself. \n" + 
				"\n" + 
				"Misc: Baring fangs is a sign of good will for some reason.... ";
		return human;
	}
	
	private static String getRockman() {
		String rockman = "Race: Rockman \n" + 
				"\n" + 
				"Home Planet: Europa Three \n" + 
				"\n" + 
				"Skills and Abilities: Very hardy and easy going folk, Rockmen are slow to anger but terrifying "
				+ "if you manage to piss them off.  Rockmen struggle to repair other races “puny tech” "
				+ "but tire far slower than others.  \n" + 
				"\n" + 
				"Misc: Don’t spit on the ground you might be spitting on his mom..... ";
		return rockman;
	}
	
	private static String getGrey() {
		String grey = "Race: Grey \n" + 
				"\n" + 
				"Home Planet: Fleet based \n" + 
				"\n" + 
				"Skills and Abilities: Incredibly intelligent race who replace their young "
				+ "wasted empathetic brain areas with cybernetic enhancements at birth. "
				+ "Grey’s repair at twice the speed of other races due to their innate ability to “feel” where technology is hurting. \n" + 
				"\n" + 
				"Misc: Grey’s are fabled in human story telling for abducting people and "
				+ "inserting probes in unmentionable places. But come on you cant hold that one weird guy against all of us? ";
		return grey;
	}
	
	private static String getGazer() {
		String gazer = "Race: Gazer \n" + 
				"\n" + 
				"Home Planet: REDACTED \n" + 
				"\n" + 
				"Skills and Abilities: Gazers can see the truth in all things, "
				+ "lying or hiding from them is foolish to the extreme. In most ways "
				+ "they resemble the appearance and abilities of a human. \nThe major "
				+ "difference is a large eye embedded in their forehead it is said "
				+ "to be the source of their otherworldly abilities. \n" + 
				"\n" + 
				"Misc: Time to get some lead lined underwear ";
		return gazer;
	}
	
	private static String getWarbot() {
		String warbot = "Race: Warbot \n" + 
				"\n" + 
				"Home Planet: Forge World of Mars \n" + 
				"\n" + 
				"Skills and Abilities: A verifiable killing machine. If it is programed to "
				+ "protect you rest assured you are safe, if not you are facing a never "
				+ "tiring machine that feels no fear or hunger. On the up side they are a bit dumb. \n" + 
				"\n" + 
				"Misc: Don’t send it to search for parts, you will be lucky if it finds its way back to the ship.";
		return warbot;
	}
	

}
