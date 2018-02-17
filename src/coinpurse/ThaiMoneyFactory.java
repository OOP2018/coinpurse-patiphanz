package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory {

	public static final String THAI_CURRENCY = "Baht";
	
	/** Make serial number start at 1000000 */
	private static long nextSerialNumber = 1000000;
	
	@Override
	public Valuable createMoney(double value) {
		if(value == 1 || value == 2 || value == 5 || value == 10)
			return new Coin(value,THAI_CURRENCY);
		else if(value == 20 || value == 50 || value == 100 || value == 500 || value == 1000)
			return new BankNote(value,THAI_CURRENCY,nextSerialNumber++);
		else
			return null;
	}

}
