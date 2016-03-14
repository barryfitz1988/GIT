package Interface;

import java.util.List;

import model.Customers_Vehicle_Model;
import model.Vehicle_Model;


public interface Vehicle_Interface {
	
	
	
	public void persist(Vehicle_Model c);
	
	public void persistOwner(Customers_Vehicle_Model c);
	
	public void update(Vehicle_Model c);
	
	public Vehicle_Model findById(int id);
	
	public Customers_Vehicle_Model findByRegistration(String reg);
	
	public Customers_Vehicle_Model findByOwnersId(int id);
	
	public void delete(Vehicle_Model c);
	
	
	public List<Vehicle_Model> findAll();
	
	public List<Customers_Vehicle_Model> findAllOwners();
	

}
