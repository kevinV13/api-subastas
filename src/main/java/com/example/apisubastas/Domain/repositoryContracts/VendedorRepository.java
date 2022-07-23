package com.example.apisubastas.Domain.repositoryContracts;

import com.example.apisubastas.Domain.entities.Vendedor;

public interface VendedorRepository {
    Vendedor buscarPorId(Integer id);
}
