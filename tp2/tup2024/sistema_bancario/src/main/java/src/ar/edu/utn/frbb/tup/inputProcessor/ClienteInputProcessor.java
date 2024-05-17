package src.ar.edu.utn.frbb.tup.inputProcessor;

import src.ar.edu.utn.frbb.tup.model.Cliente;
import src.ar.edu.utn.frbb.tup.model.Cuenta;
import src.ar.edu.utn.frbb.tup.model.TipoPersona;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Long.parseLong;
import static java.time.LocalDateTime.now;

public class ClienteInputProcessor extends BaseInputProcessor {


    public Cliente ingresarCliente() {

        // Ingreso de datos del Cliente
        Cliente cliente = new Cliente();
        clearScreen();
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);

        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scanner.nextLine();
        cliente.setApellido(apellido);

        System.out.println("Ingrese el dni del cliente:");
        String dni = scanner.nextLine();
        boolean dniValido = false;
        String dniPattern = "^[\\d]{1,3}\\.?[\\d]{3,3}\\.?[\\d]{3,3}$";
        while (!dniValido) {
            if (Pattern.matches(dniPattern, dni)) {
                dniValido = true;
            } else {
                System.out.println("El DNI ingresado es inválido.");
            }
        }
        long numdni = parseLong(dni);
        cliente.setDni(numdni);


        System.out.println("Ingrese la fecha de nacimiento del cliente (Formato: YYYY-MM-DD):");
        LocalDate fechaAlta = null;
        boolean fechaValida = false;
        while (!fechaValida) {
            try {
                fechaAlta = LocalDate.parse(scanner.nextLine());
                fechaValida = true;
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Ingrese la fecha en formato YYYY-MM-DD:");
            }
        }
        cliente.setFechaNacimiento(fechaAlta);

        System.out.println("Ingrese el tipo de persona Física(F) o Jurídica(J):");
        String tipoPersonaStr = scanner.nextLine().toUpperCase();
        while (!tipoPersonaStr.equals("F") && !tipoPersonaStr.equals("J")) {
            System.out.println("Tipo de persona inválido. Ingrese NATURAL o JURIDICA:");
            tipoPersonaStr = scanner.nextLine().toUpperCase();
        }
        TipoPersona tipoPersona = TipoPersona.fromString(tipoPersonaStr);
        cliente.setTipoPersona(tipoPersona);

        System.out.println("Ingrese el banco del cliente:");
        String banco = scanner.nextLine();
        cliente.setBanco(banco);

        System.out.println("Ingrese la fecha de alta del cliente (Formato: YYYY-MM-DD):");
        LocalDate fechaAlta2 = null;
        boolean fechaValida2 = false;
        while (!fechaValida2) {
            try {
                fechaAlta2 = LocalDate.parse(scanner.nextLine());
                fechaValida2 = true;
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Ingrese la fecha en formato YYYY-MM-DD:");
            }
        }
        cliente.setFechaAlta(fechaAlta2);

        clearScreen();
        return cliente;
    }

    public Cuenta createAccount(long numIdentificacion){
        // Ingreso de datos de la cuenta

        Cuenta cuenta = new Cuenta();

        LocalDateTime fechaAlta = now();
        cuenta.setFechaCreacion(fechaAlta);

        System.out.println("Ingrese el nombre de la cuenta: ");
        String nombreCuenta = scanner.nextLine();
        cuenta.setNombre(nombreCuenta);

        System.out.println("Ingrese el balance de la cuenta: ");
        int balance = scanner.nextInt();
        cuenta.setBalance(balance);

        System.out.println("Ingrese el tipo de cuenta: ");
        String tipoCuenta = scanner.nextLine().toUpperCase();
        cuenta.setTipoCuenta(tipoCuenta);

        cuenta.setNumIdentificacion(numIdentificacion);
        System.out.println("El número de identificación de la cuenta es: "+numIdentificacion);

        clearScreen();
        return cuenta;
    }


    public int buscarCliente(List<Cliente> clientes) {
        Cliente cliente = new Cliente();
        clearScreen();
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);


        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scanner.nextLine();
        cliente.setApellido(apellido);


        int i = 0;
        int iCliente = -1;
        while (i<clientes.size()){
            if ((clientes.get(i).getNombre() == cliente.getNombre()) && (clientes.get(i).getApellido() == cliente.getApellido())){
                iCliente = i;
                break;
            }
            else{
                i++;
            }
        }

        return iCliente;
    }
}
