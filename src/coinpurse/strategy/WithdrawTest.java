package coinpurse.strategy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Money;
import coinpurse.Valuable;

public class WithdrawTest {
	
	private WithdrawStrategy greedy;
	private WithdrawStrategy recursive;
	private List<Valuable> money;
	
	/**
	 * Code to run before each test. Setup the "test fixture"
	 */
	@Before
	public void setUp() {
		money = new ArrayList<Valuable>();
		greedy = new GreedyWithdraw();
		recursive = new RecursiveWithdraw();
	}
	
	@Test
	public void testGreedyWithdraw() {
		money.add(new Money(5,"Baht"));
		money.add(new Money(2,"Baht"));
		money.add(new Money(2,"Baht"));
		money.add(new Money(2,"Baht"));
		Valuable wd = new Money(6,"Baht");
		List<Valuable> temp = greedy.withdraw(wd, money);
		
		/* Amount of moneys should not be changed */
		assertEquals(money.size(),temp.size());
		
	}
	
	@Test
	public void testRecursiveWithdraw() {
		money.add(new Money(5,"Baht"));
		money.add(new Money(2,"Baht"));
		money.add(new Money(2,"Baht"));
		money.add(new Money(2,"Baht"));		
		Valuable wd = new Money(5,"Baht");
		List<Valuable> temp = recursive.withdraw(wd, money);
		assertEquals(money.size(),temp.size());

	}
}
