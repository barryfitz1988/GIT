package Interface;

import java.util.List;

import model.Employee_Model;



public interface Employee_Interface {
	
	
	public void persist(Employee_Model c);
	
	public void update(Employee_Model c);
	
	public Employee_Model findById(int id);
	
	public void delete(Employee_Model c);
	
	public List<Employee_Model> findAll();
	
	

}
