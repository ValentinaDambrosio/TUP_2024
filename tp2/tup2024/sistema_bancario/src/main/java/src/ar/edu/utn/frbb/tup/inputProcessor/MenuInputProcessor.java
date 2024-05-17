package src.ar.edu.utn.frbb.tup.inputProcessor;

import src.ar.edu.utn.frbb.tup.model.Banco;
import src.ar.edu.utn.frbb.tup.model.Cliente;
import src.ar.edu.utn.frbb.tup.model.Cuenta;
import src.ar.edu.utn.frbb.tup.model.OperacionBancaria;

public class MenuInputProcessor extends BaseInputProcessor {
    ClienteInputProcessor clienteInputProcessor = new ClienteInputProcessor();
    boolean exit = false;

    public void renderMenu(Banco banco) {

        while (!exit) {
            System.out.println("Bienveido a la aplicación de Banco!");
            System.out.println("1. Crear un nuevo Cliente");
            System.out.println("2. Crear una nueva Cuenta");
            System.out.println("3. Generar un movimiento");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    Cliente c = clienteInputProcessor.ingresarCliente();
                    banco.getClientes().add(c);
                    break;
                case 2:
                    int iCliente = clienteInputProcessor.buscarCliente(banco.getClientes());
                    if (iCliente == -1){
                        System.out.println("Usted no es cliente de este banco. Por favor cree un nuevo cliente.");
                    }
                    else{
                        Cuenta cuenta = clienteInputProcessor.createAccount(banco.getNumIdentCuenta());
                        banco.setNumIdentCuenta(banco.getNumIdentCuenta()+1);
                        banco.getClientes().get(iCliente).addCuenta(cuenta);
                    }
                    break;
                case 3:
                    boolean exitOperacion = false;
                    System.out.println("Ingrese el número de identificación de la cuenta: ");
                    long numId = scanner.nextInt();

                    System.out.println("¿Qué operación desea realizar?");
                    System.out.println("1. Depósito");
                    System.out.println("2. Retiro");
                    System.out.println("3. Transferencia");
                    System.out.println("4. Salir");
                    System.out.print("Ingrese su opción (1-4): ");
                    int eleccion = scanner.nextInt();
                    scanner.nextLine();

                    switch (eleccion){
                        case 1:
                            OperacionBancaria operacion = new OperacionBancaria();
                            Cuenta c1 = operacion.getCliente(banco.getClientes());
                            c1.addOperacion(operacion.depositar(banco.getClientes()));
                            break;
                        case 2:
                            OperacionBancaria operacion2 = new OperacionBancaria();
                            Cuenta c2 = operacion2.getCliente(banco.getClientes());
                            c2.addOperacion(operacion2.retirar(banco.getClientes()));
                            break;
                        case 3:
                            OperacionBancaria operacion3 = new OperacionBancaria();
                            Cuenta c3 = operacion3.getCliente(banco.getClientes());
                            c3.addOperacion(operacion3.transferir(banco.getClientes()));
                            break;
                        case 4:
                            OperacionBancaria operacion4 = new OperacionBancaria();
                            Cuenta c4 = operacion4.getCliente(banco.getClientes());
                            c4.addOperacion(operacion4.consultarSaldo(banco.getClientes()));
                            break;
                        default:
                            System.out.println("Opción inválida. Por favor seleccione 1-4.");
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-4.");
            }
            clearScreen();
        }
    }
}
