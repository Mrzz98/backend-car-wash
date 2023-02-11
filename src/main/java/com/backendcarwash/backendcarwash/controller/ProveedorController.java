package com.backendcarwash.backendcarwash.controller;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.Proveedor;
import com.backendcarwash.backendcarwash.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequiredArgsConstructor
@RequestMapping("/proveedores")
@CrossOrigin(origins = "*")
public class ProveedorController {

    private final ProveedorService proveedorService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> crearEmpleado(@RequestBody Proveedor proveedor){
        return proveedorService.crearProveedor(proveedor).build();
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getProveedorById(@RequestParam Long id){
        return proveedorService.getProveedorById(id).build();
    }

    @GetMapping(value = "/ruc", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getProveedorByRuc(@RequestParam String ruc){
        return proveedorService.getProveedorByRuc(ruc).build();
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> editarProveedor(@RequestBody Proveedor proveedor){
        return proveedorService.editarProveedor(proveedor).build();
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> eliminarProveedor(@RequestParam Long id){
        return proveedorService.eliminarProveedor(id).build();
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getProveedores(){
        return proveedorService.getProveedores().build();
    }

}
