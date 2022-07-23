package com.example.apisubastas.Infraestructure.Imp;


import com.example.apisubastas.Application.exception.ResourceNotFoundException;
import com.example.apisubastas.Domain.entities.Vendedor;
import com.example.apisubastas.Domain.repositoryContracts.VendedorRepository;
import com.example.apisubastas.Infraestructure.repositories.VendedorRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendedorRepositoryImp implements VendedorRepository {

    @Autowired
    VendedorRepositoryJPA db;

    @Override
    public Vendedor buscarPorId(Integer id) {
        return db.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("No Existe el vendedor: "+id));
    }
}
