package Interface;

import java.util.List;


import model.Invoice_Model;

public interface Invoice_Interface {
	
	
	
	public void persist(Invoice_Model c);
	
	public void update(Invoice_Model c);
	
	public Invoice_Model findById(int id);
	
	public void delete(Invoice_Model c);
	
	public List<Invoice_Model> findAll();
	
	

}
