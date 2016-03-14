package dao;

import java.util.List;

import model.Appointment_Model;
import model.Appointment_Parts_Model;
import model.Customer_Model;
import model.Customers_Vehicle_Model;
import model.Parts_Model;
import model.Vehicle_Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import Interface.Appointment_Interface;

public class Appointment_dao implements Appointment_Interface {
	
	// Create Session & Transaction 
	private Session currentSession;

	
	private Transaction currentTransaction;

	// Dao Constructor
	public Appointment_dao() {
		SessionFactory sessionFactory = getSessionFactory();
		currentSession = sessionFactory.openSession();
		currentTransaction = currentSession.beginTransaction();
	}

	
	// method to commit to Hibernate DB without closing 
	public void commit() {
		getCurrentTransaction().commit();
	}
	// method to open new Session
	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}
	// method to open new Session when doing a Transaction
	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentSession.beginTransaction();
		return currentSession;
	}
	// method to close new Session
	public void closeCurrentSession() {
		currentSession.close();
	}
	// method to close new Session when doing a Transaction
	public void closeCurrentSessionwithTransaction() {
		currentSession.getTransaction().commit();

	}

	// Create a new SessionFactory 
	private static SessionFactory getSessionFactory() {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Appointment_Model.class);
		config.addAnnotatedClass(Appointment_Parts_Model.class);
		config.addAnnotatedClass(Parts_Model.class);
		config.configure("hibernate.cfg.xml");

		ServiceRegistryBuilder rgs = new ServiceRegistryBuilder()
				.applySettings(config.getProperties());
		SessionFactory sessionFactory = config.buildSessionFactory(rgs
				.buildServiceRegistry());
		//new SchemaExport(config).create(true, true);
		return sessionFactory;
	}

	//Getter
	public Session getCurrentSession() {
		return currentSession;
	}
	//Setter
	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {

		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	// dao add to DB
	public void persist(Appointment_Model entity) {
		getCurrentSession().save(entity);
	}
	
	
	// dao add to DB
	public void persistPart(Appointment_Parts_Model entity) {
		getCurrentSession().save(entity);
	}
	
	
	// dao update to DB
	public void update(Appointment_Model entity) {
		getCurrentSession().update(entity);
	}
	// dao find ID in DB
	public Appointment_Model findById(int id) {
		Appointment_Model object = (Appointment_Model) getCurrentSession().get(
				Appointment_Model.class, id);
		return object;
	}
	// dao delete in DB
	public void delete(Appointment_Model entity) {
		getCurrentSession().delete(entity);
	}

	//List All in DB
	@SuppressWarnings("unchecked")
	public List<Appointment_Model> findAll() {
		List<Appointment_Model> art = (List<Appointment_Model>) getCurrentSession()
				.createQuery("from Appointment_Model").list();
		return art;
	}


	@Override
	public void deletePart(Appointment_Parts_Model c) {
		getCurrentSession().delete(c);
		
	}


	@Override
	public List<Appointment_Parts_Model> findAllParts() {
		List<Appointment_Parts_Model> art = (List<Appointment_Parts_Model>) getCurrentSession()
				.createQuery("from Appointment_Parts_Model").list();
		return art;
	}


	@Override
	public Appointment_Parts_Model findPartByname(int part) {
		Appointment_Parts_Model object = (Appointment_Parts_Model) getCurrentSession().get(
				Appointment_Parts_Model.class, part);
		return object;
		
	}
	
	
	

}
