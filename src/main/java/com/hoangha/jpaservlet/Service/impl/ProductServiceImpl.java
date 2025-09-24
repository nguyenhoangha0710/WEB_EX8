package com.hoangha.jpaservlet.Service.impl;

import com.hoangha.jpaservlet.DTO.ProductDTO;
import com.hoangha.jpaservlet.Entity.ProductEntity;
import com.hoangha.jpaservlet.Respository.ProductRespository;
import com.hoangha.jpaservlet.Respository.impl.ProductRespositoryImpl;
import com.hoangha.jpaservlet.Service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private ProductRespository productRespository = new ProductRespositoryImpl();

    @Override
    public List<ProductDTO> findAll() {
        // Lấy danh sách Entity từ repository
        List<ProductEntity> entities = productRespository.findAll();

        // Chuyển từ Entity sang DTO
        return entities.stream()
                .map(e -> new ProductDTO(
                        e.getId(),
                        e.getCode(),
                        e.getName(),
                        e.getPrice()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO GetProductByID(int id) {
        ProductEntity productEntity = productRespository.findProductById(id);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setName(productEntity.getName());
        productDTO.setCode(productEntity.getCode());
        productDTO.setPrice(productEntity.getPrice());
        return productDTO;
    }

    @Override
    public void addProduct(ProductDTO product) {
        ProductEntity entity = new ProductEntity();
        entity.setName(product.getName());
        entity.setCode(product.getCode());
        entity.setPrice(product.getPrice());

        productRespository.addProduct(entity); // Gọi repository để thêm vào DB
    }

    @Override
    public void updateProduct(ProductDTO product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());  // cần ID để biết sửa cái nào
        entity.setName(product.getName());
        entity.setCode(product.getCode());
        entity.setPrice(product.getPrice());

        productRespository.updateProduct(entity); // Gọi repository để update
    }

    @Override
    public void deleteProduct(int id) {
        productRespository.deleteProduct(id); // Gọi repository để xóa theo ID
    }

    @Override
    public List<ProductDTO> findByCategory(int categoryId) {
        List<ProductEntity> products = productRespository.findByCategoryId(categoryId);

        // convert sang DTO
        return products.stream()
                .map(e -> new ProductDTO(
                        e.getId(),
                        e.getCode(),
                        e.getName(),
                        e.getPrice()
                ))
                .collect(Collectors.toList());
    }
}
