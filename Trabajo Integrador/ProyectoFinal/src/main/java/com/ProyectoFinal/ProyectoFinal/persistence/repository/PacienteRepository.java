package com.ProyectoFinal.ProyectoFinal.persistence.repository;

import com.ProyectoFinal.ProyectoFinal.persistence.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
