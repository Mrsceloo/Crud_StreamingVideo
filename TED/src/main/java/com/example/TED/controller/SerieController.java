package com.example.TED.controller;

import com.example.TED.entity.Serie; // Importe a classe Serie
import com.example.TED.service.SerieService; // Importe o serviço SerieService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Serie> findAll() {
        return serieService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Serie> findById(@PathVariable Long id) {
        return serieService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Serie> create(@RequestBody Serie serie) {
        Serie createdSerie = serieService.create(serie);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSerie);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Serie> update(@PathVariable Long id, @RequestBody Serie serie) {
        Serie updatedSerie = serieService.update(id, serie);
        return ResponseEntity.status(HttpStatus.OK).body(updatedSerie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        serieService.delete(id);
    }
}