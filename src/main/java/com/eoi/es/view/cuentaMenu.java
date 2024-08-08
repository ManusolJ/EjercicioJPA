package com.eoi.es.view;

import com.eoi.es.service.CuentaService;

import java.util.Scanner;

public class cuentaMenu {

    static final int LIST_ACCOUNT = 1;
    static final int CREATE_ACCOUNT = 2;
    static final int MODIFY_ACCOUNT = 3;
    static final int DELETE_ACCOUNT = 4;
    static final int LIST_ALL_ACCOUNTS = 5;
    static final int EXIT = 0;

    public static CuentaService cuentaService = new CuentaService();

    public static void printMenu(){
        System.out.println("Menu Cuentas.");
        System.out.println("1 - Listar una cuenta.");
        System.out.println("2 - Crear una cuenta.");
        System.out.println("3 - Modificar una cuenta.");
        System.out.println("4 - Eliminar una cuenta.");
        System.out.println("5 - Listar todos los cuentas.");
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
                case LIST_ACCOUNT:
                    System.out.println(cuentaService.findCuentaById());
                    break;
                case CREATE_ACCOUNT:
                    cuentaService.createCuenta();
                    break;
                case MODIFY_ACCOUNT:
                    cuentaService.updateCuenta();
                    break;
                case DELETE_ACCOUNT:
                    cuentaService.deleteCuenta();
                    break;
                case LIST_ALL_ACCOUNTS:
                    cuentaService.findAllCuentas();
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
