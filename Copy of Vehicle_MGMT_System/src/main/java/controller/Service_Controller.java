package controller;


import gui.Main_Menu_GUI;

import gui.ServiceTable;
import gui.Service_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.ArrayList;


import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import service.Service_Service;

import model.Service_Model;

public class Service_Controller {
	

	private Main_Menu_GUI maingui = new Main_Menu_GUI();
	private Service_GUI servicegui = new Service_GUI();
	private Service_Model servicemodel = new Service_Model();
	private Service_Service serviceservice = new Service_Service();
	private ServiceTable servicetable;
	private ArrayList<Service_Model> service = new ArrayList<Service_Model>();
	
	
    public Service_Controller(Main_Menu_GUI maingui, Service_GUI servicegui, Service_Model servicemodel) {
    	        this.maingui = maingui;
    	        this.servicegui= servicegui;
    	        this.servicemodel = servicemodel;
    	         

    	    this.servicegui.exitListener(new exitListener());    
    		this.maingui.addServiceListener(new Listener());
   			this.servicegui.tableSelecterListener(new rowSelectedListener());
   			this.servicegui.addNewServiceListener(new addListener());
   			this.servicegui.editButtonListener(new editListener());
   			this.servicegui.deleteListener(new deleteListener());
   
    
    
    }
    
	class deleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				double idextract = Double.parseDouble(servicegui
						.getIdTextField().getText());
				int id = (int) idextract;

				int selectedOption = servicegui.getUpdateDetails()
						.showConfirmDialog(null, "Delete Parts?",
								"Warning!",
								servicegui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == servicegui.getUpdateDetails().YES_OPTION) {

					serviceservice.open();
					serviceservice.delete(id);
					serviceservice.close();

					servicegui.getIdTextField().setText("");
					servicegui.getNameTextfield().setText("");
					servicegui.getPriceTextField().setText("");
					servicegui.getTimeTextField().setText("");
					
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

				String name = servicegui.getNameTextfield().getText();
				double timeextract = Double.parseDouble(servicegui.getTimeTextField().getText());
				int time = (int) timeextract;
				double idextract = Double.parseDouble(servicegui.getIdTextField().getText());
				int id = (int) idextract;
				double price = Double.parseDouble(servicegui.getPriceTextField().getText());

				int selectedOption = servicegui.getUpdateDetails()
						.showConfirmDialog(null, "Update Service Information?",
								"Warning!",
								servicegui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == servicegui.getUpdateDetails().YES_OPTION) {

					for (Service_Model c : service) {

						boolean found = false;
						if (c.getJob_id() == serviceservice.findById(id)
								.getJob_id()) {
							System.out.println("Sucess");
							serviceservice.open();
							c.setJob_id(id);
							c.setJob_name(name);
							c.setJob_price(price);
							c.setJob_time(time);;
							
							serviceservice.update(c);
							serviceservice.close();
							found = true;

							servicegui.getIdTextField().setText("");
							servicegui.getNameTextfield().setText("");
							servicegui.getPriceTextField().setText("");
							servicegui.getTimeTextField().setText("");
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
    
    
    
    
	class addListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {

				serviceservice.open();
				String name = servicegui.getNameTextfield().getText();
				double timeextract = Double.parseDouble(servicegui.getTimeTextField().getText());
				int time = (int) timeextract;
				double idextract = Double.parseDouble(servicegui.getIdTextField().getText());
				int id = (int) idextract;
				double price = Double.parseDouble(servicegui.getPriceTextField().getText());
				

				servicemodel.setJob_id(id);
				servicemodel.setJob_name(name);
				servicemodel.setJob_price(price);
				servicemodel.setJob_time(time);
				
				

				serviceservice.persist(servicemodel);
				serviceservice.close();
				
				servicegui.getIdTextField().setText("");
				servicegui.getNameTextfield().setText("");
				servicegui.getPriceTextField().setText("");
				servicegui.getTimeTextField().setText("");
				


			} catch (NumberFormatException nfe) {

				System.out.println("ERROR CANNOT BE DONE: " + nfe.getMessage());

			}

		}

	}
    
    
    
	class rowSelectedListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {

			try {
				int rowSelected = (int) servicegui.getServiceTable().getValueAt(servicegui.getServiceTable().getSelectedRow(),0);

				for (Service_Model c : service) {

					if (c.getJob_id() == rowSelected) {

						servicegui.getIdTextField().setText(
								Integer.toString(c.getJob_id()));
						servicegui.getNameTextfield().setText(
								c.getJob_name());
						servicegui.getTimeTextField().setText(
								Integer.toString(c.getJob_time()));
						servicegui.getPriceTextField().setText(
								Double.toString(c.getJob_price()));
		

					}
				}

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}

		}

	}
    
    
    
    
	class exitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				service.clear();
				servicegui.dispose();
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
    			 
    			 
    			 servicegui.setVisible(true);
    			 
   				servicetable = new ServiceTable(service);
   				servicegui.getServiceTable().setModel(servicetable);

   				List<Service_Model> c = serviceservice.findAll();

   				for (int x = 0; x < c.size(); x++) {
   					servicemodel = (Service_Model) c.get(x);
   					service.add(servicemodel);

   				}	 
     			
    		 } catch (NumberFormatException nfe) {
  			   
                 System.out.println("Not A Number: " + nfe.getMessage());
       
              }
    	
    	
    }
    	
}
}