package com.backendcarwash.backendcarwash.service;


import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.TipoPago;

public interface TipoPagoService {

    ResponseDTO crearTipoPago(TipoPago unidadMedida);

    ResponseDTO editarTipoPago(TipoPago unidadMedida);

    ResponseDTO eliminarTipoPago(Long id);

    ResponseDTO getTipoPagoById(Long id);

//    ResponseDTO getEmpleadoByCedula(String ci);

    ResponseDTO getTiposPago();




}