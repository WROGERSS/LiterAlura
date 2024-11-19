package com.aluracursos.libreriadigital.service;

import com.aluracursos.libreriadigital.model.Author;
import com.aluracursos.libreriadigital.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorService {

    public AuthorRepository autorRepository;

    @Autowired
    public AuthorService(AuthorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public AuthorService(){};

    public Optional<Author> listarAutorPorNombre(String nombre){
        return autorRepository.listarAutorPorNombre(nombre);
    }

    public void guardarAutor(Author autor){
        autorRepository.save(autor);
    }

    public List<Author> listarTodosLosAutores(){
        return autorRepository.findAll();
    }

    public List<Author> listarAutoresVivosEnUnYear(int year){
        return autorRepository.listarAutoresVivosEnUnYear(year);
    }

}
