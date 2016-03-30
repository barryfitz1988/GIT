package gui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Invoice_Model;


public class InvoiceTable extends DefaultTableModel {
	
	
	
private static final int NO_OF_COLS = 5;
	
	//These are the indices of the table columns
	private static final int INVOICE_ID_COL = 0;
	private static final int INVOICE_DATE_COL = 1;
	private static final int INVOICE_CUSTOMER_COL = 2;
	private static final int INVOICE_REG_COL = 3;
	private static final int INVOICE_PRICE_COL = 4;

	private ArrayList<Invoice_Model> invoices;
	
	//constructor
	public InvoiceTable(ArrayList<Invoice_Model> invoices)
	{
		super();
		this.invoices = invoices;
	}

	//this overriding the getColumnCount() method from superclass
	public int getColumnCount()
	{
		return NO_OF_COLS;
	}
	
	 @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	
	//this overriding the getColumnCount() method from superclass	
		public String getColumnName(int column)
		{
			if(column == INVOICE_ID_COL)
				
			{	
				return "Invoice ID";
			}
			else if(column == INVOICE_DATE_COL)
			{
				return "Date ";
			}
			else if(column == INVOICE_CUSTOMER_COL)
			{
				return "Customer";
			}
			else if(column == INVOICE_REG_COL)
			{
				return "Reg";
			}
			else if(column == INVOICE_PRICE_COL)
			{
				return "Price";
			}
			else
			{
				return "";
			}
		}
		
		//this overriding the getColumnCount() method from superclass	
		public int getRowCount()
		{
			if(this.invoices != null)
			{
				return this.invoices.size();
			}
			else
			{	
				return 0;
			}
		}
		
		public Object getValueAt(int row, int col)
		{
			Invoice_Model retrieveInvoice = this.invoices.get(row);
			if(col == INVOICE_ID_COL)
			{
				return retrieveInvoice.getId();
			}
			else if(col == INVOICE_DATE_COL)
			{
				return retrieveInvoice.getDate();
			}
			else if(col == INVOICE_CUSTOMER_COL)
			{
				return retrieveInvoice.getCustomername();
			}
			else if(col == INVOICE_REG_COL)
			{
				return retrieveInvoice.getVehiclereg();
			}
			else if(col == INVOICE_PRICE_COL)
			{
				return retrieveInvoice.getPrice();
			}
			else
			{
				return "";
			}
		}
	
	
	

}
