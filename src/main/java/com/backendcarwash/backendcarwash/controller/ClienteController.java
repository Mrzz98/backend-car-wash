package com.backendcarwash.backendcarwash.controller;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.Cliente;
import com.backendcarwash.backendcarwash.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ResponseDTO> crearCliente(@RequestBody Cliente cliente){
        return clienteService.crearCliente(cliente).build();
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ResponseDTO> getClienteById(@RequestParam Long id){
        return clienteService.getClienteById(id).build();
    }

    @GetMapping(value = "/ci", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ResponseDTO> getClienteByCedula(@RequestParam String ci){
        return clienteService.getClienteByCedula(ci).build();
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ResponseDTO> editarCliente(@RequestBody Cliente cliente){
        return clienteService.editarCliente(cliente).build();
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ResponseDTO> eliminarCliente(@RequestParam Long id){
        return clienteService.getClienteById(id).build();
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ResponseDTO> getClientes(){
        return clienteService.getClientes().build();
    }

}
