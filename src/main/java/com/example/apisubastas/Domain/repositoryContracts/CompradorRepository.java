package com.example.apisubastas.Domain.repositoryContracts;

import com.example.apisubastas.Domain.entities.Comprador;

public interface CompradorRepository {
    Comprador buscarPorId(Integer id);
}
