import java.util.ArrayList;

import javax.swing.JFrame;

public class Controller {
	CustomerRegister customerRegister;
	ProductRegister productRegister;
	Product prod;
	private ArrayList<Product> saveProduct = new ArrayList<Product>();
	private ArrayList<Unit> saveUnit = new ArrayList<Unit>();
	
	JFrame menuIF;
	JFrame customerOrderIF;
	JFrame productUnitIF;
	
	public Controller(CustomerRegister customerRegister, ProductRegister productRegister,JFrame menuIF) {
		this.customerRegister = customerRegister;
		this.productRegister = productRegister;
		this.menuIF = menuIF;
		
 	}
	
	
	public void addProduct(String name, String category, double price) {
		Product product = new Product();
		product.setCategory(category);
		product.setName(name);
		product.setPrice(price);
		productRegister.addProduct(product);
		saveProduct.add(product);
	}
	
	public ArrayList<Product> getArrayListProduct() {
		ArrayList<Product> prod = productRegister.getProductRegister();
		return prod;
	}
	public Product findProduct(String name) {
		Product product = productRegister.findProduct(name);
				if(product!=null) {
					return product;
				}
		return null;
	}
	public void removeProduct(String name) {
		productRegister.removeProduct(name);
		
	}
	public void changeProduct(String name, String category, double price) {
		Product product = this.findProduct(name);
		product.setCategory(category);
		product.setPrice(price);
		
	}
	public void addUnit(String serialNumber, String name) {
		Unit unit = new Unit();
		unit.setSerialNumber(serialNumber);
		Product product=this.findProduct(name);
		product.addUnit(unit);
		
	}
	public Unit findUnit (String serialNumber, String name) {
		Product p = this.findProduct(name);
		if (p!= null) {
			return p.findUnit(serialNumber);
		}
		return null;
		
		
	}
	public void removeUnit(String serialNumber, String name) {
		Product product=this.findProduct(name);
		product.removeUnit(serialNumber);
	}


	public ArrayList<Product> getSaveProduct() {
		return saveProduct;
	}


	public void setSaveProduct(ArrayList<Product> saveProduct) {
		this.saveProduct = saveProduct;
	}


	public ArrayList<Unit> getSaveUnit() {
		ArrayList <Unit> saveUnit = prod.getUnitList();
		return saveUnit;
	}


	public void setSaveUnit(ArrayList<Unit> saveUnit) {
		this.saveUnit = saveUnit;
	}
	

}