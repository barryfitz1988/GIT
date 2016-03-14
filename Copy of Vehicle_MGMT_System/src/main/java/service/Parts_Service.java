package service;

import java.util.List;

import model.Parts_Model;
import dao.Parts_dao;



public class Parts_Service {
	
	
private static Parts_dao dao;

	
	//Constructor
	public Parts_Service() {

		dao = new Parts_dao();
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
	public void persist(Parts_Model entity) {

		dao.persist(entity);

	}
	//Update DB
	public void update(Parts_Model entity) {

		dao.update(entity);

	}

	// find object by ID
	public Parts_Model findById(int id) {
		dao.openCurrentSession();
		Parts_Model o = dao.findById(id);
		dao.closeCurrentSession();
		return o;
	}
	//Delete from DB
	public void delete(int id) {

		Parts_Model artist = dao.findById(id);
		dao.delete(artist);

	}

	// FindAll in DB
	public List<Parts_Model> findAll() {
		dao.openCurrentSession();
		List<Parts_Model> object = dao.findAll();
		dao.closeCurrentSession();
		return object;
	}
	
	
	

}
