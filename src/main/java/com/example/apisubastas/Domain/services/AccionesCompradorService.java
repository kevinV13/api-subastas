package com.example.apisubastas.Domain.services;

import com.example.apisubastas.Domain.entities.Propuesta;
import com.example.apisubastas.Domain.entities.Subasta;
import com.example.apisubastas.Domain.repositoryContracts.PropuestaRepository;
import com.example.apisubastas.Domain.repositoryContracts.SubastaRepository;
import org.springframework.stereotype.Service;


@Service
public class AccionesCompradorService {


    private SubastaRepository subastaRepository;


    public AccionesCompradorService(SubastaRepository subastaRepository) {
        this.subastaRepository = subastaRepository;
    }

    public Subasta Recogiendo(Subasta subasta){
        Subasta subastatemp= subastaRepository.buscarPorId(subasta.getIdSubasta());
        subastatemp.setFechaRecojo(subasta.getFechaRecojo());
        subastatemp.setStatus("recogiendo");
        return  subastaRepository.guardar(subastatemp);
    }

    public Subasta CompletarComprador(Integer id){
        Subasta subasta= subastaRepository.buscarPorId(id);
        subasta.setCompradorOk(true);
        if(subasta.getVendedorOk()==true && subasta.getCompradorOk()==true){
            subasta.setStatus("completado");
        }
        return  subastaRepository.guardar(subasta);
    }


}