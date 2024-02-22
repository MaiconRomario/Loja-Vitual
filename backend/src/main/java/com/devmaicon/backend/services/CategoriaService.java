package com.devmaicon.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmaicon.backend.entities.Categoria;
import com.devmaicon.backend.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> buscarTodos() {
        return repository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public Categoria inserir(Categoria obj) {
        obj.setDataCriacao(new Date());
        Categoria novaCategoria = repository.saveAndFlush(obj);
        return novaCategoria;
    }

    public Categoria alterar(Categoria obj) {
        obj.setDataAtualizacao(new Date());
        return repository.saveAndFlush(obj);
    }

    public void remove(Long id) {
        Categoria obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
