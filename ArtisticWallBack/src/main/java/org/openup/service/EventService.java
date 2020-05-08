package org.openup.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.openup.DTO.ArtistDto;
import org.openup.DTO.EventDto;
import org.openup.entity.Address;
import org.openup.entity.Artist;
import org.openup.entity.ArtistDomain;
import org.openup.entity.Categories;
import org.openup.entity.Event;
import org.openup.mapper.EventMapper;
import org.openup.repo.ArtistRepository;
import org.openup.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
@Transactional
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
		List<EventDto> listEventDto = new ArrayList<>();
		
		ArtistDto artistDto = new ArtistDto();
		
        ArtistDomain domain = ArtistDomain.builder().domain(artistDto.getArtistDomain()).build();
		
		Artist art = Artist.builder().id(artistDto.getId()).name(artistDto.getArtistName())
			.lastName(artistDto.getArtistLastName()).mail(artistDto.getArtistMail()).password(artistDto.getArtistPassword())
				.photo(artistDto.getArtistPhoto()).event(new ArrayList<Event>()).build();
		
		art.setArtistDomain(domain);
		
        art = artistRepository.getOne(id);
	    List<Event> listEvent = eventRepository.findByArtist(art);
		List<Event> eventList = eventRepository.findBySharedAndArtistIsNotLike(true, art);
 		listEvent.forEach(event -> event.setIdOwner(id));
 		eventList.forEach(event -> event.setIdOwner(-1L));
 		listEvent.addAll(eventList);
 		
 		for (Event event : listEvent) {
 			listEventDto.add(eventMapper.toEventDto(event));
 		}
 		
		return  listEventDto;
	}
	
	public EventDto findEventById(Long id) {
	EventDto eventDto = new EventDto();
	
	Event toEvent = new  Event ();
	  
		Optional<Event> events = eventRepository.findById(id);
		toEvent = events.get();
		eventDto.setIdEvent(toEvent.getId());
		eventDto.setCategoriesDto(toEvent.getCategories().getCategories());
		eventDto.setTypeEventDto(toEvent.getTypeEvent());
		eventDto.setDescriptionDto(toEvent.getDescription());
		eventDto.setCommonDto(toEvent.getAddress().getCommon());
		eventDto.setDateDto(toEvent.getAddress().getDate());
		eventDto.setPhoneDto(toEvent.getAddress().getPhone());
		eventDto.setStreetDto(toEvent.getAddress().getStreet());
		eventDto.setZipCodeDto(toEvent.getAddress().getZipCode());
		return eventDto;
	}
	
	
	public List< EventDto> findEventbyConcert() {
		List<EventDto> listEventDto = new ArrayList<>();
		List<Event> listEvent = eventRepository.findByconcert("Concert");
		for (Event event : listEvent) {
			listEventDto.add(eventMapper.toEventDto(event));
		}
		return listEventDto;
	}
	public List< EventDto> findEventbyShow() {
		List<EventDto> listEventDto = new ArrayList<>();
		List<Event> listEvent = eventRepository.findByshow("Show");
		for (Event event : listEvent) {
			listEventDto.add(eventMapper.toEventDto(event));
		}
		return listEventDto;
	}
	public List< EventDto> findEventbyAudition() {
		List<EventDto> listEventDto = new ArrayList<>();
		List<Event> listEvent = eventRepository.findByaudition("Audition");
		for (Event event : listEvent) {
			listEventDto.add(eventMapper.toEventDto(event));
		}
		return listEventDto;
	}
	
	
	public EventDto createNewEvent(EventDto eventDto , Long id) {
		Address address = Address.builder().common(eventDto.getCommonDto()).street(eventDto.getStreetDto())
				.zipCode(eventDto.getZipCodeDto()).phone(eventDto.getPhoneDto())
				.date(eventDto.getDateDto()).build();
		
		Categories categories = Categories.builder().categories(eventDto.getCategoriesDto()).build();
		
		Event toEvent = Event.builder().typeEvent(eventDto.getTypeEventDto()).description(eventDto.getDescriptionDto())
				.date(eventDto.getDateOfCreatingDto()).build();
		
		
			
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
	    Date date = new Date();  
	  
	    
       ArtistDto artistDto = new ArtistDto();
		
       ArtistDomain domain = ArtistDomain.builder().domain(artistDto.getArtistDomain()).build();
		
	 Artist art = Artist.builder().id(artistDto.getId()).name(artistDto.getArtistName())
			.lastName(artistDto.getArtistLastName()).mail(artistDto.getArtistMail()).password(artistDto.getArtistPassword())
				.photo(artistDto.getArtistPhoto()).build();
		

		toEvent.setAddress(address);
		toEvent.setCategories(categories);
		address.setEvent(toEvent);
		art.setArtistDomain(domain);
		toEvent.setDate(date);
       art = artistRepository.getOne(id);
       toEvent.setArtist(art);
        
       Event eventSave = eventRepository.save(toEvent);
       eventDto.setIdEvent(eventSave.getId());
	 return eventDto;

	}
	
	public EventDto deleteEvent(Long id) {
	EventDto eventDto = new EventDto();
	
    Event  event = eventRepository.getOne(id);      
	
	if (event != null) {
	        eventRepository.delete(event);
	 		eventRepository.flush();        
	}
		 
		  eventDto.setIdEvent(event.getId());
		 return eventDto;
	}
	
	public EventDto updateEvent (Long id, EventDto eventDto) {

		Address address = Address.builder().common(eventDto.getCommonDto()).street(eventDto.getStreetDto())
				.zipCode(eventDto.getZipCodeDto()).phone(eventDto.getPhoneDto())
				.date(eventDto.getDateDto()).build();
		
		Categories categories = Categories.builder().categories(eventDto.getCategoriesDto()).build();
		
		Event toEvent = Event.builder().typeEvent(eventDto.getTypeEventDto()).description(eventDto.getDescriptionDto())
				.date(eventDto.getDateOfCreatingDto()).photo(eventDto.getEventPhoto()).build();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
	    Date date = new Date();  
	    
	    
		toEvent.setAddress(address);
		toEvent.setCategories(categories);
		address.setEvent(toEvent);
		toEvent.setDate(date);
	
		Optional<Event> events =  eventRepository.findById(id);
		if(events.isPresent()) {
			Event event = events.get();
			event.setDescription(toEvent.getDescription());
			event.setTypeEvent(toEvent.getTypeEvent());
			event.getCategories().setCategories(categories.getCategories());
	        event.getAddress().setCommon(address.getCommon());
	        event.getAddress().setDate(address.getDate());
	        event.getAddress().setPhone(address.getPhone());
	        event.getAddress().setStreet(address.getStreet());
	        event.getAddress().setZipCode(address.getZipCode());
	        event.getAddress().setDate(date);
//	        event.setPhoto(null);
	  Event saveEvent =    eventRepository.save(event);
	 
	  eventDto.setIdEvent(saveEvent.getId());
		System.out.println(eventDto.getIdEvent()+"======================================");
		}
	
		return eventDto;
	}
	
	
	public EventDto shareEvent (Long id , boolean isShared) {
		EventDto eventDto = new EventDto();
		
		Event event = eventRepository.getOne(id);
		event.setShared(!isShared);
		eventDto.setShared(!isShared);
	
		Event saveEvent =  eventRepository.save(event);
		eventDto.setIdEvent(saveEvent.getId());
		return eventDto;
	}
	
}
