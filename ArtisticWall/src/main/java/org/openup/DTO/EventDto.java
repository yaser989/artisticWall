package org.openup.DTO;

import java.io.Serializable;
import java.util.Date;

public class EventDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idDto;
	private String typeEventDto;
	private String descriptionDto;
	private byte[] photoDto;
	private boolean sharedDto;
	private Long idOwnerDto;
	private String categoriesDto;
	private String streetDto;
	private String zipCodeDto;
	private String commonDto;
	private String phoneDto;
	private Date dateDto;
	private Date dateOfCreatingDto;
	
	public Long getIdDto() {
		return idDto;
	}
	public void setIdDto(Long idDto) {
		this.idDto = idDto;
	}
	public String getTypeEventDto() {
		return typeEventDto;
	}
	public void setTypeEventDto(String typeEventDto) {
		this.typeEventDto = typeEventDto;
	}
	public String getDescriptionDto() {
		return descriptionDto;
	}
	public void setDescriptionDto(String descriptionDto) {
		this.descriptionDto = descriptionDto;
	}
	public byte[] getPhotoDto() {
		return photoDto;
	}
	public void setPhotoDto(byte[] photoDto) {
		this.photoDto = photoDto;
	}
	public boolean isSharedDto() {
		return sharedDto;
	}
	public void setSharedDto(boolean sharedDto) {
		this.sharedDto = sharedDto;
	}
	public Long getIdOwnerDto() {
		return idOwnerDto;
	}
	public void setIdOwnerDto(Long idOwnerDto) {
		this.idOwnerDto = idOwnerDto;
	}
	public String getCategoriesDto() {
		return categoriesDto;
	}
	public void setCategoriesDto(String categoriesDto) {
		this.categoriesDto = categoriesDto;
	}
	public String getStreetDto() {
		return streetDto;
	}
	public void setStreetDto(String streetDto) {
		this.streetDto = streetDto;
	}
	public String getZipCodeDto() {
		return zipCodeDto;
	}
	public void setZipCodeDto(String zipCodeDto) {
		this.zipCodeDto = zipCodeDto;
	}
	public String getCommonDto() {
		return commonDto;
	}
	public void setCommonDto(String commonDto) {
		this.commonDto = commonDto;
	}
	public String getPhoneDto() {
		return phoneDto;
	}
	public void setPhoneDto(String phoneDto) {
		this.phoneDto = phoneDto;
	}
	public Date getDateDto() {
		return dateDto;
	}
	public void setDateDto(Date dateDto) {
		this.dateDto = dateDto;
	}
	public Date getDateOfCreatingDto() {
		return dateOfCreatingDto;
	}
	public void setDateOfCreatingDto(Date dateOfCreatingDto) {
		this.dateOfCreatingDto = dateOfCreatingDto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
