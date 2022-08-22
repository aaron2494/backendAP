
package com.portfolio.aaron.Controller;

import com.portfolio.aaron.Dto.dtoPersona;
import com.portfolio.aaron.Entity.Persona;

import com.portfolio.aaron.Entity.Skills;
import com.portfolio.aaron.Interface.IPersonaService;
import java.util.List;

import com.portfolio.aaron.Security.Controller.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://frontendap-58a02.web.app")
//@CrossOrigin( origins = "https://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = ipersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

   // @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String delete(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody dtoPersona dtopers) {
        if(!ipersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtopers.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Persona pers = ipersonaService.findPersona(id);
        pers.setNombre(dtopers.getNombre());
        pers.setApellido((dtopers.getApellido()));
        pers.setDescripcion(dtopers.getDescripcion());
        pers.setImg((dtopers.getImg()));

        ipersonaService.savePersona(pers);
        return new ResponseEntity(new Mensaje("persona actualizada"), HttpStatus.OK);
    }
    @GetMapping("/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }


}
