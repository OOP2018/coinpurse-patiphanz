package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;

/**
 * Withdraw by using recursive withdraw strategy.
 * 
 * @author Patiphan Srisook
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy{

	/**
	 * Find and return items from a collection whose total value equals
	 * the requested amount.
	 * @param amount is the amount of money to withdraw, with currency.
	 * @param money the contents that are available for possible withdraw.
	 * 			Must not be null, but may be an empty list.
	 * 			This list is not modified.
	 * @return if a solution is found, return a List containing references
	 * 			from the money parameter (List) whose sum equals the amount.
	 * 			If a solution is not found, return null
	 */
	public List<Valuable> withdraw(Valuable amount,List<Valuable> money) {
		if(amount.getValue() == 0) return new ArrayList<Valuable>();
		if(money.isEmpty() || amount.getValue() < 0) return null;
		
		Valuable remaining = new Money(amount.getValue() - money.get(0).getValue(),amount.getCurrency());
		boolean matchCurrency = money.get(0).getCurrency().equals(amount.getCurrency());
		// Case 1
		List<Valuable> withdraw1 = withdraw(remaining,money.subList(1, money.size()));
		if(withdraw1 != null) {
			List<Valuable> temp = new ArrayList<Valuable>();
			if(matchCurrency) {
				temp.add(money.get(0));
				temp.addAll(withdraw1);
			}
			return temp;
		}
		
		// Case 2
		List<Valuable> withdraw2 = withdraw(amount, money.subList(1, money.size()));
		if (withdraw2 != null) {
			List<Valuable> temp = new ArrayList<Valuable>();
			if(matchCurrency) { temp.addAll(withdraw2); }
			return temp;
		}
		return null;
	}
}
