package es.dam.calculadora.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operacion {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final String tipo;
    private final String expresion;
    private final double resultado;
    private final LocalDateTime fecha;

    public Operacion(String tipo, String expresion, double resultado) {
        this.tipo = tipo;
        this.expresion = expresion;
        this.resultado = resultado;
        this.fecha = LocalDateTime.now();
    }

    public String getTipo() {
        return tipo;
    }

    public String getExpresion() {
        return expresion;
    }

    public double getResultado() {
        return resultado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "[" + fecha.format(FORMATO_FECHA) + "] "
                + tipo + ": "
                + expresion + " = "
                + resultado;
    }
}
