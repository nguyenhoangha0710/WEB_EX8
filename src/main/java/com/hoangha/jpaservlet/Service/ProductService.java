package com.hoangha.jpaservlet.Service;

import com.hoangha.jpaservlet.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();

    ProductDTO GetProductByID(int id);

    void addProduct(ProductDTO product);

    void updateProduct(ProductDTO product);

    void deleteProduct(int id);

    List<ProductDTO> findByCategory(int categoryId);
}
