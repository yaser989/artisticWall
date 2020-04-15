package org.openup.controller;

import java.io.ByteArrayInputStream;

import org.openup.entity.Artist;
import org.openup.entity.Event;
import org.openup.repo.ArtistRepository;
import org.openup.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/photos")
@CrossOrigin(origins="*")
public class PhotoController {
	
	@Autowired
	private ArtistRepository artistRepository;
	
	@Autowired
	private EventRepository eventRepository; 
	
	
	@GetMapping("/event/{id}")
	public ResponseEntity photoEvent(@PathVariable Long id) {
		Event event=eventRepository.getOne(id);
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_GIF)
				.contentType(MediaType.IMAGE_JPEG)
				.contentType(MediaType.IMAGE_PNG)
				.body(new InputStreamResource(new ByteArrayInputStream(event.getPhoto())));
		
	}
	
	
	
	@GetMapping("/artist/{id}")
	public ResponseEntity photoArtist(@PathVariable Long id) {
		Artist artist = artistRepository.getOne(id);
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_GIF)
				.contentType(MediaType.IMAGE_JPEG)
				.contentType(MediaType.IMAGE_PNG)
				.body(new InputStreamResource(new ByteArrayInputStream(artist.getPhoto())));
		
	}

}
