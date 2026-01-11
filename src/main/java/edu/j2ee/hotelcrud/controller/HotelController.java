package edu.j2ee.hotelcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.j2ee.hotelcrud.dto.HotelDTO;
import edu.j2ee.hotelcrud.dto.ResponseStructure;
import edu.j2ee.hotelcrud.entity.Hotel;
import edu.j2ee.hotelcrud.interfaces.IHotelservice;
import edu.j2ee.hotelcrud.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private IHotelservice service;
	
	@GetMapping("/{id}")
	public Hotel getHotel(@PathVariable int id) {
		return service.getHotel(id).get();
	}
	@PostMapping
	public ResponseEntity<Hotel> saveHotel(@RequestBody HotelDTO dto) {
		return  new ResponseEntity(service.saveHotel(dto),HttpStatus.CREATED) ;
	} 
	
	@GetMapping("/response/{id}")
	public ResponseEntity<ResponseStructure<Hotel>> fetchdata(@PathVariable int id)
	{
		Optional<Hotel> hotel = service.getHotel(id);
		
		ResponseStructure<Hotel> resp=new ResponseStructure<Hotel>();
		
		if(hotel.isPresent())
		{
			resp.setStatusCode(HttpStatus.FOUND.value());
			resp.setMessage("Data found");
			resp.setData(hotel.get());
			return ResponseEntity.ok(resp);
		}
		else {
			resp.setStatusCode(HttpStatus.NOT_FOUND.value());
			resp.setMessage("no hotel data found for the given id");
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
			return new ResponseEntity<ResponseStructure<Hotel>>(resp,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll()
	{
		return ResponseEntity.ok(service.getAll());

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable int id, @RequestBody HotelDTO dto)
	{
		return ResponseEntity.ok(service.editHotel(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id )
	{
		service.deleteId(id);
		return ResponseEntity.ok("Data deleted successfully");
	}
	
	
}
