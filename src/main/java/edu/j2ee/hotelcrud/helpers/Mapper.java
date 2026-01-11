package edu.j2ee.hotelcrud.helpers;

import edu.j2ee.hotelcrud.dto.HotelDTO;
import edu.j2ee.hotelcrud.entity.Hotel;

public class Mapper {
	public static Hotel toEntity(HotelDTO dto) {
		return new Hotel(dto.getName(), dto.getRating(),dto.getType(),dto.getAddress());
	}

	public static HotelDTO toDTO(Hotel hotel) {
		return new HotelDTO(hotel.getName(), hotel.getRating(),hotel.getType(),hotel.getAddress());
	}
}
