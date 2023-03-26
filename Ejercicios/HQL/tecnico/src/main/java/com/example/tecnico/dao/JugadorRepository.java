package com.example.tecnico.dao;

import com.example.tecnico.modelo.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    //para crear un nuevo jugador debo invocar save en este repository
    //para obtener todos los jugadores uso findAll en este repository

    @Query("SELECT j FROM Jugador j where j.tecnico.nombre = ?1")
    Optional<Jugador> buscarJugador(String nombreTecnico);

}
