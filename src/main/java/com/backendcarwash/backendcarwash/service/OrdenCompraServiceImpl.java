package com.backendcarwash.backendcarwash.service;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.dto.TableDTO;
import com.backendcarwash.backendcarwash.model.OrdenCompra;
import com.backendcarwash.backendcarwash.repository.OrdenCompraRepository;
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
public class OrdenCompraServiceImpl implements OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;
    @Override
    public ResponseDTO crearOrdenCompra(OrdenCompra ordenCompra) {
        if(ordenCompra.getDetalles() == null){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "Se requieren los detalles.", null);
        }
        ordenCompraRepository.save(ordenCompra);


        return new ResponseDTO(new Date(), HttpStatus.OK, "Creado con exito.", null);
    }

    @Override
    public ResponseDTO editarOrdenCompra(OrdenCompra ordenCompra) {
        ordenCompraRepository.save(ordenCompra);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", null);
    }

    @Override
    public ResponseDTO eliminarOrdenCompra(Long id) {
        ordenCompraRepository.deleteById(id);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Eliminado con exito.", null);
    }

    @Override
    public ResponseDTO getOrdenCompraById(Long id) {
        Optional<OrdenCompra> ordenCompra = ordenCompraRepository.findById(id);
//        return empleado.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(ordenCompra.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", ordenCompra.get());
    }


    @Override
    public ResponseDTO getOrdenesCompra() {
        List<OrdenCompra> ordenesCompra = ordenCompraRepository.findAll();
        TableDTO tableDTO = new TableDTO<>();
        tableDTO.setLista(ordenesCompra);
        tableDTO.setTotalRecords(ordenesCompra.size());

        return new ResponseDTO(new Date(), HttpStatus.OK, "Lista recuperada con exito.", tableDTO);
    }
}
