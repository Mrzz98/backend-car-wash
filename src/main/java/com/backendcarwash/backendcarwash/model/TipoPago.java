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
@Table(name = "TIPO_PAGO")
public class TipoPago {

    @Id
    @SequenceGenerator(name = "TIPO_PAGO_ID_GENERATOR", sequenceName = "TIPO_PAGO_ID_USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_PAGO_ID_GENERATOR")
    @NotNull
    @Column(name = "ID_TIPO_PAGO")
    private Long id;

    @NotNull
    @Column(name = "DESCRIPCION")
    private String descripcion;
}
