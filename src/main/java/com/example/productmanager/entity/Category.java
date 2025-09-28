package com.example.productmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    private String images;

    @ManyToMany(mappedBy = "categories")
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();
}


