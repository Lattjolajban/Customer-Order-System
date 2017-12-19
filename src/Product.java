import java.util.ArrayList;

public class Product {
	private String name;
	private String category;
	private double price;
	private ArrayList<Unit> UnitList = new ArrayList <Unit>();

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
		return UnitList;
	}

	public void setUnitList(ArrayList <Unit> UnitList) {
		this.UnitList = UnitList;
	}

	public void addUnit(Unit e) {
		UnitList.add(e);
	}

	public void removeUnit(String serialNumber) {
		for (Unit e : UnitList) {
			if (e.getSerialNumber().equals(serialNumber)) {
				UnitList.remove(e);
			}
		}
	}

	public Unit findUnit(String serialNumber) {
		for (Unit u : UnitList) {
			if (u.getSerialNumber().equals(serialNumber)) {
				return u;
			}
		}
	return null;
	} 

}