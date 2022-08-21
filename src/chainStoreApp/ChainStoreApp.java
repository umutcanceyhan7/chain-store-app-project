package chainStoreApp;
import java.io.FileNotFoundException;
import classes.Simulation;

public class ChainStoreApp {
	public final static String STORE_1 = "HW1_Transactions_Store1.csv";
	public final static String STORE_2 = "HW1_Transactions_Store2.csv";
	public final static String STORE_3 = "HW1_Transactions_Store3.csv";
	public final static String STORE_4 = "HW1_Transactions_Store4.csv";
	public final static String ITEMS = "HW1_Items.csv";
	public enum ITEM_CATEGORIES {Beverage,Food,Snack,Home,Personal};
	public enum STORES { FirstStore("First Store"), SecondStore("Second Store"), ThirdStore("Third Store"), FourthStore("Fourth Store");
	private final String displayName;
	 
    STORES(final String display)
    {
        this.displayName = display;
    }

    @Override public String toString()
    {
        return this.displayName;
    }
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Simulation simulation= new Simulation();
		simulation.run();
	}
}
