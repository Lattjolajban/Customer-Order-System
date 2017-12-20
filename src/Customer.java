
import java.util.ArrayList;

public class Customer {
	private String customerNumber;
	private String name;
	private String address;
	private ArrayList<Order> orderList = new ArrayList<Order>();

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

	public void addOrder(Order o) {
		orderList.add(o);
	}

	public void removeOrder(String orderID) {
		for (Order order : orderList) {
			if (order.getOrderID().equals(orderID)) {
				orderList.remove(order);
			}
		}
		
	}

	public Order findOrder(String orderID) {
		for (Order o : orderList) {
			if (o.getOrderID().equals(orderID)) {
				return o;
			}
		}

		return null;
	}

	public Double summeraOrder(String orderID) {
		double summa = 0;
		Order o = this.findOrder(orderID);
		for (OrderLine r : o.getLines()) {
			summa += r.getProduct().getPrice() * r.getQuantity();

		}
		return summa;
	}

}