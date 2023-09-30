package com.example.TED.controller;

import com.example.TED.entity.Filme;
import com.example.TED.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Filme> findAll() {
        return filmeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Filme> findById(@PathVariable Long id) {
        return filmeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Filme> create(@RequestBody Filme filme) {
        Filme createdFilme = filmeService.create(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFilme);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Filme> update(@PathVariable Long id, @RequestBody Filme filme) {
        Filme updatedFilme = filmeService.update(id, filme);
        return ResponseEntity.status(HttpStatus.OK).body(updatedFilme);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        filmeService.delete(id);
    }
}