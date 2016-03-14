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

public class Parts_GUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane partsScroller; 
	private JTable partsTable;
	private JOptionPane updateDetails;
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
    private JTextField descriptionTextField;
    private JTextField priceTextField;


	public Parts_GUI() {
		setTitle("Parts Section");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel detailsJPanel = new JPanel();
		detailsJPanel.setBorder(new TitledBorder(null, "Parts Details", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		detailsJPanel.setBounds(22, 11, 322, 381);
		detailsJPanel.setLayout(null);
		
		partsTable = new JTable(/*data, columns*/);
		partsScroller = new JScrollPane(partsTable);
		partsScroller.setBounds(10, 23, 302, 347);
		detailsJPanel.add(partsScroller);
		contentPane.add(detailsJPanel);
		
		
		
		
		JPanel informationJPanel = new JPanel();
		informationJPanel.setBorder(new TitledBorder(null, "Parts Information", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		informationJPanel.setBounds(363, 11, 322, 381);
		contentPane.add(informationJPanel);
		informationJPanel.setLayout(null);
		
		lblServiceId = new JLabel("Part ID");
		lblServiceId.setBounds(23, 41, 88, 14);
		informationJPanel.add(lblServiceId);
		
		serviceNameJLabel = new JLabel("Part Name");
		serviceNameJLabel.setBounds(23, 94, 88, 14);
		informationJPanel.add(serviceNameJLabel);
		
		lblServiceTime = new JLabel("Part Description");
		lblServiceTime.setBounds(23, 152, 88, 14);
		informationJPanel.add(lblServiceTime);
		
		lblServicePrice = new JLabel("Part Price");
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
		
		descriptionTextField = new JTextField();
		descriptionTextField.setColumns(10);
		descriptionTextField.setBounds(105, 149, 136, 20);
		informationJPanel.add(descriptionTextField);
		
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

	public JTextField getDescriptionTextField() {
		return descriptionTextField;
	}

	public void setDescriptionTextField(JTextField descriptionTextField) {
		this.descriptionTextField = descriptionTextField;
	}

	public JTable getPartsTable() {
		return partsTable;
	}

	public void setPartsTable(JTable partsTable) {
		this.partsTable = partsTable;
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

	public JTextField getdescriptionTextField() {
		return descriptionTextField;
	}

	public void setdescriptionTextField(JTextField descriptionTextField) {
		this.descriptionTextField = descriptionTextField;
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
	
	
	public void addNewPartsListener(ActionListener listenForButton){
	    
		btnAdd.addActionListener(listenForButton);

		
		}
	
	
	public void tableSelecterListener(ListSelectionListener rowSelected){
	    
		
		partsTable.getSelectionModel().addListSelectionListener(rowSelected);
		
		}

}

