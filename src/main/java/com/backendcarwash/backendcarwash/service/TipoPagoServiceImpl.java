package com.backendcarwash.backendcarwash.service;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.dto.TableDTO;
import com.backendcarwash.backendcarwash.model.TipoPago;
import com.backendcarwash.backendcarwash.repository.TipoPagoRepository;
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
public class TipoPagoServiceImpl implements TipoPagoService {

    private final TipoPagoRepository tipoPagoRepository;
    @Override
    public ResponseDTO crearTipoPago(TipoPago tipoPago) {
        if(tipoPago.getDescripcion() == null){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "Se requiere el Nombre.", null);
        }
        tipoPagoRepository.save(tipoPago);


        return new ResponseDTO(new Date(), HttpStatus.OK, "Creado con exito.", null);
    }

    @Override
    public ResponseDTO editarTipoPago(TipoPago tipoPago) {
        tipoPagoRepository.save(tipoPago);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", null);
    }

    @Override
    public ResponseDTO eliminarTipoPago(Long id) {
        tipoPagoRepository.deleteById(id);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Eliminado con exito.", null);
    }

    @Override
    public ResponseDTO getTipoPagoById(Long id) {
        Optional<TipoPago> tipoPago = tipoPagoRepository.findById(id);
//        return empleado.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(tipoPago.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El tipo de pago no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", tipoPago.get());
    }


    @Override
    public ResponseDTO getTiposPago() {
        List<TipoPago> tiposPago = tipoPagoRepository.findAll();
        TableDTO tableDTO = new TableDTO<>();
        tableDTO.setLista(tiposPago);
        tableDTO.setTotalRecords(tiposPago.size());

        return new ResponseDTO(new Date(), HttpStatus.OK, "Lista recuperada con exito.", tableDTO);
    }
}
