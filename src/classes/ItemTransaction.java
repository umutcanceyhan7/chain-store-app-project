package classes;

import java.io.FileNotFoundException;

public class ItemTransaction {
	private Item item;
	private Transaction[][] transactions;
	
	ItemTransaction(Item item, Transaction[][] transactions) throws FileNotFoundException{
		this.item = item;
		this.transactions = transactions;
		}
	
	public Item getItem() {
		return item;
	}

	
	public void setItem(Item item) {
		this.item = item;
	}

	public Transaction[][] getTransactions() {
		return transactions;
	}

	public void setTransactions(Transaction[][] transactions) {
		this.transactions = transactions;
	}
	
	
	@Override
	public String toString() {
		return "ItemTransaction [\nItem = " + getItem().getName() + "\n" + "Store1:\n" + Helper.PrintArray(getTransactions()[0])  + "Store2:\n" + Helper.PrintArray(getTransactions()[1])  + "Store3:\n" + Helper.PrintArray(getTransactions()[2])  + "Store4:\n" + Helper.PrintArray(getTransactions()[3]) + "]\n";
	}

	
}
