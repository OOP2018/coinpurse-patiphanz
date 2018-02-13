package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

/**
 *  A money purse contains moneys.
 *  You can insert moneys, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Patiphan Srisook
 */
public class Purse {
    /** Collection of objects in the purse. */
	public List<Valuable> money;
	
	/** Comparator use to sort list of valuable (money) */
	private Comparator<Valuable> comp;
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /**
     * Balance is the total amount money in money purse.
     */
    private double balance;
    
    private static final String DEFAULT_CURRENCY = "Baht";
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of moneys you can put in purse.
     */
    public Purse( int capacity ) {
    		this.money = new ArrayList<Valuable>();
    		this.comp = new ValueComparator();
    		this.capacity = capacity;
    		this.balance = 0;
    		
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
        balance += value.getValue();
        return true;
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
    	/*
 		* See lab sheet for outline of a solution, 
 		* or devise your own solution.
 		* The idea is to be greedy.
 		* Try to withdraw the largest moneys possible.
 		* Each time you choose a item as a candidate for
 		* withdraw, add it to a temporary list and
 		* decrease the amount (remainder) to withdraw.
 		* 
 		* If you reach a point where amountNeededToWithdraw == 0
 		* then you found a solution!
 		* Now, use the temporary list to remove moneys
 		* from the money list, and return the temporary
 		* list (as an array).
 		*/
    		double amounts = amount.getValue();
        // withdraw cannot be less than 0
    		if(amounts < 0) return null;
        Collections.sort(money,comp);
        List<Valuable> templist = new ArrayList<Valuable>();
        List<Valuable> temp = new ArrayList<Valuable>();
        temp.addAll(money);
        // temp of amount to check for withdraw
        double remainAmount = amounts;
        
        // Loop for check if it can withdraw or not
        for(int index = this.count()-1 ; index>=0 ; index--) {
        		Valuable t = temp.get(index);
        		if(t.getValue() <= remainAmount && t.getCurrency().equals(amount.getCurrency())) {
        			if ( temp.size() == 0 && remainAmount >= 0 ) {	
            			// failed. Don't change the contents of the purse.
            			return null;
            		}	
            		templist.add(t);
            		remainAmount -= t.getValue();
            		temp.remove(index);
        		}
        }
        
        // Did we get the full amount?
     	// This code assumes you decrease amount each time you remove a money.
        // Your code might use some other variable for the remaining amount to withdraw.
        // remain amount = 0 so it can withdraw
        if(remainAmount == 0) {
        	// Success.
    		// Remove the moneys you want to withdraw from purse,
    		// and return them as an array.
    		// Use list.toArray( array[] ) to copy a list into an array.
    		// toArray returns a reference to the array itself.
        		for(int index = this.count()-1 ; index>=0 ; index--) {
        			Valuable m = money.get(index);
        			if(m.getValue() <= amounts && m.getCurrency().equals(amount.getCurrency())) {
        				balance -= m.getValue();
            			amounts -= m.getValue();
        				money.remove(index);
        			}
        		}
        		Valuable [] array = new Valuable [templist.size()];
            return templist.toArray(array);
        }
        else { return null; }
    }
    
    /**  
     *  Withdraw amount using the default currency, which is "Baht".
     *  @param amount is the amount to withdraw
     *  @return array of Money objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
 	   Valuable quantity = new Money(amount,DEFAULT_CURRENCY);
 	   return withdraw(quantity);
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    		return String.format("%d moneys with value %.2f", this.count(),this.getBalance());
    }
}

