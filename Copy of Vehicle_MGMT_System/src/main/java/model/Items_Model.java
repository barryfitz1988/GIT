package model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class Items_Model {
	
	@GeneratedValue
	@Id
	private int id;
	private String item_name;
	private int item_quantity;
	private double item_price;
	@JoinTable(name = "Invoice_Model",joinColumns = @JoinColumn(name = "id") )
	private int invoice_id;
	
	
	
	public Items_Model(String item_name, int item_quantity,
			double item_price, int invoice_id) {
		super();
		this.item_name = item_name;
		this.item_quantity = item_quantity;
		this.item_price = item_price;
		this.invoice_id = invoice_id;
	}


	public Items_Model(){}
	

	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getItem_name() {
		return item_name;
	}



	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}



	public int getItem_quantity() {
		return item_quantity;
	}



	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}



	public double getItem_price() {
		return item_price;
	}



	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}



	public int getInvoice_id() {
		return invoice_id;
	}



	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}





	@Override
	public String toString() {
		return "Invoice_Item_Model [id=" + id + ", item_name=" + item_name
				+ ", item_quantity=" + item_quantity + ", item_price="
				+ item_price + ", invoice_id=" + invoice_id + "]";
	}
}