package com.example.apisubastas.Domain.services;

import com.example.apisubastas.Application.exception.ResourceNotFoundException;
import com.example.apisubastas.Domain.entities.Comprador;
import com.example.apisubastas.Domain.entities.Propuesta;
import com.example.apisubastas.Domain.entities.Subasta;
import com.example.apisubastas.Domain.repositoryContracts.CompradorRepository;
import com.example.apisubastas.Domain.repositoryContracts.PropuestaRepository;
import com.example.apisubastas.Domain.repositoryContracts.SubastaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@Service
public class PropuestaService {

    private PropuestaRepository propuestaRepository;
    private CompradorRepository compradorRepository;
    private SubastaRepository subastaRepository;

    public PropuestaService(PropuestaRepository propuestaRepository, CompradorRepository compradorRepository, SubastaRepository subastaRepository) {
        this.propuestaRepository = propuestaRepository;
        this.compradorRepository = compradorRepository;
        this.subastaRepository = subastaRepository;
    }

    public Propuesta crearPropuesta(Propuesta propuesta){

        Comprador comprador = compradorRepository.buscarPorId(propuesta.getComprador().getIdShopper());
        Subasta subasta = subastaRepository.buscarPorId(propuesta.getSubasta().getIdSubasta());

        Propuesta mayor= PropuestaMayor(subasta.getIdSubasta());
        if( mayor==null){
            mayor=new Propuesta();
            mayor.setPrice(0f);
        }
        if(propuesta.getPrice()>mayor.getPrice()){
            propuesta.setComprador(comprador);
            propuesta.setSubasta(subasta);
            propuesta.setTime(Calendar.getInstance());

            return propuestaRepository.GuardarPropuesta(propuesta);
        }
        else {
             throw new ResourceNotFoundException("la propuesta es menor a una propuesta anterior");
        }

    }

    public List<Propuesta> propuestaPorSubasta(Integer id){
        return propuestaRepository.PropuestaPorSubastas(id);
    }

    public List<Propuesta> propuestaPorUser(Integer id){
        return propuestaRepository.PropuestasPorUSer(id);
    }

    public Propuesta BuscarPorId(Integer id){
        return propuestaRepository.BuscarPorId(id);
    }

    public Propuesta PropuestaMayor(Integer id){
        List<Propuesta> propuestas = propuestaRepository.PropuestaPorSubastas(id);
        if (propuestas.size()==0){
            return null;
        }
        Propuesta mayor= propuestas.get(0);
        for(int i=1; i <propuestas.size();i++){
            if(propuestas.get(i).getPrice()> mayor.getPrice()){
                mayor=propuestas.get(i);
            }
        }
        return mayor;
    }
    public void eliminarPorSubastaYComprador(Integer idS,Integer idC) {
        propuestaRepository.eliminarPorSubastaYComprador(idS,idC);
    }
}