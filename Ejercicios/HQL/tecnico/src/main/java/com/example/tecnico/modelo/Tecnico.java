package com.example.tecnico.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Tecnico {

    @Id
    @SequenceGenerator(name = "tecnico_sequence", sequenceName = "tecnico_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tecnico_sequence")
    private Long id;
    private String nombre;
    private int edad;
    @OneToMany(mappedBy = "tecnico", fetch = FetchType.LAZY)
    private Set<Jugador> jugadores = new HashSet<>();

    public Tecnico() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
