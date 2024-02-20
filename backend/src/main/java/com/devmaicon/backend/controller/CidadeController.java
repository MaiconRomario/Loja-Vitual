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

import com.devmaicon.backend.entities.Cidade;
import com.devmaicon.backend.services.CidadeService;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService services;

    @GetMapping("/")
    public List<Cidade> buscarTodos() {
        return services.buscarTodos();
    }

    @GetMapping("/{id}")
    public Cidade buscarTodos(@PathVariable Long id) {
        return services.buscarPorId(id);
    }

    @PostMapping("/")
    public Cidade inserir(@RequestBody Cidade obj) {
        return services.inserir(obj);
    }

    @PutMapping("/")
    public Cidade alterar(@RequestBody Cidade obj) {
        return services.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        services.remover(id);
        return ResponseEntity.ok().build();

    }
}
