import java.util.ArrayList;
import java.util.Random;

public class Product {
	private String productName;
	private String productCategory;
	private double productPrice;
	private Random randomGenerator = new Random();
	private ArrayList<Unit> unitList = new ArrayList<Unit>();

	public String getName() {
		return productName;
	}

	public void setName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return productCategory;
	}

	public void setCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getPrice() {
		return productPrice;
	}

	public void setPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public ArrayList<Unit> getUnitList() {
		return unitList;
	}

	public void setUnitList(ArrayList<Unit> UnitList) {
		this.unitList = UnitList;
	}

	public void addUnit(Unit unit) {
		unitList.add(unit);
	}

	public Unit findUnit(String serialNumber) {
		for (Unit unit : unitList) {
			if (unit.getSerialNumber().equals(serialNumber)) {
				return unit;
			}
		}
		return null;
	}

	public void removeUnit(String serialNumber) {
		Unit unit = this.findUnit(serialNumber);
		if (unit != null) {
			unitList.remove(unit);

		}
	}

	public Unit getRandomUnit () {
		Unit unit = unitList.get(randomGenerator.nextInt(unitList.size()));
		return unit;
	}

	public void removeRandomUnit() {
		//unitList.remove(randomGenerator.nextInt(unitList.size())); //experimental!
		unitList.remove(this.getRandomUnit());
	}

}