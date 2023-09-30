package com.example.TED.repository;

import com.example.TED.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findByTituloContainsIgnoreCase(String titulo);

    List<Filme> findByCategoria(String categoria);


}