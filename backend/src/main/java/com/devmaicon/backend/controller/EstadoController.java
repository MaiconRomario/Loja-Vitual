package com.devmaicon.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmaicon.backend.entities.Estado;
import com.devmaicon.backend.services.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService services;

    @GetMapping("/")
    public List<Estado> buscarTodos() {
        return services.buscarTodos();
    }

    @GetMapping("/{id}")
    public Estado buscarPorId(@PathVariable Long id) {
        return services.buscarPorId(id);
    }

    @PostMapping("/")
    public Estado inserir(@RequestBody Estado obj) {
        return services.inserir(obj);
    }

    @PutMapping("/")
    public Estado alterar(@RequestBody Estado obj) {
        return services.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        services.remover(id);
        return ResponseEntity.ok().build();
    }
}
