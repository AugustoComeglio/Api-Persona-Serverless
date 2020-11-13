package com.api.repositories;

import com.api.entities.Localidad;
import com.api.entities.Persona;

import java.util.List;

public interface LocalidadRepository {

    Localidad createLocalidad(Localidad localidad);

    Localidad getOneLocalidad(String localidadId);

    Localidad updateLocalidad(Localidad localidad);

    void deleteLocalidad(String localidadId);

    List<Localidad> getAllLocalidades();
}
