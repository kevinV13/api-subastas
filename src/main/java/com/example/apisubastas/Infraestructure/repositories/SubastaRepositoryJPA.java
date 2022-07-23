package com.example.apisubastas.Infraestructure.repositories;

import com.example.apisubastas.Domain.entities.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubastaRepositoryJPA extends JpaRepository<Subasta,Integer>{

    @Query("SELECT a FROM  Subasta a WHERE a.status=:estado")
    List<Subasta> FiltrarEstado(@Param("estado") String estado);

    @Query("SELECT  a FROM Subasta a WHERE a.vendedor.idVendedor=:idh")
    List<Subasta> HistoryPorUsuario(@Param("idh") Integer id );

    @Query("SELECT  a FROM Subasta a WHERE a.vendedor.idVendedor=:id AND NOT (a.status='cancelado' OR a.status='completado')")
    List<Subasta> ListarPorUsuario(@Param("id") Integer id );

    @Query("SELECT DISTINCT s.subasta FROM Propuesta s WHERE s.comprador.idShopper=:compidh")
    List<Subasta> HistoryPorComprador(@Param("compidh") Integer id);

    @Query("SELECT DISTINCT s.subasta FROM Propuesta s WHERE s.comprador.idShopper=:compid AND NOT (s.subasta.status='cancelado' OR s.subasta.status='completado')")
    List<Subasta> FiltrarPorComprador(@Param("compid") Integer id);

    @Query("SELECT DISTINCT s.subasta FROM Propuesta s WHERE s.subasta.vendedor.departamento=:dep AND s.subasta.vendedor.distrito=:dist AND s.subasta.vendedor.provincia=:prov AND NOT (s.subasta.status='cancelado' OR s.subasta.status='completado')")
    List<Subasta> ListarSubastasSercanas(@Param("dep") String dep,@Param("dist") String dist,@Param("prov") String prov);

    @Query("SELECT a FROM Subasta a WHERE a.vendedor.idVendedor=:id AND a.status=:estado")
    List<Subasta> FiltrarEstadoUsuario(@Param("estado") String estado,@Param("id") Integer id);


}
