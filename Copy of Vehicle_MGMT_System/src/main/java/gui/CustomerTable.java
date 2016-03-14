package gui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Customer_Model;



public class CustomerTable extends DefaultTableModel {

private static final int NO_OF_COLS = 3;
	
	//These are the indices of the table columns
	private static final int CUSTOMER_ID_COL = 0;
	private static final int CUSTOMER_FIRST_NAME_COL = 1;
	private static final int CUSTOMER_SECOND_NAME_COL = 2;

	private ArrayList<Customer_Model> customers;
	
	//constructor
	public CustomerTable(ArrayList<Customer_Model> customers)
	{
		super();
		this.customers = customers;
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
			if(column == CUSTOMER_ID_COL)
				
			{	
				return "Customer ID";
			}
			else if(column == CUSTOMER_FIRST_NAME_COL)
			{
				return "First Name";
			}
			else if(column == CUSTOMER_SECOND_NAME_COL)
			{
				return " Surname";
			}
			else
			{
				return "";
			}
		}
		
		//this overriding the getColumnCount() method from superclass	
		public int getRowCount()
		{
			if(this.customers != null)
			{
				return this.customers.size();
			}
			else
			{	
				return 0;
			}
		}
		
		public Object getValueAt(int row, int col)
		{
			Customer_Model retrieveCustomer = this.customers.get(row);
			if(col == CUSTOMER_ID_COL)
			{
				return retrieveCustomer.getCustomer_id();
			}
			else if(col == CUSTOMER_FIRST_NAME_COL)
			{
				return retrieveCustomer.getFirst_name();
			}
			else if(col == CUSTOMER_SECOND_NAME_COL)
			{
				return retrieveCustomer.getSurname();
			}
			else
			{
				return "";
			}
		}
	
		
}
