package com.example.TED.service;

import com.example.TED.entity.Filme;
import com.example.TED.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> findAll() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> findById(Long id) {
        return filmeRepository.findById(id);
    }

    public Filme create(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Filme update(Long id, Filme filme) {

        return filmeRepository.save(filme);
    }

    public void delete(Long id) {
        filmeRepository.deleteById(id);
    }
}