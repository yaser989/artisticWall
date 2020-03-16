package org.openup.service;

import java.util.ArrayList;
import java.util.List;

import org.openup.DTO.EventDto;
import org.openup.entity.Event;
import org.openup.mapper.EventMapper;
import org.openup.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
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
	
	public List<EventDto> findById(Long id){
		List<EventDto> listEventDto = new ArrayList<>();
		List<Event> listEvent = eventRepository.findEventById(id);
		for (Event event : listEvent) {
			listEventDto.add(eventMapper.toEventDto(event));
		}
		return listEventDto;
	}
	
	
	
	
}
