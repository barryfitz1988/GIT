package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parts_Model {
	
	/*@Id
	@GeneratedValue
	private int dbID;
*/
	@Id
	private int part_id;
	private String part_name;
	private String part_description;
	private double part_price;
	
	
	
	
	
	
	public Parts_Model(int part_id, String part_name, String part_description,
			double part_price) {
		this.part_id = part_id;
		this.part_name = part_name;
		this.part_description = part_description;
		this.part_price = part_price;
	}
	
	
	public Parts_Model(){}
	
	
	public int getPart_id() {
		return part_id;
	}
	public void setPart_id(int part_id) {
		this.part_id = part_id;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public String getPart_description() {
		return part_description;
	}
	public void setPart_description(String part_description) {
		this.part_description = part_description;
	}
	public double getPart_price() {
		return part_price;
	}
	public void setPart_price(double price) {
		this.part_price = price;
	}


	
	
	@Override
	public String toString() {
		return "Parts_Model [part_id=" + part_id + ", part_name=" + part_name
				+ ", part_description=" + part_description + ", part_price="
				+ part_price + "]";
	}
	
	
	
	

}
