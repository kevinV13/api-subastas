package com.example.apisubastas.Application.dto;

import lombok.*;

@Builder
@Getter
@Setter

public class ChatarraDto {
    private Integer idChatarra;
    private String titulo;
    private String description;
    private Float precioBase;
    private Integer Vendedor;
    private String image;
}
