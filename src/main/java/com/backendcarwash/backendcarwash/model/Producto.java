package com.backendcarwash.backendcarwash.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCTOS")
public class Producto {
    @Id
    @SequenceGenerator(name = "PRODUCTO_ID_GENERATOR", sequenceName = "PRODUCTO_ID_USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTO_ID_GENERATOR")
    @NotNull
    @Column(name = "ID_PRODUCTO")
    private Long id;

    @NotNull
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @NotNull
    @Column(name = "TIPO")
    private String tipo;
    @NotNull
    @Column(name = "PRECIO_COMPRA")
    private Double precioCompra;

    @NotNull
    @Column(name = "PRECIO_VENTA")
    private Double precioVenta;

    @NotNull
    @Column(name = "COSTO_SERVICIO")
    private Double costoServicio;

    @Column(name = "EXISTENCIA")
    private Long existencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_UNIDAD_MEDIDA")
    @JsonBackReference
    private UnidadMedida unidadMedida;


}
