package coinpurse.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
	
	/* Test Greedy withdraw strategy */
	@Test
	public void testGreedyWithdraw() {
		money.add(new Money(5,"Baht"));
		money.add(new Money(2,"Baht"));
		money.add(new Money(2,"Baht"));
		money.add(new Money(2,"Baht"));
		Valuable wd = new Money(6,"Baht");
		List<Valuable> temp = greedy.withdraw(wd, money);
		
		/* In temp should be 0 item */
		assertEquals(temp.size(),0);
		
	}
	
	/* Test Recursive withdraw strategy */
	@Test
	public void testRecursiveWithdraw() {
		money.add(new Money(5,"Baht"));
		money.add(new Money(2,"Baht"));
		money.add(new Money(2,"Baht"));
		money.add(new Money(2,"Baht"));		
		Valuable wd = new Money(6,"Baht");
		List<Valuable> temp = recursive.withdraw(wd, money);
		/* In temp should have 3 items */
		assertEquals(temp.size(),3);
	}
	
	/* Test for difference currency */
	@Test
	public void testDifferenceCurrency() {
		money.add(new Money(5,"Dollar"));
		money.add(new Money(5,"Bath"));
		money.add(new Money(2,"Baht"));
		money.add(new Money(2,"Dollar"));
		money.add(new Money(2,"Baht"));
		money.add(new Money(2,"Dollar"));
		Valuable wd = new Money(18,"Baht");
		List<Valuable> temp1 = recursive.withdraw(wd, money);
		List<Valuable> temp2 = greedy.withdraw(wd, money);
		/* Temp should have 0 item */
		assertEquals(temp1.size(),0);
		assertEquals(temp2.size(),0);
	}
	
	/* Test for impossible withdraw */
	@Test
	public void testImpossibleWithdraw() {
		money.add(new Money(5,"Dollar"));
		Valuable wd = new Money(1000,"Baht");
		List<Valuable> temp1 = recursive.withdraw(wd, money);
		List<Valuable> temp2 = greedy.withdraw(wd, money);
		/* temp should return null or empty list */
		assertNull(temp1);
		assertEquals(temp2.size(),0);
	}
	
	/* Test for normal withdraw */
	@Test
	public void testNormalWithdraw() {
		money.add(new Money(10,"Baht"));
		money.add(new Money(5,"Baht"));
		money.add(new Money(20,"Baht"));
		Valuable wd = new Money(35,"Baht");
		List<Valuable> temp1 = recursive.withdraw(wd, money);
		List<Valuable> temp2 = greedy.withdraw(wd, money);
		/* It should have 3 items */
		assertEquals(temp1.size(),3);
		assertEquals(temp2.size(),3);
	}
}
