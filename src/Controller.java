import java.util.ArrayList;

import javax.swing.JFrame;

public class Controller {
	CustomerRegister customerRegister = new CustomerRegister();
	ProductRegister productRegister = new ProductRegister();
	Product product = new Product ();
	Unit unit = new Unit ();
	
	private ArrayList<Product> saveProduct = new ArrayList<Product>();
	private ArrayList<Unit> saveUnit = new ArrayList<Unit>();
	
	JFrame menuIF;
	JFrame customerOrderIF;
	JFrame productUnitIF;
	
	public Controller(CustomerRegister customerRegister, ProductRegister productRegister,JFrame menuIF, JFrame productUnitIF, JFrame customerOrderIF, Product product, Unit unit) {
		this.customerRegister = customerRegister;
		this.productRegister = productRegister;
		this.menuIF = menuIF;
		this.productUnitIF = productUnitIF;
		this.customerOrderIF=customerOrderIF;
		this.unit = unit;
		this.product = product;
		
 	}
	
	
	public void addProduct(String name, String category, double price) {
		product = new Product();
		product.setCategory(category);
		product.setName(name);
		product.setPrice(price);
		productRegister.addProduct(product);
		saveProduct.add(product);
	}
	
	public ArrayList<Product> getArrayListProduct() {
		ArrayList<Product> productList = productRegister.getProductRegister();
		return productList;
	}
	public Product findProduct(String name) {
		product = productRegister.findProduct(name);
				if(product!=null) {
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
	public void addUnit(String serialNumber, String name) {
		unit.setSerialNumber(serialNumber);
		product=this.findProduct(name);
		product.addUnit(unit);
		
	}
	public Unit findUnit (String serialNumber, String name) {
		product = this.findProduct(name);
		if (product != null) {
			return product.findUnit(serialNumber);
		}
		return null;
		
		
	}
	public void removeUnit(String serialNumber, String name) {
		product=this.findProduct(name);
		product.removeUnit(serialNumber);
	}


	public ArrayList<Product> getSaveProduct() {
		return saveProduct;
	}


	public void setSaveProduct(ArrayList<Product> saveProduct) {
		this.saveProduct = saveProduct;
	}


	public ArrayList<Unit> getSaveUnit() {
		ArrayList <Unit> saveUnit = product.getUnitList();
		return saveUnit;
	}


	public void setSaveUnit(ArrayList<Unit> saveUnit) {
		this.saveUnit = saveUnit;
	}
	

}