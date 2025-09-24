package com.hoangha.jpaservlet.Respository.impl;

import com.hoangha.jpaservlet.Entity.CategoryEntity;
import com.hoangha.jpaservlet.Entity.ProductEntity;
import com.hoangha.jpaservlet.Respository.CategoryRespository;
import com.hoangha.jpaservlet.config.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class CategoryRespositoryImpl implements CategoryRespository {



    @Override
    public List<CategoryEntity> getCategories() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM CategoryEntity c", CategoryEntity.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
