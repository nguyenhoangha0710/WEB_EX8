package com.hoangha.jpaservlet.Respository;

import com.hoangha.jpaservlet.Entity.ProductEntity;

import java.util.List;

public interface ProductRespository {
    List<ProductEntity> findAll();

    ProductEntity findProductById(int id);

    void addProduct(ProductEntity entity);

    void updateProduct(ProductEntity entity);

    void deleteProduct(int id);

    List<ProductEntity> findByCategoryId(int categoryId);
}
