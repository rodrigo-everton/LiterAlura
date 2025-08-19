package com.example.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosBook(Long id,
                        String title,
                        List<String> language,
                        Set<DadosAuthor> authors) {
}
