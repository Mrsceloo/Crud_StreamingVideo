package com.example.TED.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    public void setNome(String nome) {
        this.nome = nome;
    }
    @OneToMany(mappedBy = "categoria")
    private Set<Serie> series;

    @OneToMany(mappedBy = "categoria")
    private Set<Filme> filmes;
}