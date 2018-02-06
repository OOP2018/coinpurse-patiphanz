package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Patiphan Srisook
 *
 */
public class Coin implements Valuable {

	/** Value of money */
	private double value;
	/** Currency of the money */
	private String currency;
	
	/**
	 * Constructor for a Coin with a value and currency.
	 * @param value must not be negative but may less than one.
	 * @param currency can be any currency.
	 */
	public Coin(double value,String currency) {
		if(value < 0) {
			this.value = 0;
		}
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * Get the value of the money.
	 * @return value of the money.
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Get the currency of the money.
	 * @return currency of the money.
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Two coins are equal if the have the same value
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
		Coin other = (Coin) arg;
		// check both value and currency
		if(this.getValue() == other.getValue() && this.getCurrency() == other.getCurrency())
			return true;
		return false;
 	}

	/**
	 * Order coins by value so that the coin with smaller
	 * value come first.
	 * @param coin is the coin to compare.
	 * @return -1 if first coin has order before second coin.
	 * 			1 if first has order after second coin.
	 * 			0 if first coin and second coin have same order.
	 */
	public int compareTo(Coin coin) {
		if(this.getValue() == coin.getValue()) return 0;
		else if(this.getValue() < coin.getValue()) return -1;
		else /* if(this.getValue() > coin.getValue()) */ return 1;
	}
	
	/**
	 * Describe the value and currency of the money.
	 * @return String of value and currency.
	 */
	@Override
	public String toString() {
		return String.format("%.2f-%s", this.getValue(),this.getCurrency());
	}
}
