package com.devmaicon.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmaicon.backend.entities.Produto;
import com.devmaicon.backend.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> buscarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public Produto inserir(Produto obj) {
        obj.setDataCriacao(new Date());
        Produto ProdutoNova = repository.saveAndFlush(obj);
        return ProdutoNova;
    }

    public Produto alterar(Produto obj) {
        obj.setDataAtualizacao(new Date());
        return repository.saveAndFlush(obj);
    }

    public void remover(Long id) {
        Produto obj = repository.findById(id).get();
        repository.delete(obj);
    }

}
