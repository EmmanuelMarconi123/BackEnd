package com.ProyectoFinal.ProyectoFinal.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name="Pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private Integer DNI;

    @Column
    private Date fechaDeIngreso;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilios_id")
    private Domicilio domicilio;



    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turno = new HashSet<>();


    public Paciente(String nombre, String apellido, Integer DNI, Date fechaDeIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilio = domicilio;
    }

    public Paciente() {
    }
}
