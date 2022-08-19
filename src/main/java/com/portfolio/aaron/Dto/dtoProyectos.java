package com.portfolio.aaron.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyectos {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String imageP;

    //Constructores

    public dtoProyectos() {
    }

    public dtoProyectos(String nombreP, String descripcionP,String imageP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imageP=imageP;
    }
    //Getters & Setters

    public String getImageP() {
        return imageP;
    }

    public void setImageP(String imageP) {
        this.imageP = imageP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

}

