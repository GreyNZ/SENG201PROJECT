package items;

/**
 * Plague consumable
 * 
 * @author Grey Harris, Cameron Bodger
 *
 */
public class PlagueConsumeable extends Consumable {
	
	/**
	 * true if can cure plague
	 */
	protected boolean curePlague;
	
	/**
	 * Consumable constructor
	 * 
	 * @param tempName        String item name
	 * @param tempvalue       int shop price
	 * @param tempCure        boolean can cure plague
	 */
	public PlagueConsumeable(String tempName, int tempvalue, boolean tempCure) {
		super(tempName, tempvalue);
		curePlague = tempCure;
		
	}
	
	/**
	 * returns {@code true} if can cure plague
	 * @return
	 */
	public boolean getCurePlague() {
		return curePlague;
	}
	
	/**
	 * Returns a formatted string with name, cost and cure plague boolean
	 * 
	 * @return formatted string describing item attributes
	 */
	public String toLongString() {
		return String.format("Name = %s\nValue = %s\nCures Plague = %s", 
				this.getName(), this.getValue(), getCurePlague());
	}
	/* (non-Javadoc)
	 * @see main.Consumable#toString()
	 */
	public String toString() {
		return getName();
	}
	
	/* (non-Javadoc)
	 * @see main.Consumable#getHealing()
	 */
	@Override
	public int getHealing() {
		return 0;
	}

}
