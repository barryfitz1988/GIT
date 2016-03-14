package service;

import java.util.List;



import model.Service_Model;
import dao.Service_dao;

public class Service_Service {
	
	
	private static Service_dao dao;

	
	//Constructor
	public Service_Service() {

		dao = new Service_dao();
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
	public void persist(Service_Model entity) {

		dao.persist(entity);

	}
	//Update DB
	public void update(Service_Model entity) {

		dao.update(entity);

	}

	// find object by ID
	public Service_Model findById(int id) {
		dao.openCurrentSession();
		Service_Model o = dao.findById(id);
		dao.closeCurrentSession();
		return o;
	}
	//Delete from DB
	public void delete(int id) {

		Service_Model artist = dao.findById(id);
		dao.delete(artist);

	}

	// FindAll in DB
	public List<Service_Model> findAll() {
		dao.openCurrentSession();
		List<Service_Model> object = dao.findAll();
		dao.closeCurrentSession();
		return object;
	}
	
	
	

}
