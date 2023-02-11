package com.backendcarwash.backendcarwash.service;


import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.UnidadMedida;

public interface UnidadMedidaService {

    ResponseDTO crearUnidadMedida(UnidadMedida unidadMedida);

    ResponseDTO editarUnidadMedida(UnidadMedida unidadMedida);

    ResponseDTO eliminarUnidadMedida(Long id);

    ResponseDTO getUnidadMedidaById(Long id);

//    ResponseDTO getEmpleadoByCedula(String ci);

    ResponseDTO getUnidadesMedida();




}