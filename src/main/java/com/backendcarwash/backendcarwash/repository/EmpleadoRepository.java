package com.backendcarwash.backendcarwash.repository;

import com.backendcarwash.backendcarwash.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Optional<Empleado> findByNombre(String nombre);

//    List<Empleado> findAllByNombre(String nombre);
}
