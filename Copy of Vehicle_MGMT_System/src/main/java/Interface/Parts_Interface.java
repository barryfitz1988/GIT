package Interface;

import java.util.List;

import model.Parts_Model;



public interface Parts_Interface {
	
	
	
	
	
	public void persist(Parts_Model c);
	
	public void update(Parts_Model c);
	
	public Parts_Model findById(int id);
	
	public void delete(Parts_Model c);
	
	public List<Parts_Model> findAll();
	

}
