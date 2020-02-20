package model.datatable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Product {

	private String name;
	private BigDecimal price;
	private int qty;

	public Product() {
	}

	public Product(Map<String, String> entry) {
		this.name = entry.get("name");
		this.price = new BigDecimal(entry.get("price")).setScale(2, RoundingMode.HALF_UP);
		this.qty = Integer.parseInt(entry.get("qty"));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price.setScale(2, RoundingMode.HALF_UP);
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", qty=" + qty + "]";
	}

}
