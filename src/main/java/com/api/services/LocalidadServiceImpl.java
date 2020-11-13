package com.api.services;

import com.api.entities.Localidad;
import com.api.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocalidadServiceImpl implements LocalidadService{

    @Autowired
    private LocalidadRepository localidadRepository;

    public Localidad createLocalidad(Localidad localidad) {
        return localidadRepository.createLocalidad(localidad);
    }

    public Localidad getOneLocalidad(String localidadId) {
        return localidadRepository.getOneLocalidad(localidadId);
    }

    @Override
    public Localidad updateLocalidad(Localidad localidad) {
        return localidadRepository.updateLocalidad(localidad);
    }

    @Override
    public void deleteLocalidad(String localidadId) {
        localidadRepository.deleteLocalidad(localidadId);
    }

    @Override
    public List<Localidad> getAllLocalidades() {
        return localidadRepository.getAllLocalidades();
    }
}
