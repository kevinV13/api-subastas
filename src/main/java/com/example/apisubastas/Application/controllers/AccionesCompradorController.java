package com.example.apisubastas.Application.controllers;


import com.example.apisubastas.Application.converters.SubastaConverter;
import com.example.apisubastas.Application.dto.SubastaDto;
import com.example.apisubastas.Application.utils.WrapperResponse;
import com.example.apisubastas.Domain.entities.Subasta;
import com.example.apisubastas.Domain.services.AccionesCompradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comprador")
public class AccionesCompradorController {

    private final SubastaConverter subastaConverter;
    private final AccionesCompradorService actionCompradorService;

    public AccionesCompradorController(SubastaConverter subastaConverter, AccionesCompradorService actionCompradorService) {
        this.subastaConverter = subastaConverter;
        this.actionCompradorService = actionCompradorService;
    }

    @PutMapping("recogiendo")
    public ResponseEntity<WrapperResponse<SubastaDto>> Recogiendo(@RequestBody SubastaDto subastaDto) {
        Subasta subastatemp=subastaConverter.fromDTO(subastaDto);
        Subasta subasta=actionCompradorService.Recogiendo(subastatemp);
        SubastaDto result=subastaConverter.fromEntity(subasta);
        return new WrapperResponse<SubastaDto>(true, "success", result)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping("completar/{id}")
    public ResponseEntity<WrapperResponse<SubastaDto>> CompletarComprador(@PathVariable("id") Integer id){
        Subasta subasta=actionCompradorService.CompletarComprador(id);
        SubastaDto result=subastaConverter.fromEntity(subasta);
        return new WrapperResponse<SubastaDto>(true, "success", result)
                .createResponse(HttpStatus.OK);
    }
}
