import java.util.ArrayList;

public class Order {
	private String orderID;
	private String deliveryDate;
	private Customer customerOrder;
	private ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();

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
		return orderLines;
	}

	public void setLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}

	public OrderLine findOrderLine(String number) {
		for (OrderLine orderLine : orderLines) {
			if (orderLine.getNumber().equals(number)) {
				return orderLine;
			}
		}
		return null;
	}

	public void removeOrderLine(String number) {
		OrderLine orderLine = this.findOrderLine(number);
		if (orderLine != null) {
			orderLines.remove(orderLine);
		}
	}
	 public double sumOrder (String orderID) {
		double sum = 0.00;
		for (OrderLine orderLine : orderLines) {
			sum =+ orderLine.getProduct().getPrice() * orderLine.getQuantity();
			
		}
		return sum;
	} 
}
