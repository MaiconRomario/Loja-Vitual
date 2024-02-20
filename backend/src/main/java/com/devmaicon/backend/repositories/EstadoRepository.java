package com.devmaicon.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmaicon.backend.entities.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    
}