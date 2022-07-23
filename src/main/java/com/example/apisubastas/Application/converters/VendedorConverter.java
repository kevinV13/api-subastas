package com.example.apisubastas.Application.converters;

import com.example.apisubastas.Application.dto.VendedorDto;
import com.example.apisubastas.Domain.entities.Vendedor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VendedorConverter extends AbstractConverter<Vendedor, VendedorDto> {

    private ChatarraConverter chatarraConverter;
    private SubastaConverter subastaConverter;

    @Override
    public VendedorDto fromEntity(Vendedor entity) {
        if (entity == null)
            return null;

        return VendedorDto.builder()
                .idVendedor(entity.getIdVendedor())
                .user(entity.getUser())
                .password(entity.getPassword())
                .phone(entity.getPhone())
                .name(entity.getName())
                .departamento(entity.getDepartamento())
                .longitud(entity.getLongitud())
                .latitud(entity.getLatitud())
                .provincia(entity.getProvincia())
                .distrito(entity.getDistrito())
                .direccion(entity.getDireccion())
                .chatarra(chatarraConverter.fromEntity(entity.getChatarra()))
                .subasta(subastaConverter.fromEntity(entity.getSubasta()))
                .build();
    }

    @Override
    public Vendedor fromDTO(VendedorDto dto) {
        if (dto == null)
            return null;

        return Vendedor.builder()
                .idVendedor(dto.getIdVendedor())
                .user(dto.getUser())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .name(dto.getName())
                .latitud(dto.getLatitud())
                .longitud(dto.getLongitud())
                .direccion(dto.getDireccion())
                .departamento(dto.getDepartamento())
                .provincia(dto.getProvincia())
                .build();
    }
}
