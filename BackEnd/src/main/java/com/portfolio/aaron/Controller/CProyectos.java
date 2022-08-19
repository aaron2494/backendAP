package com.portfolio.aaron.Controller;

import com.portfolio.aaron.Dto.dtoProyectos;
import com.portfolio.aaron.Entity.Proyectos;
import com.portfolio.aaron.Security.Controller.Mensaje;
import com.portfolio.aaron.Service.Sproyectos;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://frontendap-58a02.web.app")
public class CProyectos {
    @Autowired
    Sproyectos sproyectos;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sproyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sproyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sproyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sproyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sproyectos.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyec){
        if(StringUtils.isBlank(dtoproyec.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sproyectos.existsByNombreP(dtoproyec.getNombreP()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);

        Proyectos proyectos = new Proyectos(dtoproyec.getNombreP(), dtoproyec.getDescripcionP(),dtoproyec.getImageP());
        sproyectos.save(proyectos);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyec){
        //Validamos si existe el ID
        if(!sproyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de proyectos
        if(sproyectos.existsByNombreP(dtoproyec.getNombreP()) && sproyectos.getByNombreP(dtoproyec.getNombreP()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoproyec.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Proyectos proyectos = sproyectos.getOne(id).get();
        proyectos.setNombreP(dtoproyec.getNombreP());
        proyectos.setDescripcionP((dtoproyec.getDescripcionP()));

        sproyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

    }
}


