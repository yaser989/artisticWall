package org.openup.mapper;

import org.openup.DTO.AdminDto;
import org.openup.entity.Event;
import org.springframework.stereotype.Component;


/*
 * AdminMapper to map entity artist and event with adminDto
 */

@Component
public class AdminMapper {

	public AdminDto adminDto (Event event) {
	
		AdminDto adminDto = new AdminDto ();
		
	
		adminDto.setIdEvent(event.getId());
		adminDto.setId(event.getArtist().getId());
		adminDto.setArtistDomain(event.getArtist().getArtistDomain().getDomain());
		adminDto.setArtistName(event.getArtist().getName());
		adminDto.setArtistLastName(event.getArtist().getLastName());
		adminDto.setArtistMail(event.getArtist().getMail());
		adminDto.setDateOfCreatingDto(event.getDate());
		adminDto.setCategoriesDto(event.getCategories().getCategories());
		adminDto.setTypeEventDto(event.getTypeEvent());
		adminDto.setDescriptionDto(event.getDescription());
		adminDto.setArtistPassword(event.getArtist().getPassword());
		adminDto.setCommonDto(event.getAddress().getCommon());
		adminDto.setStreetDto(event.getAddress().getStreet());
		adminDto.setZipCodeDto(event.getAddress().getZipCode());
		adminDto.setPhoneDto(event.getAddress().getPhone());
		adminDto.setDateDto(event.getAddress().getDate());
		adminDto.setRoleName(event.getArtist().getRole().getRoleName());
		adminDto.setIdOwnerDto(event.getIdOwner());
		adminDto.setShared(event.isShared());
		
		
		return adminDto;
	}
}
