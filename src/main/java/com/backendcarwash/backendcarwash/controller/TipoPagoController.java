package com.backendcarwash.backendcarwash.controller;

import com.backendcarwash.backendcarwash.dto.ResponseDTO;
import com.backendcarwash.backendcarwash.model.TipoPago;
import com.backendcarwash.backendcarwash.service.TipoPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tiposPago")
@CrossOrigin(origins = "*")
public class TipoPagoController {

    private final TipoPagoService tipoPagoService;
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> crearTipoPago(@RequestBody TipoPago tipoPago){
        return tipoPagoService.crearTipoPago(tipoPago).build();
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getTipoPagoById(@RequestParam Long id){
        return tipoPagoService.getTipoPagoById(id).build();
    }


    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> editarTipoPago(@RequestBody TipoPago tipoPago){
        return tipoPagoService.editarTipoPago(tipoPago).build();
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> eliminarTipoPago(@RequestParam Long id){
        return tipoPagoService.eliminarTipoPago(id).build();
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseDTO> getTiposPago(){
        return tipoPagoService.getTiposPago().build();
    }

}
