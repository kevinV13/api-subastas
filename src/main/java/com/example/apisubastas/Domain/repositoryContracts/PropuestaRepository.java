package com.example.apisubastas.Domain.repositoryContracts;

import com.example.apisubastas.Domain.entities.Propuesta;

import java.util.List;

public interface PropuestaRepository {
    Propuesta GuardarPropuesta(Propuesta propuesta);

    List<Propuesta> PropuestaPorSubastas(Integer id);

    List<Propuesta> PropuestasPorUSer(Integer id);

    Propuesta BuscarPorId(Integer id);

    void eliminarPorSubastaYComprador(Integer idS,Integer idC);

}
