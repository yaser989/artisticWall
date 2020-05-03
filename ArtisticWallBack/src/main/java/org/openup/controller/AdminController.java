package org.openup.controller;

import org.openup.entity.Artist;
import org.openup.service.AdminServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired
	private AdminServise adminServise;
	
	@GetMapping("/")
	public ResponseEntity findAll() {	
		
//		Artist artist = new Artist();
//		if (artist.getRole().getRoleName() != "ROLE_Admin") {
//			return ResponseEntity.notFound().build();
//		}
	
		
		return ResponseEntity.ok(adminServise.finAll());
	}

}
