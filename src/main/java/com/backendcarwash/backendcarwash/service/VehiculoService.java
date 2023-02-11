package com.backendcarwash.backendcarwash.service;


import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.Vehiculo;

public interface VehiculoService {

    ResponseDTO crearVehiculo(Vehiculo vehiculo);

    ResponseDTO editarVehiculo(Vehiculo vehiculo);

    ResponseDTO eliminarVehiculo(Long id);

    ResponseDTO getVehiculoById(Long id);

    ResponseDTO getVehiculoByMatricula(String matricula);

    ResponseDTO getVehiculos();




}
