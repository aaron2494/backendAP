package com.portfolio.aaron.Service;


import com.portfolio.aaron.Entity.Proyectos;
import com.portfolio.aaron.Entity.Skills;
import com.portfolio.aaron.Repository.RSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Sskills {

    @Autowired
    RSkills rSkills;

    public List<Skills> list(){
        return rSkills.findAll();
    }

    public Optional<Skills> getOne(int id){
        return rSkills.findById(id);
    }

    public Optional<Skills> getByNombreS(String nombreS){return rSkills.findByNombreS(nombreS);}

    public void save(Skills skills){
        rSkills.save(skills);
    }

    public void delete(int id){
        rSkills.deleteById(id);
    }

    public boolean existsById(int id){
        return rSkills.existsById(id);
    }

    public boolean existsByNombreS(String nombreS){
        return rSkills.existsByNombreS(nombreS);
    }}
