	package edu.j2ee.hotelcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.j2ee.hotelcrud.dto.HotelDTO;
import edu.j2ee.hotelcrud.entity.Hotel;
import edu.j2ee.hotelcrud.helpers.Mapper;
import edu.j2ee.hotelcrud.interfaces.IHotelservice;
import edu.j2ee.hotelcrud.repository.HotelRepository;

@Service
public class HotelService implements IHotelservice {
	@Autowired
	private HotelRepository repository;

	@Override
	public Optional<Hotel> getHotel(int id) {
		return repository.findById(id);
	}
	
	@Override
	public List<Hotel> getAll() {
		return repository.findAll();
	}

	@Override
	public Hotel saveHotel(HotelDTO dto) {
		return repository.save(Mapper.toEntity(dto));
	}

	
	@Override
	public Hotel editHotel(int id, HotelDTO dto) {
		Hotel existingHotel=repository.findById(id).get();
		
		existingHotel.setName(dto.getName());
		existingHotel.setRating(dto.getRating());
		existingHotel.setType(dto.getType());
		existingHotel.setAddress(dto.getAddress());
		
		return	repository.save(existingHotel);
	}

	@Override
	public void deleteId(int id) {
		repository.deleteById(id);
	}
}
