package org.openup.controller;

import org.openup.DTO.EventDto;
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
	private EventService eventService;
	
	/*
	 * event find all
	 */
	
	@GetMapping("/")
	public ResponseEntity findAll() {
		return ResponseEntity.ok(eventService.findAll());
	}
	
	/*
	 * find all artist event by id
	 */
	
	@GetMapping("/{idEvent}")
	public ResponseEntity findAllArtistEventById(@PathVariable(name = "idEvent")Long idEvent) {
		return ResponseEntity.ok(eventService.findAllArtistEventById(idEvent));
	}
	
	/*
	 * find event by id
	 */
	
	@GetMapping("/findByID/{idEvent}")
	public ResponseEntity findEventById(@PathVariable(name = "idEvent")Long idEvent) {
		return ResponseEntity.ok(eventService.findEventById(idEvent));
	}
		
	/*
	 * create event
	 */
	
	@PostMapping("/create/{idEvent}")
	public EventDto createNewEvent (@RequestBody EventDto event,@PathVariable("idEvent") Long idEvent) {
		
		return   eventService.createNewEvent(event, idEvent);
	}
	
	/*
	 * delete event by id
	 */
	
	@DeleteMapping("/{idEvent}")
	public ResponseEntity deleteEvent(@PathVariable(name="idEvent") Long idEvent) {
		eventService.deleteEvent(idEvent);
		return ResponseEntity.ok("Event removed with success");
	}
	
	/*
	 * update event by id
	 */
	
	@PutMapping("/update/{idEvent}")
	public ResponseEntity updateEvent(@PathVariable(name="idEvent") Long idEvent, @RequestBody EventDto event) {
		eventService.updateEvent(idEvent, event);
		return ResponseEntity.ok("updet done with success");
	}
	
	/*
	 * share event by id
	 */
	
	@GetMapping("/share/{idEvent}/{isShared}")
	public ResponseEntity shareEvent (@PathVariable (name="idEvent")Long idEvent,@PathVariable (name ="isShared")boolean isShared) {
		eventService.shareEvent(idEvent, isShared);
		return ResponseEntity.ok("Event shared with succses");
	}
	
	/*
	 * find event by Audition
	 */
	
	@GetMapping("/Audition")
	public ResponseEntity findByAudition(){
		return ResponseEntity.ok(eventService.findEventbyAudition());
	}
	
	/*
	 * find event by Concert
	 */
	
	@GetMapping("/Concert")
	public ResponseEntity findByConcert(){
		return ResponseEntity.ok(eventService.findEventbyConcert());
	}
	
	/*
	 * find event by Show
	 */
	
	@GetMapping("/Show")
	public ResponseEntity findByShow(){
		return ResponseEntity.ok(eventService.findEventbyShow());
	}
	
}
