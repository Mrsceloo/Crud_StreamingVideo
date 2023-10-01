package com.example.TED.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;



@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Filme implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;



}