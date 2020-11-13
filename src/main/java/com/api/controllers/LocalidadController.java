package com.api.controllers;

import com.api.entities.Localidad;
import com.api.services.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/localidad")
public class LocalidadController{

    @Autowired
    LocalidadService localidadService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createLocalidad(@RequestBody Localidad localidad){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.createLocalidad(localidad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/id")
    public ResponseEntity getOneLocalidad(@RequestBody String localidadId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.getOneLocalidad(localidadId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. por favor intente mas tarde.\"}");
        }
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateLocalidad(@RequestBody Localidad localidad){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.updateLocalidad(localidad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. por favor intente mas tarde.\"}");
        }
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteLocalidad(@RequestBody String localidadId){
        try {
            localidadService.deleteLocalidad(localidadId);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("")
    public ResponseEntity getAllLocalidades(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.getAllLocalidades());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. por favor intente mas tarde.\"}");
        }
    }
}
