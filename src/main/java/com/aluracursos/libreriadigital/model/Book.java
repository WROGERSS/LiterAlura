package com.aluracursos.libreriadigital.model;

import jakarta.persistence.*;

import java.util.Optional;


@Entity
@Table(name = "libros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne
    private Author autor;
    @Enumerated(EnumType.STRING)
    private Language idioma;
    private Integer numeroDeDescargas;

    public Book(String titulo, Language idioma, Integer numeroDeDescargas, String enlace) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.numeroDeDescargas = numeroDeDescargas;
    }


    public Book(BookRecord libro) {
        this.titulo = libro.titulo();

        Optional<AuthorRecord> autor = libro.autores().stream().findFirst();
        autor.ifPresent(autorRecord -> this.autor = new Author(autorRecord));

        Optional<String> idioma = libro.idiomas().stream().findFirst();
        idioma.ifPresent(s -> this.idioma = Language.stringToEnum(s));

        this.numeroDeDescargas = libro.numeroDeDescargas();
    }

    public Book() {
    }

    ;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Language getIdioma() {
        return idioma;
    }

    public void setIdioma(Language idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Integer numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public void imprimirInformacion() {
        System.out.println("*****Libro*****");
        System.out.println("Titulo:" + titulo);
        System.out.println("Autor: " + autor.getNombre());
        System.out.println("Idioma: " + idioma.getTotalIdiomas());
        System.out.println("Numero de Descargas: " + numeroDeDescargas);
        System.out.println("");
    }

    @Override
    public String toString() {
        return titulo;
    }
}
