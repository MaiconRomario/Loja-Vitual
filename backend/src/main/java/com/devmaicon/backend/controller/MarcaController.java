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

import com.devmaicon.backend.entities.Marca;

import com.devmaicon.backend.services.MarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService services;

    @GetMapping("/")
    public List<Marca> buscarTodos() {
        return services.buscarTodos();
    }

    @GetMapping("/{id}")
    public Marca buscarPorId(@PathVariable Long id) {
        return services.buscarPorId(id);
    }

    @PostMapping("/")
    public Marca inserir(@RequestBody Marca obj) {
        return services.inserir(obj);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody Marca obj) {
        return services.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        services.remover(id);
        return ResponseEntity.ok().build();
    }
}
