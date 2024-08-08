package com.eoi.es.view;

import com.eoi.es.service.BancoService;

import java.util.Scanner;

public class bancoMenu {

    static final int LIST_BANK = 1;
    static final int CREATE_BANK = 2;
    static final int MODIFY_BANK = 3;
    static final int DELETE_BANK = 4;
    static final int LIST_ALL_BANKS = 5;
    static final int EXIT = 0;

    public static BancoService bancoService = new BancoService();

    public static void printMenu(){
        System.out.println("Menu bancos.");
        System.out.println("1 - Listar un banco.");
        System.out.println("2 - Crear un banco.");
        System.out.println("3 - Modificar un banco.");
        System.out.println("4 - Eliminar un banco.");
        System.out.println("5 - Listar todos los bancos.");
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
                case LIST_BANK:
                    System.out.println(bancoService.findBancobyId());
                    break;
                case CREATE_BANK:
                    bancoService.createBanco();
                    break;
                case MODIFY_BANK:
                    bancoService.updateBanco();
                    break;
                case DELETE_BANK:
                    bancoService.deleteBanco();
                    break;
                case LIST_ALL_BANKS:
                    bancoService.findAllBancos();
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
