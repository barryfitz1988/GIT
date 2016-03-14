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

public class Service_GUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane serviceScroller; 
	private JTable serviceTable;
	private JOptionPane updateDetails;
    //headers for the table
    String[] columns = new String[] {
      "ID" , "Name", "Time in Mins", "Price �"
    };
     
    //actual data for the table in a 2d array
    Object[][] data = new Object[][] {
        { 1, "Insp Service", 130.0, 150 },
        { 2, "Oil Change", 45.0, 50 },
        { 3, "Engine Overhaul", 800.0, 680 },
    };
    private JLabel lblServiceId;
    private JLabel serviceNameJLabel;
    private JLabel lblServiceTime;
    private JLabel lblServicePrice;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnExit;
    private JTextField idTextField;
    private JTextField nameTextfield;
    private JTextField timeTextField;
    private JTextField priceTextField;


	public Service_GUI() {
		setTitle("Service Section");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel detailsJPanel = new JPanel();
		detailsJPanel.setBorder(new TitledBorder(null, "Service Details", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		detailsJPanel.setBounds(22, 11, 322, 381);
		detailsJPanel.setLayout(null);
		serviceTable = new JTable(data, columns);
		serviceScroller = new JScrollPane(serviceTable);
		serviceScroller.setBounds(10, 23, 302, 347);
		detailsJPanel.add(serviceScroller);
		contentPane.add(detailsJPanel);
		
		
		
		
		JPanel informationJPanel = new JPanel();
		informationJPanel.setBorder(new TitledBorder(null, "Service Information", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		informationJPanel.setBounds(363, 11, 322, 381);
		contentPane.add(informationJPanel);
		informationJPanel.setLayout(null);
		
		lblServiceId = new JLabel("Service ID");
		lblServiceId.setBounds(23, 41, 88, 14);
		informationJPanel.add(lblServiceId);
		
		serviceNameJLabel = new JLabel("Service Name");
		serviceNameJLabel.setBounds(23, 94, 88, 14);
		informationJPanel.add(serviceNameJLabel);
		
		lblServiceTime = new JLabel("Service Time");
		lblServiceTime.setBounds(23, 152, 88, 14);
		informationJPanel.add(lblServiceTime);
		
		lblServicePrice = new JLabel("Service Price");
		lblServicePrice.setBounds(23, 216, 88, 14);
		informationJPanel.add(lblServicePrice);
		
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
		
		nameTextfield = new JTextField();
		nameTextfield.setColumns(10);
		nameTextfield.setBounds(105, 91, 136, 20);
		informationJPanel.add(nameTextfield);
		
		timeTextField = new JTextField();
		timeTextField.setColumns(10);
		timeTextField.setBounds(105, 149, 136, 20);
		informationJPanel.add(timeTextField);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		priceTextField.setBounds(105, 213, 136, 20);
		informationJPanel.add(priceTextField);
		
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

	public JTable getServiceTable() {
		return serviceTable;
	}

	public void setServiceTable(JTable serviceTable) {
		this.serviceTable = serviceTable;
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

	public JTextField getTimeTextField() {
		return timeTextField;
	}

	public void setTimeTextField(JTextField timeTextField) {
		this.timeTextField = timeTextField;
	}

	public JTextField getPriceTextField() {
		return priceTextField;
	}

	public void setPriceTextField(JTextField priceTextField) {
		this.priceTextField = priceTextField;
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
	
	
	public void addNewServiceListener(ActionListener listenForButton){
	    
		btnAdd.addActionListener(listenForButton);

		
		}
	
	
	public void tableSelecterListener(ListSelectionListener rowSelected){
	    
		
		serviceTable.getSelectionModel().addListSelectionListener(rowSelected);
		
		}

}
