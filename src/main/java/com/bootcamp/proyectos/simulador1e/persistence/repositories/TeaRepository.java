package com.bootcamp.proyectos.simulador1e.persistence.repositories;

import com.bootcamp.proyectos.simulador1e.persistence.entities.Tea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeaRepository extends JpaRepository<Tea, String> {
}
