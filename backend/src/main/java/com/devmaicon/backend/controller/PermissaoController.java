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

import com.devmaicon.backend.entities.Permissao;

import com.devmaicon.backend.services.PermissaoService;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService services;

    @GetMapping("/")
    public List<Permissao> buscarTodos() {
        return services.buscarTodos();
    }

    @GetMapping("/{id}")
    public Permissao buscarPorId(@PathVariable Long id) {
        return services.buscarPorId(id);
    }

    @PostMapping("/")
    public Permissao inserir(@RequestBody Permissao obj) {
        return services.inserir(obj);
    }

    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao obj) {
        return services.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        services.remover(id);
        return ResponseEntity.ok().build();
    }
}
