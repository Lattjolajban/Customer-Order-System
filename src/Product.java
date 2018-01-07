import java.util.ArrayList;
import java.util.Random;

public class Product {
	private String name;
	private String category;
	private double price;
	private Random randomGenerator = new Random();
	private ProductRegister productRegister;
	private ArrayList<Unit> unitList = new ArrayList<Unit>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
		for (Unit u : unitList) {
			if (u.getSerialNumber().equals(serialNumber)) {
				return u;
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

	public int countProductUnits() {
		int counter = 0;
		if (unitList.iterator().hasNext()) {
			counter = counter + 1;
		}
		return counter;

	}

	public void removeRandomUnit(int quantity) {
		while (quantity != 0) {
			if (quantity <= this.countProductUnits()) {
				this.unitList.remove(randomGenerator.nextInt(unitList.size()));
				quantity = quantity - 1;
			}
		}
	}

}