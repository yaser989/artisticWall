package org.openup.service;

import java.util.ArrayList;
import java.util.List;

import org.openup.DTO.EventDto;
import org.openup.controller.ResourceNotFound;
import org.openup.entity.Artist;
import org.openup.entity.Event;
import org.openup.mapper.EventMapper;
import org.openup.repo.ArtistRepository;
import org.openup.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private ArtistRepository artistRepository;
	
	@Autowired
	private EventMapper eventMapper;
	
	public List<EventDto> findAll(){
		List<EventDto> listEventDto = new ArrayList<>();
		List<Event> listEvent = eventRepository.findAll();
		for (Event event : listEvent) {
			listEventDto.add(eventMapper.toEventDto(event));
		}
		return listEventDto;
	}
	
	public List<EventDto> findAllArtistEventById(Long id){
		
		Artist artist = artistRepository.getOne(id);
		
		List<EventDto> listEventDto = new ArrayList<>();
		List<Event> eventList = eventRepository.findBySharedAndArtistIsNotLike(true, artist);
 		List<Event> listEvent = eventRepository.findByArtist(artist);
 		listEvent.forEach(event -> event.setIdOwner(id));
 		eventList.forEach(event -> event.setIdOwner(-1L));
 		listEvent.addAll(eventList);
 		
		for (Event event : listEvent) {
			listEventDto.add(eventMapper.toEventDto(event));
		}
		return listEventDto;
	}
	
	
	public Event createNewEvent(Event event , Long id) {
 
		return artistRepository.findById(id).map(artist-> {
			event.setArtist(artist);
			return eventRepository.save(event);
		}).orElseThrow(() -> new ResourceNotFound("not fond"));
		
	}
	
	
	
	
}
