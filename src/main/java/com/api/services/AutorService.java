package com.api.services;

import com.api.entities.Autor;
import java.util.List;

public interface AutorService {

    Autor createAutor(Autor autor);

    Autor getOneAutor(String autorId);

    Autor updateAutor(Autor autor);

    void deleteAutor(String autorId);

    List<Autor> getAllAutores();
}

