package coinpurse;
 
/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to money purse.
 * @author Patiphan Srisook
 */
public class Main {

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
//        // 1. create a Purse
//    	Purse purse = new Purse(10);
//        // 2. create a ConsoleDialog with a reference to the Purse object
//    	ConsoleDialog ui = new ConsoleDialog(purse);
//        // 3. run the ConsoleDialog
//    	ui.run();

    		MoneyFactory money = MoneyFactory.getInstance();
    		try {
				money.setFactory((MoneyFactory) Class.forName("ThaiMoneyFactory.java").newInstance());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}
