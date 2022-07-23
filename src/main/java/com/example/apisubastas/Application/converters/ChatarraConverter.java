package com.example.apisubastas.Application.converters;

import com.example.apisubastas.Application.dto.ChatarraDto;
import com.example.apisubastas.Domain.entities.Chatarra;
import com.example.apisubastas.Domain.entities.Vendedor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ChatarraConverter extends  AbstractConverter<Chatarra, ChatarraDto>{

    @Override
    public ChatarraDto fromEntity(Chatarra entity) {

        if(entity==null) return  null;

        return ChatarraDto.builder()
                .idChatarra(entity.getIdChatarra())
                .titulo(entity.getTitulo())
                .description(entity.getDescription())
                .precioBase(entity.getPrecioBase())
                .Vendedor(entity.getVendedor().getIdVendedor())
                .build();
    }

    @Override
    public Chatarra fromDTO(ChatarraDto dto) {

        if(dto==null) return  null;
        Vendedor newVendedor= new Vendedor();
        newVendedor.setIdVendedor(dto.getVendedor());
        return Chatarra.builder()
                .idChatarra(dto.getIdChatarra())
                .titulo(dto.getTitulo())
                .description(dto.getDescription())
                .precioBase(dto.getPrecioBase())
                .vendedor(newVendedor)
                .build();
    }
}
