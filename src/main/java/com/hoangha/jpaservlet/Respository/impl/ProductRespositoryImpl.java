package com.hoangha.jpaservlet.Respository.impl;

import com.hoangha.jpaservlet.Entity.ProductEntity;
import com.hoangha.jpaservlet.Respository.ProductRespository;
import com.hoangha.jpaservlet.config.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductRespositoryImpl implements ProductRespository {

        @Override
        public List<ProductEntity> findAll() {
            EntityManager em = JPAUtil.getEntityManager();
            try {
                return em.createQuery("SELECT c FROM ProductEntity c", ProductEntity.class)
                        .getResultList();
            } finally {
                em.close();
            }
        }

    @Override
    public ProductEntity findProductById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Tìm ProductEntity theo id
            return em.find(ProductEntity.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public void addProduct(ProductEntity entity) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();   // Bắt đầu transaction
            em.persist(entity);           // Thêm entity mới
            em.getTransaction().commit(); // Commit transaction
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Rollback nếu lỗi
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateProduct(ProductEntity entity) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);             // Cập nhật entity
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteProduct(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            ProductEntity entity = em.find(ProductEntity.class, id);
            if (entity != null) {
                em.remove(entity);       // Xóa entity
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<ProductEntity> findByCategoryId(int categoryId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                            "SELECT p FROM ProductEntity p WHERE p.category.id = :categoryId",
                            ProductEntity.class
                    )
                    .setParameter("categoryId", categoryId)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
