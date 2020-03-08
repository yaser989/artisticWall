package org.openup.service;

import org.openup.repo.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;
}
