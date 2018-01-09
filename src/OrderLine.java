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
		this.quantity = this.getQuantity()+ quantity;
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

	public void MinusOnequantity() {
		this.quantity--;
	}

	public void PlusOnequantity() {
		this.quantity++;
	}

}