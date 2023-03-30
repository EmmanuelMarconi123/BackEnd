package com.ProyectoFinal.ProyectoFinal.persistence.entities;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {

    private Integer id;

    private String nombre;

    private String apellido;

    private Integer DNI;
}
