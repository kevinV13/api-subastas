package com.example.apisubastas.Application.converters;

import com.example.apisubastas.Application.dto.SubastaDto;
import com.example.apisubastas.Application.dto.PropuestaExtendDto;
import com.example.apisubastas.Domain.entities.Propuesta;
import com.example.apisubastas.Domain.entities.Subasta;
import com.example.apisubastas.Domain.entities.Vendedor;
import com.example.apisubastas.Domain.services.PropuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class SubastaConverter extends AbstractConverter<Subasta, SubastaDto> {

    private ChatarraConverter chatarraConverter;
    private PropuestaExtendConverter propuestaExtendConverter;
    private PropuestaConverter propuestaConverter;

    private PropuestaService propuestaService;

    @Override
    public SubastaDto fromEntity(Subasta entity) {

        if (entity == null)
            return null;

        PropuestaExtendDto propuestaExtendDto=null;

        if (entity.getSeleccionado()!=null){
            Propuesta propuesta= propuestaService.BuscarPorId(entity.getSeleccionado());
            propuestaExtendDto=propuestaExtendConverter.fromEntity(propuesta);

        }


        return SubastaDto.builder()
                .idSubasta(entity.getIdSubasta())
                .fecha(entity.getFecha())
                .fechaRecojo(entity.getFechaRecojo())
                .status(entity.getStatus())
                .vendedor(entity.getVendedor().getIdVendedor())
                .seleccionado(propuestaExtendDto)
                .propuestas(propuestaConverter.fromEntity(entity.getPropuestas()))
                .chatarra(chatarraConverter.fromEntity(entity.getChatarra()))
                .build();

    }

    @Override
    public Subasta fromDTO(SubastaDto dto) {
        if (dto == null)
            return null;

        Vendedor newVendedor= new Vendedor();
        newVendedor.setIdVendedor(dto.getVendedor());



        return Subasta.builder()
                .FechaRecojo(dto.getFechaRecojo())
                .idSubasta(dto.getIdSubasta())
                .chatarra(chatarraConverter.fromDTO(dto.getChatarra()))
                .vendedor(newVendedor)
                .build();
    }
}
