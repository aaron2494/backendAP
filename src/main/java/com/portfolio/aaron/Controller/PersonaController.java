
package com.portfolio.aaron.Controller;

import com.portfolio.aaron.Dto.dtoPersona;
import com.portfolio.aaron.Entity.Persona;
import com.portfolio.aaron.Entity.Skills;
import com.portfolio.aaron.Interface.IPersonaService;
import java.util.List;

import com.portfolio.aaron.Security.Controller.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://frontendap-58a02.web.app")
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

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String delete(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody dtoPersona dtopers) {

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
