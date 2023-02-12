package com.backendcarwash.backendcarwash.repository;

        import com.backendcarwash.backendcarwash.model.Producto;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

//    Optional<Producto> findByCedula(String ci);

//    List<Empleado> findAllByNombre(String nombre);
}