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
@Table(name = "UNIDADES_MEDIDA")
public class UnidadMedida {
    @Id
    @SequenceGenerator(name = "UNIDAD_MEDIDA_ID_GENERATOR", sequenceName = "UNIDAD_MEDIDA_ID_USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UNIDAD_MEDIDA_ID_GENERATOR")
    @NotNull
    @Column(name = "ID_UNIDAD_MEDIDA")
    private Long id;
    @NotNull
    @Column(name = "DESCRIPCION")
    private String descripcion;
}

