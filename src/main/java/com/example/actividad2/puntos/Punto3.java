package com.example.actividad2.puntos;

import org.springframework.util.StringUtils;

public class Punto3 {

    public static void main(String[] args) {

        String function = "41x";
        String funcionDerivada = derivada(function);
        System.out.printf("La derivada de %s es %s%n", function, funcionDerivada);
        System.out.printf("La integral de %s es %s",funcionDerivada, integral(funcionDerivada));
    }

    public static String integral(String constante) {
        if (constante.matches("[+-]?\\d*(\\.\\d+)?")) {
            return String.format("%sx + C", constante);
        }
        return constante;
    }

    public static String derivada(String function) {
        if (function.matches("(\\d+)(((.|,)\\d+)+)*[x]")) {
            return function.substring(0, function.length() - 1);
        }
        return function;
    }
}
