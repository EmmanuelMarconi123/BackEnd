package com.example.profesor.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Profesor {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String titulo;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY)
    private Set<Alumno> alumnos = new HashSet<>();

    public Profesor() {
    }

    public Profesor(String nombre, String titulo) {
        this.nombre = nombre;
        this.titulo = titulo;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
