package controller;

import gui.CustomerTable;
import gui.Customer_GUI;
import gui.Main_Menu_GUI;
import gui.SalesTable;
import gui.Sales_GUI;

import java.awt.AlphaComposite;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputListener;

import service.Sales_Service;
import model.Customer_Model;
import model.Sales_Model;



public class Sales_Controller {
	
	
	
	private Main_Menu_GUI maingui = new Main_Menu_GUI();
	private Sales_GUI salesgui = new Sales_GUI();
	private Sales_Model salesmodel = new Sales_Model();
	private Sales_Service salesservice = new Sales_Service();
	private ArrayList<Sales_Model> sales = new ArrayList<Sales_Model>();
	private SalesTable salestable;
	
	private static final int IMG_WIDTH = 100;
	private static final int IMG_HEIGHT = 100;

	public Sales_Controller(Main_Menu_GUI maingui, Sales_GUI salesgui,
			Sales_Model salesmodel) {
		this.maingui = maingui;
		this.salesgui = salesgui;
		this.salesmodel = salesmodel;

		this.salesgui.tableSelecterListener(new rowSelectedListener());
		this.salesgui.exitListener(new exitListener());
		this.salesgui.addNewSalesListener(new addListener());
		this.salesgui.editButtonListener(new editListener());
		this.salesgui.deleteListener(new deleteListener());
		this.maingui.addSalesListener(new Listener());
		this.salesgui.SearchforImage(new ImageSearchListener());

	}
	
	
	
	
	class editListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				
				String make = salesgui.getDetailmakeTextField().getText();
				String model = salesgui.getDetailmodeltextfield().getText();
				String description = salesgui.getDetaildescriptiontextfield().getText();
				double price = Double.parseDouble(salesgui.getPriceInfotextField().getText());
				double idextract = Double.parseDouble(salesgui.getDetailidtextfield().getText());
				int id = (int) idextract;

				int selectedOption = salesgui.getUpdateDetails()
						.showConfirmDialog(null,
								"Save Update to  Sales Information?",
								"Warning!",
								salesgui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == salesgui.getUpdateDetails().YES_OPTION) {

					for (Sales_Model c : sales) {

						// System.out.println("SIZE!!!" +customers.size());
						//System.out.println(c.getCustomer_id());

						boolean found = false;
						if (c.getId() == salesservice.findById(id)
								.getId()) {
							System.out.println("Sucess");
							salesservice.open();
							
							c.setMake(make);
							c.setModel(model);
							c.setDescription(description);
							c.setPrice(price);
							
							salesservice.update(c);
							salesservice.close();
							found = true;

							salesgui.getDetailidtextfield().setText("");
							salesgui.getDetailregtextfield().setText("");
							salesgui.getDetailmakeTextField().setText("");
							salesgui.getDetailmodeltextfield().setText("");
							salesgui.getDetaildescriptiontextfield().setText("");
							salesgui.getPriceInfotextField().setText("");
						
							//salesgui.getLblDBImageLbl().setText("");
							salesgui.getLblDBImageLbl().setIcon(null);
							//refreshTable();
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
	
	
	
	
	
	class deleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				double idextract = Double.parseDouble(salesgui.getDetailidtextfield().getText());
				int id = (int) idextract;

				int selectedOption = salesgui.getUpdateDetails()
						.showConfirmDialog(null, "Delete Sales Car?",
								"Warning!",
								salesgui.getUpdateDetails().YES_NO_OPTION);
				if (selectedOption == salesgui.getUpdateDetails().YES_OPTION) {

					salesservice.open();
					salesservice.delete(id);
					salesservice.close();
					//refreshTable();
					salesgui.getDetailidtextfield().setText("");
					salesgui.getDetailregtextfield().setText("");
					salesgui.getDetailmakeTextField().setText("");
					salesgui.getDetailmodeltextfield().setText("");
					salesgui.getDetaildescriptiontextfield().setText("");
					salesgui.getPriceInfotextField().setText("");
					salesgui.getLblDBImageLbl().setIcon(null);
			
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

				int rowSelected = (int) salesgui.getSalestable().getValueAt(salesgui.getSalestable().getSelectedRow(),0);
				//int rowSelected = (int) customergui.getCustomertable().getValueAt(customergui.getCustomertable().getSelectedRow(),0);
				
				for (Sales_Model c : sales) {

					if (c.getId() == rowSelected) {

						ImageIcon i = new ImageIcon(c.getImage());
				       
			
						
						salesgui.getDetailidtextfield().setText(Integer.toString(c.getId()));
						salesgui.getDetailregtextfield().setText(c.getReg());
						salesgui.getDetailmakeTextField().setText(c.getMake());
						salesgui.getDetailmodeltextfield().setText(c.getModel());
						salesgui.getDetaildescriptiontextfield().setText(c.getDescription());
						salesgui.getPriceInfotextField().setText(Double.toString(c.getPrice()));
						salesgui.getLblDBImageLbl().setIcon(i);
						

					}
				}

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}

		}

	}
	
	
	public static BufferedImage resizeImage(Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
        return bufferedImage;
    }
	
	
	
	class addListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {

				salesservice.open();
				String reg = salesgui.getRegTextfield().getText();
				String make = salesgui.getMaketextField().getText();
				String model = salesgui.getModeltextField().getText();
				String description = salesgui.getDescriptionTextfield().getText();
				double price = Double.parseDouble(salesgui.getPriceTextfield().getText());
				double idextract = Double.parseDouble(salesgui.getIDtextField().getText());
				int id = (int) idextract;

				//save image into database
		    	File file = new File(salesgui.getImageTextField().getText());
		        byte[] bFile = new byte[(int) file.length()];

		        
		        try {
		   	     FileInputStream fileInputStream = new FileInputStream(file);
		   	     //convert file into array of bytes
		   	     fileInputStream.read(bFile);
		   	     fileInputStream.close();
		           } catch (Exception f) {
		   	     f.printStackTrace();
		           }
		        
		        
		
		        
				salesmodel.setId(id);
				salesmodel.setMake(make);
				salesmodel.setModel(model);
				salesmodel.setDescription(description);
				salesmodel.setPrice(price);
				salesmodel.setReg(reg);
				salesmodel.setImage(bFile);
				//customers.add(customers.size(),customermodel);
				salesservice.persist(salesmodel);
				salesservice.close();
				
				salesgui.getIDtextField().setText("");
				salesgui.getRegTextfield().setText("");
				salesgui.getMaketextField().setText("");
				salesgui.getModeltextField().setText("");
				salesgui.getDescriptionTextfield().setText("");
				salesgui.getPriceTextfield().setText("");
				salesgui.getImageTextField().setText("Please click to select Image");

			} catch (NumberFormatException nfe) {

				System.out.println("ERROR CANNOT BE DONE: " + nfe.getMessage());

			}

		}

	}
	
	
	class ImageSearchListener implements MouseListener {

		   JFileChooser chooser;
		   String choosertitle;

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			
			    int result;
			        
			    chooser = new JFileChooser(); 
			    chooser.setCurrentDirectory(new java.io.File("C:\\Users\\Barry\\Documents\\College Work 2016\\Final Project Pictures"));
			    chooser.setDialogTitle(choosertitle);
			    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			    //
			    // disable the "All files" option.
			    //
			    chooser.setAcceptAllFileFilterUsed(false);
			    //    
			    if (chooser.showOpenDialog(salesgui) == JFileChooser.APPROVE_OPTION) { 
			      System.out.println("getCurrentDirectory(): " 
			         +  chooser.getCurrentDirectory());
			      System.out.println("getSelectedFile() : " 
			         +  chooser.getSelectedFile());
			      
			      salesgui.getImageTextField().setText(chooser.getSelectedFile().toString());
			      
			      }
			    else {
			    salesgui.getImageTextField().setText("No Selection ");
			      System.out.println("No Selection ");
			      }
			     }
			   
			  public Dimension getPreferredSize(){
			    return new Dimension(200, 200);
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
				
				salesgui.getIDtextField().setText("");
				salesgui.getRegTextfield().setText("");
				salesgui.getMaketextField().setText("");
				salesgui.getModeltextField().setText("");
				salesgui.getDescriptionTextfield().setText("");
				salesgui.getPriceTextfield().setText("");
				salesgui.getDetailidtextfield().setText("");
				salesgui.getDetailregtextfield().setText("");
				salesgui.getDetailmakeTextField().setText("");
				salesgui.getDetailmodeltextfield().setText("");
				salesgui.getDetaildescriptiontextfield().setText("");
				salesgui.getPriceInfotextField().setText("");
				salesgui.getLblDBImageLbl().setIcon(null);
				salesgui.getImageTextField().setText("Please click to select Image");
				
				sales.clear();
				salesgui.dispose();
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
    			
    			salesgui.setVisible(true);
 				salestable = new SalesTable(sales);
 				salesgui.getSalestable().setModel(salestable);
 		
 				List<Sales_Model> c = salesservice.findAll();

 				for (int x = 0; x < c.size(); x++) {
 					salesmodel = (Sales_Model) c.get(x);
 					sales.add(salesmodel);

 				}
    			 
    			 
    			 
    		
    			 
 
    					
    			 
    		 
    		 } catch (NumberFormatException nfe) {
  			   
                 System.out.println("Not A Number: " + nfe.getMessage());
       
              }
    	
    	
    }
    	
}
	

}
