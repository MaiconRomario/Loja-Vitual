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

import com.devmaicon.backend.entities.Pessoa;

import com.devmaicon.backend.services.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService services;

    @GetMapping("/")
    public List<Pessoa> buscarTodos() {
        return services.buscarTodos();
    }

    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Long id) {
        return services.buscarPorId(id);
    }

    @PostMapping("/")
    public Pessoa inserir(@RequestBody Pessoa obj) {
        return services.inserir(obj);
    }

    @PutMapping("/")
    public Pessoa alterar(@RequestBody Pessoa obj) {
        return services.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        services.remover(id);
        return ResponseEntity.ok().build();
    }
}
