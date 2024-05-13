package src.ar.edu.utn.frbb.tup;

import src.ar.edu.utn.frbb.tup.utils.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private long numIdentCuenta = 0;

    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public long getNumIdentCuenta() {
        return numIdentCuenta;
    }

    public void setNumIdentCuenta(long numIdentCuenta) {
        this.numIdentCuenta = numIdentCuenta;
    }
}
