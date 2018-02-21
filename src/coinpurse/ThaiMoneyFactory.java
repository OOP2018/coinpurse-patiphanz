package coinpurse;

/**
 * Thai money factory can create money with Thai default currency.
 * 
 * @author Patiphan Srisook
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {

	// default currency for Thai
	public static final String THAI_CURRENCY = "Baht";
	
	/** Make serial number start at 1000000 */
	private static long nextSerialNumber = 1000000;
	
	/**
	 * Create new money objects in the local currency.
	 * @param value is amount of money
	 * @return money object for created money
	 * @throws IllegalArgumentException.
	 */
	@Override
	public Valuable createMoney(double value) {
		if(value == 0.25 || value == 0.5 || value == 1 || value == 2 || value == 5 || value == 10)
			return new Coin(value,THAI_CURRENCY);
		else if(value == 20 || value == 50 || value == 100 || value == 500 || value == 1000)
			return new BankNote(value,THAI_CURRENCY,nextSerialNumber++);
		else {
			throw new IllegalArgumentException("This value is not a valid currency value.");
		}
	}

}
