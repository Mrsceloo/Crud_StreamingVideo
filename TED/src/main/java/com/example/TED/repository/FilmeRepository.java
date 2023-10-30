package com.example.TED.repository;

import com.example.TED.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findByTituloContainsIgnoreCase(String titulo);
    @Query(value = "SELECT f.* FROM filme f " +
            "INNER JOIN filme_categoria fc ON f.id = fc.filme_id " +
            "INNER JOIN categoria c ON fc.categoria_id = c.id " +
            "WHERE c.nome = ?1", nativeQuery = true)

    List<Filme> findByCategoria(String categoria);


}