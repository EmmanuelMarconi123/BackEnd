package com.ProyectoFinal.ProyectoFinal.persistence.repository;

import com.ProyectoFinal.ProyectoFinal.persistence.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
}