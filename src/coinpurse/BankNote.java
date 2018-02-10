package coinpurse;

/**
 * BankNote represents BankNote (money) with a fixed value and currency.
 * @author Patiphan Srisook
 *
 */
public class BankNote extends Money {
	
	/** Make serial number start at 1000000 */
	private static long nextSerialNumber = 1000000;
	/** Serial number of BankNote */
	private long serialNumber;
	
	
	
	/**
	 * Constructor for a BankNote with a value and currency.
	 * @param value must not be negative but may less than one.
	 * @param currency can be any currency.
	 */
	public BankNote(double value,String currency) {
		super(value,currency);
		this.serialNumber = nextSerialNumber++;
	}

	/**
	 * Get the serial number of this BankNote.
	 * @return serialNumber of this BankNote.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * Get describe of this BankNote.
	 * @return value ,currency and serial number of this BankNote.
	 */
	public String toString() {
		return String.format("%.0f-%s [%d]", this.getValue(),this.getCurrency(),this.getSerial());
	}
}
