package com.backendcarwash.backendcarwash.controller;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.UnidadMedida;
import com.backendcarwash.backendcarwash.service.UnidadMedidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequiredArgsConstructor
@RequestMapping("/unidadesMedida")
@CrossOrigin(origins = "*")
public class UnidadMedidaController {

    private final UnidadMedidaService unidadMedidaService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> crearUnidadMedida(@RequestBody UnidadMedida unidadMedida){
        return unidadMedidaService.crearUnidadMedida(unidadMedida).build();
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getUnidadMedidaById(@RequestParam Long id){
        return unidadMedidaService.getUnidadMedidaById(id).build();
    }


    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> editarUnidadMedida(@RequestBody UnidadMedida unidadMedida){
        return unidadMedidaService.editarUnidadMedida(unidadMedida).build();
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> eliminarUnidadMedida(@RequestParam Long id){
        return unidadMedidaService.eliminarUnidadMedida(id).build();
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getUnidadesMedida(){
        return unidadMedidaService.getUnidadesMedida().build();
    }

}