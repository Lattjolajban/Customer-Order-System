import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class Controller {
	CustomerRegister customerRegister;
	ProductRegister productRegister;
	Product product;
	Customer customer;
	Order order;
	OrderLine orderLine;
	Unit unit;

	private ArrayList<Unit> tempOrderUnits = new ArrayList<Unit>();

	JFrame interFace;

	public Controller(CustomerRegister customerRegister, ProductRegister productRegister, JFrame interFace) {
		this.customerRegister = customerRegister;
		this.productRegister = productRegister;
		this.interFace = interFace;

	}

	public ArrayList<Order> getArrayListOrders() {
		ArrayList<Order> orders = customer.getOrderList();
		return orders;
	}

	public void addOrder(String orderID, String deliveryDate, String customerNumber) {
		order = new Order();
		customer = this.findCustomer(customerNumber);
		// if (order != customer.findOrder(orderID)) {
		order.setOrderID(orderID);
		order.setDeliveryDate(deliveryDate);
		customer.addOrder(order);
		order.setCustomerOrder(customer); // Detta kanske behöver findCustomer i registret
	}

	public Order findOrder(String orderID) {
		order = customer.findOrder(orderID);
		if (order != null) {
			return order;
		}

		return null;
	}

	public void removeOrder(String orderID, String customerNumber) {
		customer = this.findCustomer(customerNumber);
		customer.removeOrder(orderID);
	}

	public ArrayList<OrderLine> getArrayListOrderLines() {
		ArrayList<OrderLine> orderLines = order.getLines();
		return orderLines;
	}

	public void addOrderLines(String orderID, int quantity, String orderLineNumber, String productName) {
		order = this.findOrder(orderID);
		product = this.findProduct(productName);
		orderLine = this.findOrderLine(orderLineNumber, orderID);
		if (orderLine == null || orderLine.getProduct() != product) {
			orderLine = new OrderLine();
			if (product.getUnitList().size() >= quantity) {
				orderLine.setNumber(orderLineNumber);
				orderLine.setProduct(product);
				orderLine.setOrder(order);
				orderLine.setQuantity(quantity);
				order.addOrderLine(orderLine);
				
			}
		} else {
			if (product.getUnitList().size() >= quantity) {
				orderLine.setQuantity(orderLine.getQuantity() + quantity);
				
			}

		}
		while (quantity != 0) {
			unit = product.getRandomUnit();
			tempOrderUnits.add(unit);
			product.removeUnit(unit.getSerialNumber());
			quantity--;
		}

	}

	public boolean enoughInStock(String orderID, String productName, int quantity) {
		order = this.findOrder(orderID);
		product = this.findProduct(productName);
		if (product.getUnitList().size() >= quantity) {
			return true;
		}
		return false;
	}

	public boolean isProductInOrderAlready(String orderID, String productName) {
		order = this.findOrder(orderID);
		product = this.findProduct(productName);
		for (OrderLine orderLine : order.getLines()) {
			if (orderLine != null && orderLine.getProduct().getName() == product.getName()) {
				return true;
			}
		}
		return false;
	}

	public boolean isProductOnOrderLine(String orderID, String productName, String orderLineNumber) {
		order = this.findOrder(orderID);
		product = this.findProduct(productName);
		orderLine = this.findOrderLine(orderLineNumber, orderID);
		if (orderLine.getProduct() == product) {
			return true;
		}
		return false;
	}

	public OrderLine findOrderLine(String orderLineNumber, String orderID) {
		order = this.findOrder(orderID);
		orderLine = order.findOrderLine(orderLineNumber);
		if (orderLine != null) {
			return orderLine;
		}
		return null;
	}

	public void removeOrderLine(String orderLineNumber, String orderID) {
		order = this.findOrder(orderID);
		order.removeOrderLine(orderLineNumber);
		tempOrderUnits.clear();
	}

	public ArrayList<Customer> getArrayListCustomers() {
		ArrayList<Customer> customers = customerRegister.getRegister();
		return customers;
	}

	public void addCustomer(String name, String address, String customerNumber) {
		customer = new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.setCustomerNumber(customerNumber);
		customerRegister.addCustomer(customer);

	}

	public Customer findCustomer(String customerNumber) {
		customer = customerRegister.findCustomer(customerNumber);
		if (customer != null) {
			return customer;
		}
		return null;
	}

	public void removeCustomer(String customerNumber) {
		customerRegister.removeCustomer(customerNumber);
	}

	public void changeCustomer(String name, String address, String customerNumber) {
		customer = this.findCustomer(customerNumber);
		customer.setAddress(address);
		customer.setName(name);
	}

	public ArrayList<Product> getArrayListProducts() {
		ArrayList<Product> products = productRegister.getProductRegister();
		return products;
	}

	public void addProduct(String name, String category, double price) {
		product = new Product();
		product.setCategory(category);
		product.setName(name);
		product.setPrice(price);
		productRegister.addProduct(product);
	}

	public Product findProduct(String name) {
		product = productRegister.findProduct(name);
		if (product != null) {
			return product;
		}
		return null;
	}

	public void removeProduct(String name) {
		productRegister.removeProduct(name);

	}

	public void changeProduct(String name, String category, double price) {
		product = this.findProduct(name);
		product.setCategory(category);
		product.setPrice(price);

	}

	public ArrayList<Unit> getArrayListUnits() {
		ArrayList<Unit> units = product.getUnitList();
		return units;
	}

	public void addUnit(String serialNumber, String name) {
		product = this.findProduct(name);
		unit = new Unit();
		unit.setSerialNumber(serialNumber);
		product.addUnit(unit);

	}

	public Unit findUnit(String serialNumber, String name) {
		product = this.findProduct(name);
		if (product != null) {
			return product.findUnit(serialNumber);
		}
		return null;

	}

	public void removeUnit(String serialNumber, String name) {
		product = this.findProduct(name);
		product.removeUnit(serialNumber);
	}

	public double sumOrder(String orderID) {
		double totalPrice = 0;
		order = this.findOrder(orderID);
		for (OrderLine orderLine : order.getLines()) {
			if (orderLine != null) {
				totalPrice += orderLine.getTotalPrice();
			}
		}
		return totalPrice;

	}

}