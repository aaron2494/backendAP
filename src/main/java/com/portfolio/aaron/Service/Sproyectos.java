package com.portfolio.aaron.Service;

import com.portfolio.aaron.Entity.Educacion;
import com.portfolio.aaron.Entity.Proyectos;
import com.portfolio.aaron.Repository.RProyectos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Sproyectos {

    @Autowired
    RProyectos rProyectos;

    public List<Proyectos> list(){
        return rProyectos.findAll();
    }

    public Optional<Proyectos> getOne(int id){
        return rProyectos.findById(id);
    }

    public Optional<Proyectos> getByNombreP(String nombreP){
        return rProyectos.findByNombreP(nombreP);
    }

    public void save(Proyectos proyectos){
        rProyectos.save(proyectos);
    }

    public void delete(int id){
        rProyectos.deleteById(id);
    }

    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }

    public boolean existsByNombreP(String nombreP){
        return rProyectos.existsByNombreP(nombreP);
    }
}
