package com.example.apisubastas.Application.converters;

import com.example.apisubastas.Application.dto.PropuestaDto;
import com.example.apisubastas.Domain.entities.Comprador;
import com.example.apisubastas.Domain.entities.Propuesta;
import com.example.apisubastas.Domain.entities.Subasta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PropuestaConverter extends AbstractConverter<Propuesta, PropuestaDto> {

    @Override
    public PropuestaDto fromEntity(Propuesta entity) {

        if(entity==null){
            return null;
        }

        return PropuestaDto.builder()
                .idPropuesta(entity.getIdPropuesta())
                .price(entity.getPrice())
                .time(entity.getTime())
                .comprador(entity.getComprador().getIdShopper())
                .subasta(entity.getSubasta().getIdSubasta())
                .build();
    }

    @Override
    public Propuesta fromDTO(PropuestaDto dto) {

        if(dto ==null) {
            return  null;
        }
        Comprador comprador= new Comprador();
        comprador.setIdShopper(dto.getComprador());

        Subasta subasta= new Subasta();
        subasta.setIdSubasta(dto.getSubasta());

        return Propuesta.builder()
                .price(dto.getPrice())
                .comprador(comprador)
                .subasta(subasta)
                .build();
    }
}
