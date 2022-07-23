package com.example.apisubastas.Domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "vendedores")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Vendedor {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idVendedor;

    @Column(name = "usuario",unique = true,nullable = false)
    @Size(min = 4, max = 20, message = "Usuario no Valido")
    private String user;

    @Column(name = "contraseña",nullable = false)
    @Size(min = 8, max = 16, message = "contraseña invalida")
    private String password;

    @Column(name = "telefono",nullable = false)
    @Size(min = 9, max = 9, message = "celular no valido")
    private String phone;

    @Column(name = "nombre",nullable = false)
    @Size(min = 2, max = 50, message = "nombre no valido")
    private String name;

    @Column(name = "departamento",nullable = false)
    @Size(min = 4, max=45, message = "region no valida")
    private String departamento;

    @Column(name = "provincia",nullable = false)
    @Size(min = 4, max=45, message = "provincia no valida")
    private String provincia;

    @Column(name = "distrito",nullable = false)
    @Size(min = 4, max=45, message = "distrito no valida")
    private String distrito;

    @Column(name = "latitud")
    private Double latitud;

    @Column(name = "longitud")
    private Double longitud;

    @Column(name = "dirección")
    @Size(min = 4, max=60, message = "dirección no valida")
    private String direccion;

    @OneToMany(mappedBy = "vendedor",cascade = {CascadeType.ALL})
    private List<Subasta> subasta;

    @OneToMany(mappedBy = "vendedor",cascade = {CascadeType.ALL})
    private List<Chatarra> chatarra;
}
