package com.backendcarwash.backendcarwash.service;


import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.Producto;

public interface ProductoService {

    ResponseDTO crearProducto(Producto producto);

    ResponseDTO editarProducto(Producto producto);

    ResponseDTO eliminarProducto(Long id);

    ResponseDTO getProductoById(Long id);

//    ResponseDTO getProductoByCedula(String ci);

    ResponseDTO getProductos();




}
