package org.openup.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openup.DTO.EventDto;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/photos")
@CrossOrigin(origins="*",maxAge = 3600)
public class PhotoController {
	
	@Autowired
	private ArtistRepository artistRepository;
	
	@Autowired
	private EventRepository eventRepository; 
	
	
	@GetMapping("/event/{id}")
	public ResponseEntity photoEvent(@PathVariable Long id) {
		EventDto eventDto = new EventDto();
		 Event event = Event.builder().photo(eventDto.getPhotoDto()).build();
	      event=eventRepository.getOne(id);
	      eventDto.setPhotoDto(event.getPhoto());  
	      
	      eventDto.setId(event.getId());
		
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_GIF)
				.contentType(MediaType.IMAGE_JPEG)
				.contentType(MediaType.IMAGE_PNG)
				.body(new InputStreamResource(new ByteArrayInputStream(eventDto.getPhotoDto())));
	}
	
	@PostMapping("/uploadPhoto/{id}")
    public ResponseEntity<EventDto> uploadPhoto(@PathVariable Long id, MultipartFile file) throws IOException {
		EventDto eventDto = new EventDto();
		 Event event = Event.builder().photo(eventDto.getPhotoDto()).build();
		 byte[] byteObjects = new byte[file.getBytes().length];
		 int i= 0;
		 for (byte b : file.getBytes()){
		        byteObjects[i++] = b;
		    }
     event  = eventRepository.getOne(id);
    
     event.setPhoto(byteObjects);
     
     final Event eventSave = eventRepository.save(event);
       eventDto.setPhotoDto(event.getPhoto());
       
        eventDto.setId(eventSave.getId());
     return ResponseEntity.ok(eventDto);
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

	
//	@GetMapping("/event/{id}")
//	public ResponseEntity photoEvent(@PathVariable Long id) {
//		EventDto eventDto = new EventDto();
//		 Event event = Event.builder().photo(eventDto.getPhotoDto()).build();
//	      event=eventRepository.getOne(id);
//	      eventDto.setPhotoDto(event.getPhoto());  
//	      
//	      eventDto.setId(event.getId());
//		
//		return ResponseEntity.ok()
//				.contentType(MediaType.IMAGE_GIF)
//				.contentType(MediaType.IMAGE_JPEG)
//				.contentType(MediaType.IMAGE_PNG)
//				.body(new InputStreamResource(new StringBufferInputStream(eventDto.getPhotoDto())));
//	}
//
//	@PostMapping("/uploadPhoto/{id}")
//    public EventDto uploadPhoto(MultipartFile file, @PathVariable Long id) throws IOException {
//		EventDto eventDto = new EventDto();
//		 Event event = Event.builder().photo(eventDto.getPhotoDto()).build();
//	          
//     event  = eventRepository.getOne(id);
//     event.setPhoto(file.getOriginalFilename());
//        Files.write(Paths.get(System.getProperty("user.home") + event.getPhoto()), file.getBytes());
//
//       eventDto.setPhotoDto(event.getPhoto());
//        Event eventSave = eventRepository.save(event);
//        eventDto.setId(eventSave.getId());
//     return eventDto;
//    }
}
