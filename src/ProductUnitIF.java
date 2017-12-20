import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;



import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductUnitIF extends MenuIF{

	private JFrame frame;
	private JTextField textField_name;
	private JTextField textField_category;
	private JTextField textField_price;
	private JTextField textField_serialNumber;
	
	
	/**
	 * Launch the application.
	 */
	public void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductUnitIF window = new ProductUnitIF();
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
	public ProductUnitIF() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 589, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(294, 28, 269, 273);
		frame.getContentPane().add(textPane);
		textPane.setEditable(false);
		
		JLabel lblProdukt = new JLabel("Produkt");
		lblProdukt.setBounds(110, 38, 46, 14);
		frame.getContentPane().add(lblProdukt);
		
		JLabel lblNamn = new JLabel("Namn:");
		lblNamn.setBounds(40, 69, 46, 14);
		frame.getContentPane().add(lblNamn);
		
		JLabel lblKategori = new JLabel("Kategori:");
		lblKategori.setBounds(40, 97, 46, 14);
		frame.getContentPane().add(lblKategori);
		
		JLabel lblPris = new JLabel("Pris:");
		lblPris.setBounds(40, 122, 46, 14);
		frame.getContentPane().add(lblPris);
		
		JLabel lblExemplar = new JLabel("Exemplar");
		lblExemplar.setBounds(110, 219, 46, 14);
		frame.getContentPane().add(lblExemplar);
		
		JLabel lblSerienummer = new JLabel("Serienummer:");
		lblSerienummer.setBounds(40, 247, 66, 14);
		frame.getContentPane().add(lblSerienummer);
		
		textField_name = new JTextField("");
		textField_name.setBounds(110, 63, 86, 20);
		frame.getContentPane().add(textField_name);
		textField_name.setColumns(10);
		
		textField_category = new JTextField();
		textField_category.setBounds(110, 91, 86, 20);
		frame.getContentPane().add(textField_category);
		textField_category.setColumns(10);
		
		textField_price = new JTextField();
		textField_price.setBounds(110, 116, 86, 20);
		frame.getContentPane().add(textField_price);
		textField_price.setColumns(10);
		textField_price.setText("0");
		
		textField_serialNumber = new JTextField();
		textField_serialNumber.setBounds(130, 244, 86, 20);
		frame.getContentPane().add(textField_serialNumber);
		textField_serialNumber.setColumns(10);
		
		JButton btnLggTill = new JButton("L\u00E4gg till");
		btnLggTill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText();
				String category = textField_category.getText();
				String priceString = textField_price.getText();
				double price = Double.parseDouble(priceString);
				Product product = controller.findProduct(name);
				
				//Lägg till if-sats, vända på steken
			
				if(controller.getArrayListProduct().contains(product)) {
					textPane.setText("Produkten finns redan i systemet");
				}
				else if (!textField_name.getText().isEmpty()) {
					controller.addProduct(name, category, price);
					textPane.setText(name+" har lagts till i systemet");
					textField_price.setText("0");
				}
				
				else { textPane.setText("Fyll i Namn, Kategori och Pris"); }
				
				textField_name.setText("");
				textField_category.setText("");
				textField_price.setText("0");
			}
			
			
		});
		btnLggTill.setBounds(40, 144, 89, 23);
		frame.getContentPane().add(btnLggTill);
		
		JButton btnTaBort = new JButton("Ta bort");
		btnTaBort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText();
				Product p = controller.findProduct(name);
				
				if (p != null) {
					textPane.setText(p.getName() + " har tagits bort.");
					controller.removeProduct(name);
					textField_name.setText("");
					textField_category.setText("");
					textField_price.setText("0");
				}
				else {
					textPane.setText("Produkten kan inte hittas.");
					textField_name.setText("");
					textField_category.setText("");
					textField_price.setText("0");
				}
			}
		});
		btnTaBort.setBounds(140, 144, 89, 23);
		frame.getContentPane().add(btnTaBort);
		
		JButton btnSk = new JButton("S\u00F6k");
		btnSk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_name.getText();
				Product p = controller.findProduct(name);
				
				if (textField_name.getText().isEmpty()) {
					textPane.setText("Fyll i produktnamn");
				}
				else if (p != null) {
					textPane.setText("Namn: " + p.getName() + "\nKategori: " + p.getCategory() + "\nPris: " + p.getPrice());
					textField_name.setText("");
					textField_category.setText("");
					textField_price.setText("0");
				}
				else {
					textPane.setText("Hittar inte produkten: " + textField_name.getText());
					textField_name.setText("");
					textField_category.setText("");
					textField_price.setText("0");
				}
				
			}
		});
		btnSk.setBounds(40, 178, 89, 23);
		frame.getContentPane().add(btnSk);
		
		JButton btnndra = new JButton("\u00C4ndra");
		btnndra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText();
				String category = textField_category.getText();
				String priceString = textField_price.getText();
				double price = Double.parseDouble(priceString);
				Product product = controller.findProduct(name);
				
				if(textField_name.getText().isEmpty() || textField_category.getText().isEmpty()) {
					textPane.setText("Fyll i alla fält");
					}
				else {
					product.setCategory(category);
					product.setPrice(price);
					textPane.setText("Produkt: " + name + "\nKategorin är nu: " + category + "\nPriset är nu: " + price);
				}
				
				textField_name.setText("");
				textField_category.setText("");
				textField_price.setText("0");
			}
		});
		btnndra.setBounds(140, 178, 89, 23);
		frame.getContentPane().add(btnndra);
		
		JButton btnLggTill_1 = new JButton("L\u00E4gg till");
		btnLggTill_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText();
				String serialNumber = textField_serialNumber.getText();
				Unit unit = controller.findUnit(serialNumber, name);
				
				if(textField_name.getText().isEmpty() || textField_serialNumber.getText().isEmpty()) {
					textPane.setText("Fyll i fält");
				}
				else if (unit!=null) {
					textPane.setText("Exemplaret finns redan");
				}
			
					
				else {controller.addUnit(serialNumber, name);
				textPane.setText("Ett exemplar av produkten: "+name+" har lagts till i systemet med serienummer "+serialNumber);
				
				
			}
				textField_name.setText("");
				textField_category.setText("");
				textField_price.setText("0");
				
				
			}
		});
		btnLggTill_1.setBounds(40, 278, 89, 23);
		frame.getContentPane().add(btnLggTill_1);
		
		JButton btnTaBort_1 = new JButton("Ta bort");
		btnTaBort_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText();
				String serialNumber = textField_serialNumber.getText();
				Unit unit = controller.findUnit(serialNumber, name);
				
				if(textField_name.getText().isEmpty() && textField_serialNumber.getText().isEmpty()) {
					textPane.setText("Fyll i fält");
				}
				else if (unit==null) {
					textPane.setText("Exemplaret går inte att ta bort då det inte finns i systemet");
				}
			
					
				else {
				textPane.setText("Ett exemplar av produkten: "+name+" har tagits bort i systemet med serienummer "+serialNumber);
				controller.removeUnit(serialNumber, name);
				
			}
				textField_name.setText("");
				textField_category.setText("");
				textField_price.setText("0");
				
				
				
			}
		});
		btnTaBort_1.setBounds(140, 278, 89, 23);
		frame.getContentPane().add(btnTaBort_1);
		

		
		JTextPane txtpnlggTillOch = new JTextPane();
		txtpnlggTillOch.setText("F\u00F6r Produkt: \"L\u00E4gg till\" och \"\u00C4ndra\" kr\u00E4ver namn, kategori och pris. \"S\u00F6k\" och \"Ta bort\" kr\u00E4ver endast namn.                                                             F\u00F6r Exemplar: \"L\u00E4gg till\" och \"Ta bort\" kr\u00E4ver namn och serienummer.");
		txtpnlggTillOch.setBounds(294, 335, 269, 140);
		frame.getContentPane().add(txtpnlggTillOch);
		
		JButton btnTillbaka = new JButton("Tillbaka");
		btnTillbaka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

			}
		});
		btnTillbaka.setBounds(474, 516, 89, 23);
		frame.getContentPane().add(btnTillbaka);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 312, 533, 11);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 210, 214, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(277, 11, 7, 528);
		frame.getContentPane().add(separator_2);
		
		JButton btnVisaExemplar = new JButton("Visa exemplar");
		btnVisaExemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_name.getText();
				Product p = controller.findProduct(name);
				String string="";
				if (textField_name.getText().isEmpty()) {
					textPane.setText("Fyll i namn på produkt");
				}
				else if (p==null) {
					textPane.setText("Produkten finns inte");
				}
				else {
				for (Unit temp : p.getUnitList()) {
					if (temp!=null) {
						string += ("Serienummer: " +temp.getSerialNumber()) + "\n";
						
					}
					
				}
				
				textPane.setText("Produkten " + p.getName() + " har följande exemplar: \n" + string);
				}
			}
		});
		btnVisaExemplar.setBounds(92, 334, 89, 23);
		frame.getContentPane().add(btnVisaExemplar);
		
	}
}