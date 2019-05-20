package main;

/**
 * Bandages healing item
 * 
 * @author Cameron Bodger, Grey Harris
 *
 */
public class Bandages extends HealingConsumeable {

	/**
	 * Bandages constructor. Heals 20, costs $50
	 */
	public Bandages() {
		super("Bandages", 50, 20);
	}	
}
