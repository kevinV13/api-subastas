package com.example.apisubastas.Domain.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Data
@Entity
@Table(name = "propuestas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Propuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropuesta;

    @Column( name = "precio",nullable = false)
    private Float price;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Temporal(TemporalType.TIMESTAMP)
    @Column( name = "tiempo",nullable = false)
    private Calendar time;

    @ManyToOne
    @JoinColumn( name = "idSubasta", foreignKey = @ForeignKey(name = "FK_Propuestas_Subasta"))
    private Subasta subasta;

    @ManyToOne
    @JoinColumn( name = "idShopper", foreignKey = @ForeignKey(name = "FK_Propuestas_Comprador"))
    private Comprador comprador;

}