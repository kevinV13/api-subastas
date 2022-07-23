package com.example.apisubastas.Application.converters;

import com.example.apisubastas.Application.dto.CompradorDto;
import com.example.apisubastas.Domain.entities.Comprador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CompradorConverter extends AbstractConverter<Comprador, CompradorDto>{

    @Override
    public CompradorDto fromEntity(Comprador entity) {
        if(entity==null) return null;

        return CompradorDto.builder()
                .idShopper(entity.getIdShopper())
                .user(entity.getUser())
                .password(entity.getPassword())
                .phone(entity.getPhone())
                .name(entity.getName())
                .departamento(entity.getDepartamento())
                .provincia(entity.getProvincia())
                .distrito(entity.getDistrito())
                .status(entity.getStatus())
                .build();
    }

//    .area(entity.getRegion()+", "+entity.getDistrito()+", "+entity.getCiudad())

    @Override
    public Comprador fromDTO(CompradorDto dto) {
        if(dto==null) return null;
        return Comprador.builder()
                .idShopper(dto.getIdShopper())
                .user(dto.getUser())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .name(dto.getName())
                .departamento(dto.getDepartamento())
                .distrito(dto.getDistrito())
                .provincia(dto.getProvincia())
                .status(dto.getStatus())
                .build();
    }
}
