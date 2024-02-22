package com.devmaicon.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmaicon.backend.entities.Estado;
import com.devmaicon.backend.repositories.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    public List<Estado> buscarTodos() {
        return repository.findAll();
    }

    public Estado buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public Estado inserir(Estado obj) {
        obj.setDataCriacao(new Date());
        Estado estadoNovo = repository.saveAndFlush(obj);
        return estadoNovo;
    }

    public Estado alterar(Estado obj) {
        obj.setDataAtualizacao(new Date());
        return repository.saveAndFlush(obj);
    }

    public void remover(Long id) {
        Estado obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
