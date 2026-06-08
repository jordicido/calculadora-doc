package es.dam.calculadora;

import es.dam.calculadora.service.CalculadoraService;
import es.dam.calculadora.ui.Menu;


public class Main {

    public static void main(String[] args) {
        CalculadoraService calculadoraService = new CalculadoraService();
        Menu menu = new Menu(calculadoraService);
        menu.iniciar();
    }
}
