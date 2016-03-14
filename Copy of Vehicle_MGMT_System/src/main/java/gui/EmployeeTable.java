package gui;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


import model.Employee_Model;

public class EmployeeTable extends DefaultTableModel{
	
	
	
private static final int NO_OF_COLS = 3;
	
	//These are the indices of the table columns
	private static final int EMPLOYEE_ID_COL = 0;
	private static final int EMPLOYEE_FIRST_NAME_COL = 1;
	private static final int EMPLOYEE_SECOND_NAME_COL = 2;

	private ArrayList<Employee_Model> employees;
	
	//constructor
	public EmployeeTable(ArrayList<Employee_Model> employees)
	{
		super();
		this.employees = employees;
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
			if(column == EMPLOYEE_ID_COL)
				
			{	
				return "Employee ID";
			}
			else if(column == EMPLOYEE_FIRST_NAME_COL)
			{
				return "First Name";
			}
			else if(column == EMPLOYEE_SECOND_NAME_COL)
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
			if(this.employees != null)
			{
				return this.employees.size();
			}
			else
			{	
				return 0;
			}
		}
		
		public Object getValueAt(int row, int col)
		{
			Employee_Model retrieveEmployee = this.employees.get(row);
			if(col == EMPLOYEE_ID_COL)
			{
				return retrieveEmployee.getEmployee_id();
			}
			else if(col == EMPLOYEE_FIRST_NAME_COL)
			{
				return retrieveEmployee.getEmp_firstname();
			}
			else if(col == EMPLOYEE_SECOND_NAME_COL)
			{
				return retrieveEmployee.getEmp_surname();
			}
			else
			{
				return "";
			}
		}

}
