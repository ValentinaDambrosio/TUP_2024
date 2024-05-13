package src.ar.edu.utn.frbb.tup.utils;

import src.ar.edu.utn.frbb.tup.BaseInputProcessor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class OperacionBancaria extends BaseInputProcessor {

    private String tipoOperacion;
    private LocalDateTime fechaHoraOp;
    private int monto;


    public OperacionBancaria depositar(List<Cliente> clientes) {
        System.out.println("Ingrese el número de identificación de la cuenta: ");
        long numId = scanner.nextInt();

        System.out.println("Ingrese el monto que desea depositar: ");
        int monto = scanner.nextInt();

        int i = 0;

        while (i<clientes.size()){
            Set<Cuenta> cuentas = new HashSet<>();
            cuentas = clientes.get(i).getCuentas();
            for (Cuenta cuenta : cuentas){
                if (numId == cuenta.getNumIdentificacion()){
                    cuenta.setBalance(cuenta.getBalance()+monto);
                    OperacionBancaria operacion = new OperacionBancaria().setTipoOperacion("DEPOSITO").setMonto(monto).setFechaHoraOp(LocalDateTime.now());
                    return operacion;
                }
            }
            i++;
        }
        return null;

    }

    public OperacionBancaria retirar(List<Cliente> clientes) {
        System.out.println("Ingrese el número de identificación de la cuenta: ");
        long numId = scanner.nextInt();

        System.out.println("Ingrese el monto que desea retirar: ");
        int monto = scanner.nextInt();

        int i = 0;

        while (i<clientes.size()){
            Set<Cuenta> cuentas = new HashSet<>();
            cuentas = clientes.get(i).getCuentas();
            for (Cuenta cuenta : cuentas){
                if (numId == cuenta.getNumIdentificacion()){
                    if (cuenta.getBalance() >= monto){
                        cuenta.setBalance(cuenta.getBalance()-monto);
                        OperacionBancaria operacion = new OperacionBancaria().setTipoOperacion("RETIRO").setMonto(monto).setFechaHoraOp(LocalDateTime.now());
                        return operacion;
                    }
                }
            }
            i++;
        }
        return null;
    }

    public OperacionBancaria transferir(List<Cliente> clientes) {
        System.out.println("Ingrese el número de identificación de la cuenta: ");
        long numId = scanner.nextInt();

        System.out.println("Ingrese el número de identificación de la cuenta a transferir: ");
        long numIdDestinatario = scanner.nextInt();

        System.out.println("Ingrese el monto que desea transferir: ");
        int monto = scanner.nextInt();

        int i = 0;
        int t = 0;

        while (i<clientes.size()){
            Set<Cuenta> cuentas = new HashSet<>();
            cuentas = clientes.get(i).getCuentas();
            for (Cuenta cuenta : cuentas){
                if (numId == cuenta.getNumIdentificacion()){
                    if (cuenta.getBalance() >= monto){
                        while (t<clientes.size()){
                            Set<Cuenta> cuentas2 = new HashSet<>();
                            cuentas2 = clientes.get(t).getCuentas();
                            for (Cuenta cuenta2 : cuentas2) {
                                if (numIdDestinatario == cuenta2.getNumIdentificacion()) {
                                    cuenta2.setBalance(cuenta2.getBalance() + monto);
                                    cuenta.setBalance(cuenta.getBalance() - monto);
                                    OperacionBancaria operacion = new OperacionBancaria().setTipoOperacion("TRANSFERENCIA").setMonto(monto).setFechaHoraOp(LocalDateTime.now());
                                    return operacion;
                                }
                            }
                        }
                        t++;
                    }
                }
            }
            i++;
        }
        return null;
    }

    public OperacionBancaria consultarSaldo(List<Cliente> clientes) {
        System.out.println("Ingrese el número de identificación de la cuenta: ");
        long numId = scanner.nextInt();

        int i = 0;

        while (i<clientes.size()){
            Set<Cuenta> cuentas = new HashSet<>();
            cuentas = clientes.get(i).getCuentas();
            for (Cuenta cuenta : cuentas){
                if (numId == cuenta.getNumIdentificacion()){
                    cuenta.setBalance(cuenta.getBalance()-monto);
                    OperacionBancaria operacion = new OperacionBancaria().setTipoOperacion("CONSULTAR SALDO").setMonto(cuenta.getBalance()).setFechaHoraOp(LocalDateTime.now());
                    return operacion;
                }
            }
            i++;
        }
        return null;
    }


    public Cuenta getCliente(List<Cliente> clientes){
        System.out.println("Ingrese el número de identificación de la cuenta: ");
        long numId = scanner.nextInt();
        int i = 0;

        while (i<clientes.size()) {
            Set<Cuenta> cuentas = new HashSet<>();
            cuentas = clientes.get(i).getCuentas();
            for (Cuenta cuenta : cuentas) {
                if (numId == cuenta.getNumIdentificacion()) {
                    return cuenta;
                }
            }
            i++;
        }
        return null;
    }


    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public OperacionBancaria setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
        return this;
    }

    public LocalDateTime getFechaHoraOp() {
        return fechaHoraOp;
    }

    public OperacionBancaria setFechaHoraOp(LocalDateTime fechaHoraOp) {
        this.fechaHoraOp = fechaHoraOp;
        return this;
    }

    public int getMonto() {
        return monto;
    }

    public OperacionBancaria setMonto(int monto) {
        this.monto = monto;
        return this;
    }
}
