package org.openup.controller;

import java.util.List;

import org.openup.DTO.EventDto;
import org.openup.entity.Artist;
import org.openup.entity.Event;
import org.openup.repo.ArtistRepository;
import org.openup.repo.EventRepository;
import org.openup.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/event")
@CrossOrigin(origins="*")
public class EventController {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private ArtistRepository artistRepository;
	

	@Autowired
	private EventService eventService;
	
	@GetMapping("/")
	public ResponseEntity findAll() {
		return ResponseEntity.ok(eventService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable(name = "id")Long id) {
		return ResponseEntity.ok(eventService.findAllArtistEventById(id));
	}
	
	
	
	@PostMapping("/create/{id}")
	public EventDto createNewEvent (@RequestBody EventDto event,@PathVariable("id") Long id) {
		
		return   eventService.createNewEvent(event, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEvent(@PathVariable(name="id") Long id) {
		eventService.deleteEvent(id);
		return ResponseEntity.ok("Event removed with success");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity updateEvent(@PathVariable Long id, @RequestBody Event event) {
		eventService.updateEvent(id, event);
		return ResponseEntity.ok("updet done with success");
	}
	
	@GetMapping("/share/{id}/{isShared}")
	public ResponseEntity shareEvent (@PathVariable (name="id")Long id,@PathVariable (name ="isShared")boolean isShared) {
		eventService.shareEvent(id, isShared);
		return ResponseEntity.ok("Event shared with succses");
	}
	
	
}
