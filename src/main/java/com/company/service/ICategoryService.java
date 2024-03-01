package com.company.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.company.dto.CategoryDTO;
import com.company.entity.Category;
import com.company.form.CategoryFilterForm;

public interface ICategoryService {

	Page<CategoryDTO> getAllCategories(Pageable pageable, CategoryFilterForm filterForm);
}
