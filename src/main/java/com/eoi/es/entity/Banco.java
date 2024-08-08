package com.eoi.es.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bancos")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBanco;

    @Column(name = "nombreBanco")
    private String nombreBanco;

    @Column(name = "ciudad")
    private String ciudad;

    @OneToMany(mappedBy = "banco", cascade = CascadeType.ALL)
    private List<Cuenta> cuentas;

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return idBanco + " | " + nombreBanco + " | " + ciudad;
    }
}
