package classes;

public class Transaction<T1,T2,T3> {
	T1 purchasePrice;
	T2 salePrice;
	T3 numberOfSale;
	
	Transaction(T1 purchasePrice, T2 salePrice, T3 numberOfSale){
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.numberOfSale = numberOfSale;
	}

	public T1 getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(T1 purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public T2 getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(T2 salePrice) {
		this.salePrice = salePrice;
	}

	public T3 getNumberOfSale() {
		return numberOfSale;
	}

	public void setNumberOfSale(T3 numberOfSale) {
		this.numberOfSale = numberOfSale;
	}

	@Override
	public String toString() {
		return "Transaction [purchasePrice=" + getPurchasePrice() + ", salePrice=" + getSalePrice() + ", numberOfSale="
				+ getNumberOfSale() + "]";
	}
	
}
