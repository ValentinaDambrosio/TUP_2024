package src.ar.edu.utn.frbb.tup;

class Aplicacion {

    public static void main(String args[]) {
        Banco banco = new Banco();

        MenuInputProcessor menuInputProcessor = new MenuInputProcessor();
        menuInputProcessor.renderMenu(banco);

    }


}
