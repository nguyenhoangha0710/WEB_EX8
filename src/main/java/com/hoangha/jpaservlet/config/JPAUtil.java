package com.hoangha.jpaservlet.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("dataSource");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}