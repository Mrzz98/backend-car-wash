package com.backendcarwash.backendcarwash.repository;

import com.backendcarwash.backendcarwash.model.DetalleOrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleOrdenCompraRepository extends JpaRepository<DetalleOrdenCompra, Long> {

//    Optional<DetalleOrdenCompra> findByCedula(String ci);

//    List<Empleado> findAllByNombre(String nombre);
}

