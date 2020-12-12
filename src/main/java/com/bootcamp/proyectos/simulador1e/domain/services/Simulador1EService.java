package com.bootcamp.proyectos.simulador1e.domain.services;

import com.bootcamp.proyectos.simulador1e.domain.dto.ResultadoSimulacionRequest;
import com.bootcamp.proyectos.simulador1e.domain.dto.ResultadoSimulacionResponse;

public interface Simulador1EService {

    ResultadoSimulacionResponse obtenerResultadoSimulacion(ResultadoSimulacionRequest resultadoSimulacionRequest);
}
