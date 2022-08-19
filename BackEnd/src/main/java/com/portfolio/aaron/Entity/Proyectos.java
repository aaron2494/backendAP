package com.portfolio.aaron.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private String descripcionP;
    private String imageP;

    public Proyectos(String nombreP, String descripcionP, String imageP){
        this.nombreP=nombreP;
        this.descripcionP=descripcionP;
        this.imageP=imageP;
    }
    public Proyectos(){

    }
}
