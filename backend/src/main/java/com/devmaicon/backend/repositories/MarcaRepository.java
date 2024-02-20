package com.devmaicon.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmaicon.backend.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
