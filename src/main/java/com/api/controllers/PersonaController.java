package com.api.controllers;

import com.api.entities.Persona;
import com.api.services.PerosonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController  {

    @Autowired
    PerosonaService perosonaService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createPersona(@RequestBody Persona persona){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(perosonaService.createPersona(persona));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/id")
    public ResponseEntity getOnePersona(@RequestBody String id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(perosonaService.getOnePersona(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. por favor intente mas tarde.\"}");
        }
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updatePersona(@RequestBody Persona persona){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(perosonaService.updatePersona(persona));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. por favor intente mas tarde.\"}");
        }
    }

    @DeleteMapping("/id")
    public ResponseEntity deletePersona(@RequestBody String id){
        try {
            perosonaService.deletePersona(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("")
    public ResponseEntity getAllPersonas(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(perosonaService.getAllPersonas());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. por favor intente mas tarde.\"}");
        }
    }
}
