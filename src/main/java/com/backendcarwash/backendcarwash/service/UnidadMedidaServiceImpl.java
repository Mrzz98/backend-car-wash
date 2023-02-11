package com.backendcarwash.backendcarwash.service;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.dto.TableDTO;
import com.backendcarwash.backendcarwash.model.UnidadMedida;
import com.backendcarwash.backendcarwash.repository.EmpleadoRepository;
import com.backendcarwash.backendcarwash.repository.UnidadMedidaRepository;
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
public class UnidadMedidaServiceImpl implements UnidadMedidaService {

    private final UnidadMedidaRepository unidadMedidaRepository;
    private final EmpleadoRepository empleadoRepository;

    @Override
    public ResponseDTO crearUnidadMedida(UnidadMedida unidadMedida) {
        if(unidadMedida.getDescripcion() == null){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "Se requiere el Nombre.", null);
        }
        unidadMedidaRepository.save(unidadMedida);


        return new ResponseDTO(new Date(), HttpStatus.OK, "Creado con exito.", null);
    }

    @Override
    public ResponseDTO editarUnidadMedida(UnidadMedida unidadMedida) {
        unidadMedidaRepository.save(unidadMedida);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", null);
    }

    @Override
    public ResponseDTO eliminarUnidadMedida(Long id) {
        unidadMedidaRepository.deleteById(id);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Eliminado con exito.", null);
    }

    @Override
    public ResponseDTO getUnidadMedidaById(Long id) {
        Optional<UnidadMedida> unidadMedida = unidadMedidaRepository.findById(id);
//        return empleado.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(unidadMedida.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", unidadMedida.get());
    }


    @Override
    public ResponseDTO getUnidadesMedida() {
        List<UnidadMedida> unidadesMedida = unidadMedidaRepository.findAll();
        TableDTO tableDTO = new TableDTO<>();
        tableDTO.setLista(unidadesMedida);
        tableDTO.setTotalRecords(unidadesMedida.size());

        return new ResponseDTO(new Date(), HttpStatus.OK, "Lista recuperada con exito.", tableDTO);
    }
}
