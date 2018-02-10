package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Patiphan Srisook
 *
 */
public class Coin extends Money {

	/**
	 * Constructor for a Coin with a value and currency.
	 * @param value must not be negative but may less than one.
	 * @param currency can be any currency.
	 */
	public Coin(double value,String currency) {
		super(value,currency);
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
