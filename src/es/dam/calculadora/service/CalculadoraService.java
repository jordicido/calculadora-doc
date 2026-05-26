package es.dam.calculadora.service;

import es.dam.calculadora.exception.OperacionInvalidaException;
import es.dam.calculadora.model.Operacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculadoraService {

    private final List<Operacion> historial;

    public CalculadoraService() {
        this.historial = new ArrayList<>();
    }

    public double sumar(double numero1, double numero2) {
        double resultado = numero1 + numero2;
        guardarOperacion("Suma", numero1 + " + " + numero2, resultado);
        return resultado;
    }

    public double restar(double numero1, double numero2) {
        double resultado = numero1 - numero2;
        guardarOperacion("Resta", numero1 + " - " + numero2, resultado);
        return resultado;
    }

    public double multiplicar(double numero1, double numero2) {
        double resultado = numero1 * numero2;
        guardarOperacion("Multiplicacion", numero1 + " * " + numero2, resultado);
        return resultado;
    }

    public double dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new OperacionInvalidaException("No se puede dividir entre cero.");
        }

        double resultado = dividendo / divisor;
        guardarOperacion("Division", dividendo + " / " + divisor, resultado);
        return resultado;
    }

    public double calcularPotencia(double base, double exponente) {
        double resultado = Math.pow(base, exponente);
        guardarOperacion("Potencia", base + " ^ " + exponente, resultado);
        return resultado;
    }

    public double calcularRaizCuadrada(double numero) {
        if (numero < 0) {
            throw new OperacionInvalidaException("No se puede calcular la raiz cuadrada de un numero negativo.");
        }

        double resultado = Math.sqrt(numero);
        guardarOperacion("Raiz cuadrada", "sqrt(" + numero + ")", resultado);
        return resultado;
    }

    public List<Operacion> obtenerHistorial() {
        return Collections.unmodifiableList(historial);
    }

    public void limpiarHistorial() {
        historial.clear();
    }

    private void guardarOperacion(String tipo, String expresion, double resultado) {
        historial.add(new Operacion(tipo, expresion, resultado));
    }
}
