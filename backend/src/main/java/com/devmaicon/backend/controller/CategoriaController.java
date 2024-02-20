package com.devmaicon.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmaicon.backend.entities.Categoria;
import com.devmaicon.backend.services.CategoriaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService services;

    @GetMapping("/")
    public List<Categoria> buscarTodos() {
        return services.buscarTodos();
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id) {
        return services.buscarPorId(id);
    }

    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria obj) {
        return services.inserir(obj);
    }

    @PutMapping("/")
    public Categoria alterar(@RequestBody Categoria obj) {
        return services.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        services.remove(id);
        return ResponseEntity.ok().build();
    }

}
