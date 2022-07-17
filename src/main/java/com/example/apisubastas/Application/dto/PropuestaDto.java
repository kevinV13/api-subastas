package com.example.apisubastas.Application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


@Setter
@Builder
@Getter

public class PropuestaDto {
    private Integer idPropuesta;
    private Float price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "America/Lima")
    private Calendar time;
    private Integer subasta;
    private Integer comprador;
}
