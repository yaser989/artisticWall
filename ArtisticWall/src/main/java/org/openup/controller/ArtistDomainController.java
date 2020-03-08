package org.openup.controller;

import org.openup.service.ArtistDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/artistDomain")
@CrossOrigin(origins="*")
public class ArtistDomainController {

	@Autowired
	private ArtistDomainService artistDomainService;
}
