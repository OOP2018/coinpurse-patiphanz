package coinpurse;

import java.util.ResourceBundle;

public abstract class MoneyFactory {
	
	/** singleton instance of MoneyFactory */
	private static MoneyFactory factory = null;
	
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
	 * @param value
	 * @return
	 * @throws IllegalArgumentException.
	 */
	public abstract Valuable createMoney(double value);
	
	public Valuable createMoney (String value) {
		// parse the String as a double and call the other createMoney method
		double doubleValue = 0;
		// if String value isn't a number then throw IllegalArgumentException
		try {
			doubleValue = Double.parseDouble(value);
		} catch (IllegalArgumentException e) {
			System.out.println("Value is not a number");
		}
		return createMoney(doubleValue);
	}
	
	/**
	 * Static method to a "set" the MoneyFactory object that is used.
	 * This is mostly for testing of MoneyFactory.
	 * @param f
	 */
	public static void setFactory(MoneyFactory mf) {
		factory = mf;
	}
	
}
