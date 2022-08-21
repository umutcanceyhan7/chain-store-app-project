package classes;

public class Item<T1,T2,T3> {
	// ITEM PROPERTIES WITH DYNAMIC OPTIONS
	T1 id;
	T2 name;
	T3 category;
	// ITEM CONSTRUCTOR
	Item(T1 id,T2 name,T3 category){
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
	// GETTERS AND SETTERS
	protected T1 getId() {
		return id;
	}
	protected void setId(T1 id) {
		this.id = id;
	}
	protected T2 getName() {
		return name;
	}
	protected void setName(T2 name) {
		this.name = name;
	}
	protected T3 getCategory() {
		return category;
	}
	protected void setCategory(T3 category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [id=" + getId() + ", name=" + getName() + ", category=" + getCategory() + "]";
	}
	
}
