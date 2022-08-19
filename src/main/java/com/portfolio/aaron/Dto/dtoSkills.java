package com.portfolio.aaron.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkills {

    @NotBlank
    private String nombreS;
    @NotBlank
    private String imageS;

    private int porcentajeS;

    //Constructores

    public dtoSkills() {
    }

    public dtoSkills(String nombreS, String imageS, int porcentajeS) {
        this.nombreS = nombreS;
        this.imageS=imageS;
        this.porcentajeS=porcentajeS;
    }
    //Getters & Setters

    public String getImageS() {
        return imageS;
    }

    public void setImageS(String imageS) {
        this.imageS = imageS;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getPorcentajeS() {
        return porcentajeS;
    }

    public void setPorcentajeS(int porcentajeS) {
        this.porcentajeS = porcentajeS;
    }
}

