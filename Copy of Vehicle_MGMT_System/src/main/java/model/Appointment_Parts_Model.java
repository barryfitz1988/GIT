package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
public class Appointment_Parts_Model {
	
	
	@Id
	@GeneratedValue
	private int id;
	
	
	//@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "appointment_id")
	private Appointment_Model appointment;
	
	
	//@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToOne//(cascade = CascadeType.ALL)
	private Parts_Model part;


	public Appointment_Parts_Model(int id, Appointment_Model appointment,
			Parts_Model part) {
		super();
		this.id = id;
		this.appointment = appointment;
		this.part = part;
	}

	
	public Appointment_Parts_Model(){}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Appointment_Model getAppointment() {
		return appointment;
	}


	public void setAppointment(Appointment_Model appointment) {
		this.appointment = appointment;
	}


	public Parts_Model getPart() {
		return part;
	}


	public void setPart(Parts_Model part) {
		this.part = part;
	}


	@Override
	public String toString() {
		return "Appointment_Parts_Model [id=" + id + ", appointment="
				+ appointment + ", part=" + part + "]";
	}
	
	
	
	

	
	

}
