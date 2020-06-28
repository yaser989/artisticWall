package org.openup.mapper;

import org.openup.DTO.EventDto;
import org.openup.entity.Address;
import org.openup.entity.Event;
import org.springframework.stereotype.Component;

/*
 * EventMapper to map entity event with eventDto
 */

@Component
public class EventMapper {

	public EventDto toEventDto(Event event) {	
		EventDto eventDto = new EventDto();

		eventDto.setIdArtist(event.getArtist().getId());
		eventDto.setIdEvent(event.getId());
		eventDto.setArtistDomain(event.getArtist().getArtistDomain().getDomain());
		eventDto.setArtistName(event.getArtist().getName());
		eventDto.setArtistLastName(event.getArtist().getLastName());
		eventDto.setArtistMail(event.getArtist().getMail());
		eventDto.setDateOfCreatingDto(event.getDate());
		eventDto.setCategoriesDto(event.getCategories().getCategories());
		eventDto.setTypeEventDto(event.getTypeEvent());
		eventDto.setDescriptionDto(event.getDescription());
		eventDto.setArtistPassword(event.getArtist().getPassword());
		eventDto.setCommonDto(event.getAddress().getCommon());
		eventDto.setStreetDto(event.getAddress().getStreet());
		eventDto.setZipCodeDto(event.getAddress().getZipCode());
		eventDto.setPhoneDto(event.getAddress().getPhone());
		eventDto.setDateDto(event.getAddress().getDate());
		eventDto.setRoleName(event.getArtist().getRole().getRoleName());
		eventDto.setIdOwnerDto(event.getIdOwner());
		eventDto.setShared(event.isShared());
		
		return eventDto;
	}
}
