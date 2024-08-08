package com.eoi.es.view;

import com.eoi.es.entity.Cliente;
import com.eoi.es.service.ClienteService;

import java.util.Scanner;

public class clienteMenu {

    public static ClienteService clienteService = new ClienteService();

    static final int LIST_CLIENT = 1;
    static final int CREATE_CLIENT = 2;
    static final int MODIFY_CLIENT = 3;
    static final int DELETE_CLIENT = 4;
    static final int LIST_ALL_CLIENTS = 5;
    static final int EXIT = 0;

    public static void printMenu(){
        System.out.println("Menu Clientes.");
        System.out.println("1 - Listar un cliente.");
        System.out.println("2 - Crear un cliente.");
        System.out.println("3 - Modificar un cliente.");
        System.out.println("4 - Eliminar un cliente.");
        System.out.println("5 - Listar todos los clientes.");
        System.out.println("0 - Salir.");

    }

    public static void actionMenu(){
        int option;
        Scanner sc;
        do {
            sc = new Scanner(System.in);
            printMenu();
            option = sc.nextInt();
            switch (option){
                case LIST_CLIENT:
                    System.out.println(clienteService.findClienteByDNI());
                    break;
                case CREATE_CLIENT:
                    clienteService.createCliente();
                    break;
                case MODIFY_CLIENT:
                    clienteService.updateCliente();
                    break;
                case DELETE_CLIENT:
                    clienteService.deleteCliente();
                    break;
                case LIST_ALL_CLIENTS:
                    clienteService.FindAllClientes();
                    break;
                case EXIT:
                    System.out.println("Volviendo al menu principal.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }while (option != 0);
    }

}
