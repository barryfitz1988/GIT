package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Customer_Model {
	
	
	
	//@GeneratedValue
	//private int dbID;
	
	@Id
	@OnDelete(action = OnDeleteAction.CASCADE)
	private int customer_id;
	private String first_name;
	private String surname;
	private int phone_number;
	@Column(length=255)
	private String customer_info;
	@Column(length=255)
	private String customer_history;


	
	public Customer_Model(int customer_id, String first_name, String surname,
			int phone_number, String customer_email, String customer_address,
			String customer_info, String customer_history) {

		this.customer_id = customer_id;
		this.first_name = first_name;
		this.surname = surname;
		this.phone_number = phone_number;
		this.customer_info = customer_info;
		this.customer_history = customer_history;
	}
	
	
	public Customer_Model(){}
	
	
	
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getCustomer_info() {
		return customer_info;
	}
	public void setCustomer_info(String customer_info) {
		this.customer_info = customer_info;
	}
	public String getCustomer_history() {
		return customer_history;
	}
	public void setCustomer_history(String customer_history) {
		this.customer_history = customer_history;
	}




	@Override
	public String toString() {
		return "Customer_Model [customer_id=" + customer_id + ", first_name="
				+ first_name + ", surname=" + surname + ", phone_number="
				+ phone_number +  " customer_info="
				+ customer_info + ", customer_history=" + customer_history
				+ "]";
	}


	}
	
	
	

