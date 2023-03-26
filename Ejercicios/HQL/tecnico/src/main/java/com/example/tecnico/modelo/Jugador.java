package com.example.tecnico.modelo;

import javax.persistence.*;

@Entity
@Table
public class Jugador {

    @Id
    @SequenceGenerator(name = "jugador_sequence", sequenceName = "jugador_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugador_sequence")
    private Long id;
    private String nombre;
    private String clubFavorito;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    public Jugador() {
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

    public String getClubFavorito() {
        return clubFavorito;
    }

    public void setClubFavorito(String clubFavorito) {
        this.clubFavorito = clubFavorito;
    }
}
