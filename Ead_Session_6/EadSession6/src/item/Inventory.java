package item;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Inventory {

	private String name;
	private int quantity;

	public String getName() {
		// Method to return name of item

		return name;
	}

	public void setName(String name) {
		// Method to return name of item

		this.name = name;
	}

	public int getQuantity() {
		// Method to return quantity of item

		return quantity;
	}

	public void setQuantity(int quantity) {
		// Method to set name of item

		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "inventory [name=" + name + ", quantity=" + quantity + "]";
	}

}
