package org.openup.DTO;

import java.io.Serializable;

public class ArtistDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ArtistName;
	private String ArtistLastName;
	private String ArtistMail;
	private String ArtistPassword;
	private byte[] ArtistPhoto;
	private String ArtistDomain;
	
	public String getArtistName() {
		return ArtistName;
	}
	public void setArtistName(String artistName) {
		ArtistName = artistName;
	}
	public String getArtistLastName() {
		return ArtistLastName;
	}
	public void setArtistLastName(String artistLastName) {
		ArtistLastName = artistLastName;
	}
	public String getArtistMail() {
		return ArtistMail;
	}
	public void setArtistMail(String artistMail) {
		ArtistMail = artistMail;
	}
	public String getArtistPassword() {
		return ArtistPassword;
	}
	public void setArtistPassword(String artistPassword) {
		ArtistPassword = artistPassword;
	}
	public byte[] getArtistPhoto() {
		return ArtistPhoto;
	}
	public void setArtistPhoto(byte[] artistPhoto) {
		ArtistPhoto = artistPhoto;
	}
	public String getArtistDomain() {
		return ArtistDomain;
	}
	public void setArtistDomain(String artistDomain) {
		ArtistDomain = artistDomain;
	}
	
	
	
}
