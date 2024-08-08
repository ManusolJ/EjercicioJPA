package com.eoi.es.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String DNI;

    @Column(name = "nombreCliente")
    private String nombreCliente;

    @Column(name = "direccionCliente")
    private String direccionCliente;

    @OneToMany(mappedBy = "cliente" , cascade = CascadeType.ALL)
    private List<Cuenta> cuentas;

    public String getDNI_Cliente() {
        return DNI;
    }

    public void setDNI_Cliente(String DNI_Cliente) {
        this.DNI = DNI_Cliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    @Override
    public String toString() {
        return DNI + " | " + nombreCliente + " | " + direccionCliente;
    }
}
