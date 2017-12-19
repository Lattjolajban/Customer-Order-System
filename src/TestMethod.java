public class TestMethod {
	public static void main(String[] args) {
		
		ProductRegister pReg = new ProductRegister();
		CustomerRegister cReg = new CustomerRegister();
		Product p1 = new Product();
		OrderLine line1 = new OrderLine();
		OrderLine line2 = new OrderLine();
		Order order1 = new Order();
		Customer customer1 = new Customer();

		p1.setName("Pågatåg");
		p1.setPrice(2000);
		p1.setCategory("Tåg");

		Product p2 = new Product();
		p2.setName("Pågatåg vagn");
		p2.setPrice(500);
		p2.setCategory("Vagnar");

		Unit exp1 = new Unit();
		exp1.setSerialNumber("1");
		exp1.setProduct(p1);
		p1.addUnit(exp1);

		Unit exp2 = new Unit();
		exp2.setSerialNumber("2");
		exp2.setProduct(p1);
		p1.addUnit(exp2);

		Unit exp3 = new Unit();
		exp3.setSerialNumber("3");
		exp3.setProduct(p2);
		p2.addUnit(exp3);

		Unit exp4 = new Unit();
		exp3.setSerialNumber("4");
		exp3.setProduct(p2);
		p2.addUnit(exp4);

		pReg.addProduct(p1);
		pReg.addProduct(p2);

		line1.setNumber("1");
		line1.setProduct(p1);
		line1.setQuantity(2);
		line1.setOrder(order1);

		line2.setNumber("2");
		line2.setProduct(p2);
		line2.setQuantity(2);
		line2.setOrder(order1);

		order1.setOrderID("order1");
		order1.setDeliveryDate("Röv");
		order1.addOrderLine(line1);
		order1.addOrderLine(line2);
		order1.setCustomerOrder(customer1);

		customer1.setName("Olof");
		customer1.setCustomerNumber("1");
		customer1.setAddress("Universitetsgatan 2");
		customer1.addOrder(order1);

		cReg.addCustomer(customer1);

		System.out.println(customer1.summeraOrder("order1"));
		line1.PlusOnequantity(3);
		
	}

}