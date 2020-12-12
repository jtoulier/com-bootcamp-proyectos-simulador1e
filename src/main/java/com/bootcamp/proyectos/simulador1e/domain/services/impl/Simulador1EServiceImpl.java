package com.bootcamp.proyectos.simulador1e.domain.services.impl;

import com.bootcamp.proyectos.simulador1e.domain.dto.ResultadoSimulacionRequest;
import com.bootcamp.proyectos.simulador1e.domain.dto.ResultadoSimulacionResponse;
import com.bootcamp.proyectos.simulador1e.domain.services.Simulador1EService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class Simulador1EServiceImpl implements Simulador1EService {
    @Override
    public ResultadoSimulacionResponse obtenerResultadoSimulacion(ResultadoSimulacionRequest resultadoSimulacionRequest) {
        boolean datosValidos;
        Double montoCuota;
        LocalDate fechaPrimeraCuota;

        Double tea;

        tea = Double.parseDouble(resultadoSimulacionRequest.getTea().replace("%", "")) / 100.0;

        datosValidos = validarDatos(resultadoSimulacionRequest);
        montoCuota = calcularCuota(resultadoSimulacionRequest.getMonto(), tea, resultadoSimulacionRequest.getCuota());
        fechaPrimeraCuota= calcularFechaPrimeraCuota();

        ResultadoSimulacionResponse resultadoSimulacionResponse = new ResultadoSimulacionResponse();


        if (datosValidos) {
            resultadoSimulacionResponse.setCuota(montoCuota);
            resultadoSimulacionResponse.setMoneda(resultadoSimulacionRequest.getMoneda());
            resultadoSimulacionResponse.setPrimeraCuota(fechaPrimeraCuota);
            resultadoSimulacionResponse.setEstado("EXITOSO");
        }
        else {
            resultadoSimulacionResponse.setEstado("ERROR");

        }

        return resultadoSimulacionResponse;
    }

    private boolean validarDatos(ResultadoSimulacionRequest resultadoSimulacionRequest) {
        return true;
    }


    private Double calcularCuota(Double montoCredito, Double tea, Integer cantidadCuotas) {
        return ((montoCredito * (1.0 + tea)) / cantidadCuotas.doubleValue());
    }

    private LocalDate calcularFechaPrimeraCuota() {
        return LocalDate.now();
    }
}
