package com.backendcarwash.backendcarwash.service;


import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.Empleado;

public interface EmpleadoService {

    ResponseDTO crearEmpleado(Empleado empleado);

    ResponseDTO editarEmpleado(Empleado empleado);

    ResponseDTO eliminarEmpleado(Long id);

    ResponseDTO getEmpleadoById(Long id);

    ResponseDTO getEmpleadoByCedula(String ci);

    ResponseDTO getEmpleados();




}
