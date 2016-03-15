package Interface;

import java.util.List;

import model.Sales_Model;



public interface Sales_Interface {
	
	public void persist(Sales_Model c);
	
	public void update(Sales_Model c);
	
	public Sales_Model findById(int id);
	
	public void delete(Sales_Model c);
	
	public List<Sales_Model> findAll();
	
	
	

}
