package com.eoi.es.view;

import java.util.Scanner;

public class mainMenu {

    final static int MENU_CLIENTES = 1;
    final static int MENU_BANCOS = 2;
    final static int MENU_CUENTAS = 3;
    final static int EXIT = 0;


    public static void printMenu() {
        System.out.println("Menu Principal");
        System.out.println("1 - Clientes.");
        System.out.println("2 - Bancos.");
        System.out.println("3 - Cuentas.");
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
                case MENU_CLIENTES:
                    clienteMenu.actionMenu();
                    break;
                case MENU_BANCOS:
                    bancoMenu.actionMenu();
                    break;
                case MENU_CUENTAS:
                    cuentaMenu.actionMenu();
                    break;
                case EXIT:
                    System.out.println("Terminando programa.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }while (option != 0);

        sc.close();
    }

}
