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

	private ArrayList<Unit> tempOrderUnits = new ArrayList<Unit>(); // Is not used. future function

	JFrame interFace;

	public Controller(JFrame interFace) {
		customerRegister = new CustomerRegister ();
		productRegister = new ProductRegister();
		this.interFace = interFace;

	}

	public void addOrder(String orderID, String deliveryDate, String customerNumber) {
		if (this.IsOrderIDTaken(orderID)==false) {
		order = new Order();
		customer = this.findCustomer(customerNumber);
		order.setOrderID(orderID);
		order.setDeliveryDate(deliveryDate);
		customer.addOrder(order);
		order.setCustomerOrder(customer);
		}
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
		if (orderLine!=null) {
			if (product.getName() == orderLine.getProduct().getName()) {
			return true;
			}	
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
		ArrayList<Customer> customers = customerRegister.getCustomerRegister();
		return customers;
	}

	public void addCustomer(String customerName, String customerAddress, String customerNumber) {
		customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setCustomerAddress(customerAddress);
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

	public void changeCustomer(String customerName, String customerAddress, String customerNumber) {
		customer = this.findCustomer(customerNumber);
		customer.setCustomerAddress(customerAddress);
		customer.setCustomerName(customerName);
	}
	
	// Is method used?
	public ArrayList<Product> getArrayListProducts() { 
		ArrayList<Product> products = productRegister.getProductRegister(); 
		return products;
	}

	public void addProduct(String productName, String productCategory, double productPrice) {
		product = new Product();
		product.setCategory(productCategory);
		product.setName(productName);
		product.setPrice(productPrice);
		productRegister.addProduct(product);
	}

	public Product findProduct(String productName) {
		product = productRegister.findProduct(productName);
		if (product != null) {
			return product;
		}
		return null;
	}

	public void removeProduct(String productName) {
		productRegister.removeProduct(productName);

	}
	// Is method used?
	public ArrayList<Unit> getArrayListUnits() {
		ArrayList<Unit> units = product.getUnitList();
		return units;
	}

	public void addUnit(String serialNumber, String productName) {
		product = this.findProduct(productName);
		unit = new Unit();
		unit.setSerialNumber(serialNumber);
		product.addUnit(unit);

	}

	public Unit findUnit(String serialNumber, String productName) {
		product = this.findProduct(productName);
		if (product != null) {
			return product.findUnit(serialNumber);
		}
		return null;

	}

	public void removeUnit(String serialNumber, String productName) {
		product = this.findProduct(productName);
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
	public String showProductUnits (String productName) {
		product = this.findProduct(productName);
		String message = "";
		for (Unit unit : product.getUnitList()) {
			if (unit!=null) {
				message += "Serienummer: " + unit.getSerialNumber() + "\n";
				
			}
		}
		return message;
	}
	public String showCustomerOrders (String customerNumber) {
		customer = this.findCustomer(customerNumber);
		String message = "";
		for (Order order : customer.getOrderList()) {
			if (order!=null) {
				message += "Ordernummer: " + order.getOrderID() + "\n";
			}
		}
		return message;
	}
	public void changeProduct (String productName, String productCategory, double productPrice) {
		product = this.findProduct(productName);
		if (product!=null) {
			if (product.getCategory() != productCategory || product.getPrice()!=productPrice) {
				product.setCategory(productCategory);
				product.setPrice(productPrice);
			}
			
		}
				
		
	}
	public Order findOrder(String orderID) {
		for (Customer customer : customerRegister.getCustomerRegister()) {
			order = customer.findOrder(orderID);
			if (order != null) {
				return order;
			}
		}

		return null;
	}
	public boolean IsOrderIDTaken (String orderID) {
		for (Customer customer : customerRegister.getCustomerRegister()) {
			if (customer !=null) {
				for (Order order : customer.getOrderList()) {
					if (order.getOrderID().equals(orderID)) {
						return true;
					}
				}
			}
		}
		return false;
	}


}