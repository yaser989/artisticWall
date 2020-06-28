package org.openup.controller;

import org.openup.DTO.AdminDto;
import org.openup.DTO.EventDto;
import org.openup.service.AdminServise;
import org.openup.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired
	private AdminServise adminServise;
	
	@Autowired
	private EventService eventService;

	/*
	 * admin find all event 
	 */
	
	@GetMapping("/")
	public ResponseEntity findAll() {	
				
		return ResponseEntity.ok(adminServise.finAll());
	}
	
	/*
	 * admin find by id of event 
	 */
	
	@GetMapping("/findByID/{idEvent}")
	public ResponseEntity findEventById(@PathVariable(name = "idEvent")Long idEvent) {
		return ResponseEntity.ok(adminServise.findByID(idEvent));
	}
	
	/*
	 * delete by id
	 */
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEvent(@PathVariable(name="id") Long id) {
		adminServise.deleteEvent(id);
		return ResponseEntity.ok("Event removed with success");
	}
	
	/*
	 * update by id
	 */
	
	@PutMapping("/update/{idEvent}")
	public ResponseEntity updateEvent(@PathVariable(name="idEvent") Long idEvent, @RequestBody AdminDto adminDto) {
		adminServise.updateEvent(idEvent, adminDto);
		return ResponseEntity.ok("updet done with success");
	}
}
