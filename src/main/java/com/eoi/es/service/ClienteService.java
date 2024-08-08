package com.eoi.es.service;

import com.eoi.es.entity.Cuenta;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import com.eoi.es.entity.Cliente;


public class ClienteService {

    EntityManager entityManager = Persistence.createEntityManagerFactory("ClientesSucursalesPU").createEntityManager();

    public void createCliente(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    public Cliente findClienteByDNI(String DNI) {
        return entityManager.find(Cliente.class, DNI);
    }

    public void updateCliente(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    public void deleteCliente(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
    }
}
