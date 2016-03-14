package controller;

import gui.CustomerTable;
import gui.Invoice_GUI;
import gui.Main_Menu_GUI;
import gui.Templates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;





import java.util.ArrayList;
import java.util.List;

import service.Invoice_Service;
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

public class Invoice_Controller {
	
	public Templates templates = new Templates();

	private Main_Menu_GUI maingui = new Main_Menu_GUI();
	private Invoice_GUI invoicegui = new Invoice_GUI();
	private Invoice_Model invoicemodel = new Invoice_Model();
	private Invoice_Service invoiceservice = new Invoice_Service();
	private ArrayList<Invoice_Model>  invoices = new ArrayList<Invoice_Model>(); 
	
	
	
    public Invoice_Controller(Main_Menu_GUI maingui, Invoice_GUI invoicegui, Invoice_Model invoicemodel) {
    	        this.maingui = maingui;
    	        this.invoicegui= invoicegui;
    	        this.invoicemodel = invoicemodel;
    	         
    	        
    	       this.invoicegui.printListener(new printListener());
    	       this.invoicegui.exitListener(new exitListener());    
    		   this.maingui.addInvoiceListener(new Listener());
    		    
    
    
    }
    
    
    class printListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			/*  
			   private AggregationSubtotalBuilder<BigDecimal> totalSum;

			   public JasperReportBuilder build() throws DRException {
	
			      JasperReportBuilder report = report();
	
			 
	
			      //init styles
	
			      StyleBuilder columnStyle = stl.style(Templates.columnStyle)
	
			         .setBorder(stl.pen1Point());
		
			      StyleBuilder subtotalStyle = stl.style(columnStyle)
		
			         .bold();
		
			      StyleBuilder shippingStyle = stl.style(Templates.boldStyle)
		
			         .setHorizontalAlignment(HorizontalAlignment.RIGHT);
		
			 
		
			      //init columns
		
			      TextColumnBuilder<Integer> rowNumberColumn = col.reportRowNumberColumn()
		
			         .setFixedColumns(2)
		
			         .setHorizontalAlignment(HorizontalAlignment.CENTER);
		
			      TextColumnBuilder<String> descriptionColumn = col.column("Description", "description", type.stringType())
		
			         .setFixedWidth(250);
		
			      TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType())
		
			         .setHorizontalAlignment(HorizontalAlignment.CENTER);
		
			      TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit Price", "unitprice", Templates.currencyType);
		
			      TextColumnBuilder<String> taxColumn = col.column("Tax", exp.text("20%"))
		
			         .setFixedColumns(3);
		
			      //price = unitPrice * quantity
		
			      TextColumnBuilder<BigDecimal> priceColumn = unitPriceColumn.multiply(quantityColumn)
		
			         .setTitle("Price")
		
			         .setDataType(Templates.currencyType);
		
			      //vat = price * tax
		
			      TextColumnBuilder<Invoice_Model> vatColumn = s(invoicemodel.getPrice())
		
			         .setTitle("VAT")
		
			         .setDataType(Templates.currencyType);
		
			      //total = price + vat
		
			      TextColumnBuilder<BigDecimal> totalColumn = priceColumn.add(vatColumn)
		
			         .setTitle("Total Price")
		
			         .setDataType(Templates.currencyType)
		
			         .setRows(2)
		
			         .setStyle(subtotalStyle);
		
			      //init subtotals
		
			      totalSum = sbt.sum(totalColumn)
		
			         .setLabel("Total:")
		
			         .setLabelStyle(Templates.boldStyle);
		
			 
		
			      //configure report
		
			      report
		
			         .setTemplate(Templates.reportTemplate)
		
			         .setColumnStyle(columnStyle)
		
			         .setSubtotalStyle(subtotalStyle)
		
			         //columns
		
			         .columns(
		
			            rowNumberColumn, descriptionColumn, quantityColumn, unitPriceColumn, totalColumn, priceColumn, taxColumn, vatColumn)
		
			         .columnGrid(
		
			            rowNumberColumn, descriptionColumn, quantityColumn, unitPriceColumn,
		
			            grid.horizontalColumnGridList()
		
			               .add(totalColumn).newRow()
		
			               .add(priceColumn, taxColumn, vatColumn))
		
			         //subtotals
		
			         .subtotalsAtSummary(
		
			            totalSum, sbt.sum(priceColumn), sbt.sum(vatColumn))
		
			         //band components
		
			         .title(
		
			            Templates.createTitleComponent("Invoice No.: " + data.getInvoice().getId()),
		
			            cmp.horizontalList().setStyle(stl.style(10)).setGap(50).add(
		
			               cmp.hListCell(createCustomerComponent("Bill To", data.getInvoice().getBillTo())).heightFixedOnTop(),
	
			               cmp.hListCell(createCustomerComponent("Ship To", data.getInvoice().getShipTo())).heightFixedOnTop()),
	
			            cmp.verticalGap(10))
		
			         .pageFooter(
		
			            Templates.footerComponent)
		
			         .summary(
		
			            cmp.text(data.getInvoice().getShipping()).setValueFormatter(Templates.createCurrencyValueFormatter("Shipping:")).setStyle(shippingStyle),
		
			            cmp.horizontalList(
		
			               cmp.text("Payment terms: 30 days").setStyle(Templates.bold12CenteredStyle),
		
			               cmp.text(new TotalPaymentExpression()).setStyle(Templates.bold12CenteredStyle)),
		
			            cmp.verticalGap(30),
	
			            cmp.text("Thank you for your business").setStyle(Templates.bold12CenteredStyle))
		
			         .setDataSource(data.createDataSource());
		
			 
		
			      return report;
		
			   }
		
			 
		
			   private ComponentBuilder<?, ?> createCustomerComponent(String label, Invoice_Model invoice) {
		
			      HorizontalListBuilder list = cmp.horizontalList().setBaseStyle(stl.style().setTopBorder(stl.pen1Point()).setLeftPadding(10));
		
			      addCustomerAttribute(list, "Name", customer.getName());
		
			      addCustomerAttribute(list, "Address", customer.getAddress());
		
			      addCustomerAttribute(list, "City", customer.getCity());
		
			      addCustomerAttribute(list, "Email", customer.getEmail());
		
			      return cmp.verticalList(
		
			                     cmp.text(label).setStyle(Templates.boldStyle),
		
			                     list);
		
			   }
		
			 
		
			   private void addCustomerAttribute(HorizontalListBuilder list, String label, String value) {
		
			      if (value != null) {
		
			         list.add(cmp.text(label + ":").setFixedColumns(8).setStyle(Templates.boldStyle), cmp.text(value)).newRow();
		
			      }
		
			   }
		
			 
		
			   private class TotalPaymentExpression extends AbstractSimpleExpression<String> {
		
			      private static final long serialVersionUID = 1L;
		
			 
		
			      @Override
		
			      public String evaluate(ReportParameters reportParameters) {
		
			         BigDecimal total = reportParameters.getValue(totalSum);
		
			         String  shipping = total.add(invoicemodel.getPrice());
		
			         return "Total payment: " + Templates.currencyType.valueToString(shipping, reportParameters.getLocale());
	
			      }
			
			
			
			
		*/
	
			
		}
    	
    	
    	
    }
    
    
	class exitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

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
 			
 				
 				//customertable = new CustomerTable(customers);
 				//customergui.getCustomertable().setModel(customertable);
 		
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
