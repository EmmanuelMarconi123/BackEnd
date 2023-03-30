package com.ProyectoFinal.ProyectoFinal.service;

import com.ProyectoFinal.ProyectoFinal.persistence.entities.PacienteDTO;

import java.util.Set;

public interface IPacienteService {

    void agregarPaciente (PacienteDTO pacienteDTO);
    PacienteDTO buscarPaciente(Integer id);
    void actualizarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Integer id);
    Set<PacienteDTO> obtenerTodosPacientes();


}
