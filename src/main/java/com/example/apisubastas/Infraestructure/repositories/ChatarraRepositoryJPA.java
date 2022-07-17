package com.example.apisubastas.Infraestructure.repositories;

import com.example.apisubastas.Domain.entities.Chatarra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatarraRepositoryJPA extends JpaRepository<Chatarra,Integer> {

}
