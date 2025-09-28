package com.example.productmanager.service;

import com.example.productmanager.entity.Category;
import com.example.productmanager.entity.Product;
import com.example.productmanager.entity.User;
import com.example.productmanager.repository.CategoryRepository;
import com.example.productmanager.repository.ProductRepository;
import com.example.productmanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository,
                          UserRepository userRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public List<Product> findAll() { return productRepository.findAll(); }
    public Optional<Product> findById(Long id) { return productRepository.findById(id); }
    public void deleteById(Long id) { productRepository.deleteById(id); }
    public List<Product> findAllByPriceAsc() { return productRepository.findAllByOrderByPriceAsc(); }
    public List<Product> findAllByCategory(Long categoryId) { return productRepository.findAllByCategoryId(categoryId); }

    public Product save(Product product, Long userId, Set<Long> categoryIds) {
        if (userId != null) {
            User user = userRepository.findById(userId).orElseThrow();
            product.setUser(user);
        }
        if (categoryIds != null) {
            Set<Category> categories = new HashSet<>(categoryRepository.findAllById(categoryIds));
            product.setCategories(categories);
        }
        return productRepository.save(product);
    }
}


