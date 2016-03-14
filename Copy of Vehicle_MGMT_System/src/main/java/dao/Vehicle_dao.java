package dao;

import java.util.List;








import model.Customer_Model;
import model.Customers_Vehicle_Model;
import model.Vehicle_Model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import Interface.Vehicle_Interface;

public class Vehicle_dao implements Vehicle_Interface{
	
	
	
	
	// Create Session & Transaction 
	private Session currentSession;

	
	private Transaction currentTransaction;

	// Dao Constructor
	public Vehicle_dao() {
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
		config.addAnnotatedClass(Vehicle_Model.class);
		config.addAnnotatedClass(Customers_Vehicle_Model.class);
		config.addAnnotatedClass(Customer_Model.class);
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
	public void persist(Vehicle_Model entity) {
		getCurrentSession().save(entity);
	}
	
	// dao add to DB
	public void persistOwner(Customers_Vehicle_Model entity) {
		getCurrentSession().save(entity);
	}
	
	// dao update to DB
	public void update(Vehicle_Model entity) {
		getCurrentSession().update(entity);
	}
	
	// dao update to DB
	public void updateOwner(Customers_Vehicle_Model entity) {
		getCurrentSession().update(entity);
	}
	
	// dao find ID in DB
	public Vehicle_Model findById(int id) {
		Vehicle_Model object = (Vehicle_Model) getCurrentSession().get(
				Vehicle_Model.class, id);
		return object;
	}
	
	
	// dao find ID in DB
	public Customers_Vehicle_Model findByOwnersId(int id) {
		Customers_Vehicle_Model object = (Customers_Vehicle_Model) getCurrentSession().get(
				Customers_Vehicle_Model.class, id);
		return object;
	}
	
	// dao delete in DB
	public void delete(Vehicle_Model entity) {
		getCurrentSession().delete(entity);
	}
	


	//List All in DB
	@SuppressWarnings("unchecked")
	public List<Vehicle_Model> findAll() {
		List<Vehicle_Model> art = (List<Vehicle_Model>) getCurrentSession()
				.createQuery("from Vehicle_Model").list();
		return art;
	}
	//List All in DB
	@SuppressWarnings("unchecked")
	public List<Customers_Vehicle_Model> findAllOwners() {
		List<Customers_Vehicle_Model> art = (List<Customers_Vehicle_Model>) getCurrentSession()
				.createQuery("from Customers_Vehicle_Model").list();
		return art;
	}


	@Override
	public Customers_Vehicle_Model findByRegistration(String reg) {
		Customers_Vehicle_Model object = (Customers_Vehicle_Model) getCurrentSession().get(
				Customers_Vehicle_Model.class, reg);
		return object;
	}
	

}
