package com.backendcarwash.backendcarwash.controller;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.DetalleOrdenCompra;
import com.backendcarwash.backendcarwash.service.DetalleOrdenCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detalles")
@CrossOrigin(origins = "*")
public class DetalleOrdenCompraController {

    private final DetalleOrdenCompraService detalleOrdenCompraService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> crearDetalleOrdenCompra(@RequestBody DetalleOrdenCompra detalleOrdenCompra){
        return detalleOrdenCompraService.crearDetalleOrdenCompra(detalleOrdenCompra).build();
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getDetalleOrdenCompraById(@RequestParam Long id){
        return detalleOrdenCompraService.getDetalleOrdenCompraById(id).build();
    }


    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> editarDetalleOrdenCompra(@RequestBody DetalleOrdenCompra detalleOrdenCompra){
        return detalleOrdenCompraService.editarDetalleOrdenCompra(detalleOrdenCompra).build();
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> eliminarDetalleOrdenCompra(@RequestParam Long id){
        return detalleOrdenCompraService.eliminarDetalleOrdenCompra(id).build();
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getDetalles(){
        return detalleOrdenCompraService.getDetalles().build();
    }

}
