public class OrderLine {
	private String number;
	private int quantity;
	private Order order;
	private Product product;

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

	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void MinusOnequantity(int quantity) {
		this.quantity = quantity - 1;
	}

	public void PlusOnequantity(int quantity) {
		this.quantity = quantity + 1;
	}

}