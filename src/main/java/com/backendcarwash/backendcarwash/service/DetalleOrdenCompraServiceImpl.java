package com.backendcarwash.backendcarwash.service;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.dto.TableDTO;
import com.backendcarwash.backendcarwash.model.DetalleOrdenCompra;
import com.backendcarwash.backendcarwash.repository.DetalleOrdenCompraRepository;
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
public class DetalleOrdenCompraServiceImpl implements DetalleOrdenCompraService {

    private final DetalleOrdenCompraRepository detalleOrdenCompraRepository;
    @Override
    public ResponseDTO crearDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) {
        if(detalleOrdenCompra.getProducto() == null){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "Se requiere el Nombre.", null);
        }
        detalleOrdenCompraRepository.save(detalleOrdenCompra);


        return new ResponseDTO(new Date(), HttpStatus.OK, "Creado con exito.", null);
    }

    @Override
    public ResponseDTO editarDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) {
        detalleOrdenCompraRepository.save(detalleOrdenCompra);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", null);
    }

    @Override
    public ResponseDTO eliminarDetalleOrdenCompra(Long id) {
        detalleOrdenCompraRepository.deleteById(id);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Eliminado con exito.", null);
    }

    @Override
    public ResponseDTO getDetalleOrdenCompraById(Long id) {
        Optional<DetalleOrdenCompra> detalleOrdenCompra = detalleOrdenCompraRepository.findById(id);
//        return empleado.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(detalleOrdenCompra.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El detalle no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", detalleOrdenCompra.get());
    }


    @Override
    public ResponseDTO getDetalles() {
        List<DetalleOrdenCompra> detalles = detalleOrdenCompraRepository.findAll();
        TableDTO tableDTO = new TableDTO<>();
        tableDTO.setLista(detalles);
        tableDTO.setTotalRecords(detalles.size());

        return new ResponseDTO(new Date(), HttpStatus.OK, "Lista recuperada con exito.", tableDTO);
    }
}
