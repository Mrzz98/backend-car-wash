package com.backendcarwash.backendcarwash.repository;

import com.backendcarwash.backendcarwash.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCedula(String ci);

//    List<Empleado> findAllByNombre(String nombre);
}
