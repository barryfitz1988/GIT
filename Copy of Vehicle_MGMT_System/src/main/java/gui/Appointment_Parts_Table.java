package gui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Appointment_Parts_Model;



public class Appointment_Parts_Table extends DefaultTableModel{
	
	
	
private static final int NO_OF_COLS = 2;
	

	private static final int PART_NAME_COL = 0;
	private static final int PART_PRICE_COL = 1;

	private ArrayList<Appointment_Parts_Model> parts;
	
	//constructor
	public Appointment_Parts_Table(ArrayList<Appointment_Parts_Model> parts)
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

			if(column == PART_NAME_COL)
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
			Appointment_Parts_Model retrievePart = this.parts.get(row);

			 if(col == PART_NAME_COL)
			{
				return retrievePart.getPart().getPart_name();
			}
			else if(col == PART_PRICE_COL)
			{
				return retrievePart.getPart().getPart_price();
			}
			else
			{
				return "";
			}
		}

}

