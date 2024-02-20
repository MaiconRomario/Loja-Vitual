package com.devmaicon.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmaicon.backend.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
