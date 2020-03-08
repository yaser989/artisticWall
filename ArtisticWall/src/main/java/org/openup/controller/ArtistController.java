package org.openup.controller;

import org.openup.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/artist")
@CrossOrigin(origins="*")
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;

}
