package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.CategoryDTO;
import com.company.entity.Category;
import com.company.form.CategoryFilterForm;
import com.company.service.ICategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/categories")
@Validated
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping
	public Page<CategoryDTO> getAllCategories(Pageable pageable,@Valid CategoryFilterForm filterForm){
		return categoryService.getAllCategories(pageable,filterForm);
	}
}
