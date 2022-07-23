package com.example.apisubastas.Infraestructure.Imp;

import com.example.apisubastas.Application.exception.ResourceNotFoundException;
import com.example.apisubastas.Domain.entities.Comprador;
import com.example.apisubastas.Domain.repositoryContracts.CompradorRepository;
import com.example.apisubastas.Infraestructure.repositories.CompradorRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompradorRepositoryImp implements CompradorRepository {

    @Autowired
    CompradorRepositoryJPA db;

    @Override
    public Comprador buscarPorId(Integer id) {
        return db.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("No Existe el comprador: "+id));
    }
}