package com.devmaicon.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmaicon.backend.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
