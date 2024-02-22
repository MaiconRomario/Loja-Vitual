package com.devmaicon.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmaicon.backend.entities.Marca;
import com.devmaicon.backend.repositories.MarcaRepository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository repository;

    public List<Marca> buscarTodos() {
        return repository.findAll();
    }

    public Marca buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public Marca inserir(Marca obj) {
        obj.setDataCriacao(new Date());
        Marca marcaNova = repository.saveAndFlush(obj);
        return marcaNova;
    }

    public Marca alterar(Marca obj) {
        obj.setDataAtualizacao(new Date());
        return repository.saveAndFlush(obj);
    }

    public void remover(Long id) {
        Marca obj = repository.findById(id).get();
        repository.delete(obj);
    }

}
