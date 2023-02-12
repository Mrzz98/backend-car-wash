package com.backendcarwash.backendcarwash.service;


import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.DetalleOrdenCompra;

public interface DetalleOrdenCompraService {

    ResponseDTO crearDetalleOrdenCompra(DetalleOrdenCompra detalle);

    ResponseDTO editarDetalleOrdenCompra(DetalleOrdenCompra cliente);

    ResponseDTO eliminarDetalleOrdenCompra(Long id);

    ResponseDTO getDetalleOrdenCompraById(Long id);


    ResponseDTO getDetalles();




}
