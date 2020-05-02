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
	private byte[] artistPhoto;
	
	
	
	public ArtistDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ArtistDto(Long id, String artistName, String artistLastName, String artistMail, String artistPassword,
			byte[] artistPhoto, String artistDomain) {
		super();
		this.id = id;
		this.artistName = artistName;
		this.artistLastName = artistLastName;
		this.artistMail = artistMail;
		this.artistPassword = artistPassword;
		this.artistPhoto = artistPhoto;
		this.artistDomain = artistDomain;
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
	public byte[] getArtistPhoto() {
		return artistPhoto;
	}
	public void setArtistPhoto(byte[] artistPhoto) {
		this.artistPhoto = artistPhoto;
	}
	public String getArtistDomain() {
		return artistDomain;
	}
	public void setArtistDomain(String artistDomain) {
		this.artistDomain = artistDomain;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "ArtistDto [id=" + id + ", artistName=" + artistName + ", artistLastName=" + artistLastName
				+ ", artistMail=" + artistMail + ", artistPassword=" + artistPassword + ", artistDomain=" + artistDomain
				+ ", artistPhoto=" + Arrays.toString(artistPhoto) + "]";
	}


	
	
	
}
