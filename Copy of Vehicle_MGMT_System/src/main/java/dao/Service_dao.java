package dao;

import java.util.List;





import model.Parts_Model;
import model.Service_Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import Interface.Service_Interface;

public class Service_dao implements Service_Interface {
	
	
	// Create Session & Transaction 
	private Session currentSession;

	
	private Transaction currentTransaction;

	// Dao Constructor
	public Service_dao() {
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
		config.addAnnotatedClass(Service_Model.class);
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
	public void persist(Service_Model entity) {
		getCurrentSession().save(entity);
	}
	// dao update to DB
	public void update(Service_Model entity) {
		getCurrentSession().update(entity);
	}
	// dao find ID in DB
	public Service_Model findById(int id) {
		Service_Model object = (Service_Model) getCurrentSession().get(
				Service_Model.class, id);
		return object;
	}
	// dao delete in DB
	public void delete(Service_Model entity) {
		getCurrentSession().delete(entity);
	}

	//List All in DB
	@SuppressWarnings("unchecked")
	public List<Service_Model> findAll() {
		List<Service_Model> art = (List<Service_Model>) getCurrentSession()
				.createQuery("from Service_Model").list();
		return art;
	}
	

}
