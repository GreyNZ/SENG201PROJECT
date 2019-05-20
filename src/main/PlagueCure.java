package main;

/**
 * Item that cures plague
 * @author Grey Harris, Cameron Bodger
 *
 */
public class PlagueCure extends PlagueConsumeable {

	/**
	 * Plague cure constructor 
	 */
	public PlagueCure() {
		super("PlagueCure", 100, true);
		type = "plague";
	}	
}
