package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class Main_Menu_GUI extends JFrame {

	
	private ImageIcon appointmentIcon = new ImageIcon("images/appointment.gif");
	private ImageIcon serviceIcon = new ImageIcon("images/service.gif");
	private ImageIcon inventoryIcon = new ImageIcon("images/inventory.gif");
	private ImageIcon carIcon = new ImageIcon("images/car.gif");
	private ImageIcon rosterIcon = new ImageIcon("images/roster.gif");
	private ImageIcon customerIcon = new ImageIcon("images/customers.gif");
	private ImageIcon employeeIcon = new ImageIcon("images/employee.gif");
	private ImageIcon invoiceIcon = new ImageIcon("images/cash.gif");
	private ImageIcon exitIcon = new ImageIcon("images/exit.gif");
	private JButton appointmentJButton  = new JButton(appointmentIcon);
	private JButton serviceJButton  = new JButton(serviceIcon);
	private JButton partsJButton  = new JButton(inventoryIcon);
	private JButton vehicleJButton  = new JButton(carIcon);
	private JButton rosterJButton  = new JButton(rosterIcon);
	private JButton customerJButton  = new JButton(customerIcon);
	private JButton employeeJButton  = new JButton(employeeIcon);
	private JButton invoiceJButton  = new JButton(invoiceIcon);
	private JButton exitJButton  = new JButton(exitIcon);

	private final JSeparator separator = new JSeparator();
	
	
	public Main_Menu_GUI() {
		setResizable(false);
		setTitle("Main Menu");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		appointmentJButton.setBounds(38, 113, 80, 80);
		panel.add(appointmentJButton);
		serviceJButton.setBounds(150, 113, 80, 80);
		panel.add(serviceJButton);
		partsJButton.setBounds(258, 113, 80, 80);
		panel.add(partsJButton);
		vehicleJButton.setBounds(369, 113, 80, 80);
		panel.add(vehicleJButton);
		rosterJButton.setBounds(493, 113, 80, 80);
		panel.add(rosterJButton);
		customerJButton.setBounds(77, 273, 80, 80);
		panel.add(customerJButton);
		employeeJButton.setBounds(199, 273, 80, 80);
		panel.add(employeeJButton);
		invoiceJButton.setBounds(319, 273, 80, 80);
		panel.add(invoiceJButton);

		exitJButton.setBounds(454, 273, 80, 80);
		panel.add(exitJButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 448);
		getContentPane().add(panel);
		separator.setBounds(10, 211, 603, 9);
		panel.add(separator);
		


		
		JLabel lblMainMenu = new JLabel("Main Menu ");
		lblMainMenu.setBounds(258, 38, 114, 14);
		lblMainMenu.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(lblMainMenu);
		
		
		exitJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.out.print("Program Ended");
			System.exit(0);
			dispose();
			}
		});
	}
	
	
	



	public void addListener(ActionListener listenForButton){
	    
		customerJButton.addActionListener(listenForButton);

		}
	
	
	public void addappointmentListener(ActionListener listenForButton){
	    
		appointmentJButton.addActionListener(listenForButton);

		
		}
	
	
	public void addServiceListener(ActionListener listenForButton){
	    
		serviceJButton.addActionListener(listenForButton);

		
		}
	
	public void addpartsListener(ActionListener listenForButton){
	    
		partsJButton.addActionListener(listenForButton);

		
		}
	
	public void addvehicleListener(ActionListener listenForButton){
	    
		vehicleJButton.addActionListener(listenForButton);

		
		}
	
	public void addEmployeeListener(ActionListener listenForButton){
	    
		employeeJButton.addActionListener(listenForButton);

		
		}
	
	public void addRosterListener(ActionListener listenForButton){
	    
		rosterJButton.addActionListener(listenForButton);

		
		}
	
	public void addInvoiceListener(ActionListener listenForButton){
	    
		invoiceJButton.addActionListener(listenForButton);

		
		}
	
	
	
	

	    
		
		

		
		
	
	
	
	
	
	
}
