package com.example.tecnico.dao;

import com.example.tecnico.modelo.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

    //1- un método que cree un nuevo Director Técnico, este merodo es el metodo save en el repository

    //2- un método para agregar jugadores al técnico, debemos agregar un jugador al tecnico desde el add collection y despues save.
    //Ejemplo: tecnico.getJugadores().add(tecnico) y despues save, por medio de la cascada va a crear al jugador sino existe

    @Query("SELECT t FROM Tecnico t where t.nombre = ?1")
    Optional<Tecnico> buscarTecnico(String nombre);
}
