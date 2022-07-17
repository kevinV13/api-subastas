package com.example.apisubastas.Domain.services;

import com.example.apisubastas.Domain.entities.Propuesta;
import com.example.apisubastas.Domain.entities.Subasta;
import com.example.apisubastas.Domain.repositoryContracts.PropuestaRepository;
import com.example.apisubastas.Domain.repositoryContracts.SubastaRepository;
import org.springframework.stereotype.Service;

@Service
public class AccionesVendedorService {

    private SubastaRepository subastaRepository;

    private PropuestaService propuestaService;

    public AccionesVendedorService(SubastaRepository subastaRepository, PropuestaService propuestaService) {
        this.subastaRepository = subastaRepository;
        this.propuestaService = propuestaService;
    }

    public Subasta aceptarPropuesta(Integer id){
        Subasta subasta= subastaRepository.buscarPorId(id);
        Propuesta propuestaNew= propuestaService.PropuestaMayor(subasta.getIdSubasta());
        subasta.setSeleccionado(propuestaNew.getIdPropuesta());
        subasta.setStatus("aceptado");
        return subastaRepository.guardar(subasta);
    }

    public Subasta cancelarAceptacion(Integer idSubasta){
        Subasta subasta= subastaRepository.buscarPorId(idSubasta);
        subasta.setSeleccionado(null);
        subasta.setStatus("activo");
        return subastaRepository.guardar(subasta);
    }

    public Subasta CompletarVendedor(Integer id){
        Subasta subasta= subastaRepository.buscarPorId(id);
        subasta.setVendedorOk(true);
        if(subasta.getVendedorOk()==true && subasta.getCompradorOk()==true){
            subasta.setStatus("completado");
        }
        return subastaRepository.guardar(subasta);
    }
}
