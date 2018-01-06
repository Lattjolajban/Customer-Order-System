
import java.util.ArrayList;

public class CustomerRegister {
	private ArrayList<Customer> register = new ArrayList<Customer>();

	public ArrayList<Customer> getRegister() {
		return register;
	}

	public void setRegister(ArrayList<Customer> register) {
		this.register = register;
	}

	public void addCustomer(Customer customer) {
		register.add(customer);
	}

	public Customer findCustomer(String customerNumber) {
		for (Customer customer : register) {
			if (customer.getCustomerNumber().equals(customerNumber)) {
				return customer;
			}
		}
		return null;
	}

	public void removeCustomer(String customerNumber) {
		for (Customer customer : register) {
			if (customer.getCustomerNumber().equals(customerNumber)) {
				register.remove(customer);
			}
		}
	}

	public void andraCustomer(String customerNumber, String address, String name) {
		Customer customer = this.findCustomer(customerNumber);
		customer.setAddress(address);
		customer.setName(name);
	}

}