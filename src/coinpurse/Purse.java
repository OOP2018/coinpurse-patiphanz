package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
// You will use Collections.sort() to sort the coins

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Patiphan Srisook
 */
public class Purse {
    /** Collection of objects in the purse. */
	public List<Coin> money;
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /**
     * Balance is the total amount money in coin purse.
     */
    private double balance;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    		this.capacity = capacity;
    		this.money = new ArrayList<Coin>();
    		this.balance = 0;
    		
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
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
     * Return the capacity of the coin purse.
     * @return capacity of the coins purse.
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
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Coin coin ) {
        // if the purse is already full then can't insert anything.
        if(isFull() || coin.getValue() <= 0) return false;
        money.add(coin);
        balance += coin.getValue();
        return true;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Coin[] withdraw( double amount ) {
        // withdraw cannot be less than 0
    		if(amount < 0) return null;
        Collections.sort(money);
        List<Coin> templist = new ArrayList<Coin>();
        List<Coin> temp = new ArrayList<Coin>();
        temp.addAll(money);
        // temp of amount to check for withdraw
        double remainAmount = amount;
        
        // Loop for check if it can withdraw or not
        for(int index = this.count()-1 ; index>=0 ; index--) {
        		if(temp.get(index).getValue() <= remainAmount) {
        			if ( temp.size() == 0 && remainAmount >= 0 ) {	
            			// failed. Don't change the contents of the purse.
            			return null;
            		}	
            		templist.add(temp.get(index));
            		remainAmount -= temp.get(index).getValue();
            		temp.remove(index);
        		}
        }
        
        // remain amount = 0 so it can withdraw
        if(remainAmount == 0) {
        		for(int index = this.count()-1 ; index>=0 ; index--) {
        			if(money.get(index).getValue() <= amount) {
        				balance -= money.get(index).getValue();
            			amount -= money.get(index).getValue();
        				money.remove(index);
        			}
        		}
        		Coin [] array = new Coin [templist.size()];
            return templist.toArray(array);
        }
        
       
	   /*
		* See lab sheet for outline of a solution, 
		* or devise your own solution.
		* The idea is to be greedy.
		* Try to withdraw the largest coins possible.
		* Each time you choose a coin as a candidate for
		* withdraw, add it to a temporary list and
		* decrease the amount (remainder) to withdraw.
		* 
		* If you reach a point where amountNeededToWithdraw == 0
		* then you found a solution!
		* Now, use the temporary list to remove coins
		* from the money list, and return the temporary
		* list (as an array).
		*/
		
		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
    	// Your code might use some other variable for the remaining amount to withdraw.
		

		// Success.
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		return null;
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    		return String.format("%d coins with value %.2f", this.count(),this.getBalance());
    }

}

