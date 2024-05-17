package src.ar.edu.utn.frbb.tup;

import src.ar.edu.utn.frbb.tup.inputProcessor.MenuInputProcessor;
import src.ar.edu.utn.frbb.tup.model.Banco;

class Aplicacion {

    public static void main(String args[]) {
        Banco banco = new Banco();

        MenuInputProcessor menuInputProcessor = new MenuInputProcessor();
        menuInputProcessor.renderMenu(banco);

    }


}
