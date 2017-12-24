import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class InterFace {

	private JFrame frame;
	
	private JPanel panelMenu;
	private JPanel panelProductUnit;
	private JPanel panelCustomerOrder;
	
	private JTextField textField_name;
	private JTextField textField_category;
	private JTextField textField_price;
	private JTextField textField_serialNumber;
	private JTextArea textOutput;
	
	private Controller controller; // Connects to the controller
	private ProductRegister productRegister;
	private CustomerRegister customerRegister;
	

	private JTextField textField_customerName;
	private JTextField textField_address;
	private JTextField textField_customerNumber;
	private JTextField textField_orderId;
	private JTextField textField_deliveryDate;
	private JTextField textField_productName;
	private JTextField textField_quantity;
	private JTextField textField_orderLineNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterFace window = new InterFace();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterFace() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		productRegister = new ProductRegister ();
		customerRegister = new CustomerRegister();
		controller = new Controller (customerRegister, productRegister, frame);
		
		// MENU PANEL
		
		panelMenu = new JPanel(); // MENU PANEL
		frame.getContentPane().add(panelMenu, "name_61063878729913"); 
		panelMenu.setLayout(null);
		panelMenu.setVisible(true);
		
		JButton btnCustomerOrderButton = new JButton("Kund & Order");
		btnCustomerOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCustomerOrder.show();
				panelMenu.hide();
			}
		});
		btnCustomerOrderButton.setBounds(189, 45, 132, 44);
		panelMenu.add(btnCustomerOrderButton);
		
		JButton btnProductUnitButton = new JButton("Produkt & Exemplar");
		btnProductUnitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelProductUnit.show();
				panelMenu.hide();
				
			}
		});
		btnProductUnitButton.setBounds(189, 104, 132, 44);
		panelMenu.add(btnProductUnitButton);
		
		// PRODUCT & UNIT PANEL
		
		panelProductUnit = new JPanel(); // Product & Unit Panel
		frame.getContentPane().add(panelProductUnit, "name_61067685360616");
		panelProductUnit.setVisible(false);
		
		JLabel lblProduct = new JLabel("Produkt");
		lblProduct.setBounds(95, 10, 55, 14);
		
		JLabel lblName = new JLabel("Namn:");
		lblName.setBounds(25, 30, 55, 14);
		
		JLabel lblCategory = new JLabel("Kategori:");
		lblCategory.setBounds(25, 55, 55, 14);
		
		JLabel lblPrice = new JLabel("Pris:");
		lblPrice.setBounds(25, 80, 55, 14);
		
		textField_name = new JTextField();
		textField_name.setBounds(115, 30, 85, 20);
		textField_name.setColumns(10);
		
		textField_category = new JTextField();
		textField_category.setBounds(115, 55, 85, 20);
		textField_category.setColumns(10);
		
		textField_price = new JTextField();
		textField_price.setBounds(115, 80, 85, 20);
		textField_price.setColumns(10);
		textField_price.setText("0");
		
		JButton btnAddProduct = new JButton("Lägg till");
		btnAddProduct.setBounds(25, 115, 85, 23);
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_name.getText();
				String category = textField_category.getText();
				String priceString = textField_price.getText();
				double price = Double.parseDouble(priceString);
				Product product = controller.findProduct(name);
				
				if (textField_name.getText().isEmpty()) {
					textOutput.append("Fyll i Produktens Namn, Kategori och Pris \n");
				}
				else if (controller.getArrayListProducts().contains(product)) {
					textOutput.setText("Produkten finns redan i systemet \n");
				}
				else {
					controller.addProduct(name, category, price);
					textOutput.append(name + " har lagts till i systemet \n");
					textField_name.setText("");
					textField_category.setText("");
					textField_price.setText("0");
					
				}
				textField_price.setText("0");
				
			}
		});
		
		JButton btnRemoveProduct = new JButton("Ta bort");
		btnRemoveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText();
				Product product = controller.findProduct(name);
				
				if (textField_name.getText().isEmpty()) {
					textOutput.append("Fyll i Produktnamn \n");
				}
				else if (product==null) {
					textOutput.append("Produkten kan inte hittas \n");
					textField_name.setText("");
					textField_category.setText("");
					textField_price.setText("0");
				}
				else {
					controller.removeProduct(name);
					if (controller.findProduct(name)==null) {
						textOutput.append(product.getName() + " har tagits bort ur produktregistret \n");
					}
					textField_name.setText("");
					textField_category.setText("");
					textField_price.setText("0");
				}
			}
		});
		btnRemoveProduct.setBounds(115, 115, 85, 23);
		
		JButton btnSearchProduct = new JButton("Sök");
		btnSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText();
				Product product = controller.findProduct(name);
				
				if (textField_name.getText().isEmpty()) {
					textOutput.append("Fyll i produktnamn \n");
					textField_price.setText("0");
				}
				else if (product == null) {
					textOutput.append("Hittar inte produkten: " + textField_name.getText() + "\n");
					textField_name.setText("");
					textField_category.setText("");
					textField_price.setText("0");
					
				}
				else {
					textOutput.append("Namn: " + product.getName() + "\nKategori: " + product.getCategory() + "\nPris: " + product.getPrice()+ "\n");
				}
					
				
			}
		});
		btnSearchProduct.setBounds(25, 145, 85, 23);
		
		JButton btnChangeProduct = new JButton("Ändra");
		btnChangeProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText();
				String category = textField_category.getText();
				String priceString = textField_price.getText();
				double price = Double.parseDouble(priceString);
				Product product = controller.findProduct(name);
				
				if(textField_name.getText().isEmpty() || textField_category.getText().isEmpty() || textField_price.getText().isEmpty()) {
					textOutput.append("Fyll i samtliga produktfält \n");
					}
				else {
					product.setCategory(category);
					product.setPrice(price);
					textOutput.append("Produkt " + product.getName() + " har nu ändrats till följande: \nKategori: " + product.getCategory() + "\nPris: " + product.getPrice()+"\n");
				}
				
				textField_name.setText("");
				textField_category.setText("");
				textField_price.setText("0");
			}
		});
		btnChangeProduct.setBounds(115, 145, 85, 23);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 200, 238, 2);
		
		JLabel lblUnit = new JLabel("Exemplar");
		lblUnit.setBounds(95, 215, 46, 14);
		
		JLabel lblSerialNumber = new JLabel("Serienummer:");
		lblSerialNumber.setBounds(25, 240, 85, 14);
		
		textField_serialNumber = new JTextField();
		textField_serialNumber.setBounds(115, 237, 85, 20);
		textField_serialNumber.setColumns(10);
		
		JButton btnAddUnit = new JButton("Lägg till");
		btnAddUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText();
				String serialNumber = textField_serialNumber.getText();
				Unit unit = controller.findUnit(serialNumber, name);
				
				if(textField_name.getText().isEmpty() || textField_serialNumber.getText().isEmpty()) {
					textOutput.append("Fyll i produktnamn och serienummer \n");
				}
				else if (unit!=null) {
					textOutput.append("Exemplaret finns redan \n");
				}
			
					
				else {
					controller.addUnit(serialNumber, name);
					textOutput.append("Ett exemplar med serienummer " + controller.findUnit(serialNumber, name).getSerialNumber() + " har lagts till under produkt " + name + "\n");
				
				
			}
				textField_name.setText("");
				textField_category.setText("");
				textField_price.setText("0");
				textField_serialNumber.setText("");
				
			}
		});
		btnAddUnit.setBounds(25, 265, 85, 23);
		
		JButton btnRemoveUnit = new JButton("Ta bort");
		btnRemoveUnit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText();
				String serialNumber = textField_serialNumber.getText();
				Unit unit = controller.findUnit(serialNumber, name);
				
				if(textField_name.getText().isEmpty() || textField_serialNumber.getText().isEmpty()) {
					textOutput.append("Fyll i produktnamn och serienummer \n");
				}
				else if (unit==null) {
					textOutput.append("Exemplaret går inte att ta bort då det inte finns i systemet \n");
					textField_name.setText("");
					textField_category.setText("");
					textField_price.setText("0");
					textField_serialNumber.setText("");
				}
			
					
				else {
					controller.removeUnit(serialNumber, name);
					if (controller.findUnit(serialNumber, name)==null) {
						textOutput.append("Ett exemplar av produkten: "+name+" har tagits bort ur systemet med serienummer "+serialNumber +"\n");
					}
				
			}
				textField_name.setText("");
				textField_category.setText("");
				textField_price.setText("0");
				
			}
		});
		btnRemoveUnit.setBounds(115, 265, 85, 23);
		
		JButton btnShowUnits = new JButton("Visa exemplar");
		btnShowUnits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText();
				Product p = controller.findProduct(name);
				String string="";
				if (textField_name.getText().isEmpty()) {
					textOutput.append("Fyll i namn på produkten \n");
				}
				else if (p==null) {
					textOutput.append("Det finns inga exemplar för produkten då den ej existerar \n");
				}
				else {
				for (Unit temp : p.getUnitList()) {
					if (temp!=null) {
						string += ("Serienummer: " +temp.getSerialNumber()) + "\n";
						
					}
					
				}
				
				textOutput.append("Produkten " + p.getName() + " har följande exemplar: \n" + string);
				}
			}
		});
		btnShowUnits.setBounds(25, 295, 175, 23);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(246, 11, 2, 358);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(359, 10, 46, 14);
		
		textOutput = new JTextArea();
		textOutput.setRequestFocusEnabled(false);
		textOutput.setRows(1);
		textOutput.setColumns(10);
		textOutput.setLineWrap(true);
		textOutput.setWrapStyleWord(true);
		textOutput.setBounds(0, 71, 191, 223);
		textOutput.setEditable(false);
		panelProductUnit.add(textOutput);
		
		JScrollPane scrollPane = new JScrollPane(textOutput);
		scrollPane.setRequestFocusEnabled(false);
		scrollPane.setBounds(260, 30, 267, 268);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelProductUnit.setLayout(null);
		panelProductUnit.add(lblProduct);
		panelProductUnit.add(lblName);
		panelProductUnit.add(lblCategory);
		panelProductUnit.add(lblPrice);
		panelProductUnit.add(textField_name);
		panelProductUnit.add(textField_category);
		panelProductUnit.add(textField_price);
		panelProductUnit.add(btnAddProduct);
		panelProductUnit.add(btnRemoveProduct);
		panelProductUnit.add(btnSearchProduct);
		panelProductUnit.add(btnChangeProduct);
		panelProductUnit.add(separator);
		panelProductUnit.add(lblUnit);
		panelProductUnit.add(lblSerialNumber);
		panelProductUnit.add(textField_serialNumber);
		panelProductUnit.add(btnAddUnit);
		panelProductUnit.add(btnRemoveUnit);
		panelProductUnit.add(btnShowUnits);
		panelProductUnit.add(separator_1);
		panelProductUnit.add(lblOutput);
		panelProductUnit.add(scrollPane);
		
		JButton btnTillbaka = new JButton("Tillbaka");
		btnTillbaka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.show();
				panelProductUnit.hide();
			}
		});
		btnTillbaka.setBounds(435, 415, 89, 23);
		panelProductUnit.add(btnTillbaka);
		panelProductUnit.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField_name, textField_category, textField_price, textField_serialNumber, textOutput, lblProduct, lblName, lblCategory, lblPrice, btnAddProduct, btnRemoveProduct, btnSearchProduct, btnChangeProduct, separator, lblUnit, lblSerialNumber, btnAddUnit, btnRemoveUnit, btnShowUnits, separator_1, lblOutput, scrollPane, textOutput}));
		
		// CUSTOMER & ORDER PANEL
		
		panelCustomerOrder = new JPanel(); // Customer & Order Panel
		frame.getContentPane().add(panelCustomerOrder, "name_61069258399643");
		panelCustomerOrder.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setRequestFocusEnabled(false);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(260, 30, 267, 268);
		panelCustomerOrder.add(scrollPane_1);
		
		JTextArea textOutput_2 = new JTextArea();
		textOutput_2.setColumns(10);
		textOutput_2.setRows(1);
		textOutput_2.setWrapStyleWord(true);
		textOutput_2.setLineWrap(true);
		textOutput_2.setEditable(false);
		scrollPane_1.setViewportView(textOutput_2);
		
		
		JButton button = new JButton("Tillbaka");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.show();
				panelCustomerOrder.hide();
			}
		});
		button.setBounds(436, 415, 85, 23);
		panelCustomerOrder.add(button);
		
		
		
		JLabel lblCustomer = new JLabel("Kund");
		lblCustomer.setBounds(95, 10, 46, 14);
		panelCustomerOrder.add(lblCustomer);
		
		JLabel lblCustomerName = new JLabel("Namn:");
		lblCustomerName.setBounds(25, 30, 46, 15);
		panelCustomerOrder.add(lblCustomerName);
		
		JLabel lblAddress = new JLabel("Adress: ");
		lblAddress.setBounds(25, 55, 46, 14);
		panelCustomerOrder.add(lblAddress);
		
		JLabel lblCustomerNumber = new JLabel("Kundnummer:");
		lblCustomerNumber.setBounds(25, 80, 74, 14);
		panelCustomerOrder.add(lblCustomerNumber);
		
		textField_customerName = new JTextField();
		textField_customerName.setBounds(115, 30, 85, 20);
		panelCustomerOrder.add(textField_customerName);
		textField_customerName.setColumns(10);
		
		textField_address = new JTextField();
		textField_address.setBounds(115, 55, 85, 20);
		panelCustomerOrder.add(textField_address);
		textField_address.setColumns(10);
		
		textField_customerNumber = new JTextField();
		textField_customerNumber.setBounds(115, 80, 85, 20);
		panelCustomerOrder.add(textField_customerNumber);
		textField_customerNumber.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 165, 236, 2);
		panelCustomerOrder.add(separator_2);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setBounds(94, 170, 46, 14);
		panelCustomerOrder.add(lblOrder);
		
		JLabel lblOrderId = new JLabel("OrderID:");
		lblOrderId.setBounds(27, 189, 46, 14);
		panelCustomerOrder.add(lblOrderId);
		
		JLabel lblDeliveryDate = new JLabel("Leveransdatum:");
		lblDeliveryDate.setBounds(27, 214, 89, 14);
		panelCustomerOrder.add(lblDeliveryDate);
		
		JButton btnAddCustomer = new JButton("Skapa");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_customerName.getText();
				String address = textField_address.getText();
				String customerNumber = textField_customerNumber.getText();
				Customer customer = controller.findCustomer(customerNumber);
				
				if (textField_customerName.getText().isEmpty () || textField_customerNumber.getText().isEmpty()) {
					textOutput_2.append("Fyll i namn och kundnummer\n");
				}
				
				
				
				else if (customer != null) {
					textOutput_2.append("En kund med det kundnumret finns redan i registret \n");
				}
				else {
					controller.addCustomer(name, address, customerNumber);
					if (controller.findCustomer(customerNumber)!=null) {
						textOutput_2.append("En kund med namnet: "+ name + " och kundnummer "+ customerNumber +" har lagts till i registret \n" );
					}
					if (controller.findCustomer(customerNumber)==null) {
						textOutput_2.append("Kunden lades inte till på grund av oväntat fel\n");
					}
					
				}
				textField_customerName.setText("");
				textField_address.setText("");
				textField_customerNumber.setText("");
		
			}
		});
		btnAddCustomer.setBounds(25, 105, 85, 23);
		panelCustomerOrder.add(btnAddCustomer);
		
		JButton btnSearchCustomer = new JButton("Sök");
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerNumber = textField_customerNumber.getText();
				Customer customer = controller.findCustomer(customerNumber);
				
				if (textField_customerNumber.getText().isEmpty()) {
					textOutput_2.append("Fyll i kundnummer för att söka\n");
				}
				else if (customer== null) {
					textOutput_2.append("Det finns inte en kund med serienummer: " + customerNumber + " i registret \n" );
				}
				else {
					textOutput_2.append("En sökning på serienumret " + customerNumber + " har namnet " + customer.getName() +".\n");
				}
				textField_customerName.setText("");
				textField_address.setText("");
				textField_customerNumber.setText("");
			
			
			}
			});
		btnSearchCustomer.setBounds(115, 105, 85, 23);
		panelCustomerOrder.add(btnSearchCustomer);
		
		JButton btnChangeCustomer = new JButton("Ändra");
		btnChangeCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerNumber = textField_customerNumber.getText();
				String name = textField_customerName.getText();
				String address = textField_address.getText();
				Customer customer = controller.findCustomer(customerNumber);
				
				if (textField_customerName.getText().isEmpty() || textField_address.getText().isEmpty() || textField_customerNumber.getText().isEmpty()) {
					textOutput_2.append("Fyll i alla kundfält \n");
				}
				else if (customer == null) {
					textOutput_2.append("Kund med kundnummer " + customerNumber + " finns inte i registret \n");
				}
				else {
					String tempName = customer.getName();
					String tempAddress = customer.getAddress();
					controller.changeCustomer(name, address, customerNumber);
					textOutput_2.append("Kund med kundnummer " + customer.getCustomerNumber() + " har ändrat namn och address från: \nNamn: " + tempName + "\nAdress: " + tempAddress + "\ntill \nNamn: " + customer.getName() + "\nAdress: " + customer.getAddress() +"\n");
					
				}
				textField_customerName.setText("");
				textField_address.setText("");
				textField_customerNumber.setText("");
			}
			});
		btnChangeCustomer.setBounds(25, 130, 85, 23);
		panelCustomerOrder.add(btnChangeCustomer);
		
		
		JButton btnRemoveCustomer = new JButton("Ta bort");
		btnRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			});
		btnRemoveCustomer.setBounds(115, 130, 85, 23);
		panelCustomerOrder.add(btnRemoveCustomer);
		
		textField_orderId = new JTextField();
		textField_orderId.setBounds(115, 185, 85, 20);
		panelCustomerOrder.add(textField_orderId);
		textField_orderId.setColumns(10);
		
		textField_deliveryDate = new JTextField();
		textField_deliveryDate.setBounds(115, 210, 85, 20);
		panelCustomerOrder.add(textField_deliveryDate);
		textField_deliveryDate.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 270, 236, 2);
		panelCustomerOrder.add(separator_3);
		
		JButton btnAddOrder = new JButton("Skapa");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderID = textField_orderId.getText();
				String deliveryDate = textField_deliveryDate.getText();
				String customerNumber = textField_customerNumber.getText();
				Customer customer = controller.findCustomer(customerNumber);
				Order order = controller.findOrder(orderID);
				
				if (textField_orderId.getText().isEmpty() || textField_deliveryDate.getText().isEmpty() || textField_customerNumber.getText().isEmpty()) {
					textOutput_2.append("Fyll i ett orderID och leveransdatum \n");
				}
				else if (order != null) {
					textOutput_2.append("Ordern du försöker skapa finns redan \n");
				}
				else {
					controller.addOrder(orderID, deliveryDate, customerNumber);
					if (customer == null ) {
						textOutput_2.append("Det finns ingen med kundnummer " + customerNumber + ".\n");
					}
					else {
						textOutput_2.append("En order med id " + order.getOrderID() + " har skapats med leverans den " + order.getDeliveryDate() + " på kundnummer " + customer.getCustomerNumber() + ".\n" );
					}
					
				}
				textField_customerNumber.setText("");
				textField_deliveryDate.setText("");
				textField_orderId.setText("");
				
			}
			});
		btnAddOrder.setBounds(25, 240, 85, 23);
		panelCustomerOrder.add(btnAddOrder);
		
		JButton btnRemoveOrder = new JButton("Ta bort");
		btnRemoveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			});
		btnRemoveOrder.setBounds(115, 240, 85, 23);
		panelCustomerOrder.add(btnRemoveOrder);
		
		JLabel lblOrderLine = new JLabel("Orderrad");
		lblOrderLine.setBounds(94, 280, 46, 14);
		panelCustomerOrder.add(lblOrderLine);
		
		JLabel lblProduct2 = new JLabel("Produkt:");
		lblProduct2.setBounds(27, 300, 46, 14);
		panelCustomerOrder.add(lblProduct2);
		
		JLabel lblQuantity = new JLabel("Antal:");
		lblQuantity.setBounds(27, 325, 46, 14);
		panelCustomerOrder.add(lblQuantity);
		
		textField_productName = new JTextField();
		textField_productName.setBounds(115, 300, 85, 20);
		panelCustomerOrder.add(textField_productName);
		textField_productName.setColumns(10);
		
		textField_quantity = new JTextField();
		textField_quantity.setBounds(115, 325, 85, 20);
		panelCustomerOrder.add(textField_quantity);
		textField_quantity.setColumns(10);
		
		JButton btnAddOrderLine = new JButton("Lägg till");
		btnAddOrderLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_productName.getText();
				int quantity = Integer.parseInt(textField_quantity.getText());
				String orderID = textField_orderId.getText();
				String orderLineNumber = textField_orderLineNumber.getText();
				Order order = controller.findOrder(orderID);
				Product product = controller.findProduct(name);
				OrderLine orderLine = controller.findOrderLine(orderLineNumber);
				
				if (textField_productName.getText().isEmpty() || textField_quantity.getText().isEmpty() || textField_orderId.getText().isEmpty()) {
					textOutput_2.append("Fyll i orderID, produktnamn och antal \n");
				}
				else if (order == null) {
					textOutput_2.append("En order med det orderID:t finns inte i systemet \n");
				}
				else if (order !=null && product==null ) {
					textOutput_2.append("Det går inte att lägga till produkten i ordern då produkten inte finns \n");
				}
				else if (order!=null && product != null && orderLine != null ) {
					textOutput_2.append("Ordern har redan en sådan produkt på den angivna orderraden \n");
				}
				else {
					controller.addOrderLines(orderID, product, quantity, orderLineNumber);
					textOutput_2.append(orderLine.getQuantity() + " st av " + product.getName() + " har lagts till på orderrad " + orderLine.getNumber() + " i order " + order.getOrderID() +"\n" );
					
				}
				textField_productName.setText("");
				textField_orderId.setText("");
				textField_orderLineNumber.setText("");
				
			}
			});
		btnAddOrderLine.setBounds(25, 345, 85, 23);
		panelCustomerOrder.add(btnAddOrderLine);
		
		JLabel lblOrderLineNumber = new JLabel("Orderradnummer: ");
		lblOrderLineNumber.setBounds(25, 385, 89, 14);
		panelCustomerOrder.add(lblOrderLineNumber);
		
		textField_orderLineNumber = new JTextField();
		textField_orderLineNumber.setBounds(115, 383, 85, 20);
		panelCustomerOrder.add(textField_orderLineNumber);
		textField_orderLineNumber.setColumns(10);
		
		JButton btnRemoveOrderLine = new JButton("Ta bort");
		btnRemoveOrderLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			});
		btnRemoveOrderLine.setBounds(25, 415, 85, 23);
		panelCustomerOrder.add(btnRemoveOrderLine);
		
		JLabel lblOutput2 = new JLabel("Output");
		lblOutput2.setBounds(365, 10, 46, 14);
		panelCustomerOrder.add(lblOutput2);
		
	}
}
