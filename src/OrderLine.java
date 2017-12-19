public class OrderLine {
	private String number;
	private int quantity;
	private Order o;
	private Product p;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setOrder(Order o) {
		this.o = o;
	}

	public Order getOrder() {
		return o;
	}

	public Product getProduct() {
		return p;
	}

	public void setProduct(Product p) {
		this.p = p;
	}

	public void MinusOnequantity(int quantity) {
		this.quantity = quantity - 1;
	}

	public void PlusOnequantity(int quantity) {
		this.quantity = quantity + 1;
	}

}