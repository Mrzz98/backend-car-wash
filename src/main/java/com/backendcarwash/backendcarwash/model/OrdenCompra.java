package com.backendcarwash.backendcarwash.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDEN_COMPRA")
public class OrdenCompra implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ORDEN_COMPRA_ID_GENERATOR", sequenceName = "ORDEN_COMPRA_ID_USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDEN_COMPRA_ID_GENERATOR")
    @NotNull
    @Column(name = "ID_ORDEN_COMPRA", updatable = false, unique=true)
    private Long idOrdenCompra;

//    @Column(name="NUMERO_ORDEN_COMPRA",nullable=false,length=6)
//    private String numeroOrdenCompra;

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

    @Column(name="TOTAL_PAGO")
    private Double total;

}