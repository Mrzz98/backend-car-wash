package com.backendcarwash.backendcarwash.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAGOS")
public class Pago {
    @Id
    @SequenceGenerator(name = "PAGO_ID_GENERATOR", sequenceName = "PAGO_ID_USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAGO_ID_GENERATOR")
    @NotNull
    @Column(name = "ID_PAGO")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_ORDEN_COMPRA")
    private OrdenCompra ordenCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_TIPO_PAGO")
    private TipoPago tipopago;

    @Column(name="MONTO")
    private Long monto;
}
