package org.openup.controller;

import org.openup.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/categories")
@CrossOrigin(origins="*")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;
}
