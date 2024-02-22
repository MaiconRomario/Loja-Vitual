package com.devmaicon.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmaicon.backend.entities.Permissao;
import com.devmaicon.backend.repositories.PermissaoRepository;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository repository;

    public List<Permissao> buscarTodos() {
        return repository.findAll();
    }

    public Permissao buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public Permissao inserir(Permissao obj) {
        obj.setDataCriacao(new Date());
        Permissao PermissaoNova = repository.saveAndFlush(obj);
        return PermissaoNova;
    }

    public Permissao alterar(Permissao obj) {
        obj.setDataAtualizacao(new Date());
        return repository.saveAndFlush(obj);
    }

    public void remover(Long id) {
        Permissao obj = repository.findById(id).get();
        repository.delete(obj);
    }

}
