package com.aluracursos.libreriadigital.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "autores")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaFallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book>libros;

    public Author(AuthorRecord autor){
        this.nombre=autor.nombre();
        this.fechaNacimiento= autor.fechaNacimiento();
        this.fechaFallecimiento= autor.fechaFallecimiento();
    }

    public Author(){};

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public List<Book> getLibros() {
        return libros;
    }

    public void setLibros(List<Book> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaFallecimiento=" + fechaFallecimiento +
                ", libros=" + libros +
                '}';
    }

    public void imprimirInformacion() {
        System.out.println("*****Autor*****");
        System.out.println("Nombre:" + nombre);
        System.out.println("Fecha de nacimiento: "+fechaNacimiento);
        System.out.println("Fecha de fallecimiento: "+fechaFallecimiento);
        System.out.println("Libros: "+libros);
        System.out.println("***************");
    }
}
