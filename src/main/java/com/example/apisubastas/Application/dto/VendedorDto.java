package com.example.apisubastas.Application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class VendedorDto {
    private Integer idVendedor;
    private String user;
    private String password;
    private String phone;
    private String name;
    private String departamento;
    private String provincia;
    private String distrito;
    private Double latitud;
    private Double longitud;
    private String direccion;
    private List<ChatarraDto> chatarra;
    private List<SubastaDto> subasta;
}
