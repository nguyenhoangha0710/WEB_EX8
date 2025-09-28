package com.example.productmanager.graphql;

import com.example.productmanager.entity.Category;
import com.example.productmanager.entity.Product;
import com.example.productmanager.entity.User;
import com.example.productmanager.service.CategoryService;
import com.example.productmanager.service.ProductService;
import com.example.productmanager.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;


record UserInput(String fullname, String email, String password, String phone) {}
record CategoryInput(String name, String images) {}
record ProductInput(String title, Integer quantity, String desc, Double price, Long userId, List<Long> categoryIds) {}


record LoginResponse(Long id, String fullname, String email, String phone) {}

@Controller
public class MutationResolver {

    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    public MutationResolver(UserService userService, CategoryService categoryService, ProductService productService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }


    @MutationMapping
    public User createUser(@Argument("input") UserInput input) {
        User user = User.builder()
                .fullname(input.fullname())
                .email(input.email())
                .password(input.password())
                .phone(input.phone())
                .build();
        return userService.save(user);
    }

    @MutationMapping
    public User updateUser(@Argument("id") Long id, @Argument("input") UserInput input) {
        User existing = userService.findById(id).orElseThrow();
        existing.setFullname(input.fullname());
        existing.setEmail(input.email());
        existing.setPassword(input.password());
        existing.setPhone(input.phone());
        return userService.save(existing);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument("id") Long id) {
        userService.deleteById(id);
        return true;
    }

    @MutationMapping
    public Category createCategory(@Argument("input") CategoryInput input) {
        Category c = Category.builder()
                .name(input.name())
                .images(input.images())
                .build();
        return categoryService.save(c);
    }

    @MutationMapping
    public Category updateCategory(@Argument("id") Long id, @Argument("input") CategoryInput input) {
        Category c = categoryService.findById(id).orElseThrow();
        c.setName(input.name());
        c.setImages(input.images());
        return categoryService.save(c);
    }

    @MutationMapping
    public Boolean deleteCategory(@Argument("id") Long id) {
        categoryService.deleteById(id);
        return true;
    }

    @MutationMapping
    public Product createProduct(@Argument("input") ProductInput input) {
        Product p = Product.builder()
                .title(input.title())
                .quantity(input.quantity())
                .desc(input.desc())
                .price(input.price() == null ? null : java.math.BigDecimal.valueOf(input.price()))
                .build();
        Set<Long> categoryIds = input.categoryIds() == null ? null : Set.copyOf(input.categoryIds());
        return productService.save(p, input.userId(), categoryIds);
    }

    @MutationMapping
    public Product updateProduct(@Argument("id") Long id, @Argument("input") ProductInput input) {
        Product existing = productService.findById(id).orElseThrow();
        existing.setTitle(input.title());
        existing.setQuantity(input.quantity());
        existing.setDesc(input.desc());
        if (input.price() != null) {
            existing.setPrice(java.math.BigDecimal.valueOf(input.price()));
        }
        Set<Long> categoryIds = input.categoryIds() == null ? null : Set.copyOf(input.categoryIds());
        return productService.save(existing, input.userId(), categoryIds);
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument("id") Long id) {
        productService.deleteById(id);
        return true;
    }


    @MutationMapping
    public LoginResponse login(@Argument("email") String email,
                               @Argument("password") String password) {
        Optional<User> user = userService.login(email, password);
        return user.map(u -> new LoginResponse(u.getId(), u.getFullname(), u.getEmail(), u.getPhone()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
