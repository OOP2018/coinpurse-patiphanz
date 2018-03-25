package coinpurse.strategy;


import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;


/**
 * 
 * @author shoot
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> temp = new ArrayList<>();
		double moneyTemp = amount.getValue();
		for(Valuable value : money) {
			if(moneyTemp - value.getValue() >= 0) {
				moneyTemp -= value.getValue();
				temp.add(value);
			}
		}
		
		if(moneyTemp != 0) return null;
		return temp;
	}
	
	
}


