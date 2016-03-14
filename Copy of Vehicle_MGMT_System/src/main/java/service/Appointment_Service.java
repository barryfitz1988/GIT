package service;

import java.util.List;

import model.Appointment_Model;
import model.Appointment_Parts_Model;
import dao.Appointment_dao;

public class Appointment_Service {
	
	private static Appointment_dao dao;

	
	//Constructor
	public Appointment_Service() {

		dao = new Appointment_dao();
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
	public void persist(Appointment_Model entity) {

		dao.persist(entity);

	}
	
	public void persistPart(Appointment_Parts_Model entity) {

		dao.persistPart(entity);

	}
	//Update DB
	public void update(Appointment_Model entity) {

		dao.update(entity);

	}

	// find object by ID
	public Appointment_Model findById(int id) {
		dao.openCurrentSession();
		Appointment_Model o = dao.findById(id);
		dao.closeCurrentSession();
		return o;
	}
	//Delete from DB
	public void delete(int id) {

		Appointment_Model artist = dao.findById(id);
		dao.delete(artist);

	}
	
	//Delete from DB
	public void deleteParts(int part) {

		Appointment_Parts_Model artist = dao.findPartByname(part);
		dao.deletePart(artist);

	}

	// FindAll in DB
	public List<Appointment_Model> findAll() {
		dao.openCurrentSession();
		List<Appointment_Model> object = dao.findAll();
		dao.closeCurrentSession();
		return object;
	}
	
	public List<Appointment_Parts_Model> findAllParts() {
		dao.openCurrentSession();
		List<Appointment_Parts_Model> object = dao.findAllParts();
		dao.closeCurrentSession();
		return object;
	}
	
	

}
