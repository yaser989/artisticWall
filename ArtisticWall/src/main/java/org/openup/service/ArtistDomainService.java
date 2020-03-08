package org.openup.service;

import org.openup.repo.ArtistDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistDomainService {

	@Autowired
	private ArtistDomainRepository artistDomainRepository;
}
