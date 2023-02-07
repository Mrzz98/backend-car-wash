package com.backendcarwash.backendcarwash.controller;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.Empleado;
import com.backendcarwash.backendcarwash.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ResponseDTO> crearEmpleado(@RequestBody Empleado empleado){
        return empleadoService.crearEmpleado(empleado).build();
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ResponseDTO> getEmpleadoById(@RequestParam Long id){
        return empleadoService.getEmpleadoById(id).build();
    }

    @GetMapping(value = "/ci", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getEmpleadoByCedula(@RequestParam String ci){
        return empleadoService.getEmpleadoByCedula(ci).build();
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ResponseDTO> editarEmpleado(@RequestBody Empleado empleado){
        return empleadoService.editarEmpleado(empleado).build();
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ResponseDTO> eliminarEmpleado(@RequestParam Long id){
        return empleadoService.getEmpleadoById(id).build();
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<ResponseDTO> getEmpleados(){
        return empleadoService.getEmpleados().build();
    }

}
