package com.aluracursos.libreriadigital.repository;

import com.aluracursos.libreriadigital.model.Language;
import com.aluracursos.libreriadigital.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("SELECT l FROM Book l WHERE LOWER(l.titulo) LIKE LOWER(:nombre)")
    Optional<Book> listarLibroPorNombre(String nombre);

    @Query("SELECT l FROM Book l WHERE l.idioma=:idioma")
    List<Book> listarLibrosPorIdioma(Language idioma);
}