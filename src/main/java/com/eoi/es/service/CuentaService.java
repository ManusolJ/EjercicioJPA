package com.eoi.es.service;
import com.eoi.es.entity.Cuenta;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CuentaService implements Service{

    EntityManager entityManager = Persistence.createEntityManagerFactory("ClientesSucursalesPU").createEntityManager();

    public void Create(Object cuenta) {
        entityManager.getTransaction().begin();
        entityManager.persist(cuenta);
        entityManager.getTransaction().commit();
    }

    public Cuenta findObjectByKey(Object id) {
        return entityManager.find(Cuenta.class, id);
    }

    public void Update(Object cuenta) {
        entityManager.getTransaction().begin();
        entityManager.merge(cuenta);
        entityManager.getTransaction().commit();
    }

    public void Delete(Object cuenta) {
        entityManager.getTransaction().begin();
        entityManager.remove(cuenta);
        entityManager.getTransaction().commit();
    }
}
