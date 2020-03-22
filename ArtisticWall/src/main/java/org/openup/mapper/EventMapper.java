package org.openup.mapper;

import org.openup.DTO.EventDto;
import org.openup.entity.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

	public EventDto toEventDto(Event event) {	
		EventDto eventDto = new EventDto();
		eventDto.setIdDto(event.getId());
		eventDto.setCategoriesDto(event.getCategories().getCategories());
		eventDto.setDescriptionDto(event.getDescription());
		eventDto.setTypeEventDto(event.getTypeEvent());
		eventDto.setPhotoDto(event.getPhoto());
		eventDto.setCommonDto(event.getAddress().getCommon());
		eventDto.setDateDto(event.getAddress().getDate());
		eventDto.setDateOfCreatingDto(event.getDate());
		eventDto.setIdOwnerDto(event.getIdOwner());
		eventDto.setPhoneDto(event.getAddress().getPhone());
		eventDto.setIdOwnerDto(event.getIdOwner());
		eventDto.setStreetDto(event.getAddress().getStreet());
		eventDto.setZipCodeDto(event.getAddress().getZipCode());
		return eventDto;
	}
}
