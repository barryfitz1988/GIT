package controller;



import gui.Main_Menu_GUI;
import gui.PartsTable;
import gui.Parts_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import service.Parts_Service;
import model.Parts_Model;





public class Parts_Controller{
	

	private Main_Menu_GUI maingui = new Main_Menu_GUI();
	private Parts_GUI partsgui = new Parts_GUI();
	private Parts_Model partsmodel = new Parts_Model();
	private Parts_Service partsservice = new Parts_Service();
	private PartsTable partstable;
	private ArrayList<Parts_Model> parts = new ArrayList<Parts_Model>();
	
	
    public Parts_Controller(Main_Menu_GUI maingui, Parts_GUI partsgui, Parts_Model partsmodel) {
    	        this.maingui = maingui;
    	        this.partsgui= partsgui;
    	        this.partsmodel = partsmodel;
    	         
    	        this.partsgui.exitListener(new exitListener());
    			this.partsgui.tableSelecterListener(new rowSelectedListener());
    			this.partsgui.addNewPartsListener(new addListener());
    			this.partsgui.editButtonListener(new editListener());
    			this.partsgui.deleteListener(new deleteListener());
    	        this.maingui.addpartsListener(new Listener());
    		    
    
    
    }
    
	class deleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				double idextract = Double.parseDouble(partsgui
						.getIdTextField().getText());
				int id = (int) idextract;

				int selectedOption = partsgui.getUpdateDetails()
						.showConfirmDialog(null, "Delete Parts?",
								"Warning!",
								partsgui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == partsgui.getUpdateDetails().YES_OPTION) {

					partsservice.open();
					partsservice.delete(id);
					partsservice.close();

					partsgui.getIdTextField().setText("");
					partsgui.getNameTextfield().setText("");
					partsgui.getPriceTextField().setText("");
					partsgui.getdescriptionTextField().setText("");
					
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

				String name = partsgui.getNameTextfield().getText();
				String descritption = partsgui.getdescriptionTextField().getText();
				double idextract = Double.parseDouble(partsgui.getIdTextField().getText());
				int id = (int) idextract;
				double price = Double.parseDouble(partsgui.getPriceTextField().getText());

				int selectedOption = partsgui.getUpdateDetails()
						.showConfirmDialog(null, "Update Part Information?",
								"Warning!",
								partsgui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == partsgui.getUpdateDetails().YES_OPTION) {

					for (Parts_Model c : parts) {

						boolean found = false;
						if (c.getPart_id() == partsservice.findById(id)
								.getPart_id()) {
							System.out.println("Sucess");
							partsservice.open();
							c.setPart_id(id);
							c.setPart_name(name);
							c.setPart_description(descritption);
							c.setPart_price(price);
							
							partsservice.update(c);
							partsservice.close();
							found = true;

							partsgui.getIdTextField().setText("");
							partsgui.getNameTextfield().setText("");
							partsgui.getPriceTextField().setText("");
							partsgui.getdescriptionTextField().setText("");
						}

						else {

							found = false;
						}

					}

					partsgui.getIdTextField().setText("");
					partsgui.getNameTextfield().setText("");
					partsgui.getPriceTextField().setText("");
					partsgui.getdescriptionTextField().setText("");
					
				}

			} catch (NumberFormatException nfe) {

				System.out.println("Not A Number: " + nfe.getMessage());

			}

		}

	}
    
    
	class addListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {

				partsservice.open();
				String name = partsgui.getNameTextfield().getText();
				String descritption = partsgui.getdescriptionTextField().getText();
				double idextract = Double.parseDouble(partsgui.getIdTextField().getText());
				int id = (int) idextract;
				double price = Double.parseDouble(partsgui.getPriceTextField().getText());
				

				partsmodel.setPart_id(id);
				partsmodel.setPart_name(name);
				partsmodel.setPart_description(descritption);
				partsmodel.setPart_price(price);
				
				

				partsservice.persist(partsmodel);
				partsservice.close();
				
				partsgui.getIdTextField().setText("");
				partsgui.getNameTextfield().setText("");
				partsgui.getPriceTextField().setText("");
				partsgui.getdescriptionTextField().setText("");
				


			} catch (NumberFormatException nfe) {

				System.out.println("ERROR CANNOT BE DONE: " + nfe.getMessage());

			}

		}

	}
    
    
    
	class rowSelectedListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {

			try {
				int rowSelected = (int) partsgui.getPartsTable().getValueAt(partsgui.getPartsTable().getSelectedRow(),0);

				for (Parts_Model c : parts) {

					if (c.getPart_id() == rowSelected) {

						partsgui.getIdTextField().setText(
								Integer.toString(c.getPart_id()));
						partsgui.getNameTextfield().setText(
								c.getPart_name());
						partsgui.getdescriptionTextField().setText(
								c.getPart_description());
						partsgui.getPriceTextField().setText(
								Double.toString(c.getPart_price()));
		

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
				
				parts.clear();
				partsgui.dispose();
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
    			 
  				partsgui.setVisible(true);
  				partstable = new PartsTable(parts);
  				partsgui.getPartsTable().setModel(partstable);

  				List<Parts_Model> c = partsservice.findAll();

  				for (int x = 0; x < c.size(); x++) {
  					partsmodel = (Parts_Model) c.get(x);
  					parts.add(partsmodel);

  				}	 
    			
    			 
    		 
    		 } catch (NumberFormatException nfe) {
  			   
                 System.out.println("Not A Number: " + nfe.getMessage());
       
              }
    	
    	
    }
    	
}
}