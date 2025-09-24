package com.hoangha.jpaservlet.Respository.impl;

import com.hoangha.jpaservlet.Entity.ProductEntity;
import com.hoangha.jpaservlet.Entity.UserEntity;
import com.hoangha.jpaservlet.Respository.UserRespository;
import com.hoangha.jpaservlet.config.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class UserRespositoryImpl implements UserRespository {

    @Override
    public UserEntity getUserByGmail(String gmail) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                            "SELECT u FROM UserEntity u WHERE u.gmail = :gmail", UserEntity.class)
                    .setParameter("gmail", gmail)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // không tìm thấy user
        } finally {
            em.close();
        }
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(userEntity); // merge sẽ update nếu entity tồn tại
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        } finally {
            em.close();
        }
    }
}
