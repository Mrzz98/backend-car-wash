package com.backendcarwash.backendcarwash.service;


import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.Proveedor;

public interface ProveedorService {

    ResponseDTO crearProveedor(Proveedor proveedor);

    ResponseDTO editarProveedor(Proveedor proveedor);

    ResponseDTO eliminarProveedor(Long id);

    ResponseDTO getProveedorById(Long id);

    ResponseDTO getProveedorByRuc(String ci);

    ResponseDTO getProveedores();




}