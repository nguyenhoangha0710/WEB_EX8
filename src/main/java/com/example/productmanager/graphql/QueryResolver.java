package com.example.productmanager.graphql;

import com.example.productmanager.entity.Product;
import com.example.productmanager.entity.User;
import com.example.productmanager.entity.Category;
import com.example.productmanager.service.ProductService;
import com.example.productmanager.service.UserService;
import com.example.productmanager.service.CategoryService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QueryResolver {

    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    public QueryResolver(UserService userService,
                         CategoryService categoryService,
                         ProductService productService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }


    @QueryMapping
    public List<User> users() {
        return userService.findAll();
    }

    @QueryMapping
    public User user(@Argument("id") Long id) {
        return userService.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @QueryMapping
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @QueryMapping
    public Category category(@Argument("id") Long id) {
        return categoryService.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }


    @QueryMapping
    public List<Product> products() {
        return productService.findAll();
    }

    @QueryMapping
    public Product product(@Argument("id") Long id) {
        return productService.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @QueryMapping
    public List<Product> productsByPriceAsc() {
        return productService.findAllByPriceAsc();
    }

    @QueryMapping
    public List<Product> productsByCategory(@Argument("categoryId") Long categoryId) {
        return productService.findAllByCategory(categoryId);
    }
}
