package com.java.shopshore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.shopshore.entities.Categorys;
import com.java.shopshore.repository.CategoryRepository;
import com.java.shopshore.service.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Categorys> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

}
