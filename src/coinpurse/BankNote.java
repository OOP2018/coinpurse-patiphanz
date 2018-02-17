package coinpurse;

/**
 * BankNote represents BankNote (money) with a fixed value and currency.
 * @author Patiphan Srisook
 *
 */
public class BankNote extends Money {
	
	/** Serial number of BankNote */
	private long serialNumber;
	
	/**
	 * Constructor for a BankNote with a value and currency.
	 * @param value must not be negative but may less than one.
	 * @param currency can be any currency.
	 */
	public BankNote(double value,String currency,long serialNumber) {
		super(value,currency);
		this.serialNumber = serialNumber;
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
		return String.format("%.0f-%s note [%d]", this.getValue(),this.getCurrency(),this.getSerial());
	}
}
