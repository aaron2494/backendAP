package com.portfolio.aaron.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoPersona {
    private String nombre;
    private String apellido;
    private String descripcion;
    private String img;

    public dtoPersona(String nombre, String apellido, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.img = img;
    }
}
