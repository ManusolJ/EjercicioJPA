package com.eoi.es.service;

import com.eoi.es.DAO.CuentaDaoJpaImpl;
import com.eoi.es.entity.Banco;
import com.eoi.es.entity.Cliente;
import com.eoi.es.entity.Cuenta;

import java.util.List;
import java.util.Scanner;

public class CuentaService {

    //TODO validar los inputs...

    private static final CuentaDaoJpaImpl cuentaDao = new CuentaDaoJpaImpl();
    private static final ClienteService clienteService = new ClienteService();
    private static final BancoService bancoService = new BancoService();
    public static Scanner sc = new Scanner(System.in);

    public Cuenta findCuentaById() {
        System.out.println("Ingrese el ID del cuenta");
        int id = sc.nextInt();
        return cuentaDao.findObjectByKey(id);
    }

    public void createCuenta() {
        System.out.println("Creando un cuenta.");
        Cuenta cuenta = new Cuenta();
        dataInput(cuenta,false);
        cuentaDao.Create(cuenta);
        System.out.println("Cuenta creada con exito.");
    }

    public void updateCuenta() {
        System.out.println("Actualizando cuenta.");
        Cuenta cuenta = new Cuenta();
        dataInput(cuenta,true);
        cuentaDao.Update(cuenta);
        System.out.println("Cuenta Actualizada con exito.");
    }

    public void deleteCuenta() {
        System.out.println("Eliminando cuenta.");
        cuentaDao.Delete(findCuentaById());
        System.out.println("Cuenta Eliminada con exito.");
    }

    public void findAllCuentas(){
        List<Cuenta> cuentas = cuentaDao.findAll();
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta);
            System.out.println("--------------------");
        }
    }

    //TODO si cliente no existe, dar opcion de crearlo.
    public void dataInput(Cuenta cuenta, boolean isUpdate) {
        int idCuenta = 0;
        if(isUpdate){
            System.out.println("Ingrese el id del cuenta");
            idCuenta = sc.nextInt();
        }
        Cliente cliente = clienteService.findClienteByDNI();
        Banco banco = bancoService.findBancobyId();
        if(idCuenta != 0){
            cuenta.setIdCuenta(idCuenta);
        }
        cuenta.setCliente(cliente);
        cuenta.setBanco(banco);
    }
}
