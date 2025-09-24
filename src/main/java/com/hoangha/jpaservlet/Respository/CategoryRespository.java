package com.hoangha.jpaservlet.Respository;

import com.hoangha.jpaservlet.Entity.CategoryEntity;

import java.util.List;

public interface CategoryRespository {
    public List<CategoryEntity> getCategories();
}
