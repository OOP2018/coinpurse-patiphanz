package coinpurse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


/**
 * This class for practice using Lists.
 * @author Patiphan Srisook
 *
 */
public class MoneyUtil {
	
	/** Comparator use to sort list of valuable (money) */
	private static Comparator<Valuable> comp = new ValueComparator();
	
	/**
	 * Print the result on the console.
	 * @param money is the list of moneys to print.
	 */
	public static void printMoneys (List<Valuable> money) {
		for(Valuable v : money) {
			System.out.println(v.toString());
		}
	}
	
	/**
	 * Sort a list of moneys.
	 * @param money is the list of moneys to sort.
	 */
	public static void sortMoneys (List<Valuable> money) {
		Collections.sort(money,comp);
	}
	
	/**
	 * Return a List of Moneys that contains only the moneys
	 * that have same currency.
	 * @param money is the list of moneys to filter.
	 * @param currency that use to filtering.
	 * @return filtered is the list of coins that filtered.
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> money, String currency) {
		List<Valuable> filtered = new ArrayList<Valuable>();
		for(Valuable v : money) {
			if(currency == v.getCurrency()) {
				filtered.add(v);
			}
		}
		return filtered;
	}
	
	/**
	 * Use to test anything.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		Purse a = new Purse(10);
		a.insert(new Coin(5,"Baht"));
		a.insert(new Coin(10,"Baht"));
		a.insert(new BankNote(20,"Baht"));
		a.insert(new BankNote(50,"Baht"));
		a.insert(new Coin(5,"USD"));
		a.insert(new Coin(10,"USD"));
		a.insert(new BankNote(20,"USD"));
		a.insert(new BankNote(50,"USD"));
		printMoneys(a.money);
		System.out.println("==========");
		Valuable b = new Money(20,"USD");
		a.withdraw(b);
		printMoneys(a.money);
		System.out.println("==========");
		Valuable c = new Money(10,"Baht");
		a.withdraw(c);
		printMoneys(a.money);
		
		
	}
}
