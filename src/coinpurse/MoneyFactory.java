package coinpurse;

/**
 * Money factory can create any kind of money.
 * @author Patiphan Srisook
 *
 */
public abstract class MoneyFactory {
	
	/** singleton instance of MoneyFactory */
	private static MoneyFactory factory = new ThaiMoneyFactory();
	
	/**
	 * Get an instance of MoneyFactory.
	 * It always returns the same object.
	 * @return object of a subclass.
	 */
	public static MoneyFactory getInstance() {
		return factory;
	}
	
	/**
	 * Create new money objects in the local currency.
	 * @param value is amount of money
	 * @return money object for created money
	 * @throws IllegalArgumentException.
	 */
	public abstract Valuable createMoney(double value);
	
	/**
	 * Accept money value as String. If value is invalid number
	 * throw IllegalArgumentException.
	 * @param value is value of money in String type.
	 * @return valuable object.
	 */
	public Valuable createMoney (String value) {
		// parse the String as a double and call the other createMoney method
		double doubleValue = 0;
		// if String value isn't a number then throw IllegalArgumentException
		try {
			doubleValue = Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("This value is not a number.",e);
		}
		return createMoney(doubleValue);
	}
	
	/**
	 * Static method to a "set" the MoneyFactory object that is used.
	 * This is mostly for testing of MoneyFactory.
	 * @param mf
	 */
	public static void setFactory(MoneyFactory mf) {
		factory = mf;
	}
	
}
