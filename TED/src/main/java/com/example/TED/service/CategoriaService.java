package com.example.TED.service;

import com.example.TED.dto.CategoriaDTO;
import com.example.TED.entity.Categoria;
import com.example.TED.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }


    public Categoria create(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTO.getNome());

        return categoriaRepository.save(categoria);
    }

    public Categoria update(Long id, CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);

        if (categoriaOpt.isPresent()) {
            Categoria categoria = categoriaOpt.get();
            categoria.setNome(categoriaDTO.getNome());

            return categoriaRepository.save(categoria);
        } else {
            // Lidar com a categoria não encontrada
            return null;
        }
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}