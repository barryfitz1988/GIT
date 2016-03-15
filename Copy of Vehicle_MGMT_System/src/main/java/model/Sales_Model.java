package model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Sales_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6771806978975321401L;
	
	
	@Id
	private int id;
	private String reg;
	private String make;
	private String model;
	@Column(length=255)
	private String description;
	private double price;
	
	
	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] image;
	
	
	
	public Sales_Model(int id, String reg, String make, String model,
			String description, double price, byte[] image) {
		super();
		this.id = id;
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.description = description;
		this.price = price;
		this.image = image;
	}

	
	public Sales_Model(){}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getReg() {
		return reg;
	}



	public void setReg(String reg) {
		this.reg = reg;
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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Sales_Model [id=" + id + ", reg=" + reg + ", make=" + make
				+ ", model=" + model + ", description=" + description
				+ ", price=" + price + ", image=" + Arrays.toString(image)
				+ "]";
	}




	
	
	
	
	
	

}
