package org.openup.service;

import java.util.List;

import org.openup.entity.Artist;
import org.openup.entity.Role;
import org.openup.repo.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;
	
	public List<Artist> findAll(){

		return artistRepository.findAll();
	}
	
	public Artist findById(Long id){
		return artistRepository.findTransaksisByAccountIdOrderById(id);
	}
	
	public Artist createNewArtist(Artist artist) {
	   Role role = new Role();
	   role.setRoleName("ROLE_USER");
	   artist.setRole(role);
		return artistRepository.save(artist);
	}
	
	public Artist login(String mail,String password) {
	Artist authenticatedArtist=artistRepository.findByMailAndPassword(mail, password);
	 return authenticatedArtist;
	}
	
	
}
