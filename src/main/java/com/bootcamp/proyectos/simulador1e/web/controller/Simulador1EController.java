package com.bootcamp.proyectos.simulador1e.web.controller;

import com.bootcamp.proyectos.simulador1e.domain.dto.ResultadoSimulacionRequest;
import com.bootcamp.proyectos.simulador1e.domain.dto.ResultadoSimulacionResponse;
import com.bootcamp.proyectos.simulador1e.domain.services.Simulador1EService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("simulador1e")
public class Simulador1EController {
    @Autowired
    Simulador1EService simulador1EService;

    @PostMapping(value = "/",
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResultadoSimulacionResponse> obtenerResultadoSimulacion(@Valid @RequestBody ResultadoSimulacionRequest resultadoSimulacionRequest) {
        ResultadoSimulacionResponse resultadoSimulacionResponse =simulador1EService.obtenerResultadoSimulacion(resultadoSimulacionRequest);
        String estado = resultadoSimulacionResponse.getEstado();

        if (estado.equals("EXITOSO")) {
            return new ResponseEntity<>(resultadoSimulacionResponse, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(resultadoSimulacionResponse, HttpStatus.BAD_REQUEST);
        }

    }
}
