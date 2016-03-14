package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jvnet.hk2.config.OnDeleteCascade;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customers_Vehicle_Model {
	
	
	
		@Id
		@GeneratedValue
		private int owner_id;
		
		@OnDelete(action = OnDeleteAction.CASCADE)
		@ManyToOne(cascade = CascadeType.ALL)
		private Customer_Model customer;
		
		@OnDelete(action = OnDeleteAction.CASCADE)
		@ManyToOne(cascade = CascadeType.ALL)
		private Vehicle_Model vehicle;

		public Customers_Vehicle_Model(int owner_id, Customer_Model customer, Vehicle_Model vehicle) {

			super();
			this.owner_id = owner_id;
			this.customer = customer;
			this.vehicle = vehicle;
		}
		
		public Customers_Vehicle_Model(){
			
		}

		public int getOwner_id() {
			return owner_id;
		}

		public void setOwner_id(int owner_id) {
			this.owner_id = owner_id;
		}

		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		public Customer_Model getCustomer() {
			return customer;
		}

		public void setCustomer(Customer_Model customer) {
			this.customer = customer;
		}

		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		public Vehicle_Model getVehicle() {
			return vehicle;
		}

		public void setVehicle(Vehicle_Model vehicle) {
			this.vehicle = vehicle;
		}

	}



