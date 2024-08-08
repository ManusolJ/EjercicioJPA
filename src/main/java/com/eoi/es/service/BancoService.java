package com.eoi.es.service;

import com.eoi.es.entity.Banco;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class BancoService {

    EntityManager entityManager = Persistence.createEntityManagerFactory("ClientesSucursalesPU").createEntityManager();

    public void createBanco(Banco banco) {
        entityManager.getTransaction().begin();
        entityManager.persist(banco);
        entityManager.getTransaction().commit();
    }

    public Banco findBancoById(int id) {
        return entityManager.find(Banco.class, id);
    }

    public void updateBanco(Banco banco) {
        entityManager.getTransaction().begin();
        entityManager.merge(banco);
        entityManager.getTransaction().commit();
    }

    public void deleteBanco(Banco banco) {
        entityManager.getTransaction().begin();
        entityManager.remove(banco);
        entityManager.getTransaction().commit();
    }

}
