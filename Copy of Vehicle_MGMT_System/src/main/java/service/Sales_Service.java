package service;

import java.util.List;

import model.Sales_Model;
import dao.Sales_dao;



public class Sales_Service {
	
	
	private static Sales_dao dao;

	
	//Constructor
	public Sales_Service() {

		dao = new Sales_dao();
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
	public void persist(Sales_Model entity) {

		dao.persist(entity);

	}
	//Update DB
	public void update(Sales_Model entity) {

		dao.update(entity);

	}

	// find object by ID
	public Sales_Model findById(int id) {
		dao.openCurrentSession();
		Sales_Model o = dao.findById(id);
		dao.closeCurrentSession();
		return o;
	}
	//Delete from DB
	public void delete(int id) {

		Sales_Model artist = dao.findById(id);
		dao.delete(artist);

	}

	// FindAll in DB
	public List<Sales_Model> findAll() {
		dao.openCurrentSession();
		List<Sales_Model> object = dao.findAll();
		dao.closeCurrentSession();
		return object;
	}
	

}
