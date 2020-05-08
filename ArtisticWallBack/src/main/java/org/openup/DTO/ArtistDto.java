package org.openup.DTO;

import java.io.Serializable;
import java.util.Arrays;

public class ArtistDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Long id;
	private String artistName;
	private String artistLastName;
	private String artistMail;
	private String artistPassword;
	private String artistDomain;
	private String artistRole;
	private byte[] artistPhoto;
	
	
	
	public ArtistDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ArtistDto(Long id, String artistName, String artistLastName, String artistMail, String artistPassword,
			String artistDomain, String artistRole, byte[] artistPhoto) {
		super();
		this.id = id;
		this.artistName = artistName;
		this.artistLastName = artistLastName;
		this.artistMail = artistMail;
		this.artistPassword = artistPassword;
		this.artistDomain = artistDomain;
		this.artistRole = artistRole;
		this.artistPhoto = artistPhoto;
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



	public String getArtistRole() {
		return artistRole;
	}



	public void setArtistRole(String artistRole) {
		this.artistRole = artistRole;
	}



	public byte[] getArtistPhoto() {
		return artistPhoto;
	}



	public void setArtistPhoto(byte[] artistPhoto) {
		this.artistPhoto = artistPhoto;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "ArtistDto [id=" + id + ", artistName=" + artistName + ", artistLastName=" + artistLastName
				+ ", artistMail=" + artistMail + ", artistPassword=" + artistPassword + ", artistDomain=" + artistDomain
				+ ", artistRole=" + artistRole + ", artistPhoto=" + Arrays.toString(artistPhoto) + "]";
	}
	
}