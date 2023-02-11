package com.backendcarwash.backendcarwash.repository;

import com.backendcarwash.backendcarwash.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    Optional<Vehiculo> findByMatricula(String matricula);

//    List<Empleado> findAllByNombre(String nombre);
}
