package com.example.productmanager.service;

import com.example.productmanager.entity.Category;
import com.example.productmanager.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() { return categoryRepository.findAll(); }
    public Optional<Category> findById(Long id) { return categoryRepository.findById(id); }
    public Category save(Category category) { return categoryRepository.save(category); }
    public void deleteById(Long id) { categoryRepository.deleteById(id); }
}


