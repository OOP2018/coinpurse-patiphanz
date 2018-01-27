package coinpurse;

import java.util.Comparator;

/**
 * This class use to compare any valuable.
 * @author Patiphan Srisook
 *
 */
public class ValueComparator implements Comparator<Valuable> {

	/**
	 * Compare two object that implement Valuable.
	 * First compare them by currency. so that "Baht" < "Dollar".
	 * If both objects have the same currency, order them by value.
	 */
	@Override
	public int compare(Valuable o1, Valuable o2) {
		if(o1.getCurrency() == "Baht" && o2.getCurrency() == "Dollar") return -1;
		else if(o1.getCurrency() == "Dollar" && o2.getCurrency() == "Bath") return 1;
		
		if(o1.getCurrency() == o2.getCurrency()) {
			if(o1.getValue() > o2.getValue()) return 1;
			else if(o1.getValue() == o2.getValue()) return 0;
			else /* if(o1.getValue() < o2.getValue()) */ return -1;
		}
		return 0;
	}

}
