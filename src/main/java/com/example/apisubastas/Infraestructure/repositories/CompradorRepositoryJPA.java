package com.example.apisubastas.Infraestructure.repositories;

import com.example.apisubastas.Domain.entities.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepositoryJPA extends JpaRepository<Comprador,Integer> {
}
