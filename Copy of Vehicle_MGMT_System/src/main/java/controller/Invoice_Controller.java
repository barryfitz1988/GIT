package controller;
/*
 *for(Invoice i: InvoiceArray)
 *		ArrayList<Item> items = new ArrayList<Item>();
 * 		for(Item item : ItemArray)
 * 				if(item.invoiceId == i.id)
 * 					items.add(item);
 * 		i.setItems(items)
 * 
 * 
 * */
import gui.CustomerTable;
import gui.InvoiceTable;
import gui.Invoice_GUI;
import gui.Main_Menu_GUI;
import gui.Templates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;





import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import service.Invoice_Service;
import service.Service_Service;
import utility.InvoiceTemplate;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import model.Customer_Model;
import model.Invoice_Model;
import model.Items_Model;
import model.Service_Model;

public class Invoice_Controller {
	


	private Main_Menu_GUI maingui = new Main_Menu_GUI();
	private Invoice_GUI invoicegui = new Invoice_GUI();
	
	private Service_Service serviceservice = new Service_Service();
	private ArrayList<Service_Model>  services = new ArrayList<Service_Model>(); 
	private Service_Model servicemodel = new Service_Model();
	
	private Invoice_Model invoicemodel = new Invoice_Model();
	private Items_Model itemsmodel = new Items_Model();
	private ArrayList<Items_Model> items = new ArrayList<Items_Model>();
	private Invoice_Service invoiceservice = new Invoice_Service();
	private ArrayList<Invoice_Model>  invoices = new ArrayList<Invoice_Model>(); 
	private InvoiceTable invoicetable;
	
	
    public Invoice_Controller(Main_Menu_GUI maingui, Invoice_GUI invoicegui, Invoice_Model invoicemodel) {
    	        this.maingui = maingui;
    	        this.invoicegui= invoicegui;
    	        this.invoicemodel = invoicemodel;
    	         
    	       this.invoicegui.tableSelecterListener(new rowSelectedListener());
    	       this.invoicegui.printListener(new printListener());
    	       this.invoicegui.exitListener(new exitListener());    
    		   this.maingui.addInvoiceListener(new Listener());
    		    
    
    
    }
    
    
	class rowSelectedListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {

			try {

				double price = 0;
				int rowSelected = (int) invoicegui.getInvoiceTable().getValueAt(invoicegui.getInvoiceTable().getSelectedRow(),0);
				

				
				
				for (Invoice_Model c : invoices) {
	
					ArrayList<Items_Model> newItems = new ArrayList<Items_Model>();

					for(Service_Model s: services){
						if(s.getJob_name().equals(c.getService())){
							price = s.getJob_price();
							
						}
					}
					
					
					itemsmodel = new Items_Model(c.getService(),1,
							price,c.getId());
					
					
					if (c.getId() == rowSelected) {

						for(Items_Model i : items){
							if(i.getInvoice_id()== c.getId()){
								newItems.add(i);
							}
							
							
						invoicemodel.setCustomername(c.getCustomername());
						
						invoicemodel.setDate(c.getDate());
						invoicemodel.setPrice(c.getPrice());
						invoicemodel.setVehiclereg(c.getVehiclereg());
						invoicemodel.setItems(newItems);
						
						}
						
					}
					
					
				}
				items.add(itemsmodel);

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}

		}
    
	}
    
    
    
    class printListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			

			
			try {
				InvoiceTemplate newTempelate = new InvoiceTemplate(invoicemodel);
			} catch (DRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
		}
    	
    	
    	
    }
    
    
	class exitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				services.clear();
				items.clear();
				invoices.clear();
				invoicegui.dispose();
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
 			
 				
 				invoicetable = new InvoiceTable(invoices);
 				invoicegui.getInvoiceTable().setModel(invoicetable);
 				
 				
 				List<Service_Model> ser  = serviceservice.findAll();

 				for (int x = 0; x < ser.size(); x++) {
 					servicemodel = (Service_Model) ser.get(x);
 					services.add(servicemodel);

 				}
 				
 				
 				
 				List<Items_Model> finditems  = invoiceservice.findAllItems();

 				for (int x = 0; x < finditems.size(); x++) {
 					itemsmodel = (Items_Model) finditems.get(x);
 					items.add(itemsmodel);

 				}
 				
 		
 				List<Invoice_Model> inv = invoiceservice.findAll();

 				for (int x = 0; x < inv.size(); x++) {
 					invoicemodel = (Invoice_Model) inv.get(x);
 					invoices.add(invoicemodel);

 				}
    			 
    			 invoicegui.setVisible(true);
    			 
    		 
    		 } catch (NumberFormatException nfe) {
  			   
                 System.out.println("Not A Number: " + nfe.getMessage());
       
              }
    	
    	
    }
    	
}

}
