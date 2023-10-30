package com.example.TED.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class FilmeDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String categoria;



}