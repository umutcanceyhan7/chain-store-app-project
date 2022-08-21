package classes;
import java.io.FileNotFoundException;

import chainStoreApp.ChainStoreApp;
import fileIO.FileIO;

public class Helper {
	FileIO fileReader = new FileIO();
	
	// Reads Item Informations and Creates Item class for each item and stores it in an Array
	@SuppressWarnings("unchecked")
	public Item[] ItemInitialization() throws FileNotFoundException {
		// Item informations are stored in an array to initialization
		
		String[][] itemsInformationArray = fileReader.getItems(ChainStoreApp.ITEMS);
		
		// Items Array created to store Items
		Item[] itemsArray = new Item[itemsInformationArray.length];
		
		// Items are created by using a tempItem and stored in a different array
		for(int i=0; i < itemsInformationArray.length; i++) {
				Item tempItem = new Item(itemsInformationArray[i][1],itemsInformationArray[i][0],itemsInformationArray[i][2]);
				
				itemsArray[i] = tempItem;
				
		}
		return itemsArray;
	}
	
	// Reads Transaction Informations and Creates Transaction class for each transaction and stores it in an Array 
	// according to item and month
	@SuppressWarnings("rawtypes")
	public Transaction[][] TransactionInitialization(String filename) throws FileNotFoundException {
		
		// Transaction informations are stored in an array to initialization
		double[][] transactionsInformationArray = fileReader.getTransactionStores(filename);
		
		// Transactions array created to store transactions according to item and month
		
		Transaction[][] transactionsArray = new Transaction[transactionsInformationArray.length][12];
		
		for(int i=0; i< transactionsArray.length;i++) {
			for(int j=0; j<transactionsArray[0].length;j++) {
				//Create tempTransaction
				@SuppressWarnings("unchecked")
				Transaction tempTransaction = new Transaction(
				transactionsInformationArray[i][(3*j)+1],  //purchasePrice
				transactionsInformationArray[i][(3*j)+2], //salePrice
				transactionsInformationArray[i][(3*j)+3]); //numberOfSale
				// Store it in array
				transactionsArray[i][j] = tempTransaction;
				
			}
		}
		// First [] for items Second [] monthly Transaction
		return transactionsArray;
	}
	
	public ItemTransaction[] ItemTransactionInitialization() throws FileNotFoundException {
		// To match items with its transactions their arrays have been created.
		Item[] tempItemsArray = this.ItemInitialization();
		
		
		
		// ItemTransaction Array where itemTransactions will be stored is created .
		ItemTransaction[] itemTransactionArray = new ItemTransaction[tempItemsArray.length];
						
		// Stores are created		
		Transaction[][] tempStore1 = this.TransactionInitialization(ChainStoreApp.STORE_1);
		Transaction[][] tempStore2 = this.TransactionInitialization(ChainStoreApp.STORE_2);
		Transaction[][] tempStore3 = this.TransactionInitialization(ChainStoreApp.STORE_3);
		Transaction[][] tempStore4 = this.TransactionInitialization(ChainStoreApp.STORE_4);
		// Item Transactions properties are created in these for loops.
		for(int i=0; i<tempItemsArray.length;i++) {
			
			// Current item variable initialized. Minus 1 because of index matching.
			Item currentItem = tempItemsArray[i];
			int currentItemIndex = Integer.parseInt((String) currentItem.getId()) - 1;
			
			// Temporary transactions array has been created.
			int storeCount = 4;
			int monthCount = 12;
			Transaction[][] tempTransactions = new Transaction[storeCount][monthCount];
			
			for(int j=0; j<tempStore1[0].length;j++) {
				// Transactions initialized for each store.
				tempTransactions[0][j] = tempStore1[currentItemIndex][j];
				tempTransactions[1][j] = tempStore2[currentItemIndex][j];
				tempTransactions[2][j] = tempStore3[currentItemIndex][j];
				tempTransactions[3][j] = tempStore4[currentItemIndex][j];
			}
			
			// ItemTransaction class created.
			ItemTransaction tempItemTransaction = new ItemTransaction(currentItem,tempTransactions);
			itemTransactionArray[currentItemIndex] = tempItemTransaction;
		}
		return itemTransactionArray;
	}
	
	public AnnualSale AnnualSaleInitialization() throws FileNotFoundException {
		
		 ItemTransaction[] tempItemTransactionsArray = this.ItemTransactionInitialization();
		 ItemTransaction[] itemTransactionsArray = new ItemTransaction[tempItemTransactionsArray.length];
		 for(int i=0; i<tempItemTransactionsArray.length;i++) {
			 itemTransactionsArray[i] = tempItemTransactionsArray[i];
		 }
		 AnnualSale annualSale = new AnnualSale(itemTransactionsArray);
		 
		 return annualSale;
	}
	
	
	// Prints the array elements returns them as a bunch of string
	public static <T> String PrintArray(T[] myArray) {
		String tempString = "";
		for(int i=0; i<myArray.length;i++) {
			tempString += myArray[i] + "\n";
		}
		return tempString;
	}
}
