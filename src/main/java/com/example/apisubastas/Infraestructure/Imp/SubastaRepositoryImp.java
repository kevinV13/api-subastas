package com.example.apisubastas.Infraestructure.Imp;

import com.example.apisubastas.Application.exception.ResourceNotFoundException;
import com.example.apisubastas.Domain.entities.Subasta;
import com.example.apisubastas.Domain.repositoryContracts.SubastaRepository;
import com.example.apisubastas.Infraestructure.repositories.SubastaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubastaRepositoryImp implements SubastaRepository {
    @Autowired
    SubastaRepositoryJPA db;

    @Override
    public Subasta guardar(Subasta subasta) {
        return db.save(subasta);
    }

    @Override
    public void eliminarporId(Integer id) {
        db.deleteById(id);
    }

    @Override
    public Subasta buscarPorId(Integer id) {
        return db.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Existe esta subasta: "+id));
    }

    @Override
    public List<Subasta> FiltrarEstado(String estado) {
        return db.FiltrarEstado(estado);
    }

    @Override
    public List<Subasta> ListarSubastasporLugar(String dep,String dist,String prov) {
        return db.ListarSubastasSercanas(dep,dist,prov);
    }

    @Override
    public List<Subasta> ListarPorUsuario(Integer id) {
        return db.ListarPorUsuario(id);
    }

    @Override
    public List<Subasta> HistoryPorUsuario(Integer id) {
        return db.HistoryPorUsuario(id);
    }

    @Override
    public List<Subasta> FiltrarEstadoUsuario(String estado, Integer id) {
        return db.FiltrarEstadoUsuario(estado,id);
    }

    @Override
    public List<Subasta> SubastaPorComprador(Integer id) {
        return db.FiltrarPorComprador(id);
    }

    @Override
    public List<Subasta> HistoryPorComprador(Integer id) {
        return db.HistoryPorComprador(id);
    }
}
