package com.example.apisubastas.Application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Calendar;

@Builder
@Setter
@Getter
public class PropuestaExtendDto {
    private Integer idPropuesta;
    private Float price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "America/Lima")
    private Calendar time;
    private Integer subasta;
    private CompradorDto comprador;
}
