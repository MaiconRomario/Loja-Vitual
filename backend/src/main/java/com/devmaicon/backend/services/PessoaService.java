package com.devmaicon.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmaicon.backend.entities.Pessoa;
import com.devmaicon.backend.repositories.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> buscarTodos() {
        return repository.findAll();
    }

    public Pessoa buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public Pessoa inserir(Pessoa obj) {
        obj.setDataCriacao(new Date());
        Pessoa PessoaNova = repository.saveAndFlush(obj);
        return PessoaNova;
    }

    public Pessoa alterar(Pessoa obj) {
        obj.setDataAtualizacao(new Date());
        return repository.saveAndFlush(obj);
    }

    public void remover(Long id) {
        Pessoa obj = repository.findById(id).get();
        repository.delete(obj);
    }

}
