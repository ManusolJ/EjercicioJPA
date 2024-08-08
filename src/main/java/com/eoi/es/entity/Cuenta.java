package com.eoi.es.entity;

import javax.persistence.*;

@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCuenta;

    @Column(name = "saldo")
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "DNI_CLIENTE",referencedColumnName = "DNI")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idBanco", referencedColumnName = "idBanco")
    private Banco banco;

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return idCuenta + " | " + getCliente().getNombreCliente() + " | " + getBanco().getNombreBanco();
    }
}
