package com.alkemy.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alkemy.challenge.dto.CategoryDto;
import com.alkemy.challenge.service.CategoryService;

@RestController
@RequestMapping ("/category")
public class CategoryController {

	@Autowired 
	CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto){
		
		CategoryDto dto=categoryService.saveCategory(categoryDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
		
		categoryService.deleteCategory(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
