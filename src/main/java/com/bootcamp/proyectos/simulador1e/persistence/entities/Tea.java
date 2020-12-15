package com.bootcamp.proyectos.simulador1e.persistence.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tea", schema = "dbo")
@Getter
public class Tea {
    @Id
    @Column(name = "tea")
    private String tea;
}
