package edu.j2ee.hotelcrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double rating;
	private String type;
	private String address;

	
	public Hotel() {
		super();
	}

	
	public Hotel( String name, double rating, String type, String address) {
		
		this.name = name;
		this.rating = rating;
		this.type = type;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	
	
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", rating=" + rating + ", type=" + type + ", address=" + address
				+ "]";
	}
	

	
}
