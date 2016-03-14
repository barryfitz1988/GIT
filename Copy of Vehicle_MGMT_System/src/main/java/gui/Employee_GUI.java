package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class Employee_GUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane serviceScroller; 
	private JTable employeeTable;
	private JTable timeside;
	private JOptionPane updateDetails;
    private JLabel lblEmployeeId;
    private JLabel FirstNamelbl;
    private JLabel Surname;
    private JLabel phoneNumberlbl;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnExit;
    private JTextField idTextField;
    private JTextField nameTextfield;
    private JTextField surnameTextField;
    private JTextField phoneTextField;
    private JLabel lblType;
    private JTextField typeTextField;


	public Employee_GUI() {
		setTitle("Employee Section");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel detailsJPanel = new JPanel();
		detailsJPanel.setBorder(new TitledBorder(null, "Employee Details", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		detailsJPanel.setBounds(22, 11, 322, 381);
		detailsJPanel.setLayout(null);
		employeeTable = new JTable();
		serviceScroller = new JScrollPane(employeeTable);
		//timeside = new Time_Table_Renderer(employeeTable);
		//serviceScroller = new JScrollPane(employeeTable);
		serviceScroller.setBounds(10, 23, 302, 347);
		detailsJPanel.add(serviceScroller);
		contentPane.add(detailsJPanel);
		
		
		
		
		JPanel informationJPanel = new JPanel();
		informationJPanel.setBorder(new TitledBorder(null, "Employee Information", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		informationJPanel.setBounds(363, 11, 322, 381);
		contentPane.add(informationJPanel);
		informationJPanel.setLayout(null);
		
		lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(23, 41, 88, 14);
		informationJPanel.add(lblEmployeeId);
		
		FirstNamelbl = new JLabel("First Name");
		FirstNamelbl.setBounds(23, 94, 88, 14);
		informationJPanel.add(FirstNamelbl);
		
		Surname = new JLabel("Surname");
		Surname.setBounds(23, 152, 88, 14);
		informationJPanel.add(Surname);
		
		phoneNumberlbl = new JLabel("Phone Number\r\n");
		phoneNumberlbl.setBounds(23, 216, 88, 14);
		informationJPanel.add(phoneNumberlbl);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 301, 66, 23);
		informationJPanel.add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(86, 301, 66, 23);
		informationJPanel.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(162, 301, 66, 23);
		informationJPanel.add(btnDelete);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(238, 301, 66, 23);
		informationJPanel.add(btnExit);
		
		idTextField = new JTextField();
		idTextField.setBounds(105, 38, 136, 20);
		informationJPanel.add(idTextField);
		idTextField.setColumns(10);
		//idTextField.setEditable(false);
		
		nameTextfield = new JTextField();
		nameTextfield.setColumns(10);
		nameTextfield.setBounds(105, 91, 136, 20);
		informationJPanel.add(nameTextfield);
		
		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(105, 149, 136, 20);
		informationJPanel.add(surnameTextField);
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(105, 213, 136, 20);
		informationJPanel.add(phoneTextField);
		
		lblType = new JLabel("Type");
		lblType.setBounds(23, 257, 88, 14);
		informationJPanel.add(lblType);
		
		typeTextField = new JTextField();
		typeTextField.setColumns(10);
		typeTextField.setBounds(105, 254, 136, 20);
		informationJPanel.add(typeTextField);
		
		
		updateDetails = new JOptionPane();
		updateDetails.setBounds(574, 134, 200,200);	
		informationJPanel.add(updateDetails);
	}
	
	public JOptionPane getUpdateDetails() {
		return updateDetails;
	}

	public void setUpdateDetails(JOptionPane updateDetails) {
		this.updateDetails = updateDetails;
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

	public JTextField getNameTextfield() {
		return nameTextfield;
	}

	public void setNameTextfield(JTextField nameTextfield) {
		this.nameTextfield = nameTextfield;
	}

	public JTextField getSurnameTextField() {
		return surnameTextField;
	}

	public void setSurnameTextField(JTextField surnameTextField) {
		this.surnameTextField = surnameTextField;
	}

	public JTextField getPhoneTextField() {
		return phoneTextField;
	}

	public void setPhoneTextField(JTextField phoneTextField) {
		this.phoneTextField = phoneTextField;
	}

	public JTextField getTypeTextField() {
		return typeTextField;
	}

	public void setTypeTextField(JTextField typeTextField) {
		this.typeTextField = typeTextField;
	}

	public JTable getEmployeeTable() {
		return employeeTable;
	}

	public void setEmployeeTable(JTable employeeTable) {
		this.employeeTable = employeeTable;
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
	
	
	public void addNewEmployeeListener(ActionListener listenForButton){
	    
		btnAdd.addActionListener(listenForButton);

		
		}
	
	
	public void tableSelecterListener(ListSelectionListener rowSelected){
	    
		
		employeeTable.getSelectionModel().addListSelectionListener(rowSelected);
		
		}

}
