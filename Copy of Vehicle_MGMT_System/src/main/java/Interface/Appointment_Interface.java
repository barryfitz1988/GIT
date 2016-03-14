package Interface;

import java.util.List;

import model.Appointment_Model;
import model.Appointment_Parts_Model;



public interface Appointment_Interface {
	
	public void persist(Appointment_Model c);
	
	public void persistPart(Appointment_Parts_Model c);
	
	public void update(Appointment_Model c);
	
	public Appointment_Model findById(int id);
	
	public Appointment_Parts_Model findPartByname(int part);
	
	public void delete(Appointment_Model c);
	
	public void deletePart(Appointment_Parts_Model c);
	
	public List<Appointment_Model> findAll();
	
	public List<Appointment_Parts_Model> findAllParts();

}
