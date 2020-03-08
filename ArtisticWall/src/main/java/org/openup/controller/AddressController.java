package org.openup.controller;

import org.openup.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/address")
@CrossOrigin(origins="*")
public class AddressController {

	@Autowired
	private AddressService addressService;
}
