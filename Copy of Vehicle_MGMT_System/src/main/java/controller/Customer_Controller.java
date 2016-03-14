package controller;

import gui.CustomerTable;
import gui.Customer_GUI;
import gui.Main_Menu_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import service.Customer_Service;
import model.Customer_Model;
import model.Customers_Vehicle_Model;

public class Customer_Controller {

	private Main_Menu_GUI maingui = new Main_Menu_GUI();
	private Customer_GUI customergui = new Customer_GUI();
	private Customer_Model customermodel = new Customer_Model();
	private Customer_Service customerservice = new Customer_Service();
	private Customers_Vehicle_Model owners_car = new Customers_Vehicle_Model();
	private ArrayList<Customers_Vehicle_Model> owners_carList   = new ArrayList<Customers_Vehicle_Model>();
	private ArrayList<Customer_Model> customers = new ArrayList<Customer_Model>();
	private CustomerTable customertable;

	public Customer_Controller(Main_Menu_GUI maingui, Customer_GUI customergui,
			Customer_Model customermodel) {
		this.maingui = maingui;
		this.customergui = customergui;
		this.customermodel = customermodel;

		this.customergui.tableSelecterListener(new rowSelectedListener());
		this.customergui.exitListener(new exitListener());
		this.customergui.addNewCustomerListener(new addListener());
		this.customergui.editButtonListener(new editListener());
		this.customergui.deleteListener(new deleteListener());
		this.maingui.addListener(new Listener());

	}

	class rowSelectedListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {

			try {

				int rowSelected = (int) customergui.getCustomertable().getValueAt(customergui.getCustomertable().getSelectedRow(),0);
				for (Customer_Model c : customers) {

					if (c.getCustomer_id() == rowSelected) {

						customergui.getDetailidtextfield().setText(
								Integer.toString(c.getCustomer_id()));
						customergui.getDetailfirstnametextfield().setText(
								c.getFirst_name());
						customergui.getDetailsurnameTextField().setText(
								c.getSurname());
						customergui.getDetailphonetextfield().setText(
								Integer.toString(c.getPhone_number()));
						customergui.getDetailinfotextfield().setText(
								c.getCustomer_info());
						customergui.getDetailhistorytextfield().setText(
								c.getCustomer_history());
					}
				}

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}

		}

	}

	class deleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				double idextract = Double.parseDouble(customergui
						.getDetailidtextfield().getText());
				int id = (int) idextract;

				int selectedOption = customergui.getUpdateDetails()
						.showConfirmDialog(null, "Delete Customer?",
								"Warning!",
								customergui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == customergui.getUpdateDetails().YES_OPTION) {

					customerservice.open();
					customerservice.delete(id);
					customerservice.close();
					refreshTable();
					customergui.getDetailidtextfield().setText("");
					customergui.getDetailfirstnametextfield().setText("");
					customergui.getDetailsurnameTextField().setText("");
					customergui.getDetailphonetextfield().setText("");
					customergui.getDetailinfotextfield().setText("");
					customergui.getDetailhistorytextfield().setText("");
			
				}

			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

			}

		}

	}

	class editListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				String firstname = customergui.getDetailfirstnametextfield()
						.getText();
				String surname = customergui.getDetailsurnameTextField()
						.getText();
				String info = customergui.getDetailinfotextfield().getText();
				String history = customergui.getDetailhistorytextfield()
						.getText();
				double idextract = Double.parseDouble(customergui
						.getDetailidtextfield().getText());
				int id = (int) idextract;
				double phoneextract = Double.parseDouble(customergui
						.getDetailphonetextfield().getText());
				int phone = (int) phoneextract;

				int selectedOption = customergui.getUpdateDetails()
						.showConfirmDialog(null,
								"Save Update to  Customer Information?",
								"Warning!",
								customergui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == customergui.getUpdateDetails().YES_OPTION) {

					for (Customer_Model c : customers) {

						// System.out.println("SIZE!!!" +customers.size());
						System.out.println(c.getCustomer_id());

						boolean found = false;
						if (c.getCustomer_id() == customerservice.findById(id)
								.getCustomer_id()) {
							System.out.println("Sucess");
							customerservice.open();
							c.setFirst_name(firstname);
							c.setSurname(surname);
							c.setPhone_number(phone);
							c.setCustomer_info(info);
							c.setCustomer_history(history);
							customerservice.update(c);
							customerservice.close();
							found = true;

							customergui.getDetailidtextfield().setText("");
							customergui.getDetailfirstnametextfield().setText("");
							customergui.getDetailsurnameTextField().setText("");
							customergui.getDetailphonetextfield().setText("");
							customergui.getDetailinfotextfield().setText("");
							customergui.getDetailhistorytextfield().setText("");
							refreshTable();
						}
					
						else {

							found = false;
						}

					}

				}

			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

			}

		}

	}

	class exitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				customers.clear();
				customergui.dispose();
				maingui.setVisible(true);
				refreshTable();
			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

			}

		}

	}
	
	public void refreshTable() {
		customertable.fireTableDataChanged();
	}

	class addListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {

				customerservice.open();
				String firstname = customergui.getFirstNametextField().getText();
				String surname = customergui.getSurnametextField().getText();
				String info = customergui.getInfoTextfield().getText();
				String history = customergui.getHistoryTextfield().getText();
				double idextract = Double.parseDouble(customergui.getIDtextField().getText());
				int id = (int) idextract;
				double phoneextract = Double.parseDouble(customergui.getPhonetextField().getText());
				int phone = (int) phoneextract;

				customermodel.setCustomer_id(id);
				customermodel.setFirst_name(firstname);
				customermodel.setSurname(surname);
				customermodel.setPhone_number(phone);
				customermodel.setCustomer_info(info);
				customermodel.setCustomer_history(history);
				//customers.add(customers.size(),customermodel);
				customerservice.persist(customermodel);
				customerservice.close();
				
				customergui.getIDtextField().setText("");
				customergui.getFirstNametextField().setText("");
				customergui.getSurnametextField().setText("");
				customergui.getPhonetextField().setText("");
				customergui.getHistoryTextfield().setText("");
				customergui.getInfoTextfield().setText("");
				refreshTable();

			} catch (NumberFormatException nfe) {

				System.out.println("ERROR CANNOT BE DONE: " + nfe.getMessage());

			}

		}

	}

	class Listener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
				
				maingui.dispose();
				customergui.setVisible(true);
				customertable = new CustomerTable(customers);
				customergui.getCustomertable().setModel(customertable);
		
				List<Customer_Model> c = customerservice.findAll();

				for (int x = 0; x < c.size(); x++) {
					customermodel = (Customer_Model) c.get(x);
					customers.add(customermodel);

				}
			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

			}

		}

	}
}
