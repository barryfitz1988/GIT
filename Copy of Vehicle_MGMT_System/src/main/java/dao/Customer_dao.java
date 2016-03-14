package dao;

import java.util.List;

import model.Customer_Model;
import model.Customers_Vehicle_Model;
import model.Employee_Model;
import model.Vehicle_Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;








import Interface.Customer_Interface;

public class Customer_dao implements Customer_Interface {
	
	
	// Create Session & Transaction 
	private Session currentSession;

	
	private Transaction currentTransaction;

	// Dao Constructor
	public Customer_dao() {
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
		config.addAnnotatedClass(Customer_Model.class);
		config.addAnnotatedClass(Customers_Vehicle_Model.class);
		config.addAnnotatedClass(Vehicle_Model.class);
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
	public void persist(Customer_Model entity) {
		getCurrentSession().save(entity);
	}
	// dao update to DB
	public void update(Customer_Model entity) {
		getCurrentSession().update(entity);
	}
	// dao find ID in DB
	public Customer_Model findById(int id) {
		Customer_Model object = (Customer_Model) getCurrentSession().get(
				Customer_Model.class, id);
		return object;
	}
	// dao delete in DB
	public void delete(Customer_Model entity) {
		getCurrentSession().delete(entity);
	}

	//List All in DB
	@SuppressWarnings("unchecked")
	public List<Customer_Model> findAll() {
		List<Customer_Model> art = (List<Customer_Model>) getCurrentSession()
				.createQuery("from Customer_Model").list();
		return art;
	}
	


	

	
	
}
