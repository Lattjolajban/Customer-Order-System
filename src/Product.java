import java.util.ArrayList;

public class Product {
	private String name;
	private String category;
	private double price;
	private ArrayList<Unit> unitList = new ArrayList <Unit>();

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

	public ArrayList <Unit> getUnitList() {
		return unitList;
	}

	public void setUnitList(ArrayList <Unit> UnitList) {
		this.unitList = UnitList;
	}

	public void addUnit(Unit e) {
		unitList.add(e);
	}

	public Unit findUnit(String serialNumber) {
		for (Unit u : unitList) {
			if (u.getSerialNumber().equals(serialNumber)) {
				return u;
			}
		}
	return null;
	} 
	public void removeUnit (String serialNumber) {
		Unit unit = this.findUnit(serialNumber);
		if (unit!=null) {
			unitList.remove(unit);
		}
	}

}