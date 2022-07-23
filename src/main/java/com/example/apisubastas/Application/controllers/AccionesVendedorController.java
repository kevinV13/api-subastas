package com.example.apisubastas.Application.controllers;


import com.example.apisubastas.Application.converters.SubastaConverter;
import com.example.apisubastas.Application.dto.SubastaDto;
import com.example.apisubastas.Application.utils.WrapperResponse;
import com.example.apisubastas.Domain.entities.Subasta;
import com.example.apisubastas.Domain.services.AccionesVendedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vendedor")
public class AccionesVendedorController {

    private final AccionesVendedorService actionVendedorService;

    private final SubastaConverter subastaConverter;

    public AccionesVendedorController(AccionesVendedorService actionVendedorService, SubastaConverter subastaConverter) {
        this.actionVendedorService = actionVendedorService;
        this.subastaConverter = subastaConverter;
    }

    @PutMapping("eleccion/{idp}")
    public ResponseEntity<WrapperResponse<SubastaDto>> AsignarPropuesta(@PathVariable("idp") Integer id) {
        Subasta subasta=actionVendedorService.aceptarPropuesta(id);
        SubastaDto result=subastaConverter.fromEntity(subasta);
        return new WrapperResponse<SubastaDto>(true, "success", result)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping("eleccionAnulada/{id}")
    public ResponseEntity<WrapperResponse<SubastaDto>> AsignacionAnulada(@PathVariable("id") Integer idSubasta) {
        Subasta subasta=actionVendedorService.cancelarAceptacion(idSubasta);
        SubastaDto result=subastaConverter.fromEntity(subasta);
        return new WrapperResponse<SubastaDto>(true, "success", result)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping("completar/{id}")
    public ResponseEntity<WrapperResponse<SubastaDto>> CompletarVendedor(@PathVariable("id")Integer id){
        Subasta subasta=actionVendedorService.CompletarVendedor(id);
        SubastaDto result=subastaConverter.fromEntity(subasta);
        return new WrapperResponse<SubastaDto>(true, "success", result)
                .createResponse(HttpStatus.OK);
    }
}
