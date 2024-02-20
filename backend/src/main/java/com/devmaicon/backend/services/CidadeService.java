package com.devmaicon.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmaicon.backend.entities.Cidade;
import com.devmaicon.backend.repositories.CidadeRepository;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public List<Cidade> buscarTodos() {
        return repository.findAll();
    }

    public Cidade buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public Cidade inserir(Cidade obj) {
        obj.setDataCriacao(new Date());
        Cidade novaCidade = repository.saveAndFlush(obj);
        return novaCidade;
    }

    public Cidade alterar(Cidade obj) {
        obj.setDataAtualizacao(new Date());
        return repository.saveAndFlush(obj);
    }

    public void remover(Long id) {
        Cidade obj = repository.findById(id).get();
        repository.delete(obj);
        ;
    }
}
