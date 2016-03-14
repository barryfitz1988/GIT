package controller;


import gui.AddAppointment_GUI;
import gui.AppointmentTable;
import gui.Appointment_Desicion_GUI;
import gui.Appointment_GUI;
import gui.Appointment_Parts_Table;
import gui.BlankTable_Frame;
import gui.Current_Appointment_GUI;
import gui.CustomerTable;
import gui.Invoice_GUI;
import gui.Main_Menu_GUI;
import gui.PartsTable;
import gui.VehicleTable;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.activemq.filter.function.regexMatchFunction;
import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;

import service.Appointment_Service;
import service.Customer_Service;
import service.Employee_Service;
import service.Invoice_Service;
import service.Parts_Service;
import service.Service_Service;
import service.Vehicle_Service;
import utility.Header_Render;
import model.Appointment_Model;
import model.Appointment_Parts_Model;
import model.Customer_Model;
import model.Customers_Vehicle_Model;
import model.Employee_Model;
import model.Invoice_Model;
import model.Parts_Model;
import model.Service_Model;
import model.Vehicle_Model;

public class Appointment_Controller {

	private Main_Menu_GUI maingui = new Main_Menu_GUI();
	private Appointment_GUI appointmentgui = new Appointment_GUI();
	private Appointment_Model appointmentmodel = new Appointment_Model();
	private AddAppointment_GUI addappointmentgui = new AddAppointment_GUI();
	private Appointment_Service appointmentservice  = new Appointment_Service();
	private ArrayList<Appointment_Model> appointments = new ArrayList<Appointment_Model>();
	private Current_Appointment_GUI currentappointmentgui =  new Current_Appointment_GUI();
	private ArrayList<Parts_Model> currentparts =  new ArrayList<Parts_Model>();
	private Appointment_Desicion_GUI appointmentdescion = new Appointment_Desicion_GUI();
	private BlankTable_Frame partsFrame = new BlankTable_Frame();


	private Invoice_Model invoicemodel = new Invoice_Model();
	private Invoice_Service  invoiceservice = new Invoice_Service();
	private Invoice_GUI invoicegui = new Invoice_GUI();
	private ArrayList<Invoice_Model> invoices =  new ArrayList<Invoice_Model>();
	
	private Vehicle_Service vehicleservice = new Vehicle_Service();
	private Customers_Vehicle_Model ownersCar =  new Customers_Vehicle_Model();
	private ArrayList<Customers_Vehicle_Model> ownersCarList = new ArrayList<Customers_Vehicle_Model>();
	
	private Service_Model servivemodel = new Service_Model();
	private Service_Service serviceservice = new Service_Service();
	private ArrayList<Service_Model> services = new ArrayList<Service_Model>();
	
	private Parts_Model partsmodel = new Parts_Model();
	private Parts_Service partsservice = new Parts_Service();
	private ArrayList<Parts_Model> parts = new ArrayList<Parts_Model>();
	
	private Appointment_Parts_Model appointment_parts = new Appointment_Parts_Model();
	private ArrayList<Appointment_Parts_Model> appointment_partsList = new ArrayList<Appointment_Parts_Model>();
	
	
	private Employee_Service emservice = new Employee_Service();
	private Employee_Model employeemode = new Employee_Model();
	private ArrayList<Employee_Model> employees = new ArrayList<Employee_Model>();
	
	private DefaultTableModel appointmenttablemodel;
	private PartsTable partstablemodel;
	private PartsTable partstable;
	//private AppointmentTable appointmenttable;
	
	 private String invoice_customername;
	 private String invoice_vehiclereg;
	 private String invoice_make;
	 private String invoice_model;
	 private String invoice_tech;
	 private String invoice_date;
	 private String invoice_service;
	 private String invoice_price;
	 private String invoice_parts;
	

	private int ownerId;
	private String date;
	private String tech;
	private String hour;
	private String reg;
	private String selectedService;
	private String customer;
	private String[] servicesname;
	private int counter = 0;
	private double price = 0;
	private boolean nextCellAvailable;
	private int length = 0;
	
	public Appointment_Controller(Main_Menu_GUI maingui,AddAppointment_GUI addappointmentgui,
			Appointment_GUI appointmentgui, Appointment_Model appointmentmodel, Invoice_GUI invoicegui) {
		
		this.maingui = maingui;
		this.appointmentgui = appointmentgui;
		this.appointmentmodel = appointmentmodel;
		this.addappointmentgui = addappointmentgui;
		this.invoicegui = invoicegui;
		this.addappointmentgui.CancelandReturn(new escapeListener());
		this.appointmentgui.exitListener(new exitListener());
		this.appointmentgui.selectCellonTable(new cellListener());
		this.appointmentgui.MyDateListener(new theDateListener());
		this.addappointmentgui.searchforReg(new registrationSearcher());
		this.addappointmentgui.saveAppointment(new saveListener());
		this.partsFrame.tableSelecterListener(new PartsSelectedListener());
		this.currentappointmentgui.DeletePart(new DeletePartListener());
		this.currentappointmentgui.AddParttoJob(new partAddedListener());
		this.currentappointmentgui.tableSelecterListener(new rowSelectedListener());
		this.currentappointmentgui.InvoiceJob(new InvoiceListener());
		this.appointmentdescion.UpdateAppointment(new UpdateListener());
		this.appointmentdescion.DeleteAppointment(new DeleteListener());
		
		this.maingui.addappointmentListener(new Listener());
	

	}

	
	
	
	public void refreshPartsTable() {

		appointment_partsList.clear();
		List<Appointment_Parts_Model> parts = appointmentservice.findAllParts();

		for (int x = 0; x < parts.size(); x++) {
			appointment_parts = (Appointment_Parts_Model) parts.get(x);
			appointment_partsList.add(appointment_parts);

		}
	}
	
	public void refreshTable() {

		appointments.clear();
		List<Appointment_Model> a = appointmentservice.findAll();

		for (int x = 0; x < a.size(); x++) {
			appointmentmodel = (Appointment_Model) a.get(x);
			appointments.add(appointmentmodel);

		}
		
		
		
		
		
	}
	
	
	class InvoiceListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
	
			
			int id  = Integer.valueOf(currentappointmentgui.getIdlbl().getText());
			System.out.println("ID  " + id);
			StringBuilder stringBuilder = new StringBuilder();
			String allParts = null;
			
			for(Appointment_Parts_Model p : appointment_partsList){
				
				if(p.getAppointment().getAppointment_id() == id){
					
					stringBuilder.append("\n"+p.getPart().getPart_name()+"\n");

					allParts = stringBuilder.toString();
						
				}
			}
			
			invoice_parts = allParts;

			for(Appointment_Model a : appointments){

	
				
				if(a.getAppointment_id() == id){
					
					invoice_date = a.getDate();
					
					invoice_customername =  a.getCustomer_name();
					invoice_vehiclereg = a.getVehicle_reg();
					invoice_tech = a.getEmployee_name();
					invoice_service = a.getJob_name();
					invoice_price = currentappointmentgui.getLblPriceOutPut().getText();
					//invoice_parts = "\n" +a.getPart_name().toString()+"\n";
					for(Customers_Vehicle_Model s : ownersCarList){
						
						if(a.getVehicle_reg().equals(s.getVehicle().getVehicle_reg())){
							
							invoice_make = s.getVehicle().getVehicle_make();
							invoice_model = s.getVehicle().getVehicle_model();

						}

					}

				}

			}
			
			invoicemodel.setJob_ID(id);
			invoicemodel.setDate(invoice_date);
			invoicemodel.setPrice(invoice_price);
			invoicemodel.setCustomername(invoice_customername);
			invoicemodel.setMake(invoice_make);
			invoicemodel.setModel(invoice_model);
			invoicemodel.setVehiclereg(invoice_vehiclereg);
			invoicemodel.setTech(invoice_tech);
			invoicemodel.setService(invoice_service);
			invoicemodel.setParts(invoice_parts);
			invoiceservice.open();
			appointmentservice.open();
			appointmentservice.delete(id);
			invoiceservice.persist(invoicemodel);
			invoiceservice.close();
			appointmentservice.close();
			
		
			int selectedOption = currentappointmentgui.getUpdateDetails()
					.showConfirmDialog(null, "JOB HAS BEEN INVOICED \n"
							+ "APPOINTMENT HAS NOW BEEN DELETED \n"
							+ "PROCEED TO INVOICE SCREEN",
							"Warning!",
							currentappointmentgui.getUpdateDetails().YES_NO_OPTION);
			if (selectedOption == currentappointmentgui.getUpdateDetails().YES_OPTION) {
				
				
				
				
				currentappointmentgui.setVisible(false);
				appointmentgui.setVisible(false);
				invoicegui.setVisible(true);
				refreshTable();
				
				
				
			}

		}

	}
	
	class UpdateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			currentappointmentgui.setVisible(true);
			appointmentdescion.setVisible(false);
			 counter = 0;

			 
		}


	
	}
	
	class DeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			int id  = Integer.valueOf(currentappointmentgui.getIdlbl().getText());
			

			int selectedOption = currentappointmentgui.getUpdateDetails()
					.showConfirmDialog(null, "Delete Appointment?",
							"Warning!",
							currentappointmentgui.getUpdateDetails().YES_NO_OPTION);
			if (selectedOption == currentappointmentgui.getUpdateDetails().YES_OPTION) {
				
				
				//System.out.println("JUST BEFORE DELETE ---->" + ownerId);

						appointmentservice.open();
						appointmentservice.delete(id);
						appointmentservice.close();

				
				

			}
			
			appointmentdescion.setVisible(false);
			refreshTable();
		}


	
	}
	
	
	class rowSelectedListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {

			try {
				int rowSelected = (int) currentappointmentgui.getPartstable().getValueAt(currentappointmentgui.getPartstable().getSelectedRow(),0);
				
				
				
				for (Appointment_Parts_Model c : appointment_partsList) {
					
					if(c.getAppointment().getAppointment_id() == Integer.valueOf(currentappointmentgui.getIdlbl().getText())){
				
						if(c.getPart().getPart_id() == rowSelected){
														
							ownerId = c.getId();
			
							
						}	
						

					}

				}

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}

		}

	}
	
	
	
	
	class DeletePartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				

				int selectedOption = currentappointmentgui.getUpdateDetails()
						.showConfirmDialog(null, "Delete Part?",
								"Warning!",
								currentappointmentgui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == currentappointmentgui.getUpdateDetails().YES_OPTION) {
		

							appointmentservice.open();
							appointmentservice.deleteParts(ownerId);
							appointmentservice.close();
							refreshPartsTable();
				}

			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

			}
			
			
			
		}
		
	}
	
	
	class PartsSelectedListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
		
			try {
				int rowSelected = (int) partsFrame.getBlankTable().getValueAt(partsFrame.getBlankTable().getSelectedRow(),0);
				
			
				for (Parts_Model c : parts) {

					if (c.getPart_id() == rowSelected) {
						
						for(Appointment_Model a : appointments){
						
							if(a.getAppointment_id() == Integer.valueOf(currentappointmentgui.getIdlbl().getText())){
						appointmentservice.open();
						appointment_parts.setAppointment(a);
						appointment_parts.setPart(c);
						appointmentservice.persistPart(appointment_parts);
						appointmentservice.close();
							}
						}
					}
				
				}
				
				parts.clear();
				refreshPartsTable();
				partsFrame.dispose();

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}

		}

	}
	
	
	
	class saveListener implements ActionListener {

		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			date = addappointmentgui.getDateLbl().getText();
			tech = addappointmentgui.getTechLbl().getText();
			hour = addappointmentgui.getTimeLbl().getText();
			customer = addappointmentgui.getLblCustomersName().getText();
			reg = addappointmentgui.getLblReg().getText();
			selectedService =String.valueOf(addappointmentgui.getServiceComboBox().getSelectedItem());
			
			for(Service_Model sv : services){
				
				if(selectedService.equals(sv.getJob_name())){
					length = sv.getJob_time();
					
				}
				
			}
	
			int selectedRow = appointmentgui.getAppointmentTable().getSelectedRow();
			int selectedColumn = appointmentgui.getAppointmentTable().getSelectedColumn();
			boolean nextCellAvailable = false;
			
			System.out.println("SELECTED COLUMN LENGTH" + selectedRow);
			
			if(selectedRow + length < 12){
			if(appointmentgui.getAppointmentTable().getModel().getValueAt(selectedRow, selectedColumn).toString().equals("")
					&& appointmentgui.getAppointmentTable().getModel().getValueAt(selectedRow + length, selectedColumn).toString().equals("")
					&& appointmentgui.getAppointmentTable().getModel().getValueAt(selectedRow + length /2 , selectedColumn).toString().equals("")
					&& appointmentgui.getAppointmentTable().getModel().getValueAt(selectedRow + length /2 + 1 , selectedColumn).toString().equals("")
					&& appointmentgui.getAppointmentTable().getModel().getValueAt(selectedRow + length - 1 , selectedColumn).toString().equals("")
					&& appointmentgui.getAppointmentTable().getModel().getValueAt(selectedRow + 1 , selectedColumn).toString().equals("")	){
				
			
					
				appointmentservice.open();

				appointmentmodel.getAppointment_id();
				appointmentmodel.setCustomer_name(customer);
				appointmentmodel.setDate(date);
				appointmentmodel.setVehicle_reg(reg);
				appointmentmodel.setEmployee_name(tech);
				appointmentmodel.setJob_name(selectedService);
				appointmentmodel.setTime(hour);
				appointmentmodel.setService_length(length);
				appointmentservice.persist(appointmentmodel);
				appointmentservice.close();
				refreshTable();
				
				
				JOptionPane.showMessageDialog(partsFrame, " FOR " + customer +" ON " 
						+ date +" AND TIME " + hour ," APPOINTMENT ADDED TO SYSTEM "
						, JOptionPane.WARNING_MESSAGE);
				}		
				
				else{
				
				JOptionPane.showMessageDialog(partsFrame," THIS JOB TAKES APPROXIMETLY " + String.valueOf(length)+" HOURS  \n"
						+ " PLEASE ALLOW FOR TEST DRIVE AND PREPERATION FOR NEXT JOB \n "
						+ " SELECT ANOTHER SLOT, ", "ERROR"
									,JOptionPane.WARNING_MESSAGE);
				
				

			}
			
			
		}else{
			JOptionPane.showMessageDialog(partsFrame, "CLOSE OF BUSINESS DAY \n BOOKING EXCEEDS TIME \n PLEASE"
					+ " PLEASE RESCHEDULE " ," ERROR"
					, JOptionPane.WARNING_MESSAGE);
		
	}			
						
						System.out.println("DATE--->" + date);
						addappointmentgui.dispose();
						services.clear();
						ownersCarList.clear();
						servicesname = new String[servicesname.length];
						counter = 0;
			
			
		}
		
		
		
	}
	
	class partAddedListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
				
			
				partsFrame.setVisible(true);
				partstable = new PartsTable(parts);
				partsFrame.getBlankTable().setModel(partstable);
				
				List<Parts_Model> c = partsservice.findAll();

				for (int x = 0; x < c.size(); x++) {
					partsmodel = (Parts_Model) c.get(x);
					parts.add(partsmodel);

				}
			
			
			
		}
		

		
		
		
		
		
	}
	
	class registrationSearcher implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String reg = addappointmentgui.getSearchTextfield().getText();

			for (Customers_Vehicle_Model c : ownersCarList) {
				String customerName = c.getCustomer().getFirst_name() + " "
						+ c.getCustomer().getSurname();
				String makeModel = c.getVehicle().getVehicle_make() + " "
						+ c.getVehicle().getVehicle_model();
				String registration = c.getVehicle().getVehicle_reg();
				
				boolean found = false;

				System.out.println(c.getVehicle().getVehicle_reg());
				System.out.println("IS THERE ANYTHING HERE??   "
						+ ownersCarList.size());

				if (c.getVehicle().getVehicle_reg().equals(reg)) {
					System.out.println("Success");

					addappointmentgui.getLblCustomersName().setText(
							customerName);
					addappointmentgui.getLblMakeModel().setText(makeModel);
					addappointmentgui.getLblReg().setText(registration);

				}

				else {
					System.out.println("Fail");

					found = false;

				}

			}

		}

	}
	
	
	
	class escapeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			addappointmentgui.dispose();
			appointments.clear();
			appointment_partsList.clear();
			currentparts.clear();
			services.clear();
			ownersCarList.clear();
			servicesname = new String[servicesname.length];
			counter = 0;
			price = 0;

		}

	}
	
	class theDateListener implements DateListener{

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  
		@Override 
		public void dateChanged(DateEvent e){
			
			Calendar c = e.getSelectedDate();
			appointmentgui.getAppointmentTable().setVisible(true);
			
			if (c != null) {
				
				date = dateFormat.format(c.getTime()); 

				
				addappointmentgui.getDateLbl().setText(date);
				
				//to clear table
				 for (int i = 0; i < appointmentgui.getAppointmentTable().getRowCount(); i++) {
				        for (int j = 0; j < appointmentgui.getAppointmentTable().getColumnCount(); j++) {
				        	appointmentgui.getAppointmentTable().setValueAt("", i, j);
				        }
				    }

			
			//to populate table
			for(Appointment_Model a : appointments){
				
				
				int serviceDuration = a.getService_length();
				String employeeName = a.getEmployee_name();

				
			if(date.equals(a.getDate()) /*&& hour.equals(a.getTime())*/){

				
				for(int x = 0; x<appointmentgui.getAppointmentTable().getColumnCount();x++) {

					if(appointmentgui.getAppointmentTable().getTableHeader().getColumnModel().getColumn(x).getHeaderValue()
							.equals(employeeName)){	
					
					for(int y = 0; y<appointmentgui.getRowtable().getRowCount(); y++) {
	
						if(appointmentgui.getRowtable().getValueAt(y,y).equals(a.getTime())){
							
							appointmentgui.getAppointmentTable().setValueAt(a.getCustomer_name(), y, x);
							
							
							if(serviceDuration > 1){
								
								for(int s =0; s < serviceDuration; s++){
								appointmentgui.getAppointmentTable().setValueAt(a.getCustomer_name(), y + s, x);
											}
										}
									}

								}
							}
						}

					}

				}

			} else {

				System.out.println("No time selected.");
			}
		}

	}

	class cellListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent evt ) {
			
				partstablemodel = new PartsTable(currentparts);
				currentappointmentgui.getPartstable().setModel(partstablemodel);
			
			List<Service_Model> c = serviceservice.findAll();	
			
			for (int x = 0; x < c.size(); x++) {

				servivemodel = (Service_Model) c.get(x);
				services.add(servivemodel);
				servicesname = new String[services.size()];
				
			}
			
			
			for(int x = 0; x <services.size();x++){
				
			servicesname[counter] = services.get(x).getJob_name();	
			counter++;
			

			}
				
			
			List<Customers_Vehicle_Model> cus = vehicleservice.findAllOwners();	
			
				for (int x = 0; x < cus.size(); x++) {

				ownersCar = (Customers_Vehicle_Model) cus.get(x);
				ownersCarList.add(ownersCar);
			}	


	    	int row = appointmentgui.getAppointmentTable().rowAtPoint(evt.getPoint());
	        int col = appointmentgui.getAppointmentTable().columnAtPoint(evt.getPoint());
	        
	        String time = (String)appointmentgui.getRowtable().getValueAt(row, 0);
	      //  appointmentgui.getAppointmentTable().setValueAt("xxxxx", 0, 0);
	   
	        //System.out.println(appointmentgui.getAppointmentTable().getValueAt(row, col));
	        	
	        
	     if(appointmentgui.getAppointmentTable().getValueAt(row, col)== "") {
	    	 System.out.println(appointmentgui.getAppointmentTable().getValueAt(row, col));
	    	
	    	 
	    	 
	    	 
	    	 
	    	 
			String employeeName = (String)appointmentgui.getAppointmentTable().getTableHeader().getColumnModel()
						.getColumn(col).getHeaderValue();
	    	 
		
	    	 addappointmentgui.getTechLbl().setText(employeeName);
	    	 addappointmentgui.getTimeLbl().setText(time);
	    	 addappointmentgui.getServiceComboBox().setModel(new DefaultComboBoxModel(servicesname));
	    	 addappointmentgui.setVisible(true);
	     
	     }else{
				

	    	 for(Appointment_Model a : appointments){

	    		 
	    	if(a.getCustomer_name() == appointmentgui.getAppointmentTable().getValueAt(row, col)){ 
	    	 currentappointmentgui.getDateOutputLbl().setText(date);
	    	 
	    	 for(Service_Model s : services){
	    		 
	    	if(a.getJob_name().equals(s.getJob_name())){
	    		 price = s.getJob_price();
	    		 currentappointmentgui.getLblPriceOutPut().setText(String.valueOf(price));
	    	}
	    	 }
	    	 
	    	 
	    	 currentappointmentgui.getIdlbl().setText(String.valueOf(a.getAppointment_id()));
	    	 currentappointmentgui.getTechOutputLbl().setText(a.getEmployee_name());
	    	 currentappointmentgui.getCustomerOutputLbl().setText(a.getCustomer_name());
	    	 currentappointmentgui.getJobOutputLbl().setText(a.getJob_name());
	    	 currentappointmentgui.getLblVehicleRegOutput().setText(a.getVehicle_reg());

	    	}
	    	
	    	 }
	    	 
	    	 	
	    		partstablemodel = new PartsTable(currentparts);
   				currentappointmentgui.getPartstable().setModel(partstablemodel);
   				currentparts.clear();

				
   			
   				for(Appointment_Parts_Model parts : appointment_partsList){
   	
					if(parts.getAppointment().getAppointment_id() == Integer.valueOf(currentappointmentgui.getIdlbl().getText())){

						currentparts.add(parts.getPart());
						price = price + parts.getPart().getPart_price();
						System.out.println("PRICE"+ price);
						currentappointmentgui.getLblPriceOutPut().setText(String.valueOf(price));
					}
				
				}
   		
	    	 //currentappointmentgui.setVisible(true);
   				appointmentdescion.setVisible(true);
	    	 counter = 0;
	     }
	     
	     
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	class exitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				
				appointments.clear();
				appointment_partsList.clear();
				services.clear();
				currentparts.clear();
				ownersCarList.clear();
				servicesname = new String[servicesname.length];
				counter = 0;
				//price = 0;
				employees.clear();
				appointmentgui.dispose();
				maingui.setVisible(true);

			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

			}

		}

	}

	class Listener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {

				maingui.dispose();
				
				List<Employee_Model> c = emservice.findAll();

				for (int x = 0; x < c.size(); x++) {
					employeemode = (Employee_Model) c.get(x);
					employees.add(employeemode);

				}
				
				
				List<Appointment_Model> a = appointmentservice.findAll();

				for (int x = 0; x < a.size(); x++) {
					appointmentmodel = (Appointment_Model) a.get(x);
					appointments.add(appointmentmodel);

				}
				
				
				List<Invoice_Model> inv = invoiceservice.findAll();

				for (int x = 0; x < inv.size(); x++) {
					invoicemodel = (Invoice_Model) inv.get(x);
					invoices.add(invoicemodel);

				}
				
				
				List<Appointment_Parts_Model> p = appointmentservice.findAllParts();

				for (int x = 0; x < p.size(); x++) {
					appointment_parts = (Appointment_Parts_Model) p.get(x);
					appointment_partsList.add(appointment_parts);

				}
				
				
				appointmenttablemodel = (DefaultTableModel)appointmentgui.getAppointmentTable().getModel();
				appointmenttablemodel.setRowCount(12);
				appointmenttablemodel.setColumnCount(employees.size());
				
				//appointmenttable = new AppointmentTable(employees);
				//appointmentgui.getAppointmentTable().setModel(tablemodel);
				//appointmentgui.getTablemodel().equals((DefaultTableModel)appointmentgui.getAppointmentTable().getModel());
				



				for (int i = 0; i < appointmentgui.getAppointmentTable().getColumnCount(); i++) {
					TableColumn column1 = appointmentgui.getAppointmentTable()
							.getTableHeader().getColumnModel().getColumn(i);

					for (Employee_Model em : employees) {
						System.out.println(em.getEmp_firstname()
								+ em.getEmp_surname());
						// column1.setHeaderValue(employees.get(i).getEmp_firstname()
						// + " " + employees.get(i).getEmp_surname());
					}
					column1.setHeaderValue(employees.get(i).getEmp_firstname()
							+ " " + employees.get(i).getEmp_surname());
					


				}

				for (int j = 0; j < (appointmentgui.getColumnModel()
						.getColumnCount()); j++) {
					appointmentgui.getColumnModel().getColumn(j)
							.setPreferredWidth(150);
				}

				appointmentgui.getAppointmentTable().getTableHeader()
						.setDefaultRenderer(new Header_Render());
				
				
				
				appointmentgui.setVisible(true);

			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

			}

		}

	}

}
