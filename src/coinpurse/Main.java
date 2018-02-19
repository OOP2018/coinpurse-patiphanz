package coinpurse;

import java.util.ResourceBundle;

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
    	Main.init();
        // create a Purse
    	Purse purse = new Purse(10);
        // create a ConsoleDialog with a reference to the Purse object
    	ConsoleDialog ui = new ConsoleDialog(purse);
        // run the ConsoleDialog
    	ui.run();
    }
    
    public static void init() {
    	// create a ResourceBundle from file "purse.properties" on the classpath
    			// the ".properties" extension is automatically appended to the name
    			ResourceBundle bundle = ResourceBundle.getBundle( "purse" );
    			
    			// get value of "moneyfactory" property
    			String factoryclass = bundle.getString( "moneyfactory" );
    			MoneyFactory factory = null;
    			// if factoryclass is null then use a default class name
    			if(factoryclass.equals(null)) { factoryclass = "coinpurse.ThaiMoneyFactory"; }
    			try {
    				factory = (MoneyFactory)Class.forName(factoryclass).newInstance();
    			}
    			catch (ClassCastException cce) {
    				//the object could not be cast to type MoneyFactory
    				System.out.println(factoryclass+" is not type MoneyFactory");
    			}
    			catch (Exception ex) {
    				// any other exception means we could not create an object
    				System.out.println("Error creating MoneyFactory "+ex.getMessage() );
    			}
    			// if no factory then quit
    			if (factory == null) System.exit(1);
    			MoneyFactory.setFactory(factory);
    }
}
