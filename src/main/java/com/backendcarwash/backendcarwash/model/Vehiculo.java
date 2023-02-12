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
@Table(name = "VEHICULOS")
public class Vehiculo {
    @Id
    @SequenceGenerator(name = "VEHICULOS_ID_GNERATOR", sequenceName = "VEHICULOS_ID_USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VEHICULOS_ID_GENERATOR")
    @NotNull
    @Column(name = "ID_VEHICULOS")
    private Long id;

    @NotNull
    @Column(name = "MATRICULA", unique = true)
    private String matricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    private Cliente cliente;

    @NotNull
    @Column(name = "MODELO")
    private String modelo;

    @NotNull
    @Column(name = "MARCA")
    private String marca;

    @NotNull
    @Column(name = "COLOR")
    private String color;


}