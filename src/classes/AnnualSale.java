package classes;


public class AnnualSale {
	ItemTransaction[] itemTransactions;
	
	AnnualSale(ItemTransaction[] itemTransactions){
		this.itemTransactions = itemTransactions;
	}

	public ItemTransaction[] getItemTransactions() {
		return itemTransactions;
	}

	public void setItemTransactions(ItemTransaction[] itemTransactions) {
		this.itemTransactions = itemTransactions;
	}

	public String toString() {
		return "AnnualSale\n ItemTransactions:" + Helper.PrintArray(this.itemTransactions);
	}
	
}
