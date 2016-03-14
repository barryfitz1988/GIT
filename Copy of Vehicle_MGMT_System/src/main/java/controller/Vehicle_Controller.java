package controller;


import gui.BlankTable_Frame;
import gui.CustomerTable;
import gui.Main_Menu_GUI;
import gui.VehicleTable;
import gui.Vehicle_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputListener;

import service.Customer_Service;
import service.Vehicle_Service;
import model.Customer_Model;
import model.Customers_Vehicle_Model;
import model.Parts_Model;
import model.Vehicle_Model;


public class Vehicle_Controller {
	

	private Main_Menu_GUI maingui = new Main_Menu_GUI();
	private Vehicle_GUI vehiclegui = new Vehicle_GUI();
	private Vehicle_Model vehiclemodel = new Vehicle_Model();
	private Customer_Model customermodel = new Customer_Model();
	private Vehicle_Service vehicleservice = new Vehicle_Service();
	private Customer_Service customerservice = new Customer_Service();
	private Customers_Vehicle_Model owners_car = new Customers_Vehicle_Model();
	private ArrayList<Vehicle_Model> vehicles = new ArrayList<Vehicle_Model>();
	private ArrayList<Customer_Model> customers = new ArrayList<Customer_Model>();
	private ArrayList<Customers_Vehicle_Model> owners_carList   = new ArrayList<Customers_Vehicle_Model>();
	private VehicleTable vehicletable;
	private CustomerTable customertable;
	private BlankTable_Frame blanktable = new BlankTable_Frame();

	
    public Vehicle_Controller(Main_Menu_GUI maingui, Vehicle_GUI vehiclegui, Vehicle_Model vehiclemodel) {
    	        this.maingui = maingui;
    	        this.vehiclegui= vehiclegui;
    	        this.vehiclemodel = vehiclemodel;
    	         
    	        
    	        this.vehiclegui.exitListener(new exitListener());   
    	        this.maingui.addvehicleListener(new Listener());
    	        this.vehiclegui.tableSelecterListener(new rowSelectedListener());
    	        
    			this.vehiclegui.addNewVehicleListener(new addListener());
    			this.vehiclegui.editButtonListener(new editListener());
    			this.vehiclegui.deleteListener(new deleteListener());
    			this.vehiclegui.addCustomertoVehicle(new CustomerListener());
    			this.blanktable.tableSelecterListener(new customerSelectedListener());
    }
    
	
	class editListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				String reg = vehiclegui.getRegTextfield().getText();
				String make = vehiclegui.getMakeTextField().getText();
				String model = vehiclegui.getModelTextField().getText();
				String chassis = vehiclegui.getChassisTextfield().getText();
				double idextract = Double.parseDouble(vehiclegui.getIdTextField().getText());
				int id = (int) idextract;
				double customeridextract = Double.parseDouble(vehiclegui.getHidden_id_Customertextfield().getText());
				int customerid = (int) customeridextract;

				int rowSelected = (int) vehiclegui.getVehicleTable().getValueAt(vehiclegui.getVehicleTable().getSelectedRow(),0);
				int selectedOption = vehiclegui.getUpdateDetails()
						.showConfirmDialog(null,
								"Save Update to  Vehicle Information?",
								"Warning!",
								vehiclegui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == vehiclegui.getUpdateDetails().YES_OPTION) {
	
					
					for (Customers_Vehicle_Model c : owners_carList) {
					
						boolean found = false;
						System.out.println(owners_car.getOwner_id());
						if (c.getVehicle().getVehicle_id() == vehicleservice.findById(id).getVehicle_id()) {
							System.out.println("Sucess");
							vehicleservice.open();
							c.getVehicle().setVehicle_make(make);
							c.getVehicle().setVehicle_reg(reg);
							c.getVehicle().setVehicle_model(model);
							c.getVehicle().setVehicle_chassis(chassis);
							//c.setCustomer(customermodel);
							vehicleservice.updateOwner(c);
							vehicleservice.close();
							found = true;

							vehiclegui.getIdTextField().setText("");
							vehiclegui.getRegTextfield().setText("");
							vehiclegui.getMakeTextField().setText("");
							vehiclegui.getModelTextField().setText("");
							vehiclegui.getChassisTextfield().setText("");
							vehiclegui.getCustomerTextField().setText("");
							
					
						}
						

						else {
							System.out.println("Fail");
							found = false;

						
					}
						

					}
				}

			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

			}

		}

	}
    
    
    
    
	class rowSelectedListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {

			try {
				int rowSelected = (int) vehiclegui.getVehicleTable().getValueAt(vehiclegui.getVehicleTable().getSelectedRow(),0);

				for (Customers_Vehicle_Model c : owners_carList) {
					
		
					
					if (c.getVehicle().getVehicle_id() == rowSelected) {
					
					vehiclegui.getIdTextField().setText(
							Integer.toString(c.getVehicle().getVehicle_id()));
					vehiclegui.getRegTextfield().setText(
							(c.getVehicle().getVehicle_reg()));
					vehiclegui.getMakeTextField().setText(
							(c.getVehicle().getVehicle_make()));
					vehiclegui.getModelTextField().setText(
							(c.getVehicle().getVehicle_model()));
					vehiclegui.getChassisTextfield().setText(
							(c.getVehicle().getVehicle_chassis()));
					vehiclegui.getCustomerTextField().setText(c.getCustomer().getFirst_name()+" "
							+ c.getCustomer().getSurname());
				//vehiclegui.getHidden_id_Customertextfield().setText(Integer.toString
					//		(c.getCustomer().getCustomer_id()));
					
					}

				}

						
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}

		}

	} 
    
    class addListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {

				
				
				vehicleservice.open();
				String reg = vehiclegui.getRegTextfield().getText();
				String make = vehiclegui.getMakeTextField().getText();
				String model = vehiclegui.getModelTextField().getText();
				String chassis = vehiclegui.getChassisTextfield().getText();
				double idextract = Double.parseDouble(vehiclegui.getIdTextField().getText());
				int id = (int) idextract;
				
				

				vehiclemodel.setVehicle_id(id);
				vehiclemodel.setVehicle_reg(reg);
				vehiclemodel.setVehicle_make(make);
				vehiclemodel.setVehicle_model(model);
				vehiclemodel.setVehicle_chassis(chassis);;
				
				owners_car.setVehicle(vehiclemodel);
				
				vehicleservice.persist(vehiclemodel);
				vehicleservice.persistOwner(owners_car);
			
				
				
				vehicleservice.close();
				
				vehiclegui.getIdTextField().setText("");
				vehiclegui.getRegTextfield().setText("");
				vehiclegui.getMakeTextField().setText("");
				vehiclegui.getModelTextField().setText("");
				vehiclegui.getChassisTextfield().setText("");
				vehiclegui.getCustomerTextField().setText("");
				


			} catch (NumberFormatException nfe) {

				System.out.println("ERROR CANNOT BE DONE: " + nfe.getMessage());

			}

		}

	}
    
    
    
    
	class customerSelectedListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
		
			try {
				int rowSelected = (int) blanktable.getBlankTable().getValueAt(blanktable.getBlankTable().getSelectedRow(),0);
			
			
				for (Customer_Model c : customers) {

					if (c.getCustomer_id() == rowSelected) {
						
						vehiclegui.getCustomerTextField().setText(
								(c.getFirst_name()+" "+ c.getSurname()));
						vehiclegui.getHidden_id_Customertextfield().setText(Integer.toString
								(c.getCustomer_id()));
						owners_car.setCustomer(c);
					}
				
				}
				
				customers.clear();
				blanktable.dispose();

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}

		}

	}
    
    
    class CustomerListener implements MouseInputListener {


		

		@Override
		public void mouseClicked(MouseEvent arg0) {
			try {	 
				
				
  				blanktable.setVisible(true);
  				customertable = new CustomerTable(customers);
  				blanktable.getBlankTable().setModel(customertable);
  				
  				List<Customer_Model> c = customerservice.findAll();

  				for (int x = 0; x < c.size(); x++) {
  					customermodel = (Customer_Model) c.get(x);
  					customers.add(customermodel);

  				}
  			

			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

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

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}



	}
    
    
    
	class deleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				double idextract = Double.parseDouble(vehiclegui
						.getIdTextField().getText());
				int id = (int) idextract;

				int selectedOption = vehiclegui.getUpdateDetails()
						.showConfirmDialog(null, "Delete Vehicle?",
								"Warning!",
								vehiclegui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == vehiclegui.getUpdateDetails().YES_OPTION) {

					vehicleservice.open();
					vehicleservice.delete(id);
					//vehicleservice.deleteOwner(id);
					vehicleservice.close();

					vehiclegui.getIdTextField().setText("");
					vehiclegui.getRegTextfield().setText("");
					vehiclegui.getMakeTextField().setText("");
					vehiclegui.getModelTextField().setText("");
					vehiclegui.getChassisTextfield().setText("");
					vehiclegui.getCustomerTextField().setText("");
					
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
				owners_carList.clear();
				vehiclegui.dispose();
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
    			vehiclegui.setVisible(true);
    			vehicletable = new VehicleTable(owners_carList);
   				vehiclegui.getVehicleTable().setModel(vehicletable);
   				
 
   				List<Customers_Vehicle_Model> cuscar = vehicleservice.findAllOwners();
   				
   				for (int x = 0; x < cuscar.size(); x++) {
   					owners_car = (Customers_Vehicle_Model) cuscar.get(x);
   					owners_carList.add(owners_car);
   					
   				}

    		 } catch (NumberFormatException nfe) {
  			   
                 System.out.println("Not A Number: " + nfe.getMessage());
       
              }
    	
    	
    }
    	
}	
	
	

}
