package com.eoi.es.app;
import com.eoi.es.*;
import com.eoi.es.entity.Cliente;
import com.eoi.es.service.BancoService;
import com.eoi.es.service.ClienteService;
import com.eoi.es.service.CuentaService;

import java.util.Scanner;

public class MundoBancario {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        BancoService bancoService = new BancoService();
        ClienteService clienteService = new ClienteService();
        CuentaService cuentaService = new CuentaService();

        int option;

        do {
            printMainMenu();
            option = sc.nextInt();

        }while (option != 0);
    }

    public static void printMainMenu(){
        System.out.println("Elige sobre que operar: ");
        System.out.println("1 - Clientes");
        System.out.println("2 - Bancos");
        System.out.println("3 - Cuentas");
    }

    public static void printAuxMenu(){
        System.out.println("Elija una opcion: ");
        System.out.println("1 - Crear ");
        System.out.println("2 - Buscar  ");
        System.out.println("3 - Actualizar ");
        System.out.println("4 - Eliminar  ");
        System.out.println("0 - Salir ");
    }
}
