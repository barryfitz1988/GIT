package dao;

import java.util.List;




import model.Employee_Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import Interface.Employee_Interface;

public class Employee_dao implements Employee_Interface{
	
	
	// Create Session & Transaction 
	private Session currentSession;

	
	private Transaction currentTransaction;

	// Dao Constructor
	public Employee_dao() {
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
		config.addAnnotatedClass(Employee_Model.class);
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
	public void persist(Employee_Model entity) {
		getCurrentSession().save(entity);
	}
	// dao update to DB
	public void update(Employee_Model entity) {
		getCurrentSession().update(entity);
	}
	// dao find ID in DB
	public Employee_Model findById(int id) {
		Employee_Model object = (Employee_Model) getCurrentSession().get(
				Employee_Model.class, id);
		return object;
	}
	// dao delete in DB
	public void delete(Employee_Model entity) {
		getCurrentSession().delete(entity);
	}

	//List All in DB
	@SuppressWarnings("unchecked")
	public List<Employee_Model> findAll() {
		List<Employee_Model> art = (List<Employee_Model>) getCurrentSession()
				.createQuery("from Employee_Model").list();
		return art;
	}
	
	

}
