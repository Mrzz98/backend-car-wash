package com.backendcarwash.backendcarwash.service;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.dto.TableDTO;
import com.backendcarwash.backendcarwash.model.Proveedor;
import com.backendcarwash.backendcarwash.repository.ProveedorRepository;
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
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;
    @Override
    public ResponseDTO crearProveedor(Proveedor proveedor) {
        if(proveedor.getNombre() == null){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "Se requiere el Nombre.", null);
        }
        proveedorRepository.save(proveedor);


        return new ResponseDTO(new Date(), HttpStatus.OK, "Creado con exito.", null);
    }

    @Override
    public ResponseDTO editarProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", null);
    }

    @Override
    public ResponseDTO eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Eliminado con exito.", null);
    }

    @Override
    public ResponseDTO getProveedorById(Long id) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
//        return empleado.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(proveedor.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", proveedor.get());
    }

    @Override
    public ResponseDTO getProveedorByRuc(String ruc) {
        Optional<Proveedor> proveedor = proveedorRepository.findByRuc(ruc);
//        return cliente.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(proveedor.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", proveedor.get());
    }

    @Override
    public ResponseDTO getProveedores() {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        TableDTO tableDTO = new TableDTO<>();
        tableDTO.setLista(proveedores);
        tableDTO.setTotalRecords(proveedores.size());

        return new ResponseDTO(new Date(), HttpStatus.OK, "Lista recuperada con exito.", tableDTO);
    }
}