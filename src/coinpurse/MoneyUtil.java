package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
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
	public static void printMoney (List<Valuable> money) {
		for(Valuable v : money) {
			System.out.println(v.toString());
		}
	}
	
	/**
	 * Sort a list of moneys.
	 * @param money is the list of moneys to sort.
	 */
	public static void sortMoney (List<? extends Valuable> money) {
		Collections.sort(money,comp);
	}
	
	/**
	 * Return a List of Moneys that contains only the moneys
	 * that have same currency.
	 * @param money is the list of moneys to filter.
	 * @param currency that use to filtering.
	 * @return filtered is the list of moneys that filtered.
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<E> money, String currency) {
		List<E> filtered = new ArrayList<E>();
		for(E v : money) {
			if(currency == v.getCurrency()) {
				filtered.add(v);
			}
		}
		return filtered;
	}
	
	/**
	 * Return the larger argument, based on sort order, using
	 * the objects' own compareTo method for comparing.
	 * @param args one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E ... args) {
		E max = null;
		for(E arg : args) {
			if(max == null) 
				max = arg;
			else if(arg.compareTo(max) > 0) 
				max = arg;
		}
		return max;
	}
	
	/**
	 * Use to test anything.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
//		Main.init();
//		Purse a = new Purse(10);
//		MoneyFactory mf = MoneyFactory.getInstance();
//		a.insert(mf.createMoney(5));
//		a.insert(mf.createMoney(10));
//		a.insert(mf.createMoney(20));
//		a.insert(mf.createMoney(50));
//		printMoneys(a.money);
//		System.out.println("==========");
//		Valuable b = new Money(10,"Baht");
//		a.withdraw(b);
//		printMoneys(a.money);
		
		String max = MoneyUtil.max("dog","zebra","cat");
		System.out.println(max.toString());
		System.out.println("=========");
		Money m1 = new BankNote(100,"Baht",0);
		Money m2 = new BankNote(500,"Baht",0);
		Money m3 = new Coin(20,"Baht");
		Money max1 = MoneyUtil.max(m1,m2,m3);
		System.out.println(max1.toString());
		System.out.println("=========");
		
		List<BankNote> list = new ArrayList<BankNote>();
		list.add(new BankNote(10.0,"USD",0));
		list.add(new BankNote(500.0,"Baht",1));
		MoneyUtil.sortMoney(list);
		list.forEach((money) -> System.out.println(money));
		System.out.println("=========");
		
		List<Coin> coins = Arrays.asList( new Coin(5,"Baht"),
							new Coin(0.1,"Ringgit"),new Coin(5,"Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		result.forEach((m) -> System.out.println(m));;
	}
}
