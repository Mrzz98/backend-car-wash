package com.backendcarwash.backendcarwash.controller;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.OrdenCompra;
import com.backendcarwash.backendcarwash.service.OrdenCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ordenesCompra")
@CrossOrigin(origins = "*")
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> crearOrdenCompra(@RequestBody OrdenCompra ordenCompra){
        return ordenCompraService.crearOrdenCompra(ordenCompra).build();
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getOrdenCompraById(@RequestParam Long id){
        return ordenCompraService.getOrdenCompraById(id).build();
    }


    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> editarOrdenCompra(@RequestBody OrdenCompra ordenCompra){
        return ordenCompraService.editarOrdenCompra(ordenCompra).build();
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> eliminarOrdenCompra(@RequestParam Long id){
        return ordenCompraService.eliminarOrdenCompra(id).build();
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getOrdenesCompra(){
        return ordenCompraService.getOrdenesCompra().build();
    }

}