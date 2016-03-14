package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Vehicle_Model {
	
	
	/*@Id
	@GeneratedValue
	private int dbID;

*/
	@Id
	@OnDelete(action = OnDeleteAction.CASCADE)
	private int vehicle_id;
	private String vehicle_reg;
	private String vehicle_make;
	private String vehicle_model;
	private String vehicle_chassis;
	
	
	public Vehicle_Model(int vehicle_id, String vehicle_reg,
			String vehicle_make, String vehicle_model, String vehicle_chassis) {
		this.vehicle_id = vehicle_id;
		this.vehicle_reg = vehicle_reg;
		this.vehicle_make = vehicle_make;
		this.vehicle_model = vehicle_model;
		this.vehicle_chassis = vehicle_chassis;
	}
	
	
	public Vehicle_Model(){}


	public int getVehicle_id() {
		return vehicle_id;
	}


	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}


	public String getVehicle_reg() {
		return vehicle_reg;
	}


	public void setVehicle_reg(String vehicle_reg) {
		this.vehicle_reg = vehicle_reg;
	}


	public String getVehicle_make() {
		return vehicle_make;
	}


	public void setVehicle_make(String vehicle_make) {
		this.vehicle_make = vehicle_make;
	}


	public String getVehicle_model() {
		return vehicle_model;
	}


	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}


	public String getVehicle_chassis() {
		return vehicle_chassis;
	}


	public void setVehicle_chassis(String vehicle_chassis) {
		this.vehicle_chassis = vehicle_chassis;
	}



	@Override
	public String toString() {
		return "Vehicle_Model [vehicle_id=" + vehicle_id + ", vehicle_reg="
				+ vehicle_reg + ", vehicle_make=" + vehicle_make
				+ ", vehicle_model=" + vehicle_model + ", vehicle_history="
				+ vehicle_chassis + "]";
	}
	
	
	
	
	
	
	

}
