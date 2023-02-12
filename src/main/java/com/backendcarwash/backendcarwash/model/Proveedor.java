package com.backendcarwash.backendcarwash.model;

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
@Table(name = "Proveedores")
public class Proveedor {


    @Id
    @SequenceGenerator(name = "PROVEEDOR_ID_GENERATOR", sequenceName = "PROVEEDOR_ID_USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVEEDOR_ID_GENERATOR")
    @NotNull
    @Column(name = "ID_PROVEEDOR")
    private Long id;

    @NotNull
    @Column(name = "NOMBRE")
    private String nombre;

    @NotNull
    @Column(name = "CEDULA", unique = true)
    private String cedula;

    @NotNull
    @Column(name = "RUC_PROVEEDOR")
    private String ruc;

    @NotNull
    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "TELEFONO")
    private String telefono;

    @Email
    @Column(name = "EMAIL")
    private String correo;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    @Column(name = "FECHA_INGRESO")
    private Date fechaIngreso;

}
