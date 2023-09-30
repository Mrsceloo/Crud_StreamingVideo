package com.example.TED.service;

import com.example.TED.entity.Serie;
import com.example.TED.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    public Optional<Serie> findById(Long id) {
        return serieRepository.findById(id);
    }

    public Serie create(Serie serie) {
        return serieRepository.save(serie);
    }

    public Serie update(Long id, Serie serie) {

        return serieRepository.save(serie);
    }

    public void delete(Long id) {
        serieRepository.deleteById(id);
    }
}