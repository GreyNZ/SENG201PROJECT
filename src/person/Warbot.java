package person;

/**
 * Warbot subclass Person object
 * <p>
 * 
 *Race: Warbot <p>
 *
 *Home Planet: Forge World of Mars 
 *
 *Skills and Abilities: A verifiable killing machine. If it is programed to protect you rest assured you are safe, if not you are facing a never tiring machine that feels no fear or hunger. On the up side they are a bit dumb. 
 *<p>
 *Misc: Don�t send it to search for parts, you will be lucky if it finds its way back to the ship.
 * 
 * @author Grey Harris, Cameron Bodger
 *
 */
public class Warbot extends Person {
	/** Warbot constructor 
	 * example inputs (name, race, health, maxHealth, vigor, maxVigour, hunger, maxHunger, maxActions, currentActions, repairValue, searchValue, hasPlague
	 *
	 * @param tempName     String Warbot's name
	 * @param unique       int identifier 0-4, based off when they were selected 
	 */
	public Warbot(String tempName, int unique) {
		super(tempName, "Warbot", 150, 150, 100, 100, 0, 100, 2, 2, 0.5, 0.25, false, unique);
	}
	
	/* (non-Javadoc)
	 * @see main.Person#addPlague()
	 */
	public void addPlague() {
		this.has_plague = false;
	}
	
	
	/* (non-Javadoc)
	 * @see main.Person#decreaseVigourAction(int)
	 */
	public void decreaseVigourAction(int decrease) { // Warbots never tire
		int currentVigour = this.personVigour;
		this.personVigour = currentVigour; 		
	}
	
	/* (non-Javadoc)
	 * @see main.Person#decreaseVigourTravel()
	 */
	public void decreaseVigourTravel() { // Warbots never fatigue
		int currentVigour = this.personVigour;
		this.personVigour = currentVigour; 
	}
	
	/* (non-Javadoc)
	 * @see main.Person#increaseHungerEndDay()
	 */
	public void increaseHungerEndDay() { // Warbots never hunger
		int currentHunger = this.person_hunger;
		this.person_hunger = currentHunger; 
	}
	
	/** 
	 * Overrides increaseHunger from {@link Person} to have no effect
	 * <p>
	 * Warbots only eat the tears of their enemies
	 */
	@Override 
	public void increaseHunger(int increase) {  
		this.person_hunger = 0; 
	}
}