package com.api.repositories;

import com.api.entities.Persona;
import java.util.List;

public interface PersonaRepository {

    Persona createPersona(Persona persona);

    Persona getOnePersona(String personaId);

    Persona updatePersona(Persona persona);

    void deletePersona(String personaId);

    List<Persona> getAllPersonas();
}
