package coinpurse;

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
	 * @return filtered is the list of moneys that filtered.
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
		Main.init();
		Purse a = new Purse(10);
		MoneyFactory mf = MoneyFactory.getInstance();
		a.insert(mf.createMoney(5));
		a.insert(mf.createMoney(10));
		a.insert(mf.createMoney(20));
		a.insert(mf.createMoney(50));
		printMoneys(a.money);
		System.out.println("==========");
		Valuable b = new Money(10,"Baht");
		a.withdraw(b);
		printMoneys(a.money);
		
	}
}
