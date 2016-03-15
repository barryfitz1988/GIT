package gui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Sales_Model;



public class SalesTable extends DefaultTableModel{
	
private static final int NO_OF_COLS = 4;
	
	//These are the indices of the table columns
	private static final int SALES_ID_COL = 0;
	private static final int SALES_MAKE_COL = 1;
	private static final int SALES_MODEL_COL  = 2;
	private static final int SALES_PRICE_COL = 3;

	private ArrayList<Sales_Model> sales;
	
	//constructor
	public SalesTable(ArrayList<Sales_Model> sales)
	{
		super();
		this.sales = sales;
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
			if(column == SALES_ID_COL)
				
			{	
				return "ID";
			}
			else if(column == SALES_MAKE_COL)
				
			{	
				return "Make";
			}
			else if(column == SALES_MODEL_COL)
			{
				return "Model";
			}
			else if(column == SALES_PRICE_COL)
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
			if(this.sales != null)
			{
				return this.sales.size();
			}
			else
			{	
				return 0;
			}
		}
		
		public Object getValueAt(int row, int col)
		{
			Sales_Model retrievesales = this.sales.get(row);
			if(col == SALES_ID_COL)
			{
				return retrievesales.getId();
			}
			
			
			else if(col == SALES_MAKE_COL)
			{
				return retrievesales.getMake();
			}
			else if(col == SALES_MODEL_COL)
			{
				return retrievesales.getModel();
			}
			else if(col == SALES_PRICE_COL)
			{
				return retrievesales.getPrice();
			}
			else
			{
				return "";
			}
		}

}
