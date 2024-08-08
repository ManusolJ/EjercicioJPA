package com.eoi.es.service;

import com.eoi.es.entity.Cuenta;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import com.eoi.es.entity.Cliente;

import java.io.Serializable;


public class ClienteService implements Service {

    EntityManager entityManager = Persistence.createEntityManagerFactory("ClientesSucursalesPU").createEntityManager();

    public void Create(Object cliente) {
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    public Cliente findObjectByKey(Object DNI) {
        return entityManager.find(Cliente.class, DNI);
    }

    public void Update(Object cliente) {
        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    public void Delete(Object cliente) {
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
    }
}
