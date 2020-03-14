package org.openup.service;

import java.util.ArrayList;
import java.util.List;

import org.openup.DTO.ArtistDto;
import org.openup.entity.Artist;
import org.openup.entity.Role;
import org.openup.mapper.ArtistMapper;
import org.openup.repo.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;

	@Autowired
	private ArtistMapper artistMapper;

	public List<ArtistDto> findAll() {
		List<ArtistDto> listArtistDto = new ArrayList();

		List<Artist> listArtist = artistRepository.findAll();

		for (Artist art : listArtist) {
			listArtistDto.add(artistMapper.artistToDto(art));
		}
		return listArtistDto;
	}

	public Artist findById(Long id) {
		return artistRepository.findTransaksisByAccountIdOrderById(id);
	}

	public Artist createNewArtist(Artist artist) {
		Role role = new Role();
		role.setRoleName("ROLE_USER");
		artist.setRole(role);
		return artistRepository.save(artist);
	}

	public Artist login(String mail, String password) {
		Artist authenticatedArtist = artistRepository.findByMailAndPassword(mail, password);
		return authenticatedArtist;
	}

}
