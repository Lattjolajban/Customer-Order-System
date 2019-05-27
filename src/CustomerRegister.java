
import java.util.ArrayList;

public class CustomerRegister {
	private ArrayList<Customer> customerRegister = new ArrayList<Customer>();

	public ArrayList<Customer> getCustomerRegister() {
		return customerRegister;
	}

	public void setCustomerRegister(ArrayList<Customer> register) {
		this.customerRegister = register;
	}

	public void addCustomer(Customer customer) {
		customerRegister.add(customer);
	}

	public Customer findCustomer(String customerNumber) {
		for (Customer customer : customerRegister) {
			if (customer.getCustomerNumber().equals(customerNumber)) {
				return customer;
			}
		}
		return null;
	}

	public void removeCustomer(String customerNumber) {
		Customer customer = this.findCustomer(customerNumber);
		if (customer != null) {
			customerRegister.remove(customer);
		}
	}

	public void andraCustomer(String customerNumber, String customerAddress, String customerName) {
		Customer customer = this.findCustomer(customerNumber);
		customer.setCustomerAddress(customerAddress);
		customer.setCustomerName(customerName);
	}

}