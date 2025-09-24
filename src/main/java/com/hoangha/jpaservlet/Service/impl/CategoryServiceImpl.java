package com.hoangha.jpaservlet.Service.impl;

import com.hoangha.jpaservlet.DTO.CategoryDTO;
import com.hoangha.jpaservlet.Entity.CategoryEntity;
import com.hoangha.jpaservlet.Respository.CategoryRespository;
import com.hoangha.jpaservlet.Respository.impl.CategoryRespositoryImpl;
import com.hoangha.jpaservlet.Service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRespository categoryRespository= new CategoryRespositoryImpl();

    @Override
    public List<CategoryDTO> getCategories() {
        List<CategoryEntity> entities = categoryRespository.getCategories();
        List<CategoryDTO> categories = new ArrayList<>();

        for (CategoryEntity entity : entities) {
            CategoryDTO dto = new CategoryDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDescribe(entity.getDescribe());
            categories.add(dto);
        }
        return categories;
    }
}
