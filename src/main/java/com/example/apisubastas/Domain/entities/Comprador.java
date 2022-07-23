package com.example.apisubastas.Domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "compradores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idShopper;

    @Column(name = "usuario", unique = true)
    @Size(min = 4, max = 20, message = "Usuario no Valido")
    private String user;

    @Column(name = "contraseña",nullable = false)
    @Size(min = 8, max = 16, message = "contraseña invalida")
    private String password;

    @Column(name = "telefono",nullable = false)
    @Size(min = 9, max = 9, message = "celular no valido")
    private String phone;

    @Column(name = "nombre",nullable = false)
    @Size(min = 2, max = 30, message = "nombre no valido")
    private String name;

    @Column(name = "distrito",nullable = false)
    @Size(min = 2, max = 30, message = "distrito no valido")
    private String distrito;

    @Column(name = "departamento",nullable = false)
    @Size(min = 2, max = 30, message = "region no valido")
    private String departamento;


    @Column(name = "provincia",nullable = false)
    @Size(min = 2, max = 50, message = "provincia no valido")
    private String provincia;

    @Column( name = "estado",nullable = false)
    private String status;

    @OneToMany(mappedBy = "comprador",cascade = {CascadeType.ALL})
    private List<Propuesta> propuestas;
}
