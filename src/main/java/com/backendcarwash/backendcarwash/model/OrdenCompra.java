package com.backendcarwash.backendcarwash.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OrdenCompra implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID_ORDEN_COMPRA", updatable = false, nullable = false,unique=true)
    private Long idOrdenCompra;

    @Column(name="NUMERO_ORDEN_COMPRA",nullable=false,length=6)
    private String numeroOrdenCompra;

    @NotNull(message="No puede estar vacio")
    @Column(name="FECHA_EMISION")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaEmision;

    @Column(name="OBSERVACIONES",nullable=false,length=300)
    private String observaciones;


    @OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true )
    @JoinColumn(name="ID_DETALLE_ORDEN_COMPRA")
    @JsonManagedReference
    private Set<DetalleOrdenCompra> detalleordencompra= new HashSet<DetalleOrdenCompra>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_PROVEEDOR")
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_TIPO_PAGO")
    private TipoPago tipopago;

    @Column(name="TOTAL_PAGO")
    private Double total;

}