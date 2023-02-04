package com.backendcarwash.backendcarwash.service;


import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.Cliente;

public interface ClienteService {

    ResponseDTO crearCliente(Cliente cliente);

    ResponseDTO editarCliente(Cliente cliente);

    ResponseDTO eliminarCliente(Long id);

    ResponseDTO getClienteById(Long id);

    ResponseDTO getClienteByCi(String ci);

    ResponseDTO getClientes();




}
