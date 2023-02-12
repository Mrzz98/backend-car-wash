package com.backendcarwash.backendcarwash.service;

        import com.backendcarwash.backendcarwash.dto.ResponseDTO;
        import com.backendcarwash.backendcarwash.dto.TableDTO;
        import com.backendcarwash.backendcarwash.model.Producto;
        import com.backendcarwash.backendcarwash.repository.ProductoRepository;
        import lombok.RequiredArgsConstructor;
        import org.springframework.http.HttpStatus;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.Date;
        import java.util.List;
        import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    @Override
    public ResponseDTO crearProducto(Producto producto) {
        if(producto.getDescripcion() == null){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "Se requiere el Nombre.", null);
        }
        productoRepository.save(producto);


        return new ResponseDTO(new Date(), HttpStatus.OK, "Creado con exito.", null);
    }

    @Override
    public ResponseDTO editarProducto(Producto producto) {
        productoRepository.save(producto);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", null);
    }

    @Override
    public ResponseDTO eliminarProducto(Long id) {
        productoRepository.deleteById(id);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Eliminado con exito.", null);
    }

    @Override
    public ResponseDTO getProductoById(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
//        return empleado.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(producto.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El producto no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", producto.get());
    }

//    @Override
//    public ResponseDTO getProductoByCedula(String ci) {
//        Optional<Empleado> empleado = empleadoRepository.findByCedula(ci);
////        return empleado.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
//        if(empleado.isEmpty()){
//            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null);
//        }
//        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", empleado.get());
//    }

    @Override
    public ResponseDTO getProductos() {
        List<Producto> productos = productoRepository.findAll();
        TableDTO tableDTO = new TableDTO<>();
        tableDTO.setLista(productos);
        tableDTO.setTotalRecords(productos.size());

        return new ResponseDTO(new Date(), HttpStatus.OK, "Lista recuperada con exito.", tableDTO);
    }
}