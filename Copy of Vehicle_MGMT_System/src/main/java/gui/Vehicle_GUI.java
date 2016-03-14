package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputListener;

public class Vehicle_GUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane vehicleScroller; 
	private JTable vehicleTable;
 /*   //headers for the table
    String[] columns = new String[] {
      "ID" , "Registration", "Make", "Model", "Chassis Number", "Customer ID"
    };
     
    //actual data for the table in a 2d array
    Object[][] data = new Object[][] {
        { 001, "08-c-1999", "VW", "Golf","WVWZZZ1JZ",23 },

    };*/
    private JLabel idLabel;
    private JLabel serviceNameJLabel;
    private JLabel lblmake;
    private JLabel lblmodel;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnExit;
    private JTextField idTextField;
    private JTextField regTextfield;
    private JTextField makeTextField;
    private JTextField modelTextField;
    private JTextField chassisTextfield;
    private JLabel lblVehicleChassis;
    private JLabel lblLinkToCustomer;
    private JTextField customerTextField;
    private JOptionPane updateDetails;
    private JTextField hidden_id_Customertextfield;


	public Vehicle_GUI() {
		setTitle("Vehicle Section");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel detailsJPanel = new JPanel();
		detailsJPanel.setBorder(new TitledBorder(null, "Vehicle Details", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		detailsJPanel.setBounds(22, 11, 322, 381);
		detailsJPanel.setLayout(null);
		vehicleTable = new JTable(/*data, columns*/);
		vehicleScroller = new JScrollPane(vehicleTable);
		vehicleScroller.setBounds(10, 23, 302, 347);
		detailsJPanel.add(vehicleScroller);
		contentPane.add(detailsJPanel);
		
		
		
		
		JPanel informationJPanel = new JPanel();
		informationJPanel.setBorder(new TitledBorder(null, "Vehicle Information", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		informationJPanel.setBounds(363, 11, 322, 381);
		contentPane.add(informationJPanel);
		informationJPanel.setLayout(null);
		
		idLabel = new JLabel("Vehicle ID");
		idLabel.setBounds(23, 41, 88, 14);
		informationJPanel.add(idLabel);
		
		serviceNameJLabel = new JLabel("Vehicle Reg");
		serviceNameJLabel.setBounds(23, 78, 88, 14);
		informationJPanel.add(serviceNameJLabel);
		
		lblmake = new JLabel("Vehicle Make");
		lblmake.setBounds(23, 121, 88, 14);
		informationJPanel.add(lblmake);
		
		lblmodel = new JLabel("Vehicle Model");
		lblmodel.setBounds(23, 167, 88, 14);
		informationJPanel.add(lblmodel);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 283, 66, 23);
		informationJPanel.add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(86, 283, 66, 23);
		informationJPanel.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(162, 283, 66, 23);
		informationJPanel.add(btnDelete);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(238, 283, 66, 23);
		informationJPanel.add(btnExit);
		
		idTextField = new JTextField();
		idTextField.setBounds(105, 38, 136, 20);
		informationJPanel.add(idTextField);
		idTextField.setColumns(10);
		
		regTextfield = new JTextField();
		regTextfield.setColumns(10);
		regTextfield.setBounds(105, 75, 136, 20);
		informationJPanel.add(regTextfield);
		
		makeTextField = new JTextField();
		makeTextField.setColumns(10);
		makeTextField.setBounds(105, 118, 136, 20);
		informationJPanel.add(makeTextField);
		
		modelTextField = new JTextField();
		modelTextField.setColumns(10);
		modelTextField.setBounds(105, 164, 136, 20);
		informationJPanel.add(modelTextField);
		
		chassisTextfield = new JTextField();
		chassisTextfield.setColumns(10);
		chassisTextfield.setBounds(105, 205, 136, 20);
		informationJPanel.add(chassisTextfield);
		
		lblVehicleChassis = new JLabel("Vehicle Chassis");
		lblVehicleChassis.setBounds(23, 208, 88, 14);
		informationJPanel.add(lblVehicleChassis);
		
		lblLinkToCustomer = new JLabel("Link to Customer");
		lblLinkToCustomer.setBounds(23, 239, 88, 14);
		informationJPanel.add(lblLinkToCustomer);
		
		customerTextField = new JTextField();
		customerTextField.setColumns(10);
		customerTextField.setBounds(105, 236, 136, 20);
		informationJPanel.add(customerTextField);
		
		
		
		updateDetails = new JOptionPane();
		updateDetails.setBounds(574, 134, 200,200);	
		informationJPanel.add(updateDetails);
		
		hidden_id_Customertextfield = new JTextField();
		hidden_id_Customertextfield.setBounds(116, 324, 86, 20);
		hidden_id_Customertextfield.setVisible(false);
		hidden_id_Customertextfield.setEditable(false);
		informationJPanel.add(hidden_id_Customertextfield);
		hidden_id_Customertextfield.setColumns(10);
	}

	
	public JTextField getHidden_id_Customertextfield() {
		return hidden_id_Customertextfield;
	}


	public void setHidden_id_Customertextfield(
			JTextField hidden_id_Customertextfield) {
		this.hidden_id_Customertextfield = hidden_id_Customertextfield;
	}


	public JTable getVehicleTable() {
		return vehicleTable;
	}


	public void setVehicleTable(JTable vehicleTable) {
		this.vehicleTable = vehicleTable;
	}


	public JButton getBtnAdd() {
		return btnAdd;
	}


	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}


	public JButton getBtnEdit() {
		return btnEdit;
	}


	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}


	public JButton getBtnDelete() {
		return btnDelete;
	}


	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}


	public JButton getBtnExit() {
		return btnExit;
	}


	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}


	public JTextField getIdTextField() {
		return idTextField;
	}


	public void setIdTextField(JTextField idTextField) {
		this.idTextField = idTextField;
	}


	public JTextField getRegTextfield() {
		return regTextfield;
	}


	public void setRegTextfield(JTextField regTextfield) {
		this.regTextfield = regTextfield;
	}


	public JTextField getMakeTextField() {
		return makeTextField;
	}


	public void setMakeTextField(JTextField makeTextField) {
		this.makeTextField = makeTextField;
	}


	public JTextField getModelTextField() {
		return modelTextField;
	}


	public void setModelTextField(JTextField modelTextField) {
		this.modelTextField = modelTextField;
	}


	public JTextField getChassisTextfield() {
		return chassisTextfield;
	}


	public void setChassisTextfield(JTextField chassisTextfield) {
		this.chassisTextfield = chassisTextfield;
	}


	public JTextField getCustomerTextField() {
		return customerTextField;
	}


	public void setCustomerTextField(JTextField customerTextField) {
		this.customerTextField = customerTextField;
	}


	public JOptionPane getUpdateDetails() {
		return updateDetails;
	}


	public void setUpdateDetails(JOptionPane updateDetails) {
		this.updateDetails = updateDetails;
	}
	
	
	
	


	public void exitListener(ActionListener listenForButton){
	    
		btnExit.addActionListener(listenForButton);

		
		}
	
	
	
	public void deleteListener(ActionListener listenForButton){
	    
		btnDelete.addActionListener(listenForButton);

		
		}
	
	
	public void editButtonListener(ActionListener listenForButton){
	    
		btnEdit.addActionListener(listenForButton);

		
		}
	
	
	public void addNewVehicleListener(ActionListener listenForButton){
	    
		btnAdd.addActionListener(listenForButton);

		
		}
	
	
	public void tableSelecterListener(ListSelectionListener rowSelected){
	    
		
		vehicleTable.getSelectionModel().addListSelectionListener(rowSelected);
		
		}
	
	
	public void addCustomertoVehicle( MouseInputListener listenForTextfield){
	    
		customerTextField.addMouseListener(listenForTextfield);
		
		
		}
	

}
