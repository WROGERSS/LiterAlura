package com.aluracursos.libreriadigital.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aluracursos.libreriadigital.model.Author;
import com.aluracursos.libreriadigital.model.Language;
import com.aluracursos.libreriadigital.model.Book;
import com.aluracursos.libreriadigital.model.BookRecord;

import com.aluracursos.libreriadigital.service.ConsultAPI;
import com.aluracursos.libreriadigital.service.JsonParser;


@Service
public class MenuService {

    private ConsultAPI peticionAPI;
    private Scanner sc;
    private BookService libroService;
    private AuthorService autorService;
    private JsonParser jsonParser;

    @Autowired
    public MenuService(BookService libroService, AuthorService autorService, JsonParser jsonParser) {
        this.peticionAPI = new ConsultAPI();
        this.sc = new Scanner(System.in);
        this.libroService = libroService;
        this.autorService = autorService;
        this.jsonParser = jsonParser;
    }

    public void guardarLibro() {
        List<BookRecord> librosObtenidos = obtenerLibrosApi();

        if (librosObtenidos.isEmpty()) {
            System.out.println("No se encontró ningun libro");
            return;
        }

        System.out.println("Escoja un libro para guardar[0-Cancelar]");
        for (int i = 0; i < librosObtenidos.size(); i++) {
            System.out.println((i + 1) + " - " + librosObtenidos.get(i).titulo() + " - " + librosObtenidos.get(i).idiomas().get(0) + " - " + librosObtenidos.get(i).autores().get(0).nombre());
        }

        int opcion = sc.nextInt();
        sc.nextLine();
        if (opcion == 0) {
            return;
        }
        if (opcion < 1 || opcion > librosObtenidos.size()) {
            System.out.println("Error: número erroneo");
            return;
        }

        BookRecord libroRecord = librosObtenidos.get(opcion - 1);
        Optional<Book> libroTraidoDelRepo = libroService.listarLibroPorNombre(libroRecord.titulo());
        Optional<Author> autorTraidodelRepo = autorService.listarAutorPorNombre(libroRecord.autores().get(0).nombre());

        if (libroTraidoDelRepo.isPresent()) {
            System.out.println("Error: no se puede registrar dos veces el mismo libro");
            return;
        }

        Book libro = new Book(libroRecord);

        if (!autorTraidodelRepo.isPresent()) {
            Author autorNuevo = libro.getAutor();
            autorService.guardarAutor(autorNuevo);
        }

        libroService.guardarLibro(libro);
    }

    public List<BookRecord> obtenerLibrosApi() {
        System.out.print("Ingrese el título del libro [0-Cancelar]: ");
        String titulo = sc.nextLine();
        if (titulo.equals("0")) {
            return Collections.emptyList();
        }
        List<BookRecord> librosObtenidos;
        librosObtenidos = jsonParser.parsearLibros(peticionAPI.obtenerDatos(titulo));
        return librosObtenidos;
    }


    public void listarLibrosRegistrados() {
        List<Book> libros = libroService.listarTodosLosLibros();
        libros.forEach(libro -> libro.imprimirInformacion());
    }

    public void listarAutoresRegistrados() {
        List<Author> autores = autorService.listarTodosLosAutores();
        autores.forEach(autor -> autor.imprimirInformacion());
    }

    public void listarAutoresVivosEnUnYear() {
        try {
            System.out.print("Ingrese año: ");
            int year = sc.nextInt();
            sc.nextLine();
            List<Author> autores = autorService.listarAutoresVivosEnUnYear(year);
            autores.forEach(autor -> autor.imprimirInformacion());
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un número");
        }

    }

    public void listarLibrosPorIdioma() {
        Language.listarIdiomas();
        System.out.print("Ingrese el codigo del idioma [0-Cancelar]: ");
        String idiomaBuscado = sc.nextLine();
        if (idiomaBuscado.equals("0")) {
            return;
        }
        List<Book> libros = libroService.listarLibrosPorIdioma(Language.stringToEnum(idiomaBuscado));
        libros.forEach(libro -> libro.imprimirInformacion());
    }

}
