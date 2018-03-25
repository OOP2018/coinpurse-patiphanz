package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy{

	public List<Valuable> withdraw(Valuable amount,List<Valuable> money) {
		if(amount.getValue() == 0) return new ArrayList<Valuable>();
		if(money.isEmpty() || amount.getValue() < 0) return null;
		
		Valuable remaining = new Money(amount.getValue() - money.get(0).getValue(),amount.getCurrency());
		
		// Case 1
		List<Valuable> withdraw1 = withdraw(remaining,money.subList(1, money.size()));
		if(withdraw1 != null) {
			List<Valuable> temp = new ArrayList<Valuable>();
			temp.add(money.get(0));
			temp.addAll(withdraw1);
			return temp;
		}
		
		// Case 2
		List<Valuable> withdraw2 = withdraw(amount, money.subList(1, money.size()));
		if (withdraw2 != null) {
			List<Valuable> temp = new ArrayList<Valuable>();
			temp.addAll(withdraw2);
			return temp;
		}
		return null;
	}
}
