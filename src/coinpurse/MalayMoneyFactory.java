package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {

	public static final String MALAY_CURRENCY = "Ringgit";
	
	/** Make serial number start at 1000000 */
	private static long nextSerialNumber = 1000000;
	
	@Override
	public Valuable createMoney(double value) {
		if(value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5)
			return new Coin(value,MALAY_CURRENCY);
		else if(value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100)
			return new BankNote(value,MALAY_CURRENCY,nextSerialNumber++);
		else
			return null;
	}

}
