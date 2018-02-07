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
		List<Valuable> moneys = new ArrayList<Valuable>();
		moneys.add(new BankNote(100,"Baht"));
		moneys.add(new Coin(1,"Baht"));
		moneys.add(new Coin(10.0,"Baht"));
		moneys.add(new BankNote(500,"Baht"));
		moneys.add(new Coin(0.25,"Baht"));
		moneys.add(new BankNote(1000,"Dollar"));
		moneys.add(new Coin(0.25,"Dollar"));
		moneys.add(new Coin(0.5,"Dollar"));
		moneys.add(new BankNote(100,"Baht"));
		moneys.add(new BankNote(20,"Dollar"));
		moneys.add(new BankNote(100,"Baht"));
		moneys.add(new Coin(5,"Dollar"));
		moneys.add(new BankNote(5000,"Dong"));
		sortMoneys(moneys);
		printMoneys(moneys);
		System.out.println("\n==== Dollar ====\n");
		printMoneys(filterByCurrency(moneys,"Dollar"));
		System.out.println("\n==== Baht ====\n");
		printMoneys(filterByCurrency(moneys,"Baht"));
		System.out.println("\n==== Dong ====\n");
		printMoneys(filterByCurrency(moneys,"Dong"));
	}
}
