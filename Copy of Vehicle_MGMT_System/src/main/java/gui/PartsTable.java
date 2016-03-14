package gui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Parts_Model;


public class PartsTable extends DefaultTableModel{
	
	
	
private static final int NO_OF_COLS = 3;
	
	//These are the indices of the table columns
	private static final int PART_ID_COL = 0;
	private static final int PART_NAME_COL = 1;
	private static final int PART_PRICE_COL = 2;

	private ArrayList<Parts_Model> parts;
	
	//constructor
	public PartsTable(ArrayList<Parts_Model> parts)
	{
		super();
		this.parts = parts;
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
			if(column == PART_ID_COL)
				
			{	
				return "Part ID";
			}
			else if(column == PART_NAME_COL)
			{
				return "Part Name";
			}
			else if(column == PART_PRICE_COL)
			{
				return " Price";
			}
			else
			{
				return "";
			}
		}
		
		//this overriding the getColumnCount() method from superclass	
		public int getRowCount()
		{
			if(this.parts != null)
			{
				return this.parts.size();
			}
			else
			{	
				return 0;
			}
		}
		
		public Object getValueAt(int row, int col)
		{
			Parts_Model retrievePart = this.parts.get(row);
			if(col == PART_ID_COL)
			{
				return retrievePart.getPart_id();
			}
			else if(col == PART_NAME_COL)
			{
				return retrievePart.getPart_name();
			}
			else if(col == PART_PRICE_COL)
			{
				return retrievePart.getPart_price();
			}
			else
			{
				return "";
			}
		}

}
