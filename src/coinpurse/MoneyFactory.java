package coinpurse;

public abstract class MoneyFactory {

	private static MoneyFactory factory = null;
	
	public static MoneyFactory getInstance() {
		return factory;
	}
	
	public abstract Valuable createMoney(double value);
	
	public Valuable createMoney (String value) {
		// parse the String as a double and call the other createMoney method
		double doubleValue = 0;
		try {
			doubleValue = Double.parseDouble(value);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
		return createMoney(doubleValue);
	}
	
	public static void setFactory(MoneyFactory mf) {
		factory = mf;
	}
	
}
