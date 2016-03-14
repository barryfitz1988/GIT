package gui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Service_Model;


public class ServiceTable extends DefaultTableModel{
	
	
	
private static final int NO_OF_COLS = 4;
	
	//These are the indices of the table columns
	private static final int SERVICE_ID_COL = 0;
	private static final int SERVICE_NAME_COL = 1;
	private static final int SERVICE_PRICE_COL = 2;
	private static final int SERVICE_TIME_COL = 3;

	private ArrayList<Service_Model> service;
	
	//constructor
	public ServiceTable(ArrayList<Service_Model> service)
	{
		super();
		this.service = service;
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
			if(column == SERVICE_ID_COL)
				
			{	
				return " ID";
			}
			else if(column == SERVICE_NAME_COL)
			{
				return " Name";
			}
			else if(column == SERVICE_PRICE_COL)
			{
				return " Price";
			}
			else if(column == SERVICE_TIME_COL)
			{
				return " Time in Hours";
			}
			else
			{
				return "";
			}
		}
		
		//this overriding the getColumnCount() method from superclass	
		public int getRowCount()
		{
			if(this.service != null)
			{
				return this.service.size();
			}
			else
			{	
				return 0;
			}
		}
		
		public Object getValueAt(int row, int col)
		{
			Service_Model retrieveService = this.service.get(row);
			if(col == SERVICE_ID_COL)
			{
				return retrieveService.getJob_id();
			}
			else if(col == SERVICE_NAME_COL)
			{
				return retrieveService.getJob_name();
			}
			else if(col == SERVICE_PRICE_COL)
			{
				return retrieveService.getJob_price();
			}
			else if(col == SERVICE_TIME_COL)
			{
				return retrieveService.getJob_time();
			}
			else
			{
				return "";
			}
		}
}
