package com.eoi.es.service;

import com.eoi.es.DAO.ClienteDaoJpaImpl;
import com.eoi.es.entity.Cliente;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClienteService {

    private static final ClienteDaoJpaImpl clienteDao = new ClienteDaoJpaImpl();
    public static Scanner sc = new Scanner(System.in);

    public Cliente findClienteByDNI() {
        System.out.println("Ingrese el DNI: ");
        String DNI = validateDNI();
        return clienteDao.findObjectByKey(DNI);
    }

    public void createCliente() {
        System.out.println("Creando un cliente.");
        Cliente cliente = new Cliente();
        dataInput(cliente,false);
        clienteDao.Create(cliente);
        System.out.println("Cliente creado con exito.");
    }

    public void updateCliente() {
        System.out.println("Modificando un cliente.");
        Cliente cliente = new Cliente();
        dataInput(cliente,true);
        clienteDao.Update(cliente);
        System.out.println("Cliente modificado con exito.");
    }

    public void deleteCliente() {
        System.out.println("Eliminando un cliente.");
        clienteDao.Delete(findClienteByDNI());
        System.out.println("Cliente eliminado con exito.");
    }

    public void FindAllClientes() {
        System.out.println("Listando todos los clientes.");
        List<Cliente> clientes = clienteDao.findAll();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
            System.out.println("--------------------");
        }
    }

    public String validateDNI(){
        String DNI = sc.next();
        while (!(DNI.matches("^[0-9]{8}[A-Z]$"))){
            System.out.println("Este no es un formato de DNI valido. Use el siguiente: 11111111X");
            DNI = sc.next();
        }
        return DNI;
    }

    public void dataInput(Cliente cliente, boolean isUpdate) {
        System.out.println("Ingrese el DNI: ");
        String DNI = validateDNI();

        if(!isUpdate) {
            while (clienteDao.findObjectByKey(DNI) != null) {
                System.out.println("El cliente ya existe!");
                System.out.println("Ingrese el DNI de nuevo: ");
                DNI = validateDNI();
            }
        }else{
            while (clienteDao.findObjectByKey(DNI) == null) {
                System.out.println("El cliente no existe!");
                System.out.println("Ingrese el DNI de nuevo: ");
                DNI = validateDNI();
            }
        }
        cliente.setDNI_Cliente(DNI);
        System.out.println("Ingrese el nombre: ");
        sc.nextLine();
        cliente.setNombreCliente(sc.nextLine());
        System.out.println("Ingrese la direccion: ");
        cliente.setDireccionCliente(sc.nextLine());
    }
}