package com.aluracursos.libreriadigital.service;

import com.aluracursos.libreriadigital.model.Language;
import com.aluracursos.libreriadigital.model.Book;
import com.aluracursos.libreriadigital.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
    @Service
    public class BookService {

        private BookRepository libroRepository;

        @Autowired
        public BookService(BookRepository repository) {
            this.libroRepository = repository;
        }

        public BookService(){};

        public List<Book> listarTodosLosLibros() {
            return libroRepository.findAll();
        }

        public Optional<Book> listarLibroPorNombre(String nombre){
            return libroRepository.listarLibroPorNombre(nombre);
        }

        public List<Book>listarLibrosPorIdioma(Language idioma){
            return libroRepository.listarLibrosPorIdioma(idioma);
        }

        public void guardarLibro(Book libro){
            libroRepository.save(libro);
        }
    }



