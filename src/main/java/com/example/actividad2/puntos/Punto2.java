package com.example.actividad2.puntos;

import com.example.actividad2.model.RudenessModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class Punto2 {

    private  static final Logger log = LoggerFactory.getLogger(Punto2.class);

    public static void main(String[] args) {
        chat();
    }

    public  static void chat() {
        try {
            Boolean index = true;
            while (Boolean.TRUE.equals(index)) {
                Scanner cursor = new Scanner(System.in);
                log.info("Escribir:  ");
                String text = cursor.nextLine();
                List<String> newText = Arrays.stream(text.split(" ")).toList();
                Flux.fromIterable(newText)
                        .map(elem -> {
                            if (RudenessModel.RUDENESS.contains(elem.toLowerCase())) {
                                elem = "***";
                            }
                            return elem;
                        }).reduce("", (a, b) -> a += " " + b)
                        .subscribe(log::info);
                if (text.equals("007")) {
                    index = Boolean.FALSE;
                }
            }
            log.info("Has escrito la palabra secreta, vuelve pronto ¡Gracias!");

        } catch (Exception e) {
            log.info("Hubo un error: " + e);
        }
    }
}
