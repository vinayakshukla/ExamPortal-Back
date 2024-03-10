package com.exam.examserver.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.model.exam.Category;
import com.exam.examserver.repository.CategoryRepository;
import com.exam.examserver.service.CategoryService;

@Service
public class CategoryServiceImpl implements  CategoryService{
    
	@Autowired
	public CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return this.categoryRepository.findAll().stream().collect(Collectors.toSet());
	}

	@Override
	public Category getCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long categoryId) {
	    this.categoryRepository.deleteById(categoryId);
		
	}


}
