package com.backendcarwash.backendcarwash.service;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.dto.TableDTO;
import com.backendcarwash.backendcarwash.model.Vehiculo;
import com.backendcarwash.backendcarwash.repository.VehiculoRepository;
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
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    @Override
    public ResponseDTO crearVehiculo(Vehiculo vehiculo) {
        if(vehiculo.getMatricula() == null){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "Se requiere la matricula.", null);
        }
        vehiculoRepository.save(vehiculo);


        return new ResponseDTO(new Date(), HttpStatus.OK, "Creado con exito.", null);
    }

    @Override
    public ResponseDTO editarVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", null);
    }

    @Override
    public ResponseDTO eliminarVehiculo(Long id) {
        vehiculoRepository.deleteById(id);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Eliminado con exito.", null);
    }

    @Override
    public ResponseDTO getVehiculoById(Long id) {
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
//        return empleado.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(vehiculo.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", vehiculo.get());
    }

    @Override
    public ResponseDTO getVehiculoByMatricula(String matricula) {
        Optional<Vehiculo> vehiculo = vehiculoRepository.findByMatricula(matricula);
//        return empleado.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(vehiculo.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El vehiculo no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", vehiculo.get());
    }

    @Override
    public ResponseDTO getVehiculos() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        TableDTO tableDTO = new TableDTO<>();
        tableDTO.setLista(vehiculos);
        tableDTO.setTotalRecords(vehiculos.size());

        return new ResponseDTO(new Date(), HttpStatus.OK, "Lista recuperada con exito.", tableDTO);
    }
}
