package com.eoi.es.service;
import com.eoi.es.entity.Cuenta;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CuentaService {

    EntityManager entityManager = Persistence.createEntityManagerFactory("ClientesSucursalesPU").createEntityManager();

    public void createCuenta(Cuenta cuenta) {
        entityManager.getTransaction().begin();
        entityManager.persist(cuenta);
        entityManager.getTransaction().commit();
    }

    public Cuenta findCuentaById(int id) {
        return entityManager.find(Cuenta.class, id);
    }

    public void updateCuenta(Cuenta cuenta) {
        entityManager.getTransaction().begin();
        entityManager.merge(cuenta);
        entityManager.getTransaction().commit();
    }

    public void deleteCuenta(Cuenta cuenta) {
        entityManager.getTransaction().begin();
        entityManager.remove(cuenta);
        entityManager.getTransaction().commit();
    }
}
