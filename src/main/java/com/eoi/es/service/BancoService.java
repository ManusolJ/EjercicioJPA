package com.eoi.es.service;

import com.eoi.es.DAO.BancoDaoJpaImpl;
import com.eoi.es.entity.Banco;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BancoService {

    //TODO validar inputs...

    private static final BancoDaoJpaImpl bancoDao = new BancoDaoJpaImpl();
    public static Scanner sc = new Scanner(System.in);

    public Banco findBancobyId() {
        System.out.println("Ingrese el ID del banco: ");
        int idBanco = sc.nextInt();
        return bancoDao.findObjectByKey(idBanco);
    }

    public void createBanco() {
        System.out.println("Creando un nuevo banco.");
        Banco banco = new Banco();
        dataInput(banco);
        bancoDao.Create(banco);
        System.out.println("Banco creado con exito.");
    }

    public void updateBanco() {
        System.out.println("Actualizando banco.");
        Banco banco = new Banco();
        dataInput(banco);
        bancoDao.Update(banco);
        System.out.println("Banco actualizado con exito.");
    }

    public void deleteBanco() {
        System.out.println("Eliminando banco.");
        bancoDao.Delete(findBancobyId());
        System.out.println("Banco eliminado con exito.");
    }

    public void findAllBancos(){
        System.out.println("Listando todas las bancos.");
        List<Banco> bancos = bancoDao.findAll();
        for (Banco banco : bancos) {
            System.out.println(banco);
            System.out.println("--------------------");
        }
    }

    public void dataInput(Banco banco) {
        System.out.println("Ingrese el id del banco: ");
        int idBanco = sc.nextInt();
        System.out.println("Ingrese el nombre del banco: ");
        sc.nextLine();
        String nombreBanco = sc.nextLine();
        System.out.println("Ingrese la ciudad del banco: ");
        String ciudadBanco = sc.nextLine();
        banco.setIdBanco(idBanco);
        banco.setNombreBanco(nombreBanco);
        banco.setCiudad(ciudadBanco);
    }

}
