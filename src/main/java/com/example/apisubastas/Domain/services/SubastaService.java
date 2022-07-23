package com.example.apisubastas.Domain.services;

import com.example.apisubastas.Domain.entities.*;
import com.example.apisubastas.Domain.repositoryContracts.ChatarraRepository;
import com.example.apisubastas.Domain.repositoryContracts.CompradorRepository;
import com.example.apisubastas.Domain.repositoryContracts.SubastaRepository;
import com.example.apisubastas.Domain.repositoryContracts.VendedorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class SubastaService {

    private final SubastaRepository subastaRepository;

    private final ChatarraRepository chatarraRepository;

    private final VendedorRepository vendedorRepository;

    private final CompradorRepository compradorRepository;

    public SubastaService(SubastaRepository subastaRepository, ChatarraRepository chatarraRepository, VendedorRepository vendedorRepository, CompradorRepository compradorRepository) {
        this.subastaRepository = subastaRepository;
        this.chatarraRepository = chatarraRepository;
        this.vendedorRepository = vendedorRepository;
        this.compradorRepository = compradorRepository;
    }

    @Transactional
    public Subasta crearSubasta(Subasta subasta){
        Vendedor newVendedor=vendedorRepository.buscarPorId(subasta.getVendedor().getIdVendedor());
        subasta.setVendedor(newVendedor);
        subasta.setStatus("activo");
        subasta.setVendedorOk(false);
        subasta.setCompradorOk(false);
        subasta.setFecha(Calendar.getInstance());
        List<Propuesta> propuestas = new ArrayList<Propuesta>();
        subasta.setPropuestas(propuestas);
        Subasta newSubasta=subastaRepository.guardar(subasta);
        Chatarra newChatarra=newSubasta.getChatarra();
        newChatarra.setVendedor(newVendedor);
        newChatarra.setSubasta(newSubasta);
        chatarraRepository.guardar(newChatarra);
        return newSubasta;
    }

    @Transactional
    public Subasta eliminarSubasta(Integer id){
        Subasta temp= subastaRepository.buscarPorId(id);
        temp.setStatus("cancelado");
        return subastaRepository.guardar(temp);
    }

    @Transactional
    public Subasta editarSubasta(Subasta subasta){
        Subasta newSubasta=subastaRepository.buscarPorId(subasta.getIdSubasta());
        Chatarra newChatarra=newSubasta.getChatarra();
        newChatarra.setDescription(subasta.getChatarra().getDescription());
        newChatarra.setTitulo(subasta.getChatarra().getTitulo());
        newChatarra.setPrecioBase(subasta.getChatarra().getPrecioBase());
        chatarraRepository.guardar(newChatarra);
        return subastaRepository.buscarPorId(subasta.getIdSubasta());
    }

    public List<Subasta> misSubastas( Integer id){
        return subastaRepository.ListarPorUsuario(id);
    }

    public List<Subasta> SubsatasEstados(Integer id,String estado){
        return subastaRepository.FiltrarEstadoUsuario(estado,id);
    }

    public List<Subasta> FiltrarSubastasSercanasComrpador(Integer id){
        Comprador comprador =compradorRepository.buscarPorId(id);
        return subastaRepository.ListarSubastasporLugar(
                comprador.getDepartamento(),
                comprador.getDistrito(),
                comprador.getProvincia());
    }


    public Subasta buscarPorId( Integer id){
        return subastaRepository.buscarPorId(id);
    }

    public List<Subasta> FiltrarSubastasPorEstado(String estado){
        return subastaRepository.FiltrarEstado(estado);
    }

    public List<Subasta> historySubastas( Integer id){
        return subastaRepository.HistoryPorUsuario(id);
    }

    public List<Subasta> SubastaPorComprador(Integer id){
        return subastaRepository.SubastaPorComprador(id);
    }

    public List<Subasta> HistrySubastasComprador( Integer id){
        return subastaRepository.HistoryPorComprador(id);
    }

}
