package model;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Invoice_Model {
	
	
	@Id
	@GeneratedValue
	private int id;
	private String customername;
	private String vehiclereg;
	private String date;
	private String price;
	private String service;
	@Transient
	private ArrayList<Items_Model> items;
	

	


	
	public Invoice_Model(int id, String customername, String vehiclereg,
			String make, String model, String date, String price,String service) {
		super();
		this.id = id;
		this.customername = customername;
		this.vehiclereg = vehiclereg;
		this.date = date;
		this.price = price;
		this.service =service;
	
	
		
		
	}


	public Invoice_Model(){
		this.items = new ArrayList<Items_Model>();

	}
	
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}

	
	
	

	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public ArrayList<Items_Model> getItems() {
		return items;
	}


	public void setItems(ArrayList<Items_Model> items) {
		this.items = items;
	}


	@Override
	public String toString() {
		return "Invoice_Model [id=" + id + ", customername=" + customername
				+ ", vehiclereg=" + vehiclereg + ", date=" + date + ", price="
				+ price + ", service=" + service + ", items=" + items + "]";
	}






	
	
	

}
