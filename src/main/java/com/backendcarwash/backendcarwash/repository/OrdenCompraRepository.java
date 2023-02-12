package com.backendcarwash.backendcarwash.repository;

import com.backendcarwash.backendcarwash.model.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {

//    Optional<OrdenCompra> findByCedula(String ci);

//    List<Empleado> findAllByNombre(String nombre);
}
