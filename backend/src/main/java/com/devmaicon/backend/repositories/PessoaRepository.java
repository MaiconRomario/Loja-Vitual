package com.devmaicon.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmaicon.backend.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
