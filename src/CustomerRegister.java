
import java.util.ArrayList;

public class CustomerRegister {
	private ArrayList<Customer> register = new ArrayList<Customer>();

	public ArrayList<Customer> getRegister() {
		return register;
	}

	public void setRegister(ArrayList<Customer> register) {
		this.register = register;
	}

	public void addCustomer(Customer c) {
		register.add(c);
	}

	public Customer findCustomer(String CustomerNumber) {
		for (Customer c : register) {
			if (c.getCustomerNumber().equals(CustomerNumber)) {
				return c;
			}
		}
		return null;
	}

	public void removeCustomer(String CustomerNumber) {
		for (Customer c : register) {
			if (c.getCustomerNumber().equals(CustomerNumber)) {
				register.remove(c);
			}
		}
	}

	public void andraCustomer(String CustomerNumber, String address, String name) {
		Customer c = this.findCustomer(CustomerNumber);
		c.setAddress(address);
		c.setName(name);
	}

}