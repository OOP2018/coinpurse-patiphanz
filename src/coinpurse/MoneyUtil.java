package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


/**
 * This class for practice using Lists.
 * @author Patiphan Srisook
 *
 */
public class MoneyUtil {
	
	/**
	 * Print the result on the console.
	 * @param coin is the list of coins to print.
	 */
	public static void printCoins (List<Coin> coin) {
		for(Coin c : coin) {
			System.out.println(c.toString());
		}
	}
	
	/**
	 * Sort a list of coins.
	 * @param coin is the list of coins to sort.
	 */
	public static void sortCoins (List<Coin> coin) {
		Collections.sort(coin);
	}
	
	/**
	 * Return a List of Coins that contains only the coins
	 * that have same currency.
	 * @param coins is the list of coins to filter.
	 * @param currency that use to filtering.
	 * @return filtered is the list of coins that filtered.
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> filtered = new ArrayList<Coin>();
		for(Coin c : coins) {
			if(currency == c.getCurrency()) {
				filtered.add(c);
			}
		}
		return filtered;
	}
	
	/**
	 * Use to test anything.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(0.5, "Baht"));
		coins.add(new Coin(2.0, "Baht"));
		coins.add(new Coin(1.0, "Baht"));
		coins.add(new Coin(5.0, "Baht"));
		coins.add(new Coin(5.0, "Dollar"));
		coins.add(new Coin(10.0, "Dollar"));
		coins.add(new Coin(5.0, "Dollar"));
		coins.add(new Coin(2.0, "Dollar"));
		coins.add(new Coin(1.0, "Dollar"));
		printCoins(coins);
		System.out.println("----------------");
		sortCoins(coins);
		printCoins(filterByCurrency(coins,"Dollar"));
		
	}
}
