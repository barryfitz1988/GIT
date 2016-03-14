package Interface;

import java.util.List;

import model.Customer_Model;

public interface Customer_Interface {
	
	
		
		public void persist(Customer_Model c);
		
		public void update(Customer_Model c);
		
		public Customer_Model findById(int id);
		
		public void delete(Customer_Model c);
		
		public List<Customer_Model> findAll();
		


}
