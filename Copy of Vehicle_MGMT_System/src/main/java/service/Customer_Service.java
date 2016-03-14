package service;

import java.util.List;

import model.Customer_Model;
import dao.Customer_dao;



public class Customer_Service {
	
	private static Customer_dao dao;

	
	//Constructor
	public Customer_Service() {

		dao = new Customer_dao();
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
	public void persist(Customer_Model entity) {

		dao.persist(entity);

	}
	//Update DB
	public void update(Customer_Model entity) {

		dao.update(entity);

	}

	// find object by ID
	public Customer_Model findById(int id) {
		dao.openCurrentSession();
		Customer_Model o = dao.findById(id);
		dao.closeCurrentSession();
		return o;
	}
	//Delete from DB
	public void delete(int id) {

		Customer_Model artist = dao.findById(id);
		dao.delete(artist);

	}

	// FindAll in DB
	public List<Customer_Model> findAll() {
		dao.openCurrentSession();
		List<Customer_Model> object = dao.findAll();
		dao.closeCurrentSession();
		return object;
	}
	
	

}
