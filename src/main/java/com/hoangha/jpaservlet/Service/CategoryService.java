package com.hoangha.jpaservlet.Service;

import com.hoangha.jpaservlet.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {
    public List<CategoryDTO> getCategories();
}
