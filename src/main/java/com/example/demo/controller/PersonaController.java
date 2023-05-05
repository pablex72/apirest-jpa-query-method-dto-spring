package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/persona")
    public List<Persona> listPersona() {
        return personaService.listarPersonas();
    }

    @PostMapping("/persona")
    public Persona crearPersona(@RequestBody Persona persona){
        return personaService.crearPersona(persona);
    }

    @DeleteMapping("/persona/{id}")
    public void borrarPersona(@PathVariable Long id){
        personaService.borrarPersona(id);
    }

    @GetMapping("/persona/{id}")
    public Persona buscarPersonaPorId(@PathVariable Long id){
        return personaService.buscarPersonaPorId(id);
    }

    @PutMapping("/persona")
    public void modificarPersona(@RequestBody Persona persona){
        personaService.modificarPersona(persona);
    }
}
