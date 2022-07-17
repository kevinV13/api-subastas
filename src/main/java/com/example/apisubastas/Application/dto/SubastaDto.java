package com.example.apisubastas.Application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Builder
@Setter
@Getter

public class SubastaDto {
    private Integer idSubasta;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "America/Lima")
    private Calendar fecha;
    private PropuestaExtendDto seleccionado;
    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "America/Lima")
    private Date fechaRecojo;
    private List<PropuestaDto> propuestas;
    private String status;
    private Integer vendedor;
    private ChatarraDto chatarra;
}
