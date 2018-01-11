import java.util.ArrayList;

public class ProductRegister {
	private ArrayList<Product> productRegister = new ArrayList<Product>();

	public ArrayList<Product> getProductRegister() {
		return productRegister;
	}

	public void setProductRegister(ArrayList<Product> productRegister) {
		this.productRegister = productRegister;
	}

	public void addProduct(Product product) {
		productRegister.add(product);
	}

	public void removeProduct(String productName) {
		Product product = this.findProduct(productName);
			if (product != null) {
				productRegister.remove(product);
			}
	}

	public Product findProduct(String productName) {

		for (Product product : productRegister) {
			if (product.getName().equals(productName)) {
				return product;
			}
		}
		return null;
	}

}