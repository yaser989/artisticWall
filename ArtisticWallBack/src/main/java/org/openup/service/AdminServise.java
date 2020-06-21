package org.openup.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.openup.DTO.AdminDto;
import org.openup.DTO.EventDto;
import org.openup.entity.Address;
import org.openup.entity.Artist;
import org.openup.entity.ArtistDomain;
import org.openup.entity.Categories;
import org.openup.entity.Event;
import org.openup.entity.Role;
import org.openup.mapper.AdminMapper;
import org.openup.repo.ArtistRepository;
import org.openup.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminServise {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ArtistRepository artistRepository;
	
	
	@Autowired
	private AdminMapper adminMapper;
	
	
	public List<AdminDto> finAll(){
		
		List<AdminDto> listAdmintDto = new ArrayList();
        List<Event> listevent = eventRepository.findAll();
		for (Event ev : listevent) {
			listAdmintDto.add(adminMapper.adminDto(ev));
		}
		return listAdmintDto;	
	}
	
	

	public AdminDto deleteEvent(Long id) {
		AdminDto adminDto = new AdminDto();
		
	    Event  event = eventRepository.getOne(id);      
		
		if (event != null) {
		        eventRepository.delete(event);
		 		eventRepository.flush();        
		}
			 
	
			 return adminDto;
		}
	

	public AdminDto updateEvent (Long id, AdminDto adminDto) {

		Address address = Address.builder().common(adminDto.getCommonDto()).street(adminDto.getStreetDto())
				.zipCode(adminDto.getZipCodeDto()).phone(adminDto.getPhoneDto())
				.date(adminDto.getDateDto()).build();
		
		Categories categories = Categories.builder().categories(adminDto.getCategoriesDto()).build();
		
		Event toEvent = Event.builder().typeEvent(adminDto.getTypeEventDto()).description(adminDto.getDescriptionDto())
				.date(adminDto.getDateOfCreatingDto()).build();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
	    Date date = new Date();  
	    
		ArtistDomain artistDomain= ArtistDomain.builder().domain(adminDto.getArtistDomain()).build();
		
		Artist toPersist = Artist.builder().name(adminDto.getArtistName()).lastName(adminDto.getArtistLastName())
				.mail(adminDto.getArtistMail()).password(adminDto.getArtistPassword()).photo(adminDto.getArtistPhoto())
				.build();
		
		Role role = Role.builder().roleName(adminDto.getRoleName()).build();
		
		toPersist.setArtistDomain(artistDomain);
		toPersist.setRole(role);
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
	        event.getArtist().setName(toPersist.getName());
	        event.getArtist().setLastName(toPersist.getLastName());
	        event.getArtist().setMail(toPersist.getMail());
	        event.getArtist().setPassword(bCryptPasswordEncoder.encode(toPersist.getPassword()));
	        event.getArtist().getArtistDomain().setDomain(artistDomain.getDomain());
	        event.getArtist().getRole().setRoleName(role.getRoleName());
	       
	  Event saveEvent =  eventRepository.save(event);
	 
	  adminDto.setIdEvent(saveEvent.getId());
		
		}
	
		return adminDto;
	}
	
	public AdminDto findByID (Long id) {
		AdminDto adminDto = new AdminDto();
		Event toEvent = new Event();

		Optional<Event> events =  eventRepository.findById(id);
		if(events.isPresent()) {
		toEvent = events.get();
		adminDto.setArtistDomain(toEvent.getArtist().getArtistDomain().getDomain());
		adminDto.setArtistName(toEvent.getArtist().getName());
		adminDto.setArtistLastName(toEvent.getArtist().getLastName());
		adminDto.setArtistMail(toEvent.getArtist().getMail());
		adminDto.setArtistPassword(toEvent.getArtist().getPassword());
		adminDto.setCategoriesDto(toEvent.getCategories().getCategories());
		adminDto.setDescriptionDto(toEvent.getDescription());
		adminDto.setRoleName(toEvent.getArtist().getRole().getRoleName());
		adminDto.setTypeEventDto(toEvent.getTypeEvent());
		adminDto.setCommonDto(toEvent.getAddress().getCommon());
		adminDto.setStreetDto(toEvent.getAddress().getStreet());
		adminDto.setZipCodeDto(toEvent.getAddress().getZipCode());
		adminDto.setPhoneDto(toEvent.getAddress().getPhone());
		adminDto.setDateDto(toEvent.getAddress().getDate());
		adminDto.setDateOfCreatingDto(toEvent.getDate());
		adminDto.setIdOwnerDto(toEvent.getIdOwner());
		adminDto.setShared(toEvent.isShared());
		adminDto.setIdEvent(toEvent.getId());
		}
		return adminDto;
	}
	
	
}
