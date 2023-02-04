package com.backendcarwash.backendcarwash.service;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.dto.TableDTO;
import com.backendcarwash.backendcarwash.model.Cliente;
import com.backendcarwash.backendcarwash.repository.ClienteRepository;
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
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    @Override
    public ResponseDTO crearCliente(Cliente cliente) {
        if(cliente.getNombre() == null){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "Se requiere el Nombre.", null);
        }
        clienteRepository.save(cliente);


        return new ResponseDTO(new Date(), HttpStatus.OK, "Creado con exito.", null);
    }

    @Override
    public ResponseDTO editarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", null);
    }

    @Override
    public ResponseDTO eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
        return new ResponseDTO(new Date(), HttpStatus.OK, "Eliminado con exito.", null);
    }

    @Override
    public ResponseDTO getClienteById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
//        return empleado.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(cliente.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", cliente.get());
    }

    @Override
    public ResponseDTO getClienteByCedula(String ci) {
        Optional<Cliente> cliente = clienteRepository.findByCedula(ci);
//        return cliente.map(value -> new ResponseDTO(new Date(), HttpStatus.OK, "Actualizado con exito.", value)).orElseGet(() -> new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null));
        if(cliente.isEmpty()){
            return new ResponseDTO(new Date(), HttpStatus.BAD_REQUEST, "El empleado no existe", null);
        }
        return new ResponseDTO(new Date(), HttpStatus.OK, "Objeto recuperado con exito.", cliente.get());
    }

    @Override
    public ResponseDTO getClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        TableDTO tableDTO = new TableDTO<>();
        tableDTO.setLista(clientes);
        tableDTO.setTotalRecords(clientes.size());

        return new ResponseDTO(new Date(), HttpStatus.OK, "Lista recuperada con exito.", tableDTO);
    }
}
