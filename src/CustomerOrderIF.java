

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerOrderIF extends MenuIF {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public void newWindow () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerOrderIF window = new CustomerOrderIF();
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
	
	public CustomerOrderIF() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 639, 552);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(309, 11, 19, 488);
		frame.getContentPane().add(separator);
		
		JLabel lblKund = new JLabel("Kund");
		lblKund.setBounds(110, 11, 46, 14);
		frame.getContentPane().add(lblKund);
		
		JLabel lblNamn = new JLabel("Namn:");
		lblNamn.setBounds(40, 46, 46, 14);
		frame.getContentPane().add(lblNamn);
		
		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setBounds(40, 71, 46, 14);
		frame.getContentPane().add(lblAdress);
		
		JLabel lblKundnummer = new JLabel("Kundnummer:");
		lblKundnummer.setBounds(40, 96, 78, 14);
		frame.getContentPane().add(lblKundnummer);
		
		textField = new JTextField();
		textField.setBounds(135, 43, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 68, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(135, 93, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSkapa = new JButton("Skapa");
		btnSkapa.setBounds(40, 133, 89, 23);
		frame.getContentPane().add(btnSkapa);
		
		JButton btnSk = new JButton("S\u00F6k");
		btnSk.setBounds(135, 133, 89, 23);
		frame.getContentPane().add(btnSk);
		
		JButton btnndra = new JButton("\u00C4ndra");
		btnndra.setBounds(40, 162, 89, 23);
		frame.getContentPane().add(btnndra);
		
		JButton btnTaBort = new JButton("Ta bort");
		btnTaBort.setBounds(135, 162, 89, 23);
		frame.getContentPane().add(btnTaBort);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 196, 284, 14);
		frame.getContentPane().add(separator_1);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setBounds(110, 206, 46, 14);
		frame.getContentPane().add(lblOrder);
		
		JLabel lblOrderid = new JLabel("OrderID:");
		lblOrderid.setBounds(40, 234, 46, 14);
		frame.getContentPane().add(lblOrderid);
		
		JLabel lblLeveransdatum = new JLabel("Leveransdatum:");
		lblLeveransdatum.setBounds(40, 259, 78, 14);
		frame.getContentPane().add(lblLeveransdatum);
		
		textField_3 = new JTextField();
		textField_3.setBounds(135, 231, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(135, 256, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSkapa_1 = new JButton("Skapa");
		btnSkapa_1.setBounds(40, 284, 89, 23);
		frame.getContentPane().add(btnSkapa_1);
		
		JButton btnTaBort_1 = new JButton("Ta bort");
		btnTaBort_1.setBounds(132, 284, 89, 23);
		frame.getContentPane().add(btnTaBort_1);
		
		JLabel lblOrderrad = new JLabel("Orderrad");
		lblOrderrad.setBounds(110, 318, 46, 14);
		frame.getContentPane().add(lblOrderrad);
		
		JLabel lblProdukt = new JLabel("Produkt:");
		lblProdukt.setBounds(40, 341, 46, 14);
		frame.getContentPane().add(lblProdukt);
		
		JLabel lblAntal = new JLabel("Antal:");
		lblAntal.setBounds(40, 366, 46, 14);
		frame.getContentPane().add(lblAntal);
		
		textField_5 = new JTextField();
		textField_5.setBounds(135, 338, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(135, 363, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnLggTill = new JButton("L\u00E4gg till");
		btnLggTill.setBounds(40, 391, 89, 23);
		frame.getContentPane().add(btnLggTill);
		
		JLabel lblOrderradnummer = new JLabel("Orderradnummer:");
		lblOrderradnummer.setBounds(40, 425, 89, 14);
		frame.getContentPane().add(lblOrderradnummer);
		
		textField_7 = new JTextField();
		textField_7.setBounds(135, 422, 86, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnTaBort_2 = new JButton("Ta bort");
		btnTaBort_2.setBounds(40, 450, 89, 23);
		frame.getContentPane().add(btnTaBort_2);
		
		JTextPane txtpnOutput = new JTextPane();
		txtpnOutput.setText("Output");
		txtpnOutput.setBounds(322, 21, 289, 326);
		frame.getContentPane().add(txtpnOutput);
		
		JButton btnAvbryt = new JButton("Tillbaka");
		btnAvbryt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnAvbryt.setBounds(522, 480, 89, 23);
		frame.getContentPane().add(btnAvbryt);
	}
}