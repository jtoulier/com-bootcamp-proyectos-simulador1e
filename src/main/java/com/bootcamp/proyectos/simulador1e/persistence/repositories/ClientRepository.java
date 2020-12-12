package com.bootcamp.proyectos.simulador1e.persistence.repositories;

import com.bootcamp.proyectos.simulador1e.persistence.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
