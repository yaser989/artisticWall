package org.openup.service;

import org.openup.repo.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

	@Autowired
	private CategoriesRepository categoriesRepository;
}
