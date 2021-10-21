package com.alkemy.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alkemy.challenge.dto.CategoryDto;
import com.alkemy.challenge.mapper.CategoryMapper;
import com.alkemy.challenge.model.Category;
import com.alkemy.challenge.repository.CategoryRepository;
import com.alkemy.challenge.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {

		Category category = categoryMapper.toCategory(categoryDto);

		category = categoryRepository.save(category);

		return categoryMapper.toCategoryDto(category);
	}
	
	public void deleteCategory(Long id) {
		
		categoryRepository.deleteById(id);
	}
}
