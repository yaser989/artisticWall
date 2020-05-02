package org.openup.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.openup.DTO.AdminDto;
import org.openup.entity.Event;
import org.openup.mapper.AdminMapper;
import org.openup.repo.ArtistRepository;
import org.openup.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminServise {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private ArtistRepository artistRepository;
	
	
	@Autowired
	private AdminMapper adminMapper;
	
	
	public List<AdminDto> finAll(){
		
		List<AdminDto> listAdmintDto = new ArrayList();
        List<Event> listevent = eventRepository.AdminfindAll();
		for (Event ev : listevent) {
			listAdmintDto.add(adminMapper.adminDto(ev));
		}
		return listAdmintDto;
		
	}


	
	
}
