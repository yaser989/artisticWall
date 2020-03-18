package org.openup.controller;

import org.openup.entity.Event;
import org.openup.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/event")
@CrossOrigin(origins="*")
public class EventController {

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
	public Event createNewEvent (@RequestBody Event event,@PathVariable("id") Long id) {
		
		return   eventService.createNewEvent(event, id);
	}
	
	
	
}
