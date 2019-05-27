public class OrderLine {
	private String orderLineNumber;
	private int quantity;
	private Order order;
	private Product product;

	public String getNumber() {
		return orderLineNumber;
	}

	public void setNumber(String orderLineNumber) {
		this.orderLineNumber= orderLineNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity =  quantity;
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
	public double getTotalPrice () {
		double totalSum = 0;
		totalSum = (this.getProduct().getPrice()*this.getQuantity());
		return totalSum;
	}

}