package com.aluracursos.libreriadigital.service;

import com.aluracursos.libreriadigital.model.BookRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonParser {

    private ObjectMapper objectMapper = new ObjectMapper();


    public BookRecord parsearLibro(String json) {
        try {
            return objectMapper.readValue(json, BookRecord.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public List<BookRecord> parsearLibros(String json) {
        List<BookRecord> lista = new ArrayList<>();
        try {

            JsonNode jsonObject = objectMapper.readTree(json);
            JsonNode resultados = jsonObject.get("results");

            for (JsonNode node : (ArrayNode) resultados) {
                BookRecord libro = objectMapper.treeToValue(node, BookRecord.class);
                lista.add(libro);
            }

            return lista;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
