package com.example.apisubastas.Infraestructure.Imp;

import com.example.apisubastas.Application.exception.ResourceNotFoundException;
import com.example.apisubastas.Domain.entities.Propuesta;
import com.example.apisubastas.Domain.repositoryContracts.PropuestaRepository;
import com.example.apisubastas.Infraestructure.repositories.PropuestaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PropuestaRepositoryImp implements PropuestaRepository {

    @Autowired
    PropuestaRepositoryJPA db;

    @Override
    public Propuesta GuardarPropuesta(Propuesta propuesta) {
        return db.save(propuesta);
    }

    @Override
    public List<Propuesta> PropuestaPorSubastas(Integer id) {
        return db.BuscarPropuestasPorSubasta(id);
    }

    @Override
    public List<Propuesta> PropuestasPorUSer(Integer id) {
        return db.BuscarPropuestasPorUsuario(id);
    }

    @Override
    public Propuesta BuscarPorId(Integer id) {
        return db.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Existe esta la propuesta: "+id));
    }
    @Override
    public void eliminarPorSubastaYComprador(Integer idS, Integer idC) {
        db.deleteBySubastaAndComprador(idS,idC);
    }

}
