package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Employee_Model {
	
	/*@Id
	@GeneratedValue
	private int dbID;
	*/
	
	@Id
	private int employee_id;
	private String emp_firstname;
	private String emp_surname;
	
	private int emp_phone_number;
	private String emp_type;
	
	
	
	
	public Employee_Model(int employee_id, String emp_firstname,
			String emp_surname, int emp_phone_number, String emp_type) {
		this.employee_id = employee_id;
		this.emp_firstname = emp_firstname;
		this.emp_surname = emp_surname;
		this.emp_phone_number = emp_phone_number;
		this.emp_type = emp_type;
	}
	
	
	
	public Employee_Model(){}
	
	
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmp_firstname() {
		return emp_firstname;
	}
	public void setEmp_firstname(String emp_firstname) {
		this.emp_firstname = emp_firstname;
	}
	public String getEmp_surname() {
		return emp_surname;
	}
	public void setEmp_surname(String emp_surname) {
		this.emp_surname = emp_surname;
	}
	public int getEmp_phone_number() {
		return emp_phone_number;
	}
	public void setEmp_phone_number(int emp_phone_number) {
		this.emp_phone_number = emp_phone_number;
	}
	public String getEmp_type() {
		return emp_type;
	}
	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}


	@Override
	public String toString() {
		return "Employee_Model [employee_id=" + employee_id
				+ ", emp_firstname=" + emp_firstname + ", emp_surname="
				+ emp_surname + ", emp_phone_number=" + emp_phone_number
				+ ", emp_type=" + emp_type + "]";
	}

}
