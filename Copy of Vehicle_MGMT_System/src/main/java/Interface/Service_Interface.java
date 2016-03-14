package Interface;

import java.util.List;

import model.Service_Model;


public interface Service_Interface {
	
	
	public void persist(Service_Model c);
	
	public void update(Service_Model c);
	
	public Service_Model findById(int id);
	
	public void delete(Service_Model c);
	
	public List<Service_Model> findAll();
	

}
