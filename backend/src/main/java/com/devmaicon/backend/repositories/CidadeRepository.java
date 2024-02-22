package com.devmaicon.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmaicon.backend.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
