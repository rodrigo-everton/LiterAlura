package com.example.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosAuthor(String name,
                          @JsonAlias("birth_year") Integer birthYear,
                          @JsonAlias("death_year")Integer deathYear) {
}
