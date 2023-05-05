package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> listarPersonas(){
        return personaRepository.findAll();
    }
    public Persona crearPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public void borrarPersona(Long id){
        personaRepository.deleteById(id);
    }

    public Persona buscarPersonaPorId(Long id){
        return personaRepository.findById(id).orElse(null);
    }
    public void modificarPersona(Persona persona){
        Long idToDelete = persona.getId();
        Persona personaToUpdate = personaRepository.findById(idToDelete).orElse(null);
        personaRepository.deleteById(idToDelete);
        personaRepository.save(personaToUpdate);
    }

//    public Persona actualizarPersona(Persona persona) {
//        if (personaRepository.existsById(persona.getId())) {
//            return personaRepository.save(persona);
//        } else {
//            return null;
//        }
//    }
}
