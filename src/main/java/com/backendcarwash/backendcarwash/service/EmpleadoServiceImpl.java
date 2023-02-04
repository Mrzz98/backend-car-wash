package com.backendcarwash.backendcarwash.service;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.dto.TableDTO;
import com.backendcarwash.backendcarwash.model.Empleado;
import com.backendcarwash.backendcarwash.repository.EmpleadoRepository;
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
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    @Override
    public ResponseDTO crearEmpleado(Empleado empleado) {
        if(empleado.getNombre() == null){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "Se requiere el Nombre.", null);
        }
        empleadoRepository.save(empleado);


        return new ResponseDTO(new Date(), HttpStatus.OK, "Creado con exito.", null);
    }

    @Override
    public ResponseDTO editarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", null);
    }

    @Override
    public ResponseDTO eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Eliminado con exito.", null);
    }

    @Override
    public ResponseDTO getEmpleadoById(Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
//        return empleado.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(empleado.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", empleado.get());
    }

    @Override
    public ResponseDTO getEmpleadoByCedula(String ci) {
        Optional<Empleado> empleado = empleadoRepository.findByCedula(ci);
//        return empleado.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(empleado.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", empleado.get());
    }

    @Override
    public ResponseDTO getEmpleados() {
        List<Empleado> empleados = empleadoRepository.findAll();
        TableDTO tableDTO = new TableDTO<>();
        tableDTO.setLista(empleados);
        tableDTO.setTotalRecords(empleados.size());

        return new ResponseDTO(new Date(), HttpStatus.OK, "Lista recuperada con exito.", tableDTO);
    }
}
