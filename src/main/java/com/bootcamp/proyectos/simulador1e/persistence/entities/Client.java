package com.bootcamp.proyectos.simulador1e.persistence.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client", schema = "dbo")
@Getter
public class Client {
    @Id
    @Column(name = "dni")
    private String dni;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "nombres")
    private String nombres;
}
