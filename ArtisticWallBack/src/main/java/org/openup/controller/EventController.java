package org.openup.controller;

import org.openup.DTO.EventDto;
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
	
	@GetMapping("/{idEvent}")
	public ResponseEntity findAllArtistEventById(@PathVariable(name = "idEvent")Long idEvent) {
		return ResponseEntity.ok(eventService.findAllArtistEventById(idEvent));
	}
	
	@GetMapping("/findByID/{idEvent}")
	public ResponseEntity findEventById(@PathVariable(name = "idEvent")Long idEvent) {
		return ResponseEntity.ok(eventService.findEventById(idEvent));
	}
		
	
	@PostMapping("/create/{idEvent}")
	public EventDto createNewEvent (@RequestBody EventDto event,@PathVariable("idEvent") Long idEvent) {
		
		return   eventService.createNewEvent(event, idEvent);
	}
	
	@DeleteMapping("/{idEvent}")
	public ResponseEntity deleteEvent(@PathVariable(name="idEvent") Long idEvent) {
		eventService.deleteEvent(idEvent);
		return ResponseEntity.ok("Event removed with success");
	}
	
	@PutMapping("/update/{idEvent}")
	public ResponseEntity updateEvent(@PathVariable(name="idEvent") Long idEvent, @RequestBody EventDto event) {
		eventService.updateEvent(idEvent, event);
		return ResponseEntity.ok("updet done with success");
	}
	
	@GetMapping("/share/{idEvent}/{isShared}")
	public ResponseEntity shareEvent (@PathVariable (name="idEvent")Long idEvent,@PathVariable (name ="isShared")boolean isShared) {
		eventService.shareEvent(idEvent, isShared);
		return ResponseEntity.ok("Event shared with succses");
	}
	
	
	
	
}
