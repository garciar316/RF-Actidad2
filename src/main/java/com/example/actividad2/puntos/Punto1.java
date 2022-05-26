package com.example.actividad2.puntos;

import com.example.actividad2.model.Correo;
import com.example.actividad2.util.Constants;
import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Punto1 {

    public static void main(String[] args) {
        System.out.println(enviado());
    }

    public static List<Map> distinct() {
        return Constants.CORREOS.stream()
                .distinct()
                .map(correo -> ImmutableMap.of("correo", correo.getCorreo()))
                .collect(Collectors.toUnmodifiableList());
    }

    public static List<Map> filterHotmail() {
        return Constants.CORREOS.stream()
                .filter(correo -> correo.getCorreo().contains("@hotmail"))
                .map(correo -> ImmutableMap.of("correo", correo.getCorreo()))
                .collect(Collectors.toUnmodifiableList());
    }

    public static List<Map> filterGmail() {
        return Constants.CORREOS.stream()
                .filter(correo -> correo.getCorreo().contains("@gmail"))
                .map(correo -> ImmutableMap.of("correo", correo.getCorreo()))
                .collect(Collectors.toUnmodifiableList());
    }

    public static List<Map> filterOutlook() {
        return Constants.CORREOS.stream()
                .filter(correo -> correo.getCorreo().contains("@outlook"))
                .map(correo -> ImmutableMap.of("correo", correo.getCorreo()))
                .collect(Collectors.toUnmodifiableList());
    }

    public static Boolean map() {
        List<Map> incorrectos = Constants.CORREOS.stream()
                .filter(correo -> {
                    Pattern validar = Pattern.compile("@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\n");
                    return validar.matcher(correo.getCorreo()).matches();
                })
                .map(correo -> ImmutableMap.of("correo", correo))
                .collect(Collectors.toUnmodifiableList());

        return !incorrectos.isEmpty();
    }

    public static Integer count() {
        return Constants.CORREOS.size();
    }

    public static String countByType() {
        return String.format(
                "Hotmail: %s, Gmail: %s, Outlook: %s",
                filterHotmail().size(),
                filterGmail().size(),
                filterOutlook().size());
    }

    public static List<Map> enviado() {
        return Constants.CORREOS.stream()
                .map(correo -> {
                    if (correo.getEnviado()) {
                        return ImmutableMap.of("correo", correo.getCorreo(), "enviado", false);
                    }
                    return ImmutableMap.of("correo", correo.getCorreo(), "enviado", correo.getEnviado());
                }).collect(Collectors.toUnmodifiableList());
    }
}
