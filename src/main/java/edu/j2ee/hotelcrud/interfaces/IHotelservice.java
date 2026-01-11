package edu.j2ee.hotelcrud.interfaces;

import java.util.List;
import java.util.Optional;

import edu.j2ee.hotelcrud.dto.HotelDTO;
import edu.j2ee.hotelcrud.entity.Hotel;

public interface IHotelservice {

	public Optional<Hotel> getHotel(int id);
	public List<Hotel> getAll();
	
	public Hotel saveHotel(HotelDTO dto);
	
	public Hotel editHotel(int id,HotelDTO dto);
	
	public void deleteId(int id);
}
