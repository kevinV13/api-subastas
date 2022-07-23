package com.example.apisubastas.Application.converters;

import com.example.apisubastas.Application.dto.PropuestaExtendDto;
import com.example.apisubastas.Domain.entities.Propuesta;
import com.example.apisubastas.Domain.entities.Subasta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class PropuestaExtendConverter extends AbstractConverter<Propuesta, PropuestaExtendDto> {

    private CompradorConverter compradorConverter;



    @Override
    public PropuestaExtendDto fromEntity(Propuesta entity) {
        if(entity==null){
            return null;
        }

        return PropuestaExtendDto.builder()
                .idPropuesta(entity.getIdPropuesta())
                .price(entity.getPrice())
                .time(entity.getTime())
                .comprador(compradorConverter.fromEntity(entity.getComprador()))
                .subasta(entity.getSubasta().getIdSubasta())
                .build();
    }

    @Override
    public Propuesta fromDTO(PropuestaExtendDto dto) {
        if(dto ==null) {
            return  null;
        }

        Subasta subasta= new Subasta();
        subasta.setIdSubasta(dto.getSubasta());

        return Propuesta.builder()
                .price(dto.getPrice())
                .comprador(compradorConverter.fromDTO(dto.getComprador()))
                .subasta(subasta)
                .build();
    }
}
