package es.dam.calculadora.ui;

import es.dam.calculadora.exception.OperacionInvalidaException;
import es.dam.calculadora.model.Operacion;
import es.dam.calculadora.service.CalculadoraService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Menu {

    private final CalculadoraService calculadoraService;
    private final Scanner scanner;

    public Menu(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opcion: ");
            ejecutarOpcion(opcion);
        } while (opcion != 0);

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("=== CALCULADORA ===");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Potencia");
        System.out.println("6. Raiz cuadrada");
        System.out.println("7. Ver historial");
        System.out.println("8. Limpiar historial");
        System.out.println("0. Salir");
    }

    private void ejecutarOpcion(int opcion) {
        try {
            switch (opcion) {
                case 1:
                    sumar();
                    break;
                case 2:
                    restar();
                    break;
                case 3:
                    multiplicar();
                    break;
                case 4:
                    dividir();
                    break;
                case 5:
                    calcularPotencia();
                    break;
                case 6:
                    calcularRaizCuadrada();
                    break;
                case 7:
                    mostrarHistorial();
                    break;
                case 8:
                    limpiarHistorial();
                    break;
                case 0:
                    System.out.println("Saliendo de la calculadora...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } catch (OperacionInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void sumar() {
        double numero1 = leerDouble("Introduce el primer numero: ");
        double numero2 = leerDouble("Introduce el segundo numero: ");
        double resultado = calculadoraService.sumar(numero1, numero2);
        mostrarResultado(resultado);
    }

    private void restar() {
        double numero1 = leerDouble("Introduce el primer numero: ");
        double numero2 = leerDouble("Introduce el segundo numero: ");
        double resultado = calculadoraService.restar(numero1, numero2);
        mostrarResultado(resultado);
    }

    private void multiplicar() {
        double numero1 = leerDouble("Introduce el primer numero: ");
        double numero2 = leerDouble("Introduce el segundo numero: ");
        double resultado = calculadoraService.multiplicar(numero1, numero2);
        mostrarResultado(resultado);
    }

    private void dividir() {
        double dividendo = leerDouble("Introduce el dividendo: ");
        double divisor = leerDouble("Introduce el divisor: ");
        double resultado = calculadoraService.dividir(dividendo, divisor);
        mostrarResultado(resultado);
    }

    private void calcularPotencia() {
        double base = leerDouble("Introduce la base: ");
        double exponente = leerDouble("Introduce el exponente: ");
        double resultado = calculadoraService.calcularPotencia(base, exponente);
        mostrarResultado(resultado);
    }

    private void calcularRaizCuadrada() {
        double numero = leerDouble("Introduce el numero: ");
        double resultado = calculadoraService.calcularRaizCuadrada(numero);
        mostrarResultado(resultado);
    }

    private void mostrarHistorial() {
        List<Operacion> historial = calculadoraService.obtenerHistorial();

        if (historial.isEmpty()) {
            System.out.println("No hay operaciones en el historial.");
            return;
        }

        System.out.println();
        System.out.println("=== HISTORIAL ===");

        for (Operacion operacion : historial) {
            System.out.println(operacion);
        }
    }

    private void limpiarHistorial() {
        calculadoraService.limpiarHistorial();
        System.out.println("Historial limpiado.");
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un numero entero.");
                scanner.nextLine();
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                double numero = scanner.nextDouble();
                scanner.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un numero valido.");
                scanner.nextLine();
            }
        }
    }

    private void mostrarResultado(double resultado) {
        System.out.println("Resultado: " + resultado);
    }
}
