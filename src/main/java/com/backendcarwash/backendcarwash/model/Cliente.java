package com.backendcarwash.backendcarwash.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "CLIENTES")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cliente {

    @Id
    @SequenceGenerator(name = "CLIENTE_ID_GENERATOR", sequenceName = "CLIENTE_ID_USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_ID_GENERATOR")
    @NotNull
    @Column(name = "ID_CLIENTE")
    private Long id;
    @NotNull
    @Column(name = "NOMBRE")
    private String nombre;
    @NotNull
    @Column(name = "APELLIDO")
    private String apellido;
    @NotNull
    @Column(name = "CEDULA", unique = true)
    private String cedula;

    @NotNull
    @Column(name = "RUC_CLIENTE")
    private String ruc;

    @Column(name = "TELEFONO")
    private String telefono;
    @Email
    @Column(name = "EMAIL")
    private String correo;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-dd-mm hh:mm")
    @Column(name = "FECHA_INGRESO")
    private Date fechaIngreso;



}
