package com.company.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.type.TypeVariableToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.company.dto.CategoryDTO;
import com.company.entity.Category;
import com.company.form.CategoryFilterForm;
import com.company.repository.ICategoryRepository;
import com.company.specification.CategorySpecification;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Page<CategoryDTO> getAllCategories(Pageable pageable, CategoryFilterForm filterForm) {
		Specification<Category> where = CategorySpecification.buildWhere(filterForm);
		Page<Category> entityPage = categoryRepository.findAll(where, pageable);
		List<CategoryDTO> dtos = modelMapper.map(entityPage.getContent(), new TypeToken<List<CategoryDTO>>() {
		}.getType());
		Page<CategoryDTO> page = new PageImpl<>(dtos, pageable, entityPage.getTotalElements());
		return page;
	}

}
