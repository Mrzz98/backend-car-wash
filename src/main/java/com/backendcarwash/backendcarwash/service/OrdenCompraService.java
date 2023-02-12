package com.backendcarwash.backendcarwash.service;


import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.OrdenCompra;

public interface OrdenCompraService {

    ResponseDTO crearOrdenCompra(OrdenCompra ordenCompra);

    ResponseDTO editarOrdenCompra(OrdenCompra ordenCompra);

    ResponseDTO eliminarOrdenCompra(Long id);

    ResponseDTO getOrdenCompraById(Long id);

    ResponseDTO getOrdenesCompra();




}