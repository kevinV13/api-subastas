package com.example.apisubastas.Infraestructure.repositories;

import com.example.apisubastas.Domain.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepositoryJPA extends JpaRepository<Vendedor,Integer> {
}
