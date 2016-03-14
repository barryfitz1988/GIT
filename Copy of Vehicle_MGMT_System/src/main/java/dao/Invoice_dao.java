package dao;

import java.util.List;

import model.Customer_Model;
import model.Customers_Vehicle_Model;
import model.Invoice_Model;
import model.Vehicle_Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import Interface.Invoice_Interface;

public class Invoice_dao implements Invoice_Interface {
	
	
	// Create Session & Transaction 
	private Session currentSession;

	
	private Transaction currentTransaction;

	// Dao Constructor
	public Invoice_dao() {
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
		config.addAnnotatedClass(Invoice_Model.class);
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
	public void persist(Invoice_Model entity) {
		getCurrentSession().save(entity);
	}
	// dao update to DB
	public void update(Invoice_Model entity) {
		getCurrentSession().update(entity);
	}
	// dao find ID in DB
	public Invoice_Model findById(int id) {
		Invoice_Model object = (Invoice_Model) getCurrentSession().get(
				Invoice_Model.class, id);
		return object;
	}
	// dao delete in DB
	public void delete(Invoice_Model entity) {
		getCurrentSession().delete(entity);
	}

	//List All in DB
	@SuppressWarnings("unchecked")
	public List<Invoice_Model> findAll() {
		List<Invoice_Model> art = (List<Invoice_Model>) getCurrentSession()
				.createQuery("from Invoice_Model").list();
		return art;
	}
	
	
	

}
