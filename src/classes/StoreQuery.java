package classes;

import java.io.FileNotFoundException;

import chainStoreApp.ChainStoreApp;
import chainStoreApp.ChainStoreApp.ITEM_CATEGORIES;
import chainStoreApp.ChainStoreApp.STORES;

public class StoreQuery {
	AnnualSale annualSale;
	ItemTransaction[] itemTransactions;
	public StoreQuery() throws FileNotFoundException	{
		Helper helper = new Helper();
		// Initialize annualSale Object
		this.annualSale = helper.AnnualSaleInitialization();
		// Initialize itemTransactions 
		int itemTransactionsCount = this.annualSale.getItemTransactions().length;
		this.itemTransactions =  new ItemTransaction[itemTransactionsCount];
		this.itemTransactions = this.annualSale.getItemTransactions();
		
		
		 
	}
	
	
	
	

	private double findYearlyProfitOfItem(Transaction[][] itemTransaction) throws FileNotFoundException
	{
		
		double yearlyProfit=0;
		
		for (int i=0;i<itemTransaction.length;i++) {
			for (int j=0; j<itemTransaction[0].length;j++) {
				// Profit calculated
				 double salePriceForMonth=(double) itemTransaction[i][j].getSalePrice();
				 double purchasePriceForMonth=(double) itemTransaction[i][j].getPurchasePrice();
				 double numOfSalesForMonth=(double) itemTransaction[i][j].getNumberOfSale();  
				 double monthlyProfit=(salePriceForMonth-purchasePriceForMonth)*numOfSalesForMonth;
				 yearlyProfit+=monthlyProfit;	 
			}
		}
		return yearlyProfit;
	}
	
	
	
	public String findMostProfitableItemForYear() throws FileNotFoundException {
		double mostProfit = 0;
		Item mostProfitableItem = null;
		for(int i=0; i<this.itemTransactions.length;i++) {
			double yearlyProfitOfCurrentItem = this.findYearlyProfitOfItem(this.itemTransactions[i].getTransactions());
			if(mostProfit < yearlyProfitOfCurrentItem) {
				mostProfit = yearlyProfitOfCurrentItem;
				mostProfitableItem = this.itemTransactions[i].getItem();
			}
		}
		
		return (String) mostProfitableItem.getName();
	}
	
	public String findLeastProfitableItemForYear() throws FileNotFoundException 
	{	
		// Assigned a big number to track on least profit
		double leastProfit = 99999999;
		Item leastProfitableItem = null;
		for (int i=0;i<this.itemTransactions.length;i++)
		{   
			double yearlyProfitOfCurrentItem = this.findYearlyProfitOfItem(this.itemTransactions[i].getTransactions());
			
			if(leastProfit > yearlyProfitOfCurrentItem)
			{
				leastProfit = yearlyProfitOfCurrentItem;
				leastProfitableItem = this.itemTransactions[i].getItem();
			}
		}
		return (String) leastProfitableItem.getName();
	}
	
	private double findYearlyProfitOfCategory(ITEM_CATEGORIES category) throws FileNotFoundException
	{   
		double totalProfit=0;
		double yearlyProfit=0;
		for (int i=0;i<this.itemTransactions.length;i++)
		{   
			
			ItemTransaction tempItemTransaction =this.itemTransactions[i];
			if(itemTransactions[i].getItem().getCategory().equals(category.toString()))
			{  Transaction[][] transactionsOfItem =tempItemTransaction.getTransactions();
				yearlyProfit=findYearlyProfitOfItem(transactionsOfItem);
				totalProfit+=yearlyProfit;}
		
			yearlyProfit=0;
		}
		
		
		return totalProfit;
	}
	
	public ITEM_CATEGORIES findLeastProfitableCategoryForYear() throws FileNotFoundException
	{
		double categoryWithLeastProfit = 99999999;
		ITEM_CATEGORIES categoryName = null;
		ITEM_CATEGORIES[] categories = ChainStoreApp.ITEM_CATEGORIES.values();
		int categoryCount = ChainStoreApp.ITEM_CATEGORIES.values().length;
		for(int i=0;i<categoryCount;i++) {
			double categoryProfit = this.findYearlyProfitOfCategory(categories[i]);
			if(categoryWithLeastProfit > categoryProfit) {
				categoryName = categories[i];
				categoryWithLeastProfit = categoryProfit;
			}
		}
		return categoryName;
		
		
	}
		
	// IF CATEGORY DOES NOT SHOW OR SHOW SOMETHING WRONG CHANGE categories[i] to categories[i].toString();
	public ITEM_CATEGORIES findMostProfitableCategoryForYear() throws FileNotFoundException
	{
		double mostProfitOfCategory = 0;
		ITEM_CATEGORIES categoryName = null;
		ITEM_CATEGORIES[] categories = ChainStoreApp.ITEM_CATEGORIES.values();
		int categoryCount = ChainStoreApp.ITEM_CATEGORIES.values().length;
		for(int i=0;i<categoryCount;i++) {
			double categoryProfit = this.findYearlyProfitOfCategory(categories[i]);
			if(mostProfitOfCategory < categoryProfit){
				categoryName = categories[i];
				mostProfitOfCategory = categoryProfit;
			}
		}
		return categoryName;
		
		
	}

		
	
	
	
	public String findMostProfitableItemForSingleSale() throws FileNotFoundException
	{
		double mostProfitOfSale=0;double profitOfSale=0;
		String itemName=" ";
		for(int i=0;i<itemTransactions.length;i++)
		{
			ItemTransaction itemTransaction = itemTransactions[i];
			Transaction[][] transactionsOfItemAtStores =itemTransaction.getTransactions();
			for(int j=0;j<transactionsOfItemAtStores.length;j++)
			{	for(int k=0;k<transactionsOfItemAtStores[0].length;k++)
				{
				// Find more convenient name for transactionsofitemsatstores.
				double purchasePrice=(double) transactionsOfItemAtStores[j][k].getPurchasePrice();
				double salePrice=(double) transactionsOfItemAtStores[j][k].getSalePrice();
				double numOfSales=(double) transactionsOfItemAtStores[j][k].getNumberOfSale();
				
				profitOfSale=(salePrice-purchasePrice)*numOfSales;
				if(profitOfSale>mostProfitOfSale){
					mostProfitOfSale=profitOfSale;
					itemName=(String) itemTransactions[i].getItem().getName();
						}
				
					}
				}
		
			profitOfSale=0;
			
		} 
		return itemName;
	}
	
	
	public String findBestSellingItemForWholeYear() throws FileNotFoundException
	{   
		double mostNumOfSales=0;double numOfSales=0;
		String itemName=" ";
		for(int i=0;i<itemTransactions.length;i++)
		{
			ItemTransaction itemTransaction =itemTransactions[i];
			Transaction[][] transactionsOfItemAtStores=itemTransaction.getTransactions();
			// Loop through stores
			for(int j=0;j<transactionsOfItemAtStores.length;j++){	
				// Loop through transactions of item in stores
				for(int k=0;k<transactionsOfItemAtStores[0].length;k++){
				 // Calculates the sold item amount
				 numOfSales += ((double) transactionsOfItemAtStores[j][k].getNumberOfSale());
			}
				// If value is more than most value if statement works.
				if(numOfSales>mostNumOfSales){
				
				// Former most amount changes with new amount.
					mostNumOfSales=numOfSales;
					itemName=(String) itemTransactions[i].getItem().getName();
				}
			numOfSales=0;
			}
		}
		return itemName;
	}
	
	public STORES findMostProfitableStoreForEachMonth(int month) throws FileNotFoundException
	{
		int monthToIndex = month - 1;
		double monthlyProfitStore1=0;double monthlyProfitStore2=0;double monthlyProfitStore3=0;double monthlyProfitStore4=0;
		double maxProfit;
		
		
		for (int i=0;i<itemTransactions.length;i++)
		{
			ItemTransaction itemTransaction=itemTransactions[i];
			Transaction[][] transactionsOfItemAtStores=itemTransaction.getTransactions();
			for(int j=0;j<transactionsOfItemAtStores.length;j++)
			{
				double purchasePrice=(double) transactionsOfItemAtStores[j][(int) monthToIndex].getPurchasePrice();
				double salePrice=(double) transactionsOfItemAtStores[j][(int) monthToIndex].getSalePrice();
				double numOfSales=(double) transactionsOfItemAtStores[j][(int) monthToIndex].getSalePrice();
				double profit=(salePrice-purchasePrice)*(numOfSales);
				// Controls store
				if(j==0) {monthlyProfitStore1+=profit;}
				else if(j==1) {monthlyProfitStore2+=profit;}
				else if(j==2) {monthlyProfitStore3+=profit;}
				else  {monthlyProfitStore4+=profit;}
				}
			}
		// Compares stores
		maxProfit = Math.max(monthlyProfitStore4,Math.max(monthlyProfitStore3,Math.max(monthlyProfitStore2,monthlyProfitStore1)));
		STORES storesArray[] = STORES.values();
		if(maxProfit==monthlyProfitStore1) {return storesArray[0];}
		else if(maxProfit==monthlyProfitStore2) {return storesArray[1];}	
		else if(maxProfit==monthlyProfitStore3) {return storesArray[2];}
		else {return storesArray[3];}
	}

	/*
*/

	public AnnualSale getAnnualSale() {
		return annualSale;
	}




	public void setAnnualSale(AnnualSale annualSale) {
		this.annualSale = annualSale;
	}
	
}
