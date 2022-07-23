package com.example.apisubastas.Application.controllers;


import com.example.apisubastas.Application.converters.SubastaConverter;
import com.example.apisubastas.Application.dto.SubastaDto;
import com.example.apisubastas.Application.utils.WrapperResponse;
import com.example.apisubastas.Domain.entities.Subasta;
import com.example.apisubastas.Domain.services.AccionesCompradorService;
import com.example.apisubastas.Domain.services.SubastaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("subasta")
public class SubastaController {

    private final SubastaService subastaService;
    private final SubastaConverter subastaConverter;

    private final AccionesCompradorService accionesCompradorService;

    public SubastaController(SubastaService subastaService, SubastaConverter subastaConverter, AccionesCompradorService accionesCompradorService) {
        this.subastaService = subastaService;
        this.subastaConverter = subastaConverter;
        this.accionesCompradorService = accionesCompradorService;
    }

    @PostMapping("")
    public ResponseEntity<WrapperResponse<SubastaDto>> CrearSubasta(@RequestBody SubastaDto subastaDto) {
        Subasta subasta = subastaConverter.fromDTO(subastaDto);
        Subasta SubastaNew = subastaService.crearSubasta(subasta);
        SubastaDto response = subastaConverter.fromEntity(SubastaNew);
        return new WrapperResponse<SubastaDto>(true, "success", response).createResponse(HttpStatus.CREATED);
    }

    @PutMapping("eliminar/{id}")
    public ResponseEntity<WrapperResponse<Subasta>> Eliminar(@PathVariable("id") Integer id) {
        Subasta SubastaDeleted = subastaService.eliminarSubasta(id);
        return new WrapperResponse<Subasta>(true, "success", SubastaDeleted).createResponse(HttpStatus.OK);
    }

    @GetMapping("mis/{ids}")
    public ResponseEntity<WrapperResponse<List<SubastaDto>>> Listar(@PathVariable("ids") Integer id) {
        List<Subasta> subastasList = subastaService.misSubastas(id);
        List<SubastaDto> subastaDtoList = subastaConverter.fromEntity(subastasList);
        return new WrapperResponse<List<SubastaDto>>(true, "success", subastaDtoList)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping("mis/history/{ids}")
    public ResponseEntity<WrapperResponse<List<SubastaDto>>> ListarHistorial(@PathVariable("ids") Integer id) {
        List<Subasta> subastasList = subastaService.historySubastas(id);
        List<SubastaDto> subastaDtoList = subastaConverter.fromEntity(subastasList);
        return new WrapperResponse<List<SubastaDto>>(true, "success", subastaDtoList)
                .createResponse(HttpStatus.OK);
    }


    @GetMapping("misc/{id}")
    public  ResponseEntity<WrapperResponse<List<SubastaDto>>> ListarPorComprador(@PathVariable("id") Integer id){
        List<Subasta> subastaList =subastaService.SubastaPorComprador(id);
        List<SubastaDto> result =subastaConverter.fromEntity(subastaList);
        return new WrapperResponse<List<SubastaDto>>(true, "success", result)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping("misc/serca/{id}")
    public  ResponseEntity<WrapperResponse<List<SubastaDto>>> ListarSubastasSercanasComprador(@PathVariable("id") Integer id){
        List<Subasta> subastaList =subastaService.FiltrarSubastasSercanasComrpador(id);
        List<SubastaDto> result =subastaConverter.fromEntity(subastaList);
        return new WrapperResponse<List<SubastaDto>>(true, "success", result)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping("misc/history/{id}")
    public  ResponseEntity<WrapperResponse<List<SubastaDto>>> ListarPorCompradorHistorial(@PathVariable("id") Integer id){
        List<Subasta> subastaList =subastaService.HistrySubastasComprador(id);
        List<SubastaDto> result =subastaConverter.fromEntity(subastaList);
        return new WrapperResponse<List<SubastaDto>>(true, "success", result)
                .createResponse(HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<WrapperResponse<SubastaDto>> ObtenerPorId(@PathVariable("id") Integer id) {
        Subasta subasta = subastaService.buscarPorId(id);
        SubastaDto subastaDto = subastaConverter.fromEntity(subasta);
        return new WrapperResponse<>(true, "success", subastaDto)
                .createResponse(HttpStatus.OK);
    }
    @GetMapping("estados/{estado}")
    public ResponseEntity<WrapperResponse<List<SubastaDto>>> FiltrarSubastasPorEstado(@PathVariable("estado") String estado) {
        List<Subasta> subastasList = subastaService.FiltrarSubastasPorEstado(estado);
        List<SubastaDto> SubastaListDto = subastaConverter.fromEntity(subastasList);
        return new WrapperResponse<List<SubastaDto>>(true, "success", SubastaListDto)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping("estados/{ides}/{estado}")
    public ResponseEntity<WrapperResponse<List<SubastaDto>>> ListarEstados(@PathVariable("ides") Integer id, @PathVariable("estado") String estado) {
        List<Subasta> subastasList = subastaService.SubsatasEstados(id, estado);
        List<SubastaDto> SubastaListDto = subastaConverter.fromEntity(subastasList);
        return new WrapperResponse<List<SubastaDto>>(true, "success", SubastaListDto)
                .createResponse(HttpStatus.OK);
    }


    @PutMapping("")
    public ResponseEntity<WrapperResponse<SubastaDto>> EditarSubasta(@RequestBody SubastaDto subastaDto) {
        Subasta subasta = subastaConverter.fromDTO(subastaDto);
        Subasta SubastaNew = subastaService.editarSubasta(subasta);
        SubastaDto response = subastaConverter.fromEntity(SubastaNew);
        return new WrapperResponse<SubastaDto>(true, "success", response).createResponse(HttpStatus.CREATED);

    }


}
