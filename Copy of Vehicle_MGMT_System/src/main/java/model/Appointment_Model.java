package model;

import java.sql.Time;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Appointment_Model {
	
	@Id
	@GeneratedValue
	private int appointment_id;
	private String date;
	private String time;
	private String customer_name;
	private String employee_name;
	private String job_name;
	private String vehicle_reg;
	private int service_length;
	
	
	public Appointment_Model(int appointment_id, String date, String time,
			String customer_name, String employee_name, String job_name,
			String vehicle_reg, int service_length) {
		this.appointment_id = appointment_id;
		this.date = date;
		this.time = time;
		this.customer_name = customer_name;
		this.employee_name = employee_name;
		this.job_name = job_name;
		this.vehicle_reg = vehicle_reg;
	}
	
	public Appointment_Model(){}


	public int getAppointment_id() {
		return appointment_id;
	}


	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getCustomer_name() {
		return customer_name;
	}


	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}


	public String getEmployee_name() {
		return employee_name;
	}


	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}


	public String getJob_name() {
		return job_name;
	}


	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}


	public String getVehicle_reg() {
		return vehicle_reg;
	}


	public void setVehicle_reg(String vehicle_reg) {
		this.vehicle_reg = vehicle_reg;
	}
	
	


	public int getService_length() {
		return service_length;
	}

	public void setService_length(int service_length) {
		this.service_length = service_length;
	}

	@Override
	public String toString() {
		return "Appointment_Model [appointment_id=" + appointment_id
				+ ", date=" + date + ", time=" + time + ", customer_name="
				+ customer_name + ", employee_name=" + employee_name
				+ ", job_name=" + job_name + ", vehicle_reg=" + vehicle_reg
				+ "]";
	}
	
	
	
	

	


}
