package org.openup.service;

import org.openup.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
}
