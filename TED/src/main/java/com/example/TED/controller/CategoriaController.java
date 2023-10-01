package com.example.TED.controller;

import com.example.TED.dto.CategoriaDTO;
import com.example.TED.entity.Categoria;
import com.example.TED.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Optional<Categoria> categoriaOpt = categoriaService.findById(id);

        if (categoriaOpt.isPresent()) {
            Categoria categoria = categoriaOpt.get();
            return ResponseEntity.status(HttpStatus.OK).body(categoria);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria createdCategoria = categoriaService.create(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        Categoria updatedCategoria = categoriaService.update(id, categoriaDTO);

        if (updatedCategoria != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedCategoria);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoriaService.delete(id);
    }
}
