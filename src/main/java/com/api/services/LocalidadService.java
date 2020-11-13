package com.api.services;

import com.api.entities.Localidad;
import java.util.List;

public interface LocalidadService {


    Localidad createLocalidad(Localidad localidad);

    Localidad getOneLocalidad(String localidadId);

    Localidad updateLocalidad(Localidad localidad);

    void deleteLocalidad(String localidadId);

    List<Localidad> getAllLocalidades();
}
