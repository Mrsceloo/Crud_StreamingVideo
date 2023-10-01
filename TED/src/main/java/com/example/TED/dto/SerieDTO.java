package com.example.TED.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO { // Altere o nome da classe para SerieDTO
    private Long id;
    private String titulo;
    private String descricao;
    private String categoria;
}