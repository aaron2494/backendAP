package com.portfolio.aaron.Entity;

import javax.persistence.*;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreS;
    private String imageS;
    private int porcentajeS;


    public Skills() {
    }


    public Skills(String nombreS, String imageS,int porcentajeS) {
        this.id = id;
        this.nombreS = nombreS;
        this.imageS = imageS;
        this.porcentajeS = porcentajeS;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getImageS() {
        return imageS;
    }

    public void setImageS(String imageS) {
        this.imageS = imageS;
    }

    public int getPorcentajeS() {
        return porcentajeS;
    }

    public void setPorcentajeS(int porcentajeS) {
        this.porcentajeS = porcentajeS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
