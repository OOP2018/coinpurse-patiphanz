package coinpurse.strategy;


import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;


/**
 * Withdraw by using greedy withdraw strategy.
 * 
 * @author Patiphan Srisook
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {
	
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
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> temp = new ArrayList<>();
		double moneyTemp = amount.getValue();
		for(Valuable value : money) {
			if(moneyTemp - value.getValue() >= 0 && amount.getCurrency().equals(value.getCurrency())) {
				moneyTemp -= value.getValue();
				temp.add(value);
			}
		}
		
		if(moneyTemp != 0) return new ArrayList<>();
		return temp;
	}
	
	
}


