package com.bootcamp.proyectos.simulador1e.persistence.repositories;

import com.bootcamp.proyectos.simulador1e.persistence.entities.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetaRepository extends JpaRepository<Tarjeta, String> {
}
