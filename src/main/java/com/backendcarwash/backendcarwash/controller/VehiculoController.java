package com.backendcarwash.backendcarwash.controller;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.Vehiculo;
import com.backendcarwash.backendcarwash.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehiculos")
@CrossOrigin(origins = "*")
public class VehiculoController {

    private final VehiculoService vehiculoService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> crearEmpleado(@RequestBody Vehiculo vehiculo){
        return vehiculoService.crearVehiculo(vehiculo).build();
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getVehiculoById(@RequestParam Long id){
        return vehiculoService.getVehiculoById(id).build();
    }

    @GetMapping(value = "/matricula", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getVehiculoByMatricula(@RequestParam String ci){
        return vehiculoService.getVehiculoByMatricula(ci).build();
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> editarVehiculo(@RequestBody Vehiculo vehiculo){
        return vehiculoService.editarVehiculo(vehiculo).build();
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> eliminarVehiculo(@RequestParam Long id){
        return vehiculoService.eliminarVehiculo(id).build();
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getVehiculos(){
        return vehiculoService.getVehiculos().build();
    }

}