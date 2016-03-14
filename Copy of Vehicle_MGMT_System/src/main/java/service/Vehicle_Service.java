package service;

import java.util.List;

import model.Customers_Vehicle_Model;
import model.Vehicle_Model;
import dao.Vehicle_dao;



public class Vehicle_Service {
	
	private static Vehicle_dao dao;

	
	//Constructor
	public Vehicle_Service() {

		dao = new Vehicle_dao();
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
	public void persist(Vehicle_Model entity) {

		dao.persist(entity);

	}
	
	
	public void persistOwner(Customers_Vehicle_Model entity) {

		dao.persistOwner(entity);

	}
	//Update DB
	public void update(Vehicle_Model entity) {

		dao.update(entity);

	}

	//Update DB
	public void updateOwner(Customers_Vehicle_Model entity) {

		dao.updateOwner(entity);

	}
	
	// find object by ID
	public Vehicle_Model findById(int id) {
		dao.openCurrentSession();
		Vehicle_Model o = dao.findById(id);
		dao.closeCurrentSession();
		return o;
	}
	
	
	// find object by ID
	public Customers_Vehicle_Model findByOwnersId(int id) {
		dao.openCurrentSession();
		Customers_Vehicle_Model o = dao.findByOwnersId(id);
		dao.closeCurrentSession();
		return o;
	}
	
	
	// find object by reg
	public Customers_Vehicle_Model findbyRegistration(String reg) {
		dao.openCurrentSession();
		Customers_Vehicle_Model o = dao.findByRegistration(reg);
		dao.closeCurrentSession();
		return o;
	}
	
	//Delete from DB
	public void delete(int id) {

		Vehicle_Model artist = dao.findById(id);
		dao.delete(artist);

	}
	
	

	// FindAll in DB
	public List<Vehicle_Model> findAll() {
		dao.openCurrentSession();
		List<Vehicle_Model> object = dao.findAll();
		dao.closeCurrentSession();
		return object;
	}
	
	
	public List<Customers_Vehicle_Model> findAllOwners() {
		dao.openCurrentSession();
		List<Customers_Vehicle_Model> object = dao.findAllOwners();
		dao.closeCurrentSession();
		return object;
	}
	

}
