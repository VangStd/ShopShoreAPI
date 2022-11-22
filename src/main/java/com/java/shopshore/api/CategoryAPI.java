package com.java.shopshore.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.shopshore.entities.Categorys;
import com.java.shopshore.service.CategoryService;

@RestController
public class CategoryAPI {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/api/category/")
	public ResponseEntity<List<Categorys>> getAllCategory() {
		return new ResponseEntity<List<Categorys>>(categoryService.findAll(), HttpStatus.OK);
	}
}
