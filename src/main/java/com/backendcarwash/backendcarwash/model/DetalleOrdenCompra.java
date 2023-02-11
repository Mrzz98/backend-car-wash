package com.backendcarwash.backendcarwash.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DetalleOrdenCompra implements Serializable {


    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "iddetalleordencompra", updatable = false, nullable = false,unique=true)
    private Long iddetalleordencompra;

    private Integer cantidad;


    @Column(name="descuento",precision=10,scale=2,columnDefinition="Decimal(10,2)")
    private Double descuento;

    @Column(name="subtotal",precision=10,scale=2,columnDefinition="Decimal(10,2)")
    private Double subtotal;

    @Column(name="preciocompra",precision=10,scale=2,columnDefinition="Decimal(10,2)")
    private Double preciocompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idordencompra")
    @JsonBackReference
    private OrdenCompra ordencompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idproducto")
    private Producto producto;

}