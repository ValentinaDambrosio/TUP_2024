package src.ar.edu.utn.frbb.tup.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    String nombre;
    LocalDateTime fechaCreacion;
    int balance;
    String tipoCuenta;
    long numIdentificacion;
    List<OperacionBancaria> operaciones;

    public String getNombre() {
        return nombre;
    }

    public Cuenta setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Cuenta setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public int getBalance() {
        return balance;
    }

    public Cuenta setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public long getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(long numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public void addOperacion(OperacionBancaria operacion){
        operaciones.add(operacion);
    }

    public List<OperacionBancaria> getOperaciones() {
        return operaciones;
    }
}
