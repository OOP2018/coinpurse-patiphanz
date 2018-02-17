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
		if(this.getValue() <= 0.5 && this.getCurrency().equals("Ringgit"))
			return String.format("%.2f-%s coin", this.getValue()*100,this.getCurrency());
		return String.format("%.2f-%s coin", this.getValue(),this.getCurrency());
	}
}
