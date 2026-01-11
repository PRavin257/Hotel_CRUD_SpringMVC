package edu.j2ee.hotelcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HotelDTO {
	private String name;
	private double rating;
	private String type;
	private String address;
	

	public HotelDTO(String name, double rating, String type, String address) {
		super();
		this.name = name;
		this.rating = rating;
		this.type = type;
		this.address = address;
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
	public void setRating(double rating) {
		this.rating = rating;
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
	@Override
	public String toString() {
		return "HotelDTO [name=" + name + ", rating=" + rating + ", type=" + type + ", address=" + address + "]";
	}
	
	
	
}
