package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.WithdrawStrategy;

import java.util.Comparator;

/**
 *  A money purse contains moneys.
 *  You can insert moneys, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Patiphan Srisook
 */
public class Purse {
	
	private WithdrawStrategy strategy;
	
    /** Collection of objects in the purse. */
	private List<Valuable> money;
	
	/** Comparator use to sort list of valuable (money) */
	private Comparator<Valuable> comp;
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /**
     * Balance is the total amount money in money purse.
     */
    
    
    // default currency for this purse
    private static String CURRENCY = "Baht";
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of moneys you can put in purse.
     */
    public Purse( int capacity ) {
    		this.money = new ArrayList<Valuable>();
    		this.comp = new ValueComparator();
    		this.capacity = capacity;
    		CURRENCY = ConsoleDialog.CURRENCY;
    		strategy = new GreedyWithdraw();
    }
    
    /**
     * Count and return the number of moneys in the purse.
     * This is the number of moneys, not their value.
     * @return the number of moneys in the purse
     */
    public int count() { return this.money.size(); }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
		double balance = 0.0;
		for (Valuable valuable : money) {
			balance += valuable.getValue();
		}
		return balance;
	}

    
    /**
     * Return the capacity of the money purse.
     * @return capacity of the money purse.
     */
    public int getCapacity() { 
		return this.capacity; 
	}
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
        return (this.count() >= this.getCapacity());
    }

    /** 
     * Insert a money into the purse.
     * The money is only inserted if the purse has space for it
     * and the money has positive value.  No worthless moneys!
     * @param value is a Money object to insert into purse
     * @return true if money inserted, false if can't insert
     */
    public boolean insert( Valuable value ) {
        // if the purse is already full then can't insert anything.
        if(isFull() || value.getValue() <= 0) return false;
        money.add(value);
        return true;
    }
    
    public void setWithdrawStrategy(WithdrawStrategy strategy) {
		this.strategy = strategy;
	}
    
    /**
     * Withdraw the amount, using only items that have the
     * same currency as the parameter (amount). amount
     * must not be null and amount.getValue() > 0.
     * @param amount is the amount to withdraw
     * @return array of Money objects for money withdrawn, 
	 * or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw(Valuable amount) {

    		double amounts = amount.getValue();
        // withdraw cannot be less than 0
    		if(amounts < 0) return null;
    		if(strategy.toString().equals("GreedyWithdraw")) {
    			Collections.sort(money,comp);
    			Collections.reverse(money);
    		}
    		List<Valuable> tempFiltered = MoneyUtil.filterByCurrency(money, amount.getCurrency());
        List<Valuable> temp = strategy.withdraw(amount, tempFiltered);
        if(temp == null) return null;
        
        for(Valuable value : temp) {
        		money.remove(value);
        }
        Valuable[] array = new Valuable[temp.size()]; // create the array
        temp.toArray(array);
        return array;  
    }
    
    /**  
     *  Withdraw amount using the default currency, which is "Baht".
     *  @param amount is the amount to withdraw
     *  @return array of Money objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
 	   	Valuable quantity = new Money(amount,CURRENCY);
 	   	return withdraw(quantity);
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    		return String.format("%d items with value %.2f", this.count(),this.getBalance());
    }
}

