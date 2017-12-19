import java.util.ArrayList;

public class Order {
	private String orderID;
	private String deliveryDate;
	private Customer CustomerOrder;
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
		return CustomerOrder;
	}

	public void setCustomerOrder(Customer CustomerOrder) {
		this.CustomerOrder = CustomerOrder;
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

	public void removeOrderLine(String number) {
		for (OrderLine line : lines) {
			if (line.getNumber().equals(number)) {
				lines.remove(line);
			}
		}
	}

	public OrderLine findOrderLine(String number) {
		for (OrderLine line : lines) {
			if (line.getNumber().equals(number)){
				return line;
			}
		}
		return null;
	}

}