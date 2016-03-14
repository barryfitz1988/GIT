package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AddAppointment_GUI extends JFrame {

	private JPanel contentPane;
	private JComboBox serviceComboBox;
	private JLabel techLbl;
	private JLabel dateLbl;
	private JLabel timeLbl;
	private JButton btnCancel;
	private JButton btnSave;
	private JTextField searchTextfield;
	private JLabel lblCustomersName;
	private JLabel lblMakeModel;
	private JButton btnAddPart;
	private JLabel lblReg;

	
	public AddAppointment_GUI() {
		setTitle("Create Appointment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel customerPanel = new JPanel();
		customerPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search For Vehicle", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		customerPanel.setBounds(10, 11, 458, 133);
		contentPane.add(customerPanel);
		customerPanel.setLayout(null);
		
		searchTextfield = new JTextField();
		searchTextfield.setBounds(120, 26, 216, 20);
		customerPanel.add(searchTextfield);
		searchTextfield.setColumns(10);
		
		lblCustomersName = new JLabel("");
		lblCustomersName.setBounds(10, 61, 157, 14);
		customerPanel.add(lblCustomersName);
		
		lblMakeModel = new JLabel("");
		lblMakeModel.setBounds(267, 86, 168, 14);
		customerPanel.add(lblMakeModel);
		
		lblReg = new JLabel("");
		lblReg.setBounds(267, 61, 157, 14);
		customerPanel.add(lblReg);
		
		JPanel ServicePanel = new JPanel();
		ServicePanel.setLayout(null);
		ServicePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Select Service", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		ServicePanel.setBounds(10, 155, 458, 71);
		contentPane.add(ServicePanel);
		
		serviceComboBox = new JComboBox();
		serviceComboBox.setBounds(128, 26, 179, 29);
		
		

		ServicePanel.add(serviceComboBox);
		
		JPanel techPanel = new JPanel();
		techPanel.setLayout(null);
		techPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Assigned Technician", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		techPanel.setBounds(10, 237, 458, 71);
		contentPane.add(techPanel);
		
		techLbl = new JLabel("");
		techLbl.setBounds(132, 33, 167, 27);
		techPanel.add(techLbl);
		
		JPanel DateandTimePanel = new JPanel();
		DateandTimePanel.setLayout(null);
		DateandTimePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Date & Time", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		DateandTimePanel.setBounds(10, 319, 458, 71);
		contentPane.add(DateandTimePanel);
		
		dateLbl = new JLabel("");
		dateLbl.setBounds(29, 33, 167, 27);
		DateandTimePanel.add(dateLbl);
		
		timeLbl = new JLabel("");
		timeLbl.setBounds(240, 33, 167, 27);
		DateandTimePanel.add(timeLbl);
		
		btnAddPart = new JButton("Add Part");
		btnAddPart.setBounds(177, 23, 89, 23);
		//partsPanel.add(btnAddPart);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(348, 401, 89, 23);
		contentPane.add(btnCancel);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(55, 401, 89, 23);
		contentPane.add(btnSave);
	}


	public JTextField getSearchTextfield() {
		return searchTextfield;
	}

	public void setSearchTextfield(JTextField searchTextfield) {
		this.searchTextfield = searchTextfield;
	}

	public JComboBox getServiceComboBox() {
		return serviceComboBox;
	}

	public void setServiceComboBox(JComboBox serviceComboBox) {
		this.serviceComboBox = serviceComboBox;
	}

	public JLabel getTechLbl() {
		return techLbl;
	}

	public void setTechLbl(JLabel techLbl) {
		this.techLbl = techLbl;
	}

	public JLabel getDateLbl() {
		return dateLbl;
	}

	public void setDateLbl(JLabel dateLbl) {
		this.dateLbl = dateLbl;
	}

	public JLabel getTimeLbl() {
		return timeLbl;
	}

	public void setTimeLbl(JLabel timeLbl) {
		this.timeLbl = timeLbl;
	}



	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}
	
	
	public JLabel getLblCustomersName() {
		return lblCustomersName;
	}

	public void setLblCustomersName(JLabel lblCustomersName) {
		this.lblCustomersName = lblCustomersName;
	}

	public JLabel getLblMakeModel() {
		return lblMakeModel;
	}

	public void setLblMakeModel(JLabel lblMakeModel) {
		this.lblMakeModel = lblMakeModel;
	}
	
	

	public JLabel getLblReg() {
		return lblReg;
	}

	public void setLblReg(JLabel lblReg) {
		this.lblReg = lblReg;
	}
	
	



	public void CancelandReturn(ActionListener listenForClick){
	    
		btnCancel.addActionListener(listenForClick);


		
		}
	
	
	public void searchforReg(ActionListener listenForClick){
	    
		searchTextfield.addActionListener(listenForClick);
		
		}
	
	public void addParttoAppointment(ActionListener listenForClick){
	    
		btnAddPart.addActionListener(listenForClick);


		
		}
	
	public void saveAppointment(ActionListener listenForClick){
	    
		btnSave.addActionListener(listenForClick);


		
		}
}
