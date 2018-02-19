package coinpurse;

/**
 * This class is used to create a MoneyFactory and call its methods.
 * 
 * @author Patiphan Srisook
 *
 */
public class MoneyFactoryDemo {

	public static void main(String[] args) {
		Main.init();
		MoneyFactory mf = MoneyFactory.getInstance();
		Purse purse = new Purse(3);
		
		
		
//		MoneyFactory mf = MoneyFactory.getInstance();
//		MoneyFactory mf2 = MoneyFactory.getInstance();
//		
//		Valuable m = mf.createMoney(500);
//		Valuable m2 = mf.createMoney("500");
//		
//		Valuable mt = mf2.createMoney(500);
//		Valuable mt2 = mf2.createMoney("500");
//		
//		System.out.println(m);
//		System.out.println(m2);
//		System.out.println(mt);
//		System.out.println(mt2);
		
//		Main.init();
//		MoneyFactory factory = MoneyFactory.getInstance();
//		Valuable m = factory.createMoney(5);
//		System.out.println(m);
//		Valuable m2 = factory.createMoney("1000.0");
//		System.out.println(m2);
//		
//		String factoryclass = "coinpurse.MalayMoneyFactory";
//		try {
//			factory = (MoneyFactory)Class.forName(factoryclass).newInstance();
//		}
//		catch (ClassCastException cce) {
//			//the object could not be cast to type MoneyFactory
//			System.out.println(factoryclass+" is not type MoneyFactory");
//		}
//		catch (Exception ex) {
//			// any other exception means we could not create an object
//			System.out.println("Error creating MoneyFactory "+ex.getMessage() );
//		}
//		// if no factory then quit
//		if (factory == null) System.exit(1);
//		System.out.println(factoryclass);
//		MoneyFactory.setFactory(factory);
//		
//		Valuable m3 = factory.createMoney(5);
//		System.out.println(m3);
//		Valuable m4 = factory.createMoney(0.05);
//		System.out.println(m4);
//		System.out.println(m3.getCurrency());
//		Valuable m5 = factory.createMoney("1000.0");
		
	}
}
