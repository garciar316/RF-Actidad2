package com.example.actividad2.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Correo {

    private String correo;
    private Boolean enviado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correo correo1 = (Correo) o;
        return Objects.equals(correo, correo1.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo);
    }
}
