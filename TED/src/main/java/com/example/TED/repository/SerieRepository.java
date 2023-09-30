package com.example.TED.repository;

import com.example.TED.entity.Serie; // Importe a classe Serie
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    List<Serie> findByTituloContainsIgnoreCase(String titulo);

    List<Serie> findByCategoria(String categoria);
}