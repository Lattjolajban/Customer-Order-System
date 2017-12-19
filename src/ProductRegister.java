import java.util.ArrayList;

public class ProductRegister {
	private ArrayList<Product> reg = new ArrayList<Product>();

	public ArrayList<Product> getProductRegister() {
		return reg;
	}

	public void setProductRegister(ArrayList<Product> reg) {
		this.reg = reg;
	}

	public void addProduct(Product p) {
		reg.add(p);
	}

	public void removeProduct(String name) {
		Product p = this.findProduct(name);
			if (p != null) {
				reg.remove(p);
			}
	}

	public Product findProduct(String name) {

		for (Product p : reg) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

}