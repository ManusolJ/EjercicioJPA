package com.eoi.es.entity;

import javax.persistence.*;

@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column()
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "DNI_CLIENTE",referencedColumnName = "DNI")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idBanco", referencedColumnName = "idBanco")
    private Banco banco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
