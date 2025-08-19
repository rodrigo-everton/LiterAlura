package com.example.LiterAlura.dto;

import java.util.List;

public record ResultadoGutendexDTO(
        int count,
        String next,
        String previous
        //List<DadosBook> results
) {}

