

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class MenuIF {

	private JFrame frame;
	ProductRegister productRegister;
	CustomerRegister customerRegister;
	JFrame productUnitIF;
	JFrame customerOrderIF;
	Product product;
	Unit unit;
	Controller controller = new Controller(customerRegister, productRegister, frame, productUnitIF, customerOrderIF, product, unit);
	private final JPanel panel = new JPanel();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuIF window = new MenuIF();
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
	
	public MenuIF() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 495, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		JLabel lblStart = new JLabel("Startmeny");
		lblStart.setBounds(108, 11, 74, 14);
		frame.getContentPane().add(lblStart);
		
		JButton btnKundOrder = new JButton("Kund & Order");
		btnKundOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerOrderIF newScreen = new CustomerOrderIF();
				newScreen.newWindow();
			}
		});
		btnKundOrder.setBounds(10, 36, 116, 23);
		frame.getContentPane().add(btnKundOrder);
		
		JButton btnProduktExemplar = new JButton("Produkt & Exemplar");
		btnProduktExemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductUnitIF newScreen =new ProductUnitIF ();
				newScreen.newWindow();
			}
		});
		btnProduktExemplar.setBounds(136, 36, 130, 23);
		frame.getContentPane().add(btnProduktExemplar);
		
		JButton btnAvsluta = new JButton("Avsluta");
		btnAvsluta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnAvsluta.setBounds(177, 131, 89, 23);
		frame.getContentPane().add(btnAvsluta);
		panel.setBounds(28, 239, 197, 109);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(52, 11, 89, 23);
		panel.add(btnNewButton);
	}
}