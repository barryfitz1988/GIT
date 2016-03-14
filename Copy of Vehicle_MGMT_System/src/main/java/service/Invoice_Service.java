package service;

import java.util.List;

import model.Invoice_Model;
import dao.Invoice_dao;


public class Invoice_Service {
	
	
	private static Invoice_dao dao;

	
	//Constructor
	public Invoice_Service() {

		dao = new Invoice_dao();
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
	public void persist(Invoice_Model entity) {

		dao.persist(entity);

	}
	//Update DB
	public void update(Invoice_Model entity) {

		dao.update(entity);

	}

	// find object by ID
	public Invoice_Model findById(int id) {
		dao.openCurrentSession();
		Invoice_Model o = dao.findById(id);
		dao.closeCurrentSession();
		return o;
	}
	//Delete from DB
	public void delete(int id) {

		Invoice_Model artist = dao.findById(id);
		dao.delete(artist);

	}

	// FindAll in DB
	public List<Invoice_Model> findAll() {
		dao.openCurrentSession();
		List<Invoice_Model> object = dao.findAll();
		dao.closeCurrentSession();
		return object;
	}
	
	

}
