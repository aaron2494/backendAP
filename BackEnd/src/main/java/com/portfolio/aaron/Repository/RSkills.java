package com.portfolio.aaron.Repository;

import com.portfolio.aaron.Entity.Proyectos;
import com.portfolio.aaron.Entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RSkills extends JpaRepository<Skills,Integer> {

    public Optional<Skills> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}
