package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;

import java.awt.SystemColor;

import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Current_Appointment_GUI extends JFrame {

	private JPanel contentPane;
	private JLabel dateOutputLbl;
	private JLabel customerOutputLbl;
	private JLabel techOutputLbl;
	private JLabel jobOutputLbl;
	private JLabel lblVehicleRegOutput;
	private JLabel lblPriceOutPut;
	private JLabel idlbl;
	private JButton btnInvoice;
	private JButton btnAddPart;
	private JButton btnDeleteJob;
	private JScrollPane partsScroller; 
	private JTable partstable;
	private JOptionPane updateDetails;
	
	
	
	public Current_Appointment_GUI() {
		setTitle("Current Job");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new LineBorder(SystemColor.activeCaption, 5, true));
		infoPanel.setBounds(30, 32, 362, 111);
		contentPane.add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 11, 78, 14);
		infoPanel.add(lblDate);
		
		dateOutputLbl = new JLabel("");
		dateOutputLbl.setBounds(234, 11, 78, 14);
		infoPanel.add(dateOutputLbl);
		
		JLabel lblCustomer = new JLabel("Customer:");
		lblCustomer.setBounds(10, 36, 93, 14);
		infoPanel.add(lblCustomer);
		
		customerOutputLbl = new JLabel("");
		customerOutputLbl.setBounds(234, 36, 78, 14);
		infoPanel.add(customerOutputLbl);
		
		JLabel lblTechnician = new JLabel("Technician");
		lblTechnician.setBounds(10, 61, 93, 14);
		infoPanel.add(lblTechnician);
		
		techOutputLbl = new JLabel("");
		techOutputLbl.setBounds(234, 61, 78, 14);
		infoPanel.add(techOutputLbl);
		
		JLabel lblJobType = new JLabel("Job Type");
		lblJobType.setBounds(10, 86, 78, 14);
		infoPanel.add(lblJobType);
		
		jobOutputLbl = new JLabel("");
		jobOutputLbl.setBounds(234, 86, 78, 14);
		infoPanel.add(jobOutputLbl);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(175, 128, 0, -126);
		infoPanel.add(separator);
		
		JLabel reglbl = new JLabel("Registration");
		reglbl.setBounds(30, 7, 78, 14);
		contentPane.add(reglbl);
	
		lblVehicleRegOutput = new JLabel("");
		lblVehicleRegOutput.setBounds(116, 7, 95, 14);
		contentPane.add(lblVehicleRegOutput);
		
		JLabel lblCurrentPrice = new JLabel("Current Price");
		lblCurrentPrice.setBounds(235, 7, 78, 14);
		contentPane.add(lblCurrentPrice);
		
		lblPriceOutPut = new JLabel("");
		lblPriceOutPut.setBounds(346, 7, 46, 14);
		contentPane.add(lblPriceOutPut);
		
		btnInvoice = new JButton("Invoice Job");
		btnInvoice.setBounds(294, 258, 109, 23);
		contentPane.add(btnInvoice);
		
		btnAddPart = new JButton("Add Part");
		btnAddPart.setBounds(40, 258, 110, 23);
		contentPane.add(btnAddPart);
		
		btnDeleteJob = new JButton("Delete Part");
		btnDeleteJob.setBounds(163, 258, 104, 23);
		contentPane.add(btnDeleteJob);
		

		
		
		
		JPanel partsPanel = new JPanel();
		partsPanel.setLayout(null);
		partsPanel.setBorder(new LineBorder(SystemColor.activeCaption, 5, true));
		partsPanel.setBounds(30, 139, 362, 111);
        partstable = new JTable();
		partsScroller = new JScrollPane(partstable);
		partsScroller.setSize(342, 89);
		partsScroller.setLocation(10, 11);
		partsPanel.add(partsScroller);
		contentPane.add(partsPanel);
		
		updateDetails = new JOptionPane();
		updateDetails.setBounds(574, 134, 200,200);	
		infoPanel.add(updateDetails);

		
		idlbl = new JLabel();
		idlbl.setVisible(false);
		infoPanel.add(idlbl);
		
		


	}
	


	public void DeletePart(ActionListener listenForClick){
	    
		btnDeleteJob.addActionListener(listenForClick);

		}
	
	
	public void tableSelecterListener(ListSelectionListener rowSelected){
	    
		
		partstable.getSelectionModel().addListSelectionListener(rowSelected);
		
		}
	
	
	public void AddParttoJob(ActionListener listenForClick){
	    
		btnAddPart.addActionListener(listenForClick);
		
		}
	
	public void InvoiceJob(ActionListener listenForClick){
	    
		btnInvoice.addActionListener(listenForClick);


		
		}
	
	

	public JOptionPane getUpdateDetails() {
		return updateDetails;
	}



	public void setUpdateDetails(JOptionPane updateDetails) {
		this.updateDetails = updateDetails;
	}



	public JLabel getDateOutputLbl() {
		return dateOutputLbl;
	}

	public void setDateOutputLbl(JLabel dateOutputLbl) {
		this.dateOutputLbl = dateOutputLbl;
	}

	public JLabel getCustomerOutputLbl() {
		return customerOutputLbl;
	}

	public void setCustomerOutputLbl(JLabel customerOutputLbl) {
		this.customerOutputLbl = customerOutputLbl;
	}

	public JLabel getTechOutputLbl() {
		return techOutputLbl;
	}

	public void setTechOutputLbl(JLabel techOutputLbl) {
		this.techOutputLbl = techOutputLbl;
	}

	public JLabel getJobOutputLbl() {
		return jobOutputLbl;
	}

	public void setJobOutputLbl(JLabel jobOutputLbl) {
		this.jobOutputLbl = jobOutputLbl;
	}

	public JLabel getLblPriceOutPut() {
		return lblPriceOutPut;
	}

	public void setLblPriceOutPut(JLabel lblPriceOutPut) {
		this.lblPriceOutPut = lblPriceOutPut;
	}

	public JTable getPartstable() {
		return partstable;
	}

	public void setPartstable(JTable partstable) {
		this.partstable = partstable;
	}

	public JLabel getLblVehicleRegOutput() {
		return lblVehicleRegOutput;
	}

	public void setLblVehicleRegOutput(JLabel lblVehicleRegOutput) {
		this.lblVehicleRegOutput = lblVehicleRegOutput;
	}
	
	public JLabel getIdlbl() {
		return idlbl;
	}

	public void setIdlbl(JLabel idlbl) {
		this.idlbl = idlbl;
	}
	
}
