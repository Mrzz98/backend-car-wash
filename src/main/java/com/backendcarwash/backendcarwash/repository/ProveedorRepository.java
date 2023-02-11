package com.backendcarwash.backendcarwash.repository;


import com.backendcarwash.backendcarwash.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    Optional<Proveedor> findByRuc(String ruc);

//    List<Empleado> findAllByNombre(String nombre);
}
