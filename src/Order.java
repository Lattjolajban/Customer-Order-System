import java.util.ArrayList;

public class Order {
	private String orderID;
	private String deliveryDate;
	private Customer customerOrder;
	private ArrayList<OrderLine> lines = new ArrayList<OrderLine>();

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Customer getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(Customer CustomerOrder) {
		this.customerOrder = CustomerOrder;
	}

	public ArrayList<OrderLine> getLines() {
		return lines;
	}

	public void setLines(ArrayList<OrderLine> line) {
		this.lines = line;
	}

	public void addOrderLine(OrderLine r) {
		lines.add(r);
	}

	public OrderLine findOrderLine(String number) {
		for (OrderLine line : lines) {
			if (line.getNumber().equals(number)) {
				return line;
			}
		}
		return null;
	}

	public void removeOrderLine(String number) {
		OrderLine orderLine = this.findOrderLine(number);
		if (orderLine != null) {
			lines.remove(orderLine);
		}
	}
	public Double sumOrder (String orderID) {
		double sum = 0.00;
		for (OrderLine orderLine : lines) {
			sum += orderLine.getProduct().getPrice() * orderLine.getQuantity();

		}
		
		return sum;
	}
}
