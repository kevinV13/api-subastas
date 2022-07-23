package com.example.apisubastas.Domain.repositoryContracts;

import com.example.apisubastas.Domain.entities.Subasta;

import java.util.List;

public interface SubastaRepository {
    Subasta guardar(Subasta subasta);

    void eliminarporId(Integer id);

    Subasta buscarPorId(Integer id);

    List<Subasta> FiltrarEstado(String estado);

    List<Subasta> ListarSubastasporLugar(String dep,String dist,String prov);
    List<Subasta> ListarPorUsuario(Integer id );

    List<Subasta> HistoryPorUsuario(Integer id);

    List<Subasta> FiltrarEstadoUsuario(String estado,Integer id);

    List<Subasta> SubastaPorComprador(Integer id);

    List<Subasta> HistoryPorComprador(Integer id);
}
