package com.aluracursos.libreriadigital.repository;


import com.aluracursos.libreriadigital.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE LOWER(a.nombre) LIKE LOWER(:nombre)")
    Optional<Author> listarAutorPorNombre(String nombre);

    @Query("SELECT a FROM Author a WHERE :year>=a.fechaNacimiento AND :year<a.fechaFallecimiento")
    List<Author> listarAutoresVivosEnUnYear(int year);
}
