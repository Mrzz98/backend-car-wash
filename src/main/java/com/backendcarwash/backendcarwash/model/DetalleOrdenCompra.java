package com.backendcarwash.backendcarwash.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DETALLES_ORDEN_COMPRA")
public class DetalleOrdenCompra implements Serializable {


    private static final long serialVersionUID = 1L;


    @Id
    @SequenceGenerator(name = "DETALLE_ORDEN_COMPRA_ID_GENERATOR", sequenceName = "DETALLE_ORDEN_COMPRA_ID_USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DETALLE_ORDEN_COMPRA_ID_GENERATOR")
    @NotNull
    @Column(name = "ID_DETALLE_ORDEN_COMPRA", updatable = false, unique=true)
    private Long id;

    @Column(name="CANTIDAD")
    private Integer cantidad;

    @Column(name="PRECIO_COMPRA",precision=10,scale=2,columnDefinition="Decimal(10,2)")
    private Double precioCompra;
    @Column(name="SUB_TOTAL",precision=10,scale=2,columnDefinition="Decimal(10,2)")
    private Double subTotal;

    @JsonProperty("ID_ORDEN_COMPRA")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_ORDEN_COMPRA")
    private OrdenCompra ordenCompra;

    @JsonProperty("ID_PRODUCTO")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_PRODUCTO")
    private Producto producto;

}