package service;

import java.util.List;




import model.Employee_Model;
import dao.Employee_dao;

public class Employee_Service {
	
	
	
	private static Employee_dao dao;

	
	//Constructor
	public Employee_Service() {

		dao = new Employee_dao();
	}

	//Open Transaction
	public void open() {
		dao.openCurrentSessionwithTransaction();
	}
	//Close Transaction
	public void close() {
		dao.closeCurrentSessionwithTransaction();
	}
	//Commit Transaction
	public void commit() {

		dao.commit();
	}

	//Add to DB
	public void persist(Employee_Model entity) {

		dao.persist(entity);

	}
	//Update DB
	public void update(Employee_Model entity) {

		dao.update(entity);

	}

	// find object by ID
	public Employee_Model findById(int id) {
		dao.openCurrentSession();
		Employee_Model o = dao.findById(id);
		dao.closeCurrentSession();
		return o;
	}
	//Delete from DB
	public void delete(int id) {

		Employee_Model artist = dao.findById(id);
		dao.delete(artist);

	}

	// FindAll in DB
	public List<Employee_Model> findAll() {
		dao.openCurrentSession();
		List<Employee_Model> object = dao.findAll();
		dao.closeCurrentSession();
		return object;
	}
	

}
