package com.hoangha.jpaservlet.DTO;

import com.hoangha.jpaservlet.Entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {


    private int id;

    private String name;

    private String describe;

    private List<ProductEntity> products= new ArrayList<ProductEntity>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
