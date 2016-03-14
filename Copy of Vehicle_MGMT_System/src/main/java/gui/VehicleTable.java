package gui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Customer_Model;
import model.Customers_Vehicle_Model;
import model.Vehicle_Model;


public class VehicleTable extends DefaultTableModel{
	
	
	
private static final int NO_OF_COLS = 5;
	
	//These are the indices of the table columns
	private static final int VEHICLE_ID_COL = 0;
	private static final int VEHICLE_REG_COL = 1;
	private static final int VEHICLE_MAKE_COL = 2;
	private static final int VEHICLE_MODEL_COL = 3;
	private static final int CUSTOMER_NAME_COL = 4;

	private ArrayList<Customers_Vehicle_Model> vehicles;

	//constructor
	public VehicleTable(ArrayList<Customers_Vehicle_Model> vehicles)
	{
		super();
		this.vehicles = vehicles;
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
			if(column == VEHICLE_ID_COL)
				
			{	
				return " ID";
			}
			else if(column == VEHICLE_REG_COL)
			{
				return " Registration";
			}
			else if(column == VEHICLE_MAKE_COL)
			{
				return " Make";
			}
			else if(column == VEHICLE_MODEL_COL)
			{
				return " Model";
			}
			else if(column == CUSTOMER_NAME_COL)
			{
				return " Customer";
			}
			else
			{
				return "";
			}
		}
		
		//this overriding the getColumnCount() method from superclass	
		public int getRowCount()
		{
			if(this.vehicles != null)
			{
				return this.vehicles.size();
			}
			else
			{	
				return 0;
			}
		}
		
		public Object getValueAt(int row, int col)
		{
			Customers_Vehicle_Model retrieveCar = this.vehicles.get(row);
			if(col == VEHICLE_ID_COL)
			{
				return retrieveCar.getVehicle().getVehicle_id();
			}
			else if(col == VEHICLE_REG_COL)
			{
				return retrieveCar.getVehicle().getVehicle_reg();
			}
			else if(col == VEHICLE_MAKE_COL)
			{
				return retrieveCar.getVehicle().getVehicle_make();
			}
			else if(col == VEHICLE_MODEL_COL)
			{
				return retrieveCar.getVehicle().getVehicle_model();
			}
			else if(col == CUSTOMER_NAME_COL)
			{
				return retrieveCar.getCustomer().getFirst_name();
			}
			else
			{
				return "";
			}
		}

}
