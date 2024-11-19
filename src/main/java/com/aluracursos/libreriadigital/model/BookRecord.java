package com.aluracursos.libreriadigital.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookRecord(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AuthorRecord> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Integer numeroDeDescargas
) {
}
