package com.backendcarwash.backendcarwash.repository;

import com.backendcarwash.backendcarwash.model.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago, Long> {

//    Optional<UnidadMedida> findByCedula(String ci);

//    List<Empleado> findAllByNombre(String nombre);
}