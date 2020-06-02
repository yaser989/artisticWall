package org.openup.DTO;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Transient;

import org.openup.config.CustomerDateAndTimeDeserialize;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class AdminDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	    private Long idEvent;
	    private Long id;
		private String artistName;
		private String artistLastName;
		private String artistMail;
		private String artistPassword;
		private String artistDomain;
		private String roleName;
		private byte[] artistPhoto;
		private String typeEventDto;
		private String descriptionDto;
		private byte[] eventPhoto;
		private boolean shared;
		@Transient
		private Long idOwnerDto;
		private String categoriesDto;
		private String streetDto;
		private String zipCodeDto;
		private String commonDto;
		private String phoneDto;
		@JsonDeserialize(using= CustomerDateAndTimeDeserialize.class)
		private Date dateDto;
		@JsonDeserialize(using= CustomerDateAndTimeDeserialize.class)
		private Date dateOfCreatingDto;
		public AdminDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AdminDto(Long idEvent, Long id, String artistName, String artistLastName, String artistMail,
				String artistPassword, String artistDomain, String roleName, byte[] artistPhoto, String typeEventDto,
				String descriptionDto, byte[] eventPhoto, boolean shared, Long idOwnerDto, String categoriesDto,
				String streetDto, String zipCodeDto, String commonDto, String phoneDto, Date dateDto,
				Date dateOfCreatingDto) {
			super();
			this.idEvent = idEvent;
			this.id = id;
			this.artistName = artistName;
			this.artistLastName = artistLastName;
			this.artistMail = artistMail;
			this.artistPassword = artistPassword;
			this.artistDomain = artistDomain;
			this.roleName = roleName;
			this.artistPhoto = artistPhoto;
			this.typeEventDto = typeEventDto;
			this.descriptionDto = descriptionDto;
			this.eventPhoto = eventPhoto;
			this.shared = shared;
			this.idOwnerDto = idOwnerDto;
			this.categoriesDto = categoriesDto;
			this.streetDto = streetDto;
			this.zipCodeDto = zipCodeDto;
			this.commonDto = commonDto;
			this.phoneDto = phoneDto;
			this.dateDto = dateDto;
			this.dateOfCreatingDto = dateOfCreatingDto;
		}
		public Long getIdEvent() {
			return idEvent;
		}
		public void setIdEvent(Long idEvent) {
			this.idEvent = idEvent;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getArtistName() {
			return artistName;
		}
		public void setArtistName(String artistName) {
			this.artistName = artistName;
		}
		public String getArtistLastName() {
			return artistLastName;
		}
		public void setArtistLastName(String artistLastName) {
			this.artistLastName = artistLastName;
		}
		public String getArtistMail() {
			return artistMail;
		}
		public void setArtistMail(String artistMail) {
			this.artistMail = artistMail;
		}
		public String getArtistPassword() {
			return artistPassword;
		}
		public void setArtistPassword(String artistPassword) {
			this.artistPassword = artistPassword;
		}
		public String getArtistDomain() {
			return artistDomain;
		}
		public void setArtistDomain(String artistDomain) {
			this.artistDomain = artistDomain;
		}
		public String getRoleName() {
			return roleName;
		}
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
		public byte[] getArtistPhoto() {
			return artistPhoto;
		}
		public void setArtistPhoto(byte[] artistPhoto) {
			this.artistPhoto = artistPhoto;
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
		public byte[] getEventPhoto() {
			return eventPhoto;
		}
		public void setEventPhoto(byte[] eventPhoto) {
			this.eventPhoto = eventPhoto;
		}
		public boolean isShared() {
			return shared;
		}
		public void setShared(boolean shared) {
			this.shared = shared;
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
		@Override
		public String toString() {
			return "AdminDto [idEvent=" + idEvent + ", id=" + id + ", artistName=" + artistName
					+ ", artistLastName=" + artistLastName + ", artistMail=" + artistMail + ", artistPassword="
					+ artistPassword + ", artistDomain=" + artistDomain + ", roleName=" + roleName + ", artistPhoto="
					+ Arrays.toString(artistPhoto) + ", typeEventDto=" + typeEventDto + ", descriptionDto="
					+ descriptionDto + ", eventPhoto=" + Arrays.toString(eventPhoto) + ", shared=" + shared
					+ ", idOwnerDto=" + idOwnerDto + ", categoriesDto=" + categoriesDto + ", streetDto=" + streetDto
					+ ", zipCodeDto=" + zipCodeDto + ", commonDto=" + commonDto + ", phoneDto=" + phoneDto
					+ ", dateDto=" + dateDto + ", dateOfCreatingDto=" + dateOfCreatingDto + "]";
		}

	
		
}