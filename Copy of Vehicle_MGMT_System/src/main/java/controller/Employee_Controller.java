package controller;


import gui.EmployeeTable;
import gui.Employee_GUI;
import gui.Main_Menu_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;











import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import service.Employee_Service;
import model.Customer_Model;
import model.Employee_Model;




public class Employee_Controller {
	
	private Main_Menu_GUI maingui = new Main_Menu_GUI();
	private Employee_GUI employeegui = new Employee_GUI();
	private Employee_Model employeemodel = new Employee_Model();
	private Employee_Service employeeservice = new Employee_Service();
	private EmployeeTable employeetable;
	private ArrayList<Employee_Model> employees = new ArrayList<Employee_Model>();
	
    public Employee_Controller(Main_Menu_GUI maingui, Employee_GUI employeegui, Employee_Model employeemodel) {
    	        this.maingui = maingui;
    	        this.employeegui= employeegui;
    	        this.employeemodel = employeemodel;
    	         

    	        this.employeegui.exitListener(new exitListener());    
    	        this.maingui.addEmployeeListener(new Listener());
    			this.employeegui.tableSelecterListener(new rowSelectedListener());
    			this.employeegui.addNewEmployeeListener(new addListener());
    			this.employeegui.editButtonListener(new editListener());
    			this.employeegui.deleteListener(new deleteListener());
    			
    
    
    }
	class rowSelectedListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {

			try {
				int rowSelected = (int) employeegui.getEmployeeTable().getValueAt(employeegui.getEmployeeTable().getSelectedRow(),0);

				for (Employee_Model c : employees) {

					if (c.getEmployee_id() == rowSelected) {

						employeegui.getIdTextField().setText(
								Integer.toString(c.getEmployee_id()));
						employeegui.getNameTextfield().setText(
								c.getEmp_firstname());
						employeegui.getSurnameTextField().setText(
								c.getEmp_surname());
						employeegui.getPhoneTextField().setText(
								Integer.toString(c.getEmp_phone_number()));
						employeegui.getTypeTextField().setText(
								c.getEmp_type());

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

				double idextract = Double.parseDouble(employeegui
						.getIdTextField().getText());
				int id = (int) idextract;

				int selectedOption = employeegui.getUpdateDetails()
						.showConfirmDialog(null, "Delete Employee?",
								"Warning!",
								employeegui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == employeegui.getUpdateDetails().YES_OPTION) {

					employeeservice.open();
					employeeservice.delete(id);
					employeeservice.close();

					employeegui.getIdTextField().setText("");
					employeegui.getNameTextfield().setText("");
					employeegui.getSurnameTextField().setText("");
					employeegui.getPhoneTextField().setText("");
					employeegui.getTypeTextField().setText("");
					
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

				String firstname = employeegui.getNameTextfield().getText();
				String surname = employeegui.getSurnameTextField().getText();
				String type = employeegui.getTypeTextField().getText();
				double idextract = Double.parseDouble(employeegui.getIdTextField().getText());
				int id = (int) idextract;
				double phoneextract = Double.parseDouble(employeegui.getPhoneTextField().getText());
				int phone = (int) phoneextract;

				int selectedOption = employeegui.getUpdateDetails()
						.showConfirmDialog(null, "Update Employee Information?",
								"Warning!",
								employeegui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == employeegui.getUpdateDetails().YES_OPTION) {

					for (Employee_Model c : employees) {

						boolean found = false;
						if (c.getEmployee_id() == employeeservice.findById(id)
								.getEmployee_id()) {
							System.out.println("Sucess");
							employeeservice.open();
							c.setEmp_firstname(firstname);
							c.setEmp_surname(surname);
							c.setEmp_phone_number(phone);
							c.setEmp_type(type);
							
							employeeservice.update(c);
							employeeservice.close();
							found = true;

							employeegui.getIdTextField().setText("");
							employeegui.getNameTextfield().setText("");
							employeegui.getSurnameTextField().setText("");
							employeegui.getPhoneTextField().setText("");
							employeegui.getTypeTextField().setText("");
						}

						else {

							found = false;
						}

					}

					employeegui.getIdTextField().setText("");
					employeegui.getNameTextfield().setText("");
					employeegui.getSurnameTextField().setText("");
					employeegui.getPhoneTextField().setText("");
					employeegui.getTypeTextField().setText("");
					
				}

			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

			}

		}

	}
	
	
	class addListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {

				employeeservice.open();
				String firstname = employeegui.getNameTextfield().getText();
				String surname = employeegui.getSurnameTextField().getText();
				String type = employeegui.getTypeTextField().getText();
				double idextract = Double.parseDouble(employeegui.getIdTextField().getText());
				int id = (int) idextract;
				double phoneextract = Double.parseDouble(employeegui.getPhoneTextField().getText());
				int phone = (int) phoneextract;

				employeemodel.setEmployee_id(id);
				employeemodel.setEmp_firstname(firstname);
				employeemodel.setEmp_surname(surname);
				employeemodel.setEmp_phone_number(phone);
				employeemodel.setEmp_type(type);
				

				employeeservice.persist(employeemodel);
				employeeservice.close();
				
				employeegui.getIdTextField().setText("");
				employeegui.getNameTextfield().setText("");
				employeegui.getSurnameTextField().setText("");
				employeegui.getPhoneTextField().setText("");
				employeegui.getTypeTextField().setText("");


			} catch (NumberFormatException nfe) {

				System.out.println("ERROR CANNOT BE DONE: " + nfe.getMessage());

			}

		}

	}
	
	
    
	class exitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				employees.clear();
				employeegui.dispose();
				maingui.setVisible(true);

			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

			}

		}

	}
    
    
    
    class Listener implements ActionListener{
    	
    	
    	public void actionPerformed(ActionEvent e) {
   
    		
    		
    		 try {

    		
    			
    			 maingui.dispose();
 				employeetable = new EmployeeTable(employees);
 				employeegui.getEmployeeTable().setModel(employeetable);

 				List<Employee_Model> c = employeeservice.findAll();

 				for (int x = 0; x < c.size(); x++) {
 					employeemodel = (Employee_Model) c.get(x);
 					employees.add(employeemodel);

 				}
    			 
    			 employeegui.setVisible(true);
    			 
    		 
    		 } catch (NumberFormatException nfe) {
  			   
                 System.out.println("Not A Number: " + nfe.getMessage());
       
              }
    	
    	
    }
    	
}
	

}
