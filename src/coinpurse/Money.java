package coinpurse;

/**
 * Money represents money with a fixed value and currency.
 * @author Patiphan Srisook
 *
 */
public class Money implements Valuable{

	/** Value of money */
	protected double value;
	/** Currency of the money */
	protected String currency;

	public Money(double value,String currency) {
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
	 * Order coins by value so that the coin with smaller
	 * value come first.
	 * @param coin is the coin to compare.
	 * @return -1 if first coin has order before second coin.
	 * 			1 if first has order after second coin.
	 * 			0 if first coin and second coin have same order.
	 */
	public int compareTo(Valuable o) {
		if(this.getCurrency().equals(o.getCurrency())) {
			if(this.getValue() == o.getValue()) return 0;
			else if(this.getValue() < o.getValue()) return -1;
			else /* if(this.getValue() > o.getValue()) */ return 1;
		}
		return(this.getCurrency().compareToIgnoreCase(o.getCurrency()));
		
	}

	/**
	 * Two moneys are equal if the have the same value
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
		// build other object to compare
		Valuable other = (Valuable) arg;
		// check both value and currency
		if(this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency()))
			return true;
		return false;
	}

}