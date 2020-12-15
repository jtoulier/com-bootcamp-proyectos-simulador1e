package com.bootcamp.proyectos.simulador1e.domain.services.impl;

import com.bootcamp.proyectos.simulador1e.domain.dto.ResultadoSimulacionRequest;
import com.bootcamp.proyectos.simulador1e.domain.dto.ResultadoSimulacionResponse;
import com.bootcamp.proyectos.simulador1e.domain.services.Simulador1EService;
import com.bootcamp.proyectos.simulador1e.persistence.entities.Client;
import com.bootcamp.proyectos.simulador1e.persistence.entities.Tarjeta;
import com.bootcamp.proyectos.simulador1e.persistence.entities.Tea;
import com.bootcamp.proyectos.simulador1e.persistence.repositories.ClientRepository;
import com.bootcamp.proyectos.simulador1e.persistence.repositories.TarjetaRepository;
import com.bootcamp.proyectos.simulador1e.persistence.repositories.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import org.joda.time.MutableDateTime;

@Service
public class Simulador1EServiceImpl implements Simulador1EService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TarjetaRepository tarjetaRepository;

    @Autowired
    TeaRepository teaRepository;

    @Override
    public ResultadoSimulacionResponse obtenerResultadoSimulacion(ResultadoSimulacionRequest resultadoSimulacionRequest) {
        boolean datosValidos;
        Double montoCuota;
        LocalDate fechaPrimeraCuota;
        ResultadoSimulacionResponse resultadoSimulacionResponse = new ResultadoSimulacionResponse();

        Double tea;

        tea = Double.parseDouble(resultadoSimulacionRequest.getTea().replace("%", "")) / 100.0;

        datosValidos = validarDatos(resultadoSimulacionRequest);

        if (datosValidos) {
            montoCuota = calcularCuota(resultadoSimulacionRequest.getMonto(), tea, resultadoSimulacionRequest.getCuota());
            fechaPrimeraCuota= calcularFechaPrimeraCuota(resultadoSimulacionRequest.getDiaPago());


            resultadoSimulacionResponse.setCuota(montoCuota);
            resultadoSimulacionResponse.setMoneda(resultadoSimulacionRequest.getMoneda());
            resultadoSimulacionResponse.setPrimeraCuota(fechaPrimeraCuota);
            resultadoSimulacionResponse.setEstado("EXITOSO");

        }
        else {
            resultadoSimulacionResponse.setEstado("ABEND: ERROR DATOS NO VALIDOS");
        }


        return resultadoSimulacionResponse;
    }

    private boolean validarDatos(ResultadoSimulacionRequest resultadoSimulacionRequest) {


        // validar DNI
        try {
            Client client;

            System.out.println("Obteniendo cliente ...");
            client = clientRepository.findById(resultadoSimulacionRequest.getDni()).get();
            System.out.println("client = " + client);


            Tarjeta tarjeta;

            System.out.println("Obteniendo tarjeta ...");
            tarjeta = tarjetaRepository.findById(resultadoSimulacionRequest.getTarjeta()).get();
            System.out.println("tarjeta = " + tarjeta);


            Tea tea;

            System.out.println("Obteniendo TEA ...");
            tea = teaRepository.findById(resultadoSimulacionRequest.getTea()).get();
            System.out.println("tea = " + tea);


            return true;
        }
        catch (Exception e) {
            System.out.println("Datos no validos");
            return false;
        }

    }


    private Double calcularCuota(Double montoCredito, Double tea, Integer cantidadCuotas) {
        return ((montoCredito * (1.0 + tea)) / cantidadCuotas.doubleValue());
    }

    private LocalDate calcularFechaPrimeraCuota(Integer diaPago) {
        System.out.println("Calculando fecha primera cuota");
        System.out.println("diaPago = " + diaPago);

        LocalDate hoy = LocalDate.now();
        System.out.println("hoy = " + hoy);
        
        LocalDate deAcaUnMes = hoy.plusMonths(1);
        System.out.println("deAcaUnMes = " + deAcaUnMes);

        LocalDate fechaPago = LocalDate.of(deAcaUnMes.getYear(), deAcaUnMes.getMonth(), diaPago);
        System.out.println("fechaPago = " + fechaPago);
        
        return fechaPago;
    }
}
