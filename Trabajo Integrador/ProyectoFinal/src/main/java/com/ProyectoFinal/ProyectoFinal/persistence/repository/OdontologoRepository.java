package com.ProyectoFinal.ProyectoFinal.persistence.repository;

import com.ProyectoFinal.ProyectoFinal.persistence.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
}
