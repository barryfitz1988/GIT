package model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Invoice_Model {
	
	@GeneratedValue
	@Id
	private int id;
	private int job_ID;
	private String customername;
	private String vehiclereg;
	private String make;
	private String model;
	private String tech;
	private String date;
	private String service;
	private String price;
	@Column(length = 500)
	private String parts;
	

	

	public Invoice_Model(int id, int job_ID, String customername,
			String vehiclereg, String make, String model, String tech,
			String date, String service, String price, String parts) {
		super();
		this.id = id;
		this.job_ID = job_ID;
		this.customername = customername;
		this.vehiclereg = vehiclereg;
		this.make = make;
		this.model = model;
		this.tech = tech;
		this.date = date;
		this.service = service;
		this.price = price;
		this.parts = parts;
	}


	public Invoice_Model(){}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getJob_ID() {
		return job_ID;
	}


	public void setJob_ID(int job_ID) {
		this.job_ID = job_ID;
	}


	public String getCustomername() {
		return customername;
	}


	public void setCustomername(String customername) {
		this.customername = customername;
	}


	public String getVehiclereg() {
		return vehiclereg;
	}


	public void setVehiclereg(String vehiclereg) {
		this.vehiclereg = vehiclereg;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getTech() {
		return tech;
	}


	public void setTech(String tech) {
		this.tech = tech;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getParts() {
		return parts;
	}


	public void setParts(String parts) {
		this.parts = parts;
	}


	@Override
	public String toString() {
		return "Invoice_Model [id=" + id + ", job_ID=" + job_ID
				+ ", customername=" + customername + ", vehiclereg="
				+ vehiclereg + ", make=" + make + ", model=" + model
				+ ", tech=" + tech + ", date=" + date + ", service=" + service
				+ ", price=" + price + ", parts=" + parts
				+ "]";
	}
	
	
	/*public String partstoString() {
		return  "\n" +Arrays.toString(parts) +"\n";
	}*/
	

	
	
	

}
