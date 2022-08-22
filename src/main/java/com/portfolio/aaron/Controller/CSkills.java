package com.portfolio.aaron.Controller;



import com.portfolio.aaron.Dto.dtoSkills;
import com.portfolio.aaron.Entity.Skills;
import com.portfolio.aaron.Security.Controller.Mensaje;
import com.portfolio.aaron.Service.Sskills;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Skills")
@CrossOrigin(origins = "https://frontendap-58a02.web.app")
public class        CSkills {

    @Autowired
    Sskills sSkills;

        @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoS){
        if(StringUtils.isBlank(dtoS.getNombreS()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sSkills.existsByNombreS(dtoS.getNombreS()))
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);

        Skills skills = new Skills(dtoS.getNombreS(), dtoS.getImageS(),dtoS.getPorcentajeS());
        sSkills.save(skills);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoS){
        //Validamos si existe el ID
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de skills
        if(sSkills.existsByNombreS(dtoS.getNombreS()) && sSkills.getByNombreS(dtoS.getNombreS()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoS.getNombreS()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Skills skills = sSkills.getOne(id).get();
        skills.setNombreS(dtoS.getNombreS());
        skills.setPorcentajeS(dtoS.getPorcentajeS());
        skills.setImageS(dtoS.getImageS());

        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("Skills actualizadas"), HttpStatus.OK);

    }
}

