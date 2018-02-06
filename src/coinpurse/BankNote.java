package coinpurse;

/**
 * BankNote represents BankNote (money) with a fixed value and currency.
 * @author Patiphan Srisook
 *
 */
public class BankNote implements Valuable{
	
	/** Make serial number start at 1000000 */
	private static long nextSerialNumber = 1000000;
	/** Value of BankNote */
	private double value;
	/** Currency of BankNote */
	private String currency;
	/** Serial number of BankNote */
	private long serialNumber;
	
	
	
	/**
	 * Constructor for a BankNote with a value and currency.
	 * @param value must not be negative but may less than one.
	 * @param currency can be any currency.
	 */
	public BankNote(double value,String currency) {
		if(value<0) this.value = 0;
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
	}

	/**
	 * Get the value of this BankNote.
	 * @return the value of this BankNote.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of this BankNote.
	 * @return the currency of this BankNote.
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Get the serial number of this BankNote.
	 * @return serialNumber of this BankNote.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * Two BankNotes are equal if the have the same value
	 * and same currency.
	 * @param arg is the object to check equal.
	 * @return true if both value and currency are the same,
	 * Otherwise false.
	 */
	@Override
	public boolean equals(Object arg) {
		// null check
		if(arg == null) 
			return false;
		// type check and cast
		if(getClass() != arg.getClass())
			return false;		
		// self check
		if(this == arg) 
			return true;
		// build other object to compare
		BankNote other = (BankNote) arg;
		// check both value and currency
		if(this.getValue() == other.getValue() && this.getCurrency() == other.getCurrency())
			return true;
		return false;
 	}
	
	/**
	 * Get describe of this BankNote.
	 * @return value ,currency and serial number of this BankNote.
	 */
	public String toString() {
		return String.format("%.0f-%s [%d]", this.getValue(),this.getCurrency(),this.getSerial());
	}
}
