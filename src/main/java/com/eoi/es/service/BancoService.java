package com.eoi.es.service;

import com.eoi.es.entity.Banco;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class BancoService implements Service{

    EntityManager entityManager = Persistence.createEntityManagerFactory("ClientesSucursalesPU").createEntityManager();

    public void Create(Object banco) {
        entityManager.getTransaction().begin();
        entityManager.persist(banco);
        entityManager.getTransaction().commit();
    }

    public Banco findObjectByKey(Object id) {
        return entityManager.find(Banco.class, id);
    }

    public void Update(Object banco) {
        entityManager.getTransaction().begin();
        entityManager.merge(banco);
        entityManager.getTransaction().commit();
    }

    public void Delete  (Object banco) {
        entityManager.getTransaction().begin();
        entityManager.remove(banco);
        entityManager.getTransaction().commit();
    }

}
