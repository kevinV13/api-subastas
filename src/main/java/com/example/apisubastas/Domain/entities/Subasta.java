package com.example.apisubastas.Domain.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "subastas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Subasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubasta;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Temporal(TemporalType.TIMESTAMP)
    @Column( name = "fecha",nullable = false)
    private Calendar fecha;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    @Column( name = "fecha_recojo" )
    private Date FechaRecojo;

    @Column( name = "estado", nullable = false)
    private String status;

    @Column( name = "PropuestaSeleccionada")
    private Integer seleccionado;

    @Column(name = "Comprador_OK",nullable = false)
    private Boolean CompradorOk;

    @Column(name = "Vendedor_OK",nullable = false)
    private Boolean VendedorOk;

    @OneToMany(mappedBy = "subasta",cascade = {CascadeType.ALL})
    private List<Propuesta> propuestas;

    @ManyToOne
    @JoinColumn( name = "idVendedor", foreignKey = @ForeignKey(name = "FK_Subasta_Vendedor"),nullable = false)
    private Vendedor vendedor;



    @OneToOne
    @JoinColumn(name = "idChatarra",foreignKey = @ForeignKey(name = "FK_Subasta_Chatarra"))
    private Chatarra chatarra;

}
